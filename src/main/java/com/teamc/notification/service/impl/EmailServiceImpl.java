package com.teamc.notification.service.impl;

import com.teamc.notification.model.SendEmailFromTemplateCommand;
import com.teamc.notification.service.EmailService;
import jakarta.mail.Message;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring4.SpringTemplateEngine;

import java.util.Locale;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender javaMailSender;
    private final SpringTemplateEngine templateEngine;

    @Override
    public void sendEmailFromTemplate(SendEmailFromTemplateCommand sendEmailCommand) throws MessagingException {
        log.info("Constructing MimeMessage to be used to send emails ...");
        MimeMessage message = getMimeMessage(sendEmailCommand);

        log.info("Sending emails ...");
        log.info("Template: {}, To: {}", sendEmailCommand.template(), sendEmailCommand.to());
        javaMailSender.send(message);
        log.info("Email sent");
    }

    private MimeMessage getMimeMessage(SendEmailFromTemplateCommand sendEmailCommand) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        message.setRecipients(Message.RecipientType.TO, String.join(",", sendEmailCommand.to()));
        message.setSubject(sendEmailCommand.template().getSubject());
        message.setContent(getEmailContent(sendEmailCommand.template().getTemplateName(), sendEmailCommand.variables()),
                "text/html; charset=utf-8");
        if (!ObjectUtils.isEmpty(sendEmailCommand.cc()))
            message.setRecipients(Message.RecipientType.CC, String.join(",", sendEmailCommand.cc()));
        if (!ObjectUtils.isEmpty(sendEmailCommand.bcc()))
            message.setRecipients(Message.RecipientType.BCC, String.join(",", sendEmailCommand.bcc()));
        return message;
    }

    private String getEmailContent(String template, Map<String, Object> variables) {
        Context context = new Context(Locale.ENGLISH, variables);
        return templateEngine.process(template, context);
    }

}
