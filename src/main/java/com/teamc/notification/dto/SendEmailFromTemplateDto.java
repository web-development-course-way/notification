package com.teamc.notification.dto;

import com.teamc.notification.enums.EmailTemplate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Map;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SendEmailFromTemplateDto {

    private List<String> to;
    private List<String> cc;
    private List<String> bcc;
    private EmailTemplate template;
    private Map<String, Object> variables;

}
