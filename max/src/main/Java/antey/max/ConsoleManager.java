package antey.max;

/**
 * Created by Max on 09/08/16.
 */
public class ConsoleManager {

    // # Vars and constants #
    private ConsoleReader consoleReader;
    private ConsolePrinter consolePrinter;

    // # Constructors #
    ConsoleManager(
            ConsoleReader consoleReader,
            ConsolePrinter consolePrinter){
        this.consoleReader = consoleReader;
        this.consolePrinter = consolePrinter;
    }

    // # Methods #

    // Getter for the ConsoleReader class
    ConsoleReader getConsoleReader(){
        return consoleReader;
    }

    // Getter for the ConsolePrinter class
    ConsolePrinter getConsolePrinter(){
        return consolePrinter;
    }

}
