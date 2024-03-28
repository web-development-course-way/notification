package com.teamc.notification.model;

import com.teamc.notification.enums.EmailTemplate;
import com.teamc.notification.validation.BeanValidator;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

import java.util.List;
import java.util.Map;

@Builder
public record SendEmailFromTemplateCommand(@NotEmpty List<String> to,
                                           List<String> cc,
                                           List<String> bcc,
                                           @NotNull EmailTemplate template,
                                           Map<String, Object> variables) {

    public SendEmailFromTemplateCommand(List<String> to, List<String> cc, List<String> bcc, EmailTemplate template,
                                        Map<String, Object> variables) {
        this.to = to;
        this.cc = cc;
        this.bcc = bcc;
        this.template = template;
        this.variables = variables;
        BeanValidator.validate(this);
    }

}
