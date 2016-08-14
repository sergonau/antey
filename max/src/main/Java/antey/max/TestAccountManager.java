package antey.max;

/**
 * Created by Max on 14/08/16.
 */

public class TestAccountManager {

    public static void main(String[] args){

//        // # Test class AccountValidityChecker #
//        System.out.println("Input account ID:");
//        Scanner scanner = new Scanner(System.in);
//        String inputAccountId = scanner.nextLine();
//        // Decalre and construct instance of class
//        AccountValidityChecker accountValidityChecker = new AccountValidityChecker(inputAccountId);
//        // Test method checkIsAccountIdProperLength()
//        if ( accountValidityChecker.checkIsAccountIdProperLength() ) {
//            System.out.println("Account ID is of proper length!");
//        }else{
//            System.out.println("Account ID is of INCORRECT LENGTH!");
//        }
//        // Test method checkIsAccountIdOnlyDigit()
//        if ( accountValidityChecker.checkIsAccountIdOnlyDigit() ) {
//            System.out.println("Account ID has proper format!");
//        }else{
//            System.out.println("Account ID must contain ONLY DIGITS!");
//        }
//
//        // # Test class AccountFeasibilityChecker #
//        // Decalre and construct instance of class
//        AccountFeasibilityChecker accountFeasibilityChecker = new AccountFeasibilityChecker(inputAccountId);
//        // Test method checkIsAccountIdFeasible()
//        if ( accountFeasibilityChecker.checkIsAccountIdFeasible() ) {
//            System.out.println("Account ID is feasible!");
//        }else{
//            System.out.println("Account ID is NOT FOUND!");
//        }// # Test class AccountValidityChecker #
//        System.out.println("Input account ID:");
//        Scanner scanner = new Scanner(System.in);
//        String inputAccountId = scanner.nextLine();
//        // Decalre and construct instance of class
//        AccountValidityChecker accountValidityChecker = new AccountValidityChecker(inputAccountId);
//        // Test method checkIsAccountIdProperLength()
//        if ( accountValidityChecker.checkIsAccountIdProperLength() ) {
//            System.out.println("Account ID is of proper length!");
//        }else{
//            System.out.println("Account ID is of INCORRECT LENGTH!");
//        }
//        // Test method checkIsAccountIdOnlyDigit()
//        if ( accountValidityChecker.checkIsAccountIdOnlyDigit() ) {
//            System.out.println("Account ID has proper format!");
//        }else{
//            System.out.println("Account ID must contain ONLY DIGITS!");
//        }
//
//        // # Test class AccountFeasibilityChecker #
//        // Decalre and construct instance of class
//        AccountFeasibilityChecker accountFeasibilityChecker = new AccountFeasibilityChecker(inputAccountId);
//        // Test method checkIsAccountIdFeasible()
//        if ( accountFeasibilityChecker.checkIsAccountIdFeasible() ) {
//            System.out.println("Account ID is feasible!");
//        }else{
//            System.out.println("Account ID is NOT FOUND!");
//        }

        // # Test class AccountManager #
        // Decalre and construct instance of class
        ConsoleReader consoleReader = new ConsoleReader();
        ConsolePrinter consolePrinter = new ConsolePrinter();
        ConsoleManager consoleManager = new ConsoleManager(consoleReader, consolePrinter);
        AccountFeasibilityChecker accountFeasibilityChecker = new AccountFeasibilityChecker();
        AccountValidityChecker accountValidityChecker = new AccountValidityChecker();
        AccountManager accountManager = new AccountManager(consoleManager, accountValidityChecker, accountFeasibilityChecker);
        accountManager.conductCheck();

    }

}
