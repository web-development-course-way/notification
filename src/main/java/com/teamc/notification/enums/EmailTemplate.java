package com.teamc.notification.enums;

public enum EmailTemplate {
    FIRST_ADMIN_CREATION_EMAIL("first-admin-creation-email", "Admin Account Created !");

    private final String templateName;
    private final String subject;

    EmailTemplate(String templateName, String subject) {
        this.templateName = templateName;
        this.subject = subject;
    }

    public String getTemplateName() {
        return templateName;
    }

    public String getSubject() {
        return subject;
    }

}
