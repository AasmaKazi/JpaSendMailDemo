package com.sendMail.sendMail.controller;

import com.sendMail.sendMail.domain.MailData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController

public class SendController {

    @Autowired
    private SimpleMailMessage simpleMailMessage;

    @Autowired
    private MailSender mailSender;

    @Autowired
    private Logger logger;

    @PostMapping(value = "/sendMail")

    public String sendMail(@RequestBody MailData mailData) {

        simpleMailMessage.setTo(mailData.getTo());
        simpleMailMessage.setText(mailData.getData());
        simpleMailMessage.setSubject(mailData.getSubject());

        mailSender.send(simpleMailMessage);

        logger.info("Mail send Successfully....");
        return "Mail Send";

    }


}
