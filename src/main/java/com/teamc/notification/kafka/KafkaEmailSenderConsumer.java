package com.teamc.notification.kafka;

import com.teamc.notification.constant.KafkaTopics;
import com.teamc.notification.dto.SendEmailFromTemplateDto;
import com.teamc.notification.mapper.SendEmailFromTemplateCommandMapper;
import com.teamc.notification.service.EmailService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class KafkaEmailSenderConsumer {

    private static final String EMAIL_SENDER = "email-sender";
    private final EmailService emailService;
    private final SendEmailFromTemplateCommandMapper sendEmailFromTemplateCommandMapper;


    @KafkaListener(topics = KafkaTopics.EMAIL, groupId = EMAIL_SENDER)
    void listener(SendEmailFromTemplateDto dto) throws MessagingException {
        log.info("Consumed from topic {} the object {}", KafkaTopics.EMAIL, dto);
        emailService.sendEmailFromTemplate(sendEmailFromTemplateCommandMapper.toSendEmailFromTemplateCommand(dto));
    }

}
