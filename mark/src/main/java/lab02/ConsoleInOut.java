package lab02;

import java.util.Scanner;

/**
 * Console reader/writer
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.3
 */
public class ConsoleInOut {
    /** Quit commands */
    private static final String[] QUIT_SIGNATURES = {"e", "q", "exit", "quit"};
    /** proxy object for console input */
    private Scanner in;
    /** values that was entered on menu level 1 */
    private String lastInputValueLevel1;
    /** values that was entered on menu level 2 */
    private String lastInputValueLevel2;

    /**
     * class constructor
     */
    public ConsoleInOut() {
        in = new Scanner(System.in);
        this.lastInputValueLevel1 = "";
        this.lastInputValueLevel2 = "";
    }

    /**
     * Method that checks does exit command entered?
     *
     * @param inputString String to compare with quit signatures
     * @return true If quit signatures was found
     */
    private boolean isExitCommand(String inputString) {
        return Utils.isStringFound(inputString, QUIT_SIGNATURES);
    }

    /**
     * printing signatures for program quit
     */
    protected String getQuitSignatures() {
        String res = "";
        for (String str : QUIT_SIGNATURES) {
            res += "\"" + str + "\" ";
        }
        return res;
    }

    /**
     * Method that writes menu level 1 prompt string to console
     */
    protected void printLevel1Prompt() {
        writeString( MsgConsts.MSG_NEW_LINE.toString() );
        writeString( MsgConsts.MSG_PROMPT_LEVEL1.toString() );
        writeString( getQuitSignatures() );
        writeString( MsgConsts.MSG_PROMPT_LEVEL1add.toString() );
    }

    /**
     * Method that writes menu level 2 prompt string to console
     */
    private void printLevel2Prompt(TrialgleCalculationKind triKind) {

        switch ( triKind ) {
            case SIDE_AND_HEIGHT: {
                writeString(MsgConsts.MSG_PROMPT_SIDE_AND_HEIGHT.toString());
                break;
            }
            case THREE_SIDES: {
                writeString(MsgConsts.MSG_PROMPT_THREE_SIDES.toString());
                break;
            }
            case TWO_SIDES_AND_ANGLE: {
                writeString(MsgConsts.MSG_PROMPT_TWO_SIDES_AND_ANGLE.toString());
                break;
            }
            case NOTHING: {
                break;
            }
        }
        writeString(getQuitSignatures());
        writeString(MsgConsts.MSG_PROMPT_LEVEL2add.toString());
    }


    /**
     * Getter for private class member
     *
     * @return Value if private member LastInputValue
     */
    public String getLastInputValueLevel1() {
        return lastInputValueLevel1;
    }

    /**
     * Getter for private class member
     *
     * @return Value if private member LastInputValue
     */
    public String getLastInputValueLevel2() {
        return lastInputValueLevel2;
    }

    /**
     * Method that writes string to console
     *
     * @param str String that should be displayed
     */
    public void writeString(String str) {
        System.out.print(str);
    }

    /**
     * Method that writes string with \n to console
     *
     * @param str String that should be displayed
     */
    public void writeStringLn(String str) {
        System.out.print(str + MsgConsts.MSG_NEW_LINE.toString());
    }

    /**
     * Method that writes string to console with given format
     *
     * @param format String that should be displayed
     * @param args   Objects that should be displayed within format string
     */
    public void writeStringFormat(String format, Object... args) {
        System.out.printf(format, args);
    }


    /**
     * Method that gets string from console from menu level 1
     *
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperLevel1InputString() {
        printLevel1Prompt();
        lastInputValueLevel1 = Utils.prepareString( in.nextLine().trim().toLowerCase() );
        return ! isExitCommand ( lastInputValueLevel1 );
    }


    /**
     * Method that gets string from console from menu level 2
     *
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperLevel2InputString(TrialgleCalculationKind triKind) {
        printLevel2Prompt( triKind );
        lastInputValueLevel2 = Utils.prepareString( in.nextLine().trim().toLowerCase() );
        return ! isExitCommand ( lastInputValueLevel2 );
    }
}
