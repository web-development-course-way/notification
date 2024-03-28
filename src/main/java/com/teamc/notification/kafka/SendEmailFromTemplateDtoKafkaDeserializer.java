package com.teamc.notification.kafka;


import com.teamc.notification.config.ObjectMapperFactory;
import com.teamc.notification.dto.SendEmailFromTemplateDto;
import org.apache.kafka.common.serialization.Deserializer;
import org.springframework.kafka.support.serializer.DeserializationException;

import java.io.IOException;

public class SendEmailFromTemplateDtoKafkaDeserializer implements Deserializer<SendEmailFromTemplateDto> {

    @Override
    public SendEmailFromTemplateDto deserialize(String topic, byte[] data) throws DeserializationException {
        try {
            return ObjectMapperFactory.getInstance().readValue(data, SendEmailFromTemplateDto.class);
        } catch (IOException e) {
            throw new DeserializationException("Error deserializing data", data, false, e);
        }
    }

}
