package lab02a;

import lab01.Accounts;
import lab01.AccountNotFoundException;
import lab01.MsgConsts;

import lab02.TriangleCalculatorFactory;
import lab02.TriangleTransferData;
import lab02.InputParamsParser;
import lab02.Worker;

/**
 * Java with Sergey Naumovich
 * Homework #2a

 * Main worker class
 *
 * @author Mark Lobanov (31.08.2016)
 * @version 2.1.0
 */
public class WorkerLab2a extends Worker {
    private Accounts accountList;
    private ConsoleIOWithLogging console;

    /**
     * Class constructor
     *
     * @param aFactory Triangle factory
     * @param aData
     * @param aConsole Console reader/writer
     * @param aParser
     */
    public WorkerLab2a(Accounts aAccountList, TriangleCalculatorFactory aFactory, TriangleTransferData aData, ConsoleIOWithLogging aConsole, InputParamsParser aParser) {
        super(aFactory, aData, aConsole, aParser);
        this.accountList = aAccountList;
        this.console = aConsole;
    }

    public void setFullLogFileName(String fullLogFileName) {
        this.console.setFullLogFileName( fullLogFileName );
    }

    /**
     * main working method
     */
    @Override
    public void runWork() {
        try {
            console.initLogManager();
            super.runWork();
        } finally {
            console.downLogManager();
        }
    }

    public boolean loggedIn() {
        try {
            console.initLogManager();

            console.setCustomLevel1Message("Enter account name: ");
            while ( console.hasProperLevel1InputString() ) {
                // If user not enters exit command
                try {
                    if ( accountList.checkAccountName( console.getLastInputValueLevel1() ) ) {
                        console.writeStringLn( String.format("SUCCESS! User %s is logged in.", console.getLastInputValueLevel1() ));
                        console.setCustomLevel1Message("");
                        return true;
                    }
                } catch (AccountNotFoundException e) {
                    console.writeStringLn( String.format(MsgConsts.MSG_ACCOUNT_NOT_FOUND_EXCEPTION.toString(), console.getLastInputValueLevel1() ));
                } catch (IllegalArgumentException e) {
                    console.writeStringLn( MsgConsts.MSG_ACCOUNT_FORMAT_EXCEPTION.toString() );
                }

            }
            console.writeStringLn( MsgConsts.MSG_FINAL_WORD.toString() );
            return false;
        } finally {
            console.downLogManager();
        }
    }
}


