/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ejb;

import java.util.Date;
import javax.mail.Authenticator;
import java.util.Properties;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

/**
 *
 * @author Jakub
 */
@Stateless
@LocalBean
public class MailSession {
    
    private int port = 465;
    private String host = "smtp.gmail.com";
    private String from = "qbass.rpi@gmail.com";
    private boolean auth = true;
    private String username = "qbass.rpi@gmail.com";
    private String password = "";
    private MailProtocol protocol = MailProtocol.SMTPS;
    private boolean debug = true;
    
    
    
    
    public void sendMail(String to, String subject, String body) {
        Properties props = new Properties();
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", port);
        switch (protocol) {
            case SMTPS:
                props.put("mail.smtp.ssl.enable", true);
                break;
            case TLS:
                props.put("mail.smtp.starttls.enable", true);
                break;
        }

        Authenticator authenticator = null;
        if (auth) {
            props.put("mail.smtp.auth", true);
            authenticator = new Authenticator() {
                private PasswordAuthentication pa = new PasswordAuthentication(username, password);
                @Override
                public PasswordAuthentication getPasswordAuthentication() {
                    return pa;
                }
            };
        }

        Session session = Session.getInstance(props, authenticator);
        session.setDebug(debug);

        MimeMessage message = new MimeMessage(session);
        try {
            message.setFrom(new InternetAddress(from));
            InternetAddress[] address = {new InternetAddress(to)};
            message.setRecipients(Message.RecipientType.TO, address);
            message.setSubject(subject);
            message.setSentDate(new Date());
            message.setText(body);
            Transport.send(message);
        } catch (MessagingException ex) {
            ex.printStackTrace();
        }
        
    }
    
    

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
}
