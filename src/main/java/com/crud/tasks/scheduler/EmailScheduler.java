package com.crud.tasks.scheduler;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.domain.Mail;
import com.crud.tasks.repository.TaskRepository;
import com.crud.tasks.service.SimpleEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import static sun.security.x509.X509CertInfo.SUBJECT;

@Component
public class EmailScheduler {

    @Autowired
    private SimpleEmailService simpleEmailService;

    @Autowired
    private TaskRepository taskRepository;

    @Autowired
    private AdminConfig adminConfig;

    @Scheduled(fixedDelay = 10000)
    //@Scheduled(cron = "0 0 10 * * *")
    public void sendInformationEmail(){
        long size = taskRepository.count();

        if (size!=1) {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(), SUBJECT,
                    "Currently in database you got: " + size + " tasks in Heroku."));
        } else {
            simpleEmailService.send(new Mail(
                    adminConfig.getAdminMail(), SUBJECT,
                    "Currently in database you got: 1 task in Heroku."));
        }
    }
}
