package me.ahenteti.quartz.helloworld.jobs;

import java.time.LocalDateTime;

public class CollectWindowTime {

    private LocalDateTime start;
    private LocalDateTime end;

    public CollectWindowTime(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public LocalDateTime getEnd() {
        return end;
    }
}
