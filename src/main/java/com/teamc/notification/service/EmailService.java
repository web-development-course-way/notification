package com.teamc.notification.service;

import com.teamc.notification.model.SendEmailFromTemplateCommand;
import jakarta.mail.MessagingException;

public interface EmailService {

    void sendEmailFromTemplate(SendEmailFromTemplateCommand sendEmailCommand) throws MessagingException;

}
