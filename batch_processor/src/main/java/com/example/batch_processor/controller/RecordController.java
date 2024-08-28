package com.example.batch_processor.controller;

import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/job")
public class RecordController {

    @Autowired
    private JobLauncher jobLauncher;
    @Autowired
    private Job job;


    @PostMapping("/start")
    public void startImport()
    {
        JobParameters jobParameters = new JobParametersBuilder()
                .addLong("StartAt",System.currentTimeMillis())
                .toJobParameters();
        try {
            jobLauncher.run(job,jobParameters);
        } catch (JobExecutionAlreadyRunningException | JobInstanceAlreadyCompleteException |
                 JobParametersInvalidException | JobRestartException e) {
            throw new RuntimeException(e);
        }
    }
}
