package me.ahenteti.quartz.helloworld.jobs;

import org.quartz.Job;
import org.quartz.JobDetail;

import static org.quartz.JobBuilder.newJob;

public class JobDetailFactory {

    public <T extends Job> JobDetail create(Class<T> clazz) {
        return newJob(clazz).withIdentity(clazz.getName()).build();
    }
}
