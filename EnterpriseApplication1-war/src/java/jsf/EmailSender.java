/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package jsf;

import ejb.MailSession;
import javax.ejb.EJB;

/**
 *
 * @author Jakub
 */
public class EmailSender {
    
    @EJB
    MailSession sender;
    
    private String to;
    private String subject;
    private String body;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
    
    public void sendMail(){
        sender.sendMail(to, subject, body);
    }

    /**
     * Creates a new instance of EmailSender
     */
    public EmailSender() {
    }
    
}
