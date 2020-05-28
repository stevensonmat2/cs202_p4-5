import java.util.Scanner;

public class Utility {

    protected Scanner input;

    protected Utility() {
        input = new Scanner(System.in);
    }

    protected String title(String word) {

        char [] temp = word.toCharArray();
        temp[0] = Character.toUpperCase(temp[0]);
        return new String(temp);
    }

    protected boolean again() {

        String reply;

        do {

            System.out.println("again? y or n: ");

            reply = input.nextLine();

        } while (!reply.equalsIgnoreCase("y") && !reply.equalsIgnoreCase("n"));

        return reply.equalsIgnoreCase("y");
    }


    protected int max(int a, int b) {

        return Math.max(a, b);
    }
}
