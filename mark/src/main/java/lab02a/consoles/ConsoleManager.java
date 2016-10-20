package lab02a.consoles;

import java.util.Scanner;

import lab02a.checkers.IInputChecker;
import lab02a.common.IStringWriter;

import static lab02a.common.Utils.prepareString;
import static lab02a.common.Utils.isStringFound;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public class ConsoleManager implements IStringWriter {
    /** Quit commands */
    private static final String[] QUIT_SIGNATURES = {"e", "q", "exit", "quit"};
    /** proxy object for console input */
    private Scanner in;
    /** object for input data storing */
    private ConsoleInputData inputData = null;
    /** field stores current data input level value */
    private int currentLevel=0;

    /**
     * class constructor
     */
    public ConsoleManager() {
        in = new Scanner(System.in);
    }

    /**
     * printing signatures for program quit
     */
    private String getQuitSignatures() {
        StringBuffer buf = new StringBuffer( Byte.MAX_VALUE );

        for (String str : QUIT_SIGNATURES) {
            buf.append( "\"" ).append( str ).append( "\" " );
        }
        return buf.toString();
    }

    /**
     * Method that checks does exit command entered?
     *
     * @param inputString String to compare with quit signatures
     * @return true If quit signatures was found
     */
    private boolean isExitCommand(String inputString) {
        return isStringFound(inputString, QUIT_SIGNATURES);
    }

    public void setInputData(ConsoleInputData inputData) {
        this.inputData = inputData;
    }

    public ConsoleManager setPrompt(String aPrompt) {
        inputData.setPrompt(currentLevel, aPrompt);
        return this;
    }

    public ConsoleManager setChecker(IInputChecker checker) {
        inputData.setChecker( currentLevel, checker );
        return this;
    }

    public ConsoleManager addInputDatalevel() {
        inputData.addDataLevel();
        return this;
    }

    public int switchToNextLevel() {
        // TODO: add range checking
        return ++currentLevel;
    }

    public int switchToPrevLevel() {
        // TODO: add range checking
        return --currentLevel;
    }




    @Override
    public void writeStrLn(String str) {
        System.out.println( str );
    }

    public void newLine() {
        writeStrLn("");
    }

    public void printPrompt() {
        System.out.print( String.format(inputData.getPrompt( currentLevel ), getQuitSignatures() ) );
    };

    /**
     * Method that gets string from console from menu level 2
     *
     * @return true If the user enters a regular string, but not exit the command
     */
    public boolean hasProperInputString() {
        String s;
        printPrompt();
        s = prepareString( in.nextLine().trim().toLowerCase() );
        inputData.setDataString( currentLevel, s );
        return ! isExitCommand ( inputData.getDataString( currentLevel ) );
    }

    public boolean lastInputValueIsCorrect() {
        boolean res;
        IInputChecker checker = inputData.getChecker( currentLevel );
        String value = inputData.getDataString( currentLevel );
        try {
             res = checker.lastInputValueIsCorrect( value );
        } catch (NumberFormatException e) {
            this.writeStrLn( e.getMessage() );
            return false;

        } catch (IllegalArgumentException e) {
            this.writeStrLn( e.getMessage() );
            return false;
        }
        return res;
    }

    public int getLastInputValueAsInt() {
        return inputData.getDataInt( currentLevel );
    }

    public String getLastInputValueAsString() {
        return inputData.getDataString( currentLevel );
    }

}
