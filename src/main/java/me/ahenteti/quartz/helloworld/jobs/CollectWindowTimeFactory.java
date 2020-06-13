package me.ahenteti.quartz.helloworld.jobs;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class CollectWindowTimeFactory {

    public CollectWindowTime create(LocalDateTime triggerStartTime) {
        LocalDateTime windowStart = triggerStartTime.truncatedTo(ChronoUnit.MINUTES);
        windowStart = windowStart.withMinute(windowStart.getMinute() - windowStart.getMinute() % 5 - 5);

        LocalDateTime windowEnd = triggerStartTime.truncatedTo(ChronoUnit.MINUTES);
        windowEnd = windowEnd.withMinute(windowEnd.getMinute() - windowEnd.getMinute() % 5);

        return new CollectWindowTime(windowStart, windowEnd);
    }

}
