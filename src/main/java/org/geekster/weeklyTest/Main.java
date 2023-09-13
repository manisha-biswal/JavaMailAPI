package org.geekster.weeklyTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Starting to send out Mail");
        System.out.print("Enter the number of recipients: ");
        int n = sc.nextInt();
        mailMetaData.password = args[0];

        mailHandler msgSender = new mailHandler();

        msgSender.sendMail(n);

        System.out.println("Email sent");

    }
}