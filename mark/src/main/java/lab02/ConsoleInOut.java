package lab02;

import java.util.Scanner;

/**
 * Console reader/writer
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.1
 */
public class ConsoleInOut {
    /** Quit commands */
    private static final String[] QUIT_SIGNATURES = { "e", "q", "exit", "quit" };
    /** proxy object for console input */
    private Scanner in;
    /** value that was entered at last time */
    private String  lastInputValue;

    /** class constructor */
    public ConsoleInOut() {
        in = new Scanner(System.in);
        lastInputValue = "";
    }

    /**
     * Method that checks does exit command entered?
     * @param inputString String to compare with quit signatures
     * @return true If quit signatures was found
     */
    private boolean isExitCommand(String inputString) {
        return Utils.isStringFound(inputString, QUIT_SIGNATURES);
    }

    /**
     * Getter for private class member
     * @return Value if private member LastInputValue
     */
    public String getLastInputValue() {
        return lastInputValue;
    }

    /** printing signatures for program quit */
    public String printQuitSignatures() {
    	String res = "";
        for (String str : QUIT_SIGNATURES) {
        	res += "\"" + str + "\" ";
        }
        return res;
    }

    /**
     * Method that writes string to console
     * @param str String that should be displayed
     */
    public void writeString(String str) {
        System.out.print( str );
    }

    /**
     * Method that writes string to console with given format
     * @param str String that should be displayed
     * @param args Objects that should be displayed within format string
     */
    public void writeStringFormat(String format, Object ... args) {
        System.out.printf(format, args);
    }

    /**
     * Method that gets string from console
     * @param prompt String that should be displayed before user input
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperInputString(String prompt) {
        writeString( prompt );
        lastInputValue = in.nextLine().trim().toLowerCase();
        return ! isExitCommand ( lastInputValue );
    }
}
