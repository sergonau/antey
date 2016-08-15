package antey.max;

/**
 * Created by Max on 09/08/16.
 */

public class AccountManager {

    // # Vars and constants #
    private ConsoleManager consoleManager;
    private AccountValidityChecker accountValidityChecker;
    private AccountFeasibilityChecker accountFeasibilityChecker;

    // # Constructors #
    AccountManager(
            ConsoleManager consoleManager,
            AccountValidityChecker accountValidityChecker,
            AccountFeasibilityChecker accountFeasibilityChecker) {
        this.consoleManager = consoleManager;
        this.accountValidityChecker = accountValidityChecker;
        this.accountFeasibilityChecker = accountFeasibilityChecker;
    }

    // # Methods #

    // Main account-checking method
    public void conductCheck() {
        String inputString = "";
        boolean exitCommand = false;
        while ( !exitCommand ) {
            try{
                this.consoleManager.getConsolePrinter().printString("Input account ID:");
                inputString = this.consoleManager.getConsoleReader().readString();
                if ( !this.consoleManager.getConsoleReader().checkIsExitCommand() ) {
                    if ( this.accountValidityChecker.checkIsAccountIdOnlyDigit(inputString) && this.accountValidityChecker.checkIsAccountIdProperLength(inputString) ) {
                        if ( this.accountFeasibilityChecker.checkIsAccountIdFeasible(inputString)) {
                            this.consoleManager.getConsolePrinter().printString("Account ID is OK!");
                        }
                    }
                } else {
                    exitCommand = true;
                }
            } catch (IllegalArgumentException|
                    AccountIdMissingException exception) {
                this.consoleManager.getConsolePrinter().printException(exception);
            }
        }
    }

}
