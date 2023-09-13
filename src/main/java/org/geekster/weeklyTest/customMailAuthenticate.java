package org.geekster.weeklyTest;

import javax.mail.PasswordAuthentication;
import javax.mail.Authenticator;

public class customMailAuthenticate extends Authenticator {
    protected PasswordAuthentication getPasswordAuthentication()
    {
        return new PasswordAuthentication(mailMetaData.senderMail,mailMetaData.password);
    }
}