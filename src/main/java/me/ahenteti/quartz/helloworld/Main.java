package me.ahenteti.quartz.helloworld;

import me.ahenteti.quartz.helloworld.jobs.CollectWindowTimeJob;
import me.ahenteti.quartz.helloworld.jobs.JobDetailFactory;
import me.ahenteti.quartz.helloworld.jobs.StartNowTriggerFactory;
import me.ahenteti.quartz.helloworld.jobs.TriggerStartTimeJob;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

    private static JobDetailFactory jobDetailFactory = new JobDetailFactory();
    private static StartNowTriggerFactory startNowTriggerFactory = new StartNowTriggerFactory();

    public static void main(String[] args) throws Exception {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        JobDetail triggerStartTimeJobDetail = jobDetailFactory.create(TriggerStartTimeJob.class);
        Trigger triggerStartTimeJobTrigger = startNowTriggerFactory.create(TriggerStartTimeJob.class);
        JobDetail collectWindowTimeJobDetail = jobDetailFactory.create(CollectWindowTimeJob.class);
        Trigger collectWindowTimeJobTrigger = startNowTriggerFactory.create(CollectWindowTimeJob.class);
        scheduler.scheduleJob(collectWindowTimeJobDetail, triggerStartTimeJobTrigger);
        scheduler.scheduleJob(triggerStartTimeJobDetail, collectWindowTimeJobTrigger);
        scheduler.start();
        Thread.sleep(1000);
        scheduler.shutdown(true);
    }


}
