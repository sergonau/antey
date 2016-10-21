package lab02a.accounts;

import java.io.IOException;

import lab02a.checkers.IInputChecker;
import lab02a.consoles.ConsoleManager;
import lab02a.logger.LogWriter;
import lab02a.workerspool.IWorkRunnable;
import lab02a.workerspool.WorkerKeyInfo;

import static lab02a.accounts.AccountConsts.MSG_ANFE;
import static lab02a.accounts.AccountConsts.MSG_IOE;
import static lab02a.accounts.AccountConsts.MSG_ACC_FOUND;
import static lab02a.accounts.AccountConsts.MSG_ACC_PROMPT;
import static lab02a.accounts.AccountConsts.MSG_ACC_WELLCOME;
import static lab02a.accounts.AccountConsts.MSG_ACC_FINAL_WORD;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public class AccountWorker implements IWorkRunnable {
    private static final String logAccountsValidation = "reports/accounts_validation/mark.acc.report.%s.txt";
    private WorkerKeyInfo keyInfo;
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

        logger.setFileName( logAccountsValidation );

        console.switchToNextLevel();
        console.setPrompt( MSG_ACC_PROMPT.toString() );
        console.setChecker( checker );

        console.newLine();
        console.writeStrLn( MSG_ACC_WELLCOME.toString() );
        while ( console.hasProperInputString() ) {

            if ( console.lastInputValueIsCorrect() ) {
                accountEntered = console.getLastInputValueAsString();
                try {

                    if ( isAccountFound( accountEntered ) ) {
                        String msg = String.format(MSG_ACC_FOUND.toString(), accountEntered);
                        console.writeStrLn( msg );
                        logger.writeStrLn( msg );
                        console.newLine();
                    } else {
                        logger.writeStrLn( String.format(MSG_ANFE.toString(), accountEntered) );
                    }

                } catch (AccountNotFoundException e) {
                    console.writeStrLn( String.format(MSG_ANFE.toString(), accountEntered) );
                } catch (IOException e) {
                    console.writeStrLn( String.format(MSG_IOE.toString(), logger.getFileName()) );
                }
            }
        }
        console.switchToPrevLevel();
        console.writeStrLn( MSG_ACC_FINAL_WORD.toString() );
    }

}
