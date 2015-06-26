package com.seotoaster.utils;


/*
Some SMTP servers require a username and password authentication before you
can use their Server for Sending mail. This is most common with couple
of ISP's who provide SMTP Address to Send Mail.

This Program gives any example on how to do SMTP Authentication
(User and Password verification)

This is a free source code and is provided as it is without any warranties and
it can be used in any your code for free.

Author : Sudhir Ancha
*/

import javax.mail.*;
import javax.mail.internet.*;
import java.util.*;
import java.io.*;

/*
  To use this program, change values for the following three constants,

    SMTP_HOST_NAME -- Has your SMTP Host Name
    SMTP_AUTH_USER -- Has your SMTP Authentication UserName
    SMTP_AUTH_PWD  -- Has your SMTP Authentication Password

  Next change values for fields

  emailMsgTxt  -- Message Text for the Email
  emailSubjectTxt  -- Subject for email
  emailFromAddress -- Email Address whose name will appears as "from" address

  Next change value for "emailList".
  This String array has List of all Email Addresses to Email Email needs to be sent to.


  Next to run the program, execute it as follows,

  SendMail authProg = new SendMail();

*/

public class SendMail
{

  public static final String SMTP_HOST_NAME = "smtp.gmail.com";
  public static final String SMTP_AUTH_USER = "mailqalearning@gmail.com";
  public static final String SMTP_AUTH_PWD  = "bestmovie24";

  public static final String emailMsgTxt      = "Hi Edwin \nI would like to inform you that the Automation Testing is now complete! \nKindly check the results (screenshots, logs and reports) at their corresponding folders. \nMany Thanks\n \nYours Selenium WebDriver";
  public static final String emailSubjectTxt  = "Completion of Test Execution";
  public static final String emailFromAddress = "mailqalearning@gmail.com";

  // Add List of Email address to who email needs to be sent to
  public static final String[] emailList = {"omotayo.babalola@gmail.com", "johnikwumelezeh85@gmail.com", "david.umogbai@gmail.com", "ijeoma.nwofor@yahoo.com"};
/*
  public static void main(String args[]) throws Exception
  {
    SendMail smtpMailSender = new SendMail();
    smtpMailSender.postMail( emailList, emailSubjectTxt, emailMsgTxt, emailFromAddress);
    System.out.println("Successfully Sent mail to All Users");
  }

*/
  public void postMail( String recipients[ ], String subject,
                            String message , String from) throws MessagingException
  {
    boolean debug = false;

     //Set the host smtp address
     Properties props = new Properties();
     props.put("mail.smtp.starttls.enable", "true");
     props.put("mail.smtp.host", SMTP_HOST_NAME);
     props.put("mail.smtp.auth", "true");

    Authenticator auth = new SMTPAuthenticator();
    Session session = Session.getDefaultInstance(props, auth);

    session.setDebug(debug);

    // create a message
    Message msg = new MimeMessage(session);

    // set the from and to address
    InternetAddress addressFrom = new InternetAddress(from);
    msg.setFrom(addressFrom);

    InternetAddress[] addressTo = new InternetAddress[recipients.length];
    for (int i = 0; i < recipients.length; i++)
    {
        addressTo[i] = new InternetAddress(recipients[i]);
    }
    msg.setRecipients(Message.RecipientType.TO, addressTo);


    // Setting the Subject and Content Type
    msg.setSubject(subject);
    msg.setContent(message, "text/plain");
    
    Transport.send(msg);
    System.out.println("Sucessfully Sent mail to All Users");
 }


/**
* SimpleAuthenticator is used to do simple authentication
* when the SMTP server requires it.
*/
private class SMTPAuthenticator extends javax.mail.Authenticator
{

    public PasswordAuthentication getPasswordAuthentication()
    {
        String username = SMTP_AUTH_USER;
        String password = SMTP_AUTH_PWD;
        return new PasswordAuthentication(username, password);
    }
}

}


