package task01;

import java.util.Scanner;

import static task01.ConsoleOut.*;

/**
 * Created by SDem on 23.08.2016.
 * ver: 001
 */
class ConsoleIn {

    private static final String[] QUIT_COMMAND = { "e", "q", "exit", "quit" };

    private Scanner sc;
    private String inValue;


    ConsoleIn() {
        sc = new Scanner(System.in);
        inValue = "";
    }

    String getInValue() {
        return inValue;
    }

    boolean hasEnterValue() {
        writeLine("Enter account name:");
        inValue = sc.nextLine().trim();
        return !CommonFunctions.isStringFound(inValue,QUIT_COMMAND);
    }
}
