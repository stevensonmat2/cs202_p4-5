/*
Matt Stevenson
CS202 Program #4
5/29/2020

this file contains the Utility class. this class provides some common
utility methods to derived classes.

 */

import java.util.Scanner;



public class Utility {

    protected Scanner input;

    protected Utility() {
        input = new Scanner(System.in);
    }

    //capitalizes a word
    protected String title(String word) {

        char [] temp = word.toCharArray();
        temp[0] = Character.toUpperCase(temp[0]);
        return new String(temp);
    }

    //prompts user to repeat or move on
    protected boolean again() {

        String reply;

        do {

            System.out.println("again? y or n: ");

            reply = input.nextLine();

        } while (!reply.equalsIgnoreCase("y") && !reply.equalsIgnoreCase("n"));

        return reply.equalsIgnoreCase("y");
    }

    //abbreviated max function
    protected int max(int a, int b) {

        return Math.max(a, b);
    }
}
