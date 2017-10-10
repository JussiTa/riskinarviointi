package com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session;

// File Name SendEmail.java

import android.content.Context;
import android.content.res.Resources;
import android.util.Log;

import com.example.jussi.tyokohtainenriskinarviointi.R;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.Security;
import java.util.*;
import javax.mail.*;
import javax.mail.internet.*;
import javax.activation.*;

public class SendEmail extends javax.mail.Authenticator {
    private String uuid;
    private  String to;
    private String username;
    private String password;
    private String url = "https://botniamillservice.000webhostapp.com/confirmEmail.php?uuid=";

   // static {

     //   Security.addProvider(new com.example.jussi.tyokohtainenriskinarviointi.com.example.jussi.tyokohtainenriskininarviointi.Session.JSSEProvider());

   // }

    public SendEmail(final String email,final String usernameandpassword,final String uuid){
        String[] userNameandPassword = new String[2];
        userNameandPassword = usernameandpassword.split(" ");
        username = userNameandPassword[0];
        password = userNameandPassword[1];
        this.uuid=uuid;
        this.to =email;








        // Sender's email ID needs to be mentioned
   //      String from = "justapis77@gmail.com";
           String from ="localhost";



        // Get the default Session object.
               Properties props = new Properties();
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.host", "smtp.gmail.com");
                props.put("mail.smtp.port", "587");

                        Session session = Session.getInstance(props,
                                new javax.mail.Authenticator() {
                    protected PasswordAuthentication getPasswordAuthentication() {
                                                return new PasswordAuthentication(username, password);
                                            }
                }); /*

*/
        try {
            // Create a default MimeMessage object.
            MimeMessage message = new MimeMessage(session);


            // Set From: header field of the header.
            message.setSender(new InternetAddress(from));

            // Set To: header field of the header.
            message.addRecipient(Message.RecipientType.TO, new InternetAddress(to));

            // Set Subject: header field
            message.setSubject("Aktivointilinkki työkohtaiseen riskinarviointilomakkeeseen ");

            // Now set the actual message
            message.setText("Aktivointilinkki:"+url+this.uuid);


            // Send message
            Transport.send(message);
            System.out.println("Sent message successfully....");
        }catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}