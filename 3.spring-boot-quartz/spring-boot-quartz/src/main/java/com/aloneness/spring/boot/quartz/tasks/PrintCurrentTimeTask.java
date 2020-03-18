package com.aloneness.spring.boot.quartz.tasks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class PrintCurrentTimeTask {

    @Scheduled(cron = "0/5 * * * * ?")
    public void printCurrentTime(){
        System.out.println("Current Time is : " + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
    }

}
