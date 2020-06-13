package me.ahenteti.quartz.helloworld.jobs;

import org.quartz.JobExecutionContext;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;

public class JobExecutionContextService {

    public LocalDateTime getStartLocalDateTime(JobExecutionContext context) {
        return context.getTrigger().getStartTime().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime();
    }

    public ZonedDateTime getStartUTC0DateTime(JobExecutionContext context) {
        return context.getTrigger().getStartTime().toInstant().atZone(ZoneOffset.UTC);
    }
}
