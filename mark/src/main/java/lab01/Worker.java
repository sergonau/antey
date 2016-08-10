package lab01;

import lab01.Accounts;
import lab01.MsgConsts;
import lab01.ConsoleInOut;
import java.lang.IllegalArgumentException;

/**
 * Main working class
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.4
 */
public class Worker {
    /** Account list private member */
    private Accounts accList;
    /** Console reader/writer private member */
    private ConsoleInOut cons;

    /**
     * Class constructor
     * @param accountList Object that contains account list
     * @param aConsole Console reader/writer
     * */
    public Worker(Accounts accountList, ConsoleInOut aConsole) {
        this.accList = accountList;
        this.cons = aConsole;
    }


    /** print common information about program */
    private void init() {
        cons.writeString( MsgConsts.MSG_HEAD1.toString() );
        cons.printQuitSignatures();
        cons.writeString( MsgConsts.MSG_HEAD2.toString() );
    }

    /** print "program is closing" message */
    private void down() {
        cons.writeString( MsgConsts.MSG_FINAL_WORD.toString() );
    }

    /** main working method */
    public void runWork() {
        // program initialization
        init();
        // main work cycle, test the console input
        while ( cons.hasProperInputString() ) {

            // If user not enters exit command
            try {
              if ( accList.checkAccountName( cons.getLastInputValue() ) ) {
                  cons.writeString( MsgConsts.MSG_ACCOUNT_IS_VALID.toString() );
              }
            } catch (AccountNotFoundException e) {
                cons.writeString( MsgConsts.MSG_ACCOUNT_NOT_FOUND_EXCEPTION.toString() );
            } catch (IllegalArgumentException e) {
                cons.writeString( MsgConsts.MSG_ACCOUNT_FORMAT_EXCEPTION.toString() );
            }

        }
        // program is closing
        down();
    }
}
