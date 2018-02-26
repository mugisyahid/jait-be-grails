package com.jait.service.admin

import com.sendgrid.*
import grails.config.Config
import grails.core.support.GrailsConfigurationAware

/**
 * sendgrid implementation
 */
class EmailService implements GrailsConfigurationAware {

    private SendGrid sendGrid
    private String emailFrom

    @Override
    void setConfiguration(Config co) {
        sendGrid = new SendGrid(co.getRequiredProperty('grails.email.sendGridKey'))
        emailFrom = co.getRequiredProperty('emailFrom')
    }


    String sendMail(String to, String subject, Content content) {
        String result = 'notOk'
        Email emailFrom = new Email(emailFrom)
        Email emailTo = new Email(to)
        Mail mail = new Mail(emailFrom, subject, emailTo, content);
        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint("mail/send");
            request.setBody(mail.build());
            Response response = sendGrid.api(request);
            if (response.getStatusCode() == '202' || response.getStatusCode() == '200') result = 'ok'
        } catch (IOException ex) {
            throw ex;
        }
        return result
    }
}
