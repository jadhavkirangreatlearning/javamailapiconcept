package com.csi.controller;

import com.csi.model.EmailModel;
import com.csi.service.EmailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.MessagingException;

@RestController
@RequestMapping("/api")
public class EmailController {

    @Autowired
    EmailServiceImpl emailServiceImpl;

    @PostMapping("/sendemail")
    public ResponseEntity<String> sendEmail(@RequestBody EmailModel emailModel) throws MessagingException {
       emailServiceImpl.sendEmail(emailModel);
       return ResponseEntity.ok("Mail Sent Successfully");
    }
}
