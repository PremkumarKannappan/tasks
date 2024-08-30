package com.example.batch_processor.config;

import com.example.batch_processor.entity.Record;
import com.example.batch_processor.repository.RecordRepository;
import jakarta.persistence.EntityManagerFactory;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemWriter;
import org.springframework.batch.item.database.JpaItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionManager;

@Configuration
@EnableBatchProcessing
@AllArgsConstructor
@NoArgsConstructor
public class SpringBatchConfig {

    private EntityManagerFactory entityManagerFactory;
    private JobBuilder jobBuilder;
    private StepBuilder stepBuilder;
    private RecordRepository recordRepository;
    private PlatformTransactionManager transactionManager;

    @Bean
    public FlatFileItemReader<Record> reader() {
        FlatFileItemReader<Record> itemReader = new FlatFileItemReader<>();
        itemReader.setResource(new FileSystemResource("src/main/resources/data.csv"));
        itemReader.setName("csvReader");
        itemReader.setLineMapper(lineMapper());
        return itemReader;
    }

    private LineMapper<Record> lineMapper() {
        DefaultLineMapper<Record> lineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();
        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames("tableName", "columnName", "dataType");
        BeanWrapperFieldSetMapper<Record> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Record.class);

        lineMapper.setLineTokenizer(lineTokenizer);
        lineMapper.setFieldSetMapper(fieldSetMapper);
        return lineMapper;

    }

    @Bean
    public ItemProcessor<Record, Record> processor() {
        return new RecordProcessor();
    }

    @Bean
    public JpaItemWriter<Record> writer(EntityManagerFactory entityManagerFactory1) {
        JpaItemWriter<Record> writer = new JpaItemWriter<>();
        writer.setEntityManagerFactory(entityManagerFactory1);
        writer.setUsePersist(true);
        return writer;
    }

    @Bean
    public Step step(JobRepository jobRepository, PlatformTransactionManager transactionManager1) {
        return new StepBuilder("step1", jobRepository)
                .<Record, Record>chunk(10, transactionManager1)
                .reader(reader())
                .processor(processor())
                .writer(writer(entityManagerFactory))
                .build();
    }

    @Bean
    public Job importUserJob(JobRepository jobRepository, JobCompletionNotificationListener listener) {
        return new JobBuilder("importUserJob", jobRepository)
//                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .start(step(jobRepository, transactionManager))
                .build();
    }
}
