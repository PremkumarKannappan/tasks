package com.example.quartz_example;


import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QuartzJob implements Job {

    Logger log =  LoggerFactory.getLogger(QuartzJob.class);

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        log.info("job running with the quartz schedule.....");
        log.info("Executing MyQuartzJob at {}", jobExecutionContext.getFireTime());
    }

}
