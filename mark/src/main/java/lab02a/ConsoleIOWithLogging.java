package lab02a;

import lab02.ConsoleInOut;
import lab02.MsgConsts;
import java.io.*;

/**
 * Created by Mark Lobanov on 06.09.2016.
 */



public class ConsoleIOWithLogging extends lab02.ConsoleInOut {
    private String customLevel1Message;
    private LogManager logManager;

    public ConsoleIOWithLogging( LogManager logManager ) {
        super();
        this.customLevel1Message = "";
        this.logManager = logManager;
    }

    public void setCustomLevel1Message(String customLevel1Message) {
        this.customLevel1Message = customLevel1Message;
    }

    public void setFullLogFileName(String fullFileName) {
        logManager.setFullFileName(fullFileName );
    }

    /**
     * Method that writes menu level 1 prompt string to console
     */
    @Override
    public void printLevel1Prompt() {
        if (  customLevel1Message.isEmpty() ) {
            super.printLevel1Prompt();
        } else {
            writeString( MsgConsts.MSG_NEW_LINE.toString() );
            writeString( "Enter account name or " );
            writeString( getQuitSignatures() );
            writeString( MsgConsts.MSG_PROMPT_LEVEL1add.toString() );
        }
    }

    /**
     * Method that writes string with \n to console
     *
     * @param str String that should be displayed
     */
    @Override
    public void writeStringLn(String str) {
        try {
            super.writeStringLn(str);
            logManager.writeStrLn(str);
        } catch (IOException e) {
            super.writeStringLn("IOException: "+e.getMessage() );
        }
    }



    public void initLogManager() {
        logManager.init();
    }
    public void downLogManager() {
        logManager.down();
    }
}
