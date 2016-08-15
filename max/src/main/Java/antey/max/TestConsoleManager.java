package antey.max;

/**
 * Created by Max on 14/08/16.
 */

public class TestConsoleManager {
    public static void main(String[] args){

        // # Test class ConsoleReader #

        // Decalre and construct instance of class
        ConsoleReader consoleReader = new ConsoleReader();
        System.out.println("Instance created");
        // Test method readString()
        System.out.println("Input string:");
        String input = consoleReader.readString();
        // Test method getInputString()
        System.out.println("Inputted string: " + consoleReader.getInputString());
        // Test method checkIsExitCommand()
        if ( consoleReader.checkIsExitCommand() ) {
            System.out.println("Exit command detected!");
        } else{
            System.out.println("Exit command NOT DETECTED!");
        }

        // # Test class ConsolePrinter #

        // Decalre and construct instance of class
        ConsolePrinter consolePrinter = new ConsolePrinter();
        // Test method printString()
        consolePrinter.printString("Printer works fine, too!");

        // # Test class ConsoleManager #

        // Decalre and construct instance of class
        ConsoleManager consoleManager = new ConsoleManager(consoleReader, consolePrinter);

    }

}
