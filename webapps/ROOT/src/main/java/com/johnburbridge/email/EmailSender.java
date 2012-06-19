package com.johnburbridge.email;

import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import javax.servlet.http.HttpServletRequest;

/**
 * A simple email sender that uses javax.mail
 * 
 * @author jburbridge
 * @since 6/19/2012
 */
public class EmailSender {

    private static final String HOST = "smtp.metabuild.net";
    private static final String HOST_PROP = "mail.smtp.host";
    
    private static final String RECIPIENT = "johnburbridge@metabuild.org";
    private static final String SUBJECT = "A message from the interwebs!";
    
    /** the form's name parameter - required to be not null */
    protected static final String NAME_PARAM = "visitorName";
    /** the form's email paramter - required to be not null*/
    protected static final String EMAIL_PARAM = "visitorEmail";
    /** the form's message paramter - required to be not null*/
    protected static final String MESSAGE_PARAM = "visitorMessage";
    
    /**
     * @param request
     * @return true of the required paramters are not null
     */
    public static boolean validateParamsNotNull(HttpServletRequest request) {
        return request.getParameter(NAME_PARAM) != null && 
            request.getParameter(EMAIL_PARAM) != null &&
            request.getParameter(MESSAGE_PARAM) != null;
    }
    
    /**
     * @param request
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMessage(HttpServletRequest request) throws AddressException, MessagingException {
        sendMessage(request.getParameter(EMAIL_PARAM), SUBJECT, request.getParameter(MESSAGE_PARAM));
    }
    
    /**
     * @param to
     * @param subject
     * @param bodyText
     * @throws AddressException
     * @throws MessagingException
     */
    public static void sendMessage(String to, String subject, String bodyText) throws AddressException, MessagingException {

        Properties properties = System.getProperties();
        properties.setProperty(HOST_PROP, HOST);
        Session session = Session.getDefaultInstance(properties);
        
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(RECIPIENT));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
        message.setSubject(subject);
        message.setText(bodyText);
        
        Transport.send(message);
    }
}
