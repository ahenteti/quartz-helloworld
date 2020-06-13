package me.ahenteti.quartz.helloworld.jobs;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.time.LocalDateTime;

public class CollectWindowTimeJob implements Job {

    // dependencies
    private JobExecutionContextService jobExecutionContextService;
    private CollectWindowTimeFactory collectWindowTimeFactory;

    /**
     * constructor with dependencies
     *
     * @param jobExecutionContextService jobExecutionContextService
     * @param collectWindowTimeFactory   collectWindowTimeFactory
     */
    public CollectWindowTimeJob(JobExecutionContextService jobExecutionContextService, CollectWindowTimeFactory collectWindowTimeFactory) {
        this.jobExecutionContextService = jobExecutionContextService;
        this.collectWindowTimeFactory = collectWindowTimeFactory;
    }

    /**
     * Empty constructor used by Quartz to initialize this job
     */
    public CollectWindowTimeJob() {
        this(new JobExecutionContextService(), new CollectWindowTimeFactory());
    }

    public void execute(JobExecutionContext context) throws JobExecutionException {
        LocalDateTime triggerStartTime = jobExecutionContextService.getStartLocalDateTime(context);
        CollectWindowTime collectWindowTime = collectWindowTimeFactory.create(triggerStartTime);
        System.out.println("Execution time: " + LocalDateTime.now());
        System.out.println("CollectWindowTime.start: " + collectWindowTime.getStart());
        System.out.println("CollectWindowTime.end: " + collectWindowTime.getEnd());
    }
}
