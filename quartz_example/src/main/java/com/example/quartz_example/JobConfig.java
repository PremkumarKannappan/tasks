package com.example.quartz_example;

import org.quartz.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JobConfig {

        @Bean
        public JobDetail jobDetail()
        {
            return JobBuilder.newJob(QuartzJob.class)
                    .withIdentity("quartzJob")
                    .storeDurably().build();
        }

//        @Bean
//        public Trigger trigger()
//        {
//            return TriggerBuilder.newTrigger()
//                    .forJob(jobDetail())
//                    .withIdentity("quartzJobTrigger")
//                    .withSchedule(SimpleScheduleBuilder.simpleSchedule()
//                            .withIntervalInMinutes(2)
//                            .repeatForever())
//                    .build();
//        }

        @Bean
        public Trigger trigger()
        {
            return TriggerBuilder.newTrigger()
                    .forJob(jobDetail())
                    .withIdentity("quartzJobTrigger")
                    .withSchedule(CronScheduleBuilder.cronSchedule("0 */2 * * * ?"))
                    .build();

        }
}
