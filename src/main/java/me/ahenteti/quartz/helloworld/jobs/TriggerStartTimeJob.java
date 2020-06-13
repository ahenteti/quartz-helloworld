package me.ahenteti.quartz.helloworld.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class TriggerStartTimeJob implements Job {

    // dependencies
    private JobExecutionContextService jobExecutionContextService;

    /**
     * constructor with dependencies
     *
     * @param jobExecutionContextService jobExecutionContextService
     */
    public TriggerStartTimeJob(JobExecutionContextService jobExecutionContextService) {
        this.jobExecutionContextService = jobExecutionContextService;
    }

    /**
     * Empty constructor used by Quartz to initialize this job
     */
    public TriggerStartTimeJob() {
        this(new JobExecutionContextService());
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        try {
            System.out.println(LocalDateTime.now() + ": " + jobExecutionContextService
                    .getStartLocalDateTime(context) + " (" + jobExecutionContextService
                    .getStartUTC0DateTime(context) + ")");
            Thread.sleep(3000);
            System.out.println(LocalDateTime.now() + ": " + jobExecutionContextService
                    .getStartLocalDateTime(context) + " (" + jobExecutionContextService
                    .getStartUTC0DateTime(context) + ")");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
