package antey.max;

/**
 * Created by Max on 09/08/16.
 */

public class ConsolePrinter {

    // # Vars and constants #

    // # Constructors #
    public ConsolePrinter(){
    }

    // # Methods #

    // Print a string
    public void printString(String outputString) {
        System.out.println(outputString);
    }

    // Print an exception
    public void printException(Exception outputoutputException) {
        System.out.println("Exception has occured: " + outputoutputException.getMessage());
    }

}
