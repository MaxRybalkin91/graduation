package ru.topjava.graduation.service;

import org.springframework.stereotype.Service;

@Service
public class MailService {
    /*
    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.username}")
    private String username;


    public void send(String emailTo, String subject, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();

        mailMessage.setFrom(username);
        mailMessage.setTo(emailTo);
        mailMessage.setSubject(subject);
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
     */
}