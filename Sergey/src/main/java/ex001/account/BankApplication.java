package ex001.account;

import ex001.ConsoleIO;
import ex001.exc.AccountNotFoundException;

public class BankApplication {

    private final IAccountCheck accountChecker;
    private final ConsoleIO cons;


    public BankApplication(IAccountCheck accountChecker, ConsoleIO aConsole){
        this.accountChecker = accountChecker;
        this.cons = aConsole;
    }

    public void runBankApp() {
        while (cons.hasProperInputString()) {
            try {
                if (accountChecker.isAccountValid(cons.getLastInputValue())) {
                    System.out.println("OK!");
                }
            } catch (AccountNotFoundException e) {
                System.out.println(("AccountNotFoundException: Account %s was not found\n"));
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());

            }

        }
    }

}
