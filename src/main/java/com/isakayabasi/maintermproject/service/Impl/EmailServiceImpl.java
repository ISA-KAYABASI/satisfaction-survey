package com.isakayabasi.maintermproject.service.Impl;

import com.isakayabasi.maintermproject.model.QuestionForm;
import com.isakayabasi.maintermproject.model.Result;
import com.isakayabasi.maintermproject.repository.IUserRepository;
import com.isakayabasi.maintermproject.repository.ResultRepo;
import com.isakayabasi.maintermproject.service.Service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import java.security.Principal;

@Service
public class EmailServiceImpl implements EmailService {


    private IUserRepository iUserRepository;

    public EmailServiceImpl(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }
    @Autowired
    public JavaMailSender javaMailSender;

    @Autowired
    ResultRepo resultRepo;

    @Autowired
    ResultServiceImpl resultServiceImpl;

    @Autowired
    Result result;


    @Autowired
    QuestionForm qForm;

    public String sendEmail(Principal principal) {

        if (principal.getName()=="admin@gmail.com"){

            SimpleMailMessage message = new SimpleMailMessage();

            message.setFrom("dinyester.975@gmail.com");
            message.setTo("dinyester.975@gmail.com");
            message.setSubject("Online Survey Results");
            message.setText("Survey Result : " +"\n"+ "\n" +   "Thank you for taking the time to complete this survey. We truly value the information you have provided." + "\n" + "Your responses will contribute to our analyses of the texts and suggest new lines of approach to the perfect data.");

            javaMailSender.send(message);

            return "Mail sent successfully";

        }else {

        Result result1 = resultRepo.findByEmail(principal.getName());

        SimpleMailMessage message = new SimpleMailMessage();

        message.setFrom("dinyester.975@gmail.com");
        message.setTo(principal.getName());
        message.setSubject("Online Survey Results");
        message.setText("Survey Result : "+result1.getSatisfaction() +"\n"+ "\n" +   "Thank you for taking the time to complete this survey. We truly value the information you have provided." + "\n" + "Your responses will contribute to our analyses of the texts and suggest new lines of approach to the perfect data.");

        javaMailSender.send(message);

        return "Mail sent successfully";
    }
    }

}

