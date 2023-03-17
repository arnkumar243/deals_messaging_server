package com.messaging.pubsubservice.notify.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Service
public class EmailSender {

    private static final int THREAD_POOL_SIZE = 100;

    @Autowired
    private JavaMailSender javaMailSender;

    private ExecutorService executor;

    public EmailSender() {
        executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE);
    }

    public void sendEmail(String[] recipients, String subject, String body) {
        executor.execute(new EmailTask(recipients, subject, body));
    }

    private class EmailTask implements Runnable {
        private String[] recipients;
        private String subject;
        private String body;

        public EmailTask(String[] recipients, String subject, String body) {
            this.recipients = recipients;
            this.subject = subject;
            this.body = body;
        }

        public void run() {
            try {

                SimpleMailMessage message = new SimpleMailMessage();
                message.setTo(recipients);
                message.setSubject("New deal has been published");
                message.setText(body);
                javaMailSender.send(message);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
