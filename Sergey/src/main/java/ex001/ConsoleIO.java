package ex001;

import java.util.Scanner;

public class ConsoleIO {

    private static final String[] quittypes = { "e", "q" };
    private Scanner scr;
    private String  lastInputValue;

    public ConsoleIO() {

        System.out.println("Enter account name (10 digits)");
        scr = new Scanner(System.in);
        lastInputValue = "";
    }

    //TODO fix me
//    private boolean isItExitCommand(String inputString) {
//        return AccountsOperator.isAccountApplicable(inputString, quittypes);
//    }

    public String getLastInputValue() {
        return lastInputValue;
    }

    //TODO fix me
    public boolean hasProperInputString() {
        System.out.println( "Enter account name. 10 digits: ");
        lastInputValue = scr.nextLine().trim().toLowerCase();
        return true;
    }
}
