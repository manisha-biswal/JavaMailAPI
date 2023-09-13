package org.geekster.weeklyTest;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
import java.util.Scanner;

public class mailHandler {
    Scanner sc = new Scanner(System.in);
    void sendMail(int n){
        Properties sysProps = System.getProperties();

        // System.out.println(sysProps);

        sysProps.put(mailMetaData.host,mailMetaData.hostServer);//host
        sysProps.put(mailMetaData.portServer,mailMetaData.port);//port
        sysProps.put(mailMetaData.sslProperty,"true");//sslEnable
        sysProps.put(mailMetaData.authPerm,"true");//authentication

        //create a session using sender-email and password
        Authenticator mailAuth = new customMailAuthenticate();
        Session mailSession = Session.getInstance(sysProps,mailAuth);
        //mime message build

        MimeMessage msg = new MimeMessage(mailSession);

        try {
            msg.setFrom(mailMetaData.senderMail);
            msg.setSubject("This is my java code testing");
            msg.setText("Hey this is me who is trying to send mail using java");

            //set the receiver
            Address []recipients = new InternetAddress[n];
            for(int i = 0;i<n;i++)
            {
                String receiver = sc.nextLine();
                recipients[i] = new InternetAddress(receiver);
            }

            msg.setRecipients(Message.RecipientType.TO, recipients);



            Transport.send(msg);
        }
        catch(Exception mailException)
        {
            System.out.println(mailException.toString());
        }
    }
}