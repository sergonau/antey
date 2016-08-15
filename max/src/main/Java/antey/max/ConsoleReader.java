package antey.max;

/**
 * Created by Max on 09/08/16.
 */


import java.util.Scanner;

public class ConsoleReader {

    // # Vars and constants #

    // Exit commands
    private static final String[] EXIT_COMMANDS = {"q", "stop", "exit", "quit"};

    // String inputted by user
    private String inputString;

    // Console input object
    private Scanner scanner;

    // # Constructor #
    public ConsoleReader(){
        scanner = new Scanner(System.in);
    }

    // # Methods #

    // Input string from the console
    public String readString(){
        inputString = scanner.nextLine();
        return inputString;
    }

    // Check for the Exit command
    boolean checkIsExitCommand(){
    inputString = inputString.trim().toLowerCase();
        for (String exitCommand : EXIT_COMMANDS) {
            if ( exitCommand.equals( inputString ) ) {
                return true;
            }
        }
        return false;
    }

    // Getter for the input string
    String getInputString(){
        return inputString;
    }

}

