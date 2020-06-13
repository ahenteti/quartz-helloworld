package me.ahenteti.quartz.helloworld.jobs;

import org.quartz.Trigger;

import static org.quartz.TriggerBuilder.newTrigger;

public class StartNowTriggerFactory {

    public <T> Trigger create(Class<T> clazz) {
        return newTrigger().withIdentity(clazz.getName()).startNow().build();
    }
}
