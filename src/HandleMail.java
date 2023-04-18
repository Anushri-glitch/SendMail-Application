package org.geekster;

import org.geekster.MailAuthenticator;
import org.geekster.MailConstants;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;

public class HandleMail {

    void sendMail(){

        String host  = "smtp.gmail.com";

        Properties props = System.getProperties();

        System.out.println(props);

        //set properties :

        props.put("mail.smtp.host",host);
        props.put("mail.smtp.port","465");
        props.put("mail.smtp.ssl.enable","true");
        props.put("mail.smtp.auth","true");


        Session mailSession = Session.getInstance(props,new MailAuthenticator());

        MimeMessage mimeMessage = new MimeMessage(mailSession);

        try {
            mimeMessage.setFrom(MailConstants.SENDER);

            mimeMessage.setRecipient(Message.RecipientType.TO, new InternetAddress(MailConstants.RECEIVERMAILADDRESS));

            mimeMessage.setSubject(MailConstants.SUBJECT);

            mimeMessage.setText(MailConstants.MESSAGE);

            Transport.send(mimeMessage);

        } catch (MessagingException e) {
            e.printStackTrace();
        }
    }
}
