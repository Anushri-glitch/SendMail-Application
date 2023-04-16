package org.geekster;

public class Main {

    public static void main(String[] args) {
      
        System.out.println("This application is supposed to send mails using java.........");
      
        HandleMail mailer = new HandleMail();
      
        mailer.sendMail();
      
    }
}
