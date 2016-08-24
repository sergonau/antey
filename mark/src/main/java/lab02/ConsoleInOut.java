package lab02;

import java.util.Scanner;

/**
 * Console reader/writer
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.2
 */
public class ConsoleInOut {
    /** Quit commands */
    private static final String[] QUIT_SIGNATURES = { "e", "q", "exit", "quit" };
    /** proxy object for console input */
    private Scanner in;
    /** values that was entered */
    private TriangleData lastInputValue;
    /** triangle params parser */
    private TriangleParamsParser parser;

    /** class constructor */
    public ConsoleInOut(TriangleParamsParser aParser, TriangleData aLastInputValue) {
        in = new Scanner(System.in);
        this.parser = aParser;
        this.lastInputValue = aLastInputValue;
    }

    /**
     * Method that checks does exit command entered?
     * @param inputString String to compare with quit signatures
     * @return true If quit signatures was found
     */
    private boolean isExitCommand(String inputString) {
        return Utils.isStringFound(inputString, QUIT_SIGNATURES);
    }

    /** printing signatures for program quit */
    private String getQuitSignatures() {
        String res = "";
        for (String str : QUIT_SIGNATURES) {
            res += "\"" + str + "\" ";
        }
        return res;
    }

    /**
     * Getter for private class member
     * @return Value if private member LastInputValue
     */
    public TriangleData getLastInputValue() {
        return lastInputValue;
    }

    /**
     * Method that writes string to console
     * @param str String that should be displayed
     */
    public void writeString(String str) {
        System.out.print( str );
    }

    /**
     * Method that writes string with \n to console
     * @param str String that should be displayed
     */
    public void writeStringLn(String str) {
        System.out.print( str + MsgConsts.MSG_NEW_LINE.toString() );
    }
    /**
     * Method that writes string to console with given format
     * @param format String that should be displayed
     * @param args Objects that should be displayed within format string
     */
    public void writeStringFormat(String format, Object ... args) {
        System.out.printf(format, args);
    }

    /**
     * Method that gets string from console from menu level 1
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperLevel1InputString() {
        writeString( MsgConsts.MSG_NEW_LINE.toString() );
        writeString( MsgConsts.MSG_PROMPT_LEVEL1.toString() );
        writeString( getQuitSignatures() );
        writeString( MsgConsts.MSG_PROMPT_LEVEL1add.toString() );
        String tmp = in.nextLine().trim().toLowerCase();

        lastInputValue.clearFull();

        if ( isExitCommand( tmp ) ) {
            return false;
        } else {
            try {

                lastInputValue.setTriangleKind( parser.parseStringToTrialgleKind(tmp) );

            } catch (NumberFormatException e) {
                writeStringLn( MsgConsts.MSG_LEVEL1_INVALID_CHICE.toString() + tmp);
            } catch (IllegalArgumentException e) {
                writeStringLn( MsgConsts.MSG_IAE.toString() + e.getMessage() );
            } finally {
                return true;
            }
        }
    }

    /**
     * Method that gets string from console from menu level 2
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperLevel2InputString() {
        double[] params_arr;

        switch ( lastInputValue.getTriangleKind() ) {
            case SIDE_AND_HEIGHT: {
                writeString( MsgConsts.MSG_PROMPT_SIDE_AND_HEIGHT.toString() );
                break;
            }
            case THREE_SIDES: {
                writeString( MsgConsts.MSG_PROMPT_THREE_SIDES.toString() );
                break;
            }
            case TWO_SIDES_AND_ANGLE: {
                writeString( MsgConsts.MSG_PROMPT_TWO_SIDES_AND_ANGLE.toString() );
                break;
            }
        }
        writeString( getQuitSignatures() );
        writeString( MsgConsts.MSG_PROMPT_LEVEL2add.toString() );
        String tmp = in.nextLine().trim().toLowerCase();
        lastInputValue.clearData();

        if ( isExitCommand( tmp ) ) {
            return false;
        } else {
            try {
                // input parsing
                switch ( lastInputValue.getTriangleKind() ) {
                    case SIDE_AND_HEIGHT: {
                        params_arr = parser.parseSideAndHeight( tmp );
                        lastInputValue.setSideAndHeight( params_arr[0], params_arr[1] );
                        break;
                    }
                    case THREE_SIDES: {
                        params_arr = parser.parseThreeSides( tmp );
                        lastInputValue.setThreeSides( params_arr[0], params_arr[1], params_arr[2]);
                        break;
                    }
                    case TWO_SIDES_AND_ANGLE: {
                        params_arr = parser.parseTwoSidesAndAngle( tmp );
                        lastInputValue.setTwoSidesAndAngle( params_arr[0], params_arr[1], params_arr[2]);
                        break;
                    }
                }

            } catch (NumberFormatException e) {
                writeStringLn( MsgConsts.MSG_NFE.toString() + e.getMessage() );
            } catch (IllegalArgumentException e) {
                writeStringLn( MsgConsts.MSG_IAE.toString() + e.getMessage() );
            } finally {
                return true;
            }
        }
    }
}
