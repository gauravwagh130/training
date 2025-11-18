package com.java.training.nov_14.exceptions;

import java.util.Scanner;

public class ChekEmail {
    public void validateEmail(String email) throws InvalidEmailException, InvalidUserNameException {
        String username = email.substring(0, email.indexOf("@"));
        if(!email.contains("@")){
            throw new InvalidEmailException("Email must contain @ symbol");
        }

        else if (username.length() <8 || username.length() > 14){
            throw new InvalidUserNameException("Username must be between 8 to 14 chars");
        }
        System.out.println("Email are vaild");
    }
    public static void main(String[] args) {
        String email;
        Scanner sc = new Scanner(System.in);
        email = sc.nextLine();
        ChekEmail ob = new ChekEmail();
        try {
            ob.validateEmail(email);
        } catch (InvalidEmailException | InvalidUserNameException e) {
            System.err.println(e.getMessage());
        }
    }
}
