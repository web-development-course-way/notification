package com.teamc.notification.mapper;


import com.teamc.notification.dto.SendEmailFromTemplateDto;
import com.teamc.notification.model.SendEmailFromTemplateCommand;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class SendEmailFromTemplateCommandMapper {

    private final ModelMapper mapper;

    public SendEmailFromTemplateDto toSendEmailFromTemplateDto(SendEmailFromTemplateCommand command) {
        return mapper.map(command, SendEmailFromTemplateDto.class);
    }

    public SendEmailFromTemplateCommand toSendEmailFromTemplateCommand(SendEmailFromTemplateDto dto) {
        return SendEmailFromTemplateCommand.builder()
                .cc(dto.getCc())
                .bcc(dto.getBcc())
                .to(dto.getTo())
                .variables(dto.getVariables())
                .template(dto.getTemplate())
                .build();
    }

}
