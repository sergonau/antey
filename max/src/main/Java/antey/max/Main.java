package antey.max;

/**
 * Created by Max on 01/08/16.
 */

public class Main {

    // Main function
    public static void main(String[] args) {

        ConsoleReader consoleReader = new ConsoleReader();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        ConsoleManager consoleManager = new ConsoleManager(consoleReader, consolePrinter);
        AccountFeasibilityChecker accountFeasibilityChecker = new AccountFeasibilityChecker();
        AccountValidityChecker accountValidityChecker = new AccountValidityChecker();
        AccountManager accountManager = new AccountManager(consoleManager, accountValidityChecker, accountFeasibilityChecker);
        accountManager.conductCheck();

    }

}