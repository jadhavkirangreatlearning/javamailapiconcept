package com.csi.dao;

import com.csi.model.EmailModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;

@Component
@Slf4j
public class EmailDaoImpl {


    @Autowired
    JavaMailSender javaMailSender;

    public void sendEmail(EmailModel emailModel) throws MessagingException {

        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);

        mimeMessageHelper.setFrom("jadhavkiran2011@gmail.com");
        mimeMessageHelper.setTo(emailModel.getToEmail());
        mimeMessageHelper.setCc(emailModel.getCcEmail());
        mimeMessageHelper.setSubject(emailModel.getEmailSubject());
        mimeMessageHelper.setText(emailModel.getEmailBody());

        FileSystemResource fileSystemResource = new FileSystemResource(new File(emailModel.getAttachment()));

        mimeMessageHelper.addAttachment(fileSystemResource.getFilename(), fileSystemResource);
        javaMailSender.send(mimeMessage);

        log.info("Mail Sent Successfully");
    }

}
