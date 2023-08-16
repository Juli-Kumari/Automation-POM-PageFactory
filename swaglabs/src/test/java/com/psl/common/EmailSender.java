package com.psl.common;

import java.util.Properties;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class EmailSender {
    public static void sendEmail(String sendTo, String sendFrom, String senderPwd, String subject, String body) {

        // SMTP server configuration
        String smtpHost = "smtp.gmail.com";
        String smtpPort = "587"; // Use for SSL

        // Set up properties for the mail session
        Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.host", smtpHost);
        properties.put("mail.smtp.port", smtpPort);

        // Create a session with authentication
        Session session = Session.getInstance(properties, new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(sendFrom, senderPwd);
            }
        });

        try {
            // Create a new email message
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(sendFrom));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(sendTo));
            message.setSubject(subject);
            message.setText(body);

            // Send the message
            Transport.send(message);

            System.out.println("Email sent successfully!");
        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}









