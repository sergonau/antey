package lab02a.accounts;

import lab02a.checkers.CheckerForDigitalString;
import lab02a.checkers.IInputChecker;
import lab02a.common.IWorkRunnable;
import lab02a.consoles.ConsoleManager;
import lab02a.logger.LogWriter;

import java.io.IOException;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public class AccountWorker implements IWorkRunnable {
    private static final String logAccountsValidation = "reports/accounts_validation/mark.acc.report.%s.txt";
    private ConsoleManager console;
    private IInputChecker checker;
    private AccountStore accountStore;
    private LogWriter logger;


    public AccountWorker(ConsoleManager console, IInputChecker checker, AccountStore accountStore, LogWriter logger) {
        this.console = console;
        this.checker = checker;
        this.accountStore = accountStore;
        this.logger = logger;
    }

    private boolean isAccountFound(String accountName) {
        String tmp = "";
        try {
            tmp = accountStore.isAccountFound( accountName );

        } catch (AccountNotFoundException e) {
            console.writeStrLn( e.getMessage() );
            return false;
        }
     return tmp.equals( accountName );
    }

    @Override
    public void runWork() {
        String accountEntered = "";

        logger.setParam( logAccountsValidation );

        console.switchToNextLevel();
        console.setPrompt( AccountConsts.MSG_ACC_PROMPT.toString() );
        console.setChecker( checker );

        console.newLine();
        console.writeStrLn( AccountConsts.MSG_ACC_WELLCOME.toString() );
        while ( console.hasProperInputString() ) {

            if ( console.lastInputValueIsCorrect() ) {
                accountEntered = console.getLastInputValueAsString();
                try {

                    if ( isAccountFound( accountEntered ) ) {
                        String msg = String.format(AccountConsts.MSG_ACC_FOUND.toString(), accountEntered);
                        console.writeStrLn( msg );
                        logger.writeStrLn( msg );
                        console.newLine();
                    } else {
                        logger.writeStrLn( String.format(AccountConsts.MSG_ANFE.toString(), accountEntered) );
                    }

                } catch (AccountNotFoundException e) {
                    console.writeStrLn( String.format(AccountConsts.MSG_ANFE.toString(), accountEntered) );
                } catch (IOException e) {
                    console.writeStrLn( String.format(AccountConsts.MSG_IOE.toString(), logger.getFileName()) );
                }
            }
        }
        console.switchToPrevLevel();
        console.writeStrLn( AccountConsts.MSG_ACC_FINAL_WORD.toString() );
    }

}
