package com.example.library.service.schedule;

import com.example.library.service.AsyncMailSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ReturnAlertSchedule {
    private final AsyncMailSender asyncMailSender;
    @Autowired
    public ReturnAlertSchedule(AsyncMailSender asyncMailSender) {
        this.asyncMailSender = asyncMailSender;
    }

    @Scheduled(cron = "0 0 7 * * ?")
    public void sendDailyEmails() {

    }
}
