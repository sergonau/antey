package antey.max;

/**
 * Created by Max on 01/08/16.
 */

import java.util.Scanner;

public class Main {

    // Account array
    private static final String[] ACCOUNT_NUM_SET =
            { "0000000000", "1111111111",
            "2222222222", "3333333333",
            "4444444444", "5555555555",
            "6666666666", "7777777777",
            "8888888888", "9999999999" };

    // Checking the input for digits
    private static boolean checkDigit(String input) {
            for (int i = 0; i < input.length(); i++) {
                if (!Character.isDigit(input.charAt(i)))
                    return false;
            }
            return true;
    }

    // Checking the input for validity
    private static boolean findAccount(String input, String[] allowedInput) {
        input = input.trim().toLowerCase();
        for (String allowedMember : allowedInput) {
            if (allowedMember.equals(input))
                return true;
        }
        return false;
    }

    // Main function
    public static void main(String[] args)
            throws java.lang.IllegalArgumentException {
        try {
            System.out.println("Enter account number");
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            boolean stringNotDigit = !checkDigit(input);
            boolean stringNotMember = !findAccount(input, ACCOUNT_NUM_SET);

            if (stringNotDigit){
                throw new IllegalArgumentException("Illegal account name! Name must contain only integers.");
            } else if (stringNotMember){
                throw new AccountStringMissingException("Illegal account name! Name cannot be found.");
            } else{
                System.out.println("Success!");
            }
        } catch(IllegalArgumentException | AccountStringMissingException err) {
            System.out.println(err.getMessage());
        }
    }
}
