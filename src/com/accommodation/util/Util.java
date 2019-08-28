package com.accommodation.util;

import com.accommodation.bean.User;
import javax.servlet.http.HttpServletRequest;
import java.security.NoSuchAlgorithmException;
import java.util.Properties;
import javax.mail.MessagingException;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import static com.accommodation.util.Constant.*;
import static com.accommodation.util.PasswordMD5.getMD5;

/**
 * @author chanthan
 */
public class Util {
    public static User createUserBean(HttpServletRequest request) throws NoSuchAlgorithmException {
        User user = new User();
        user.setEmail(request.getParameter("email"));
        user.setPassword(getMD5(request.getParameter("password")));
        user.setFirstName(request.getParameter("firstName"));
        user.setLastName(request.getParameter("lastName"));
        user.setAddress(request.getParameter("address"));
        user.setTelephoneNumber(request.getParameter("telephoneNumber"));
        user.setRoleId(Integer.parseInt(request.getParameter("roleId")));
        user.setStudentId(request.getParameter("studentId")!=null?request.getParameter("studentId"):"0");
        user.setRentId(0);
        user.setActive(true);
        return user;
    }

    public static void sendEmail(String toAddress, String subject, String message) throws MessagingException {
        Properties properties = new Properties();
        properties.put("mail.smtp.host", HOST);
        properties.put("mail.smtp.port", PORT);
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.starttls.enable", "true");
        properties.put("mail.smtp.ssl.trust", HOST);

        Authenticator auth = new Authenticator() {
            public PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(EMAIL_ADDRESS, EMAIL_PASSWORD);
            }
        };
        Session session = Session.getInstance(properties, auth);
        Message msg = new MimeMessage(session);
        msg.setFrom(new InternetAddress(EMAIL_ADDRESS));
        InternetAddress[] toAddresses = { new InternetAddress(toAddress) };
        msg.setRecipients(Message.RecipientType.TO, toAddresses);
        msg.setSubject(subject);
        msg.setSentDate(new Date());
        msg.setText(message);
        Transport.send(msg);
    }

}
