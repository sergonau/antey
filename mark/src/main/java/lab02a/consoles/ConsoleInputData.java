package lab02a.consoles;

import java.util.ArrayList;

import lab02a.checkers.IInputChecker;


/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public class ConsoleInputData {
    private ArrayList<String> inputData = new ArrayList<String>();
    private ArrayList<String> prompts = new ArrayList<String>();
    private ArrayList<IInputChecker> checkers = new ArrayList<IInputChecker>();

//    public ConsoleInputData() {
//    }

    private void internalSetArrayString(ArrayList<String> stringArray, int index, String stringData) throws IndexOutOfBoundsException {
        if ( (index >= 0) && (index < stringArray.size()) ) {
            stringArray.set(index , stringData);
        } else {
            throw new IndexOutOfBoundsException("ConsoleInputData level index is out of bounds. Index value=" + index );
        }
    }

    private String internalGetArrayString(ArrayList<String> stringArray, int index) throws IndexOutOfBoundsException {
        if ( (index >= 0) && (index < stringArray.size()) ) {
            return stringArray.get( index );
        } else {
            throw new IndexOutOfBoundsException("ConsoleInputData level index is out of bounds. Index value=" + index );
        }
    }


    public void setChecker(int index, IInputChecker checker) throws IndexOutOfBoundsException {
        if ( (index >= 0) && (index < checkers.size()) ) {
            checkers.set(index , checker);
        } else {
            throw new IndexOutOfBoundsException("ConsoleInputData level index is out of bounds. Index value=" + index );
        }
    }

    public IInputChecker getChecker(int index) throws IndexOutOfBoundsException {
        if ( (index >= 0) && (index < checkers.size()) ) {
            return checkers.get( index );
        } else {
            throw new IndexOutOfBoundsException("ConsoleInputData level index is out of bounds. Index value=" + index );
        }
    }

    public String getPrompt(int levelIndex) throws IndexOutOfBoundsException {
        return internalGetArrayString(prompts, levelIndex);
    }


    public void setPrompt(int levelIndex, String promptData) throws IndexOutOfBoundsException {
        internalSetArrayString(prompts, levelIndex, promptData);
    }


    public String getDataString(int levelIndex) throws IndexOutOfBoundsException {
        return internalGetArrayString(inputData, levelIndex);
    }

    public int getDataInt(int levelIndex) throws IndexOutOfBoundsException {
        return Integer.parseInt( internalGetArrayString(inputData, levelIndex) );
    }

    public void setDataString(int levelIndex, String stringData) throws IndexOutOfBoundsException {
        internalSetArrayString(inputData, levelIndex, stringData);
    }


    public ConsoleInputData addDataLevel() {
        this.inputData.add("");
        this.prompts.add("");
        this.checkers.add( null );
        return this;
    }

    public void clear() {
        this.inputData.clear();
        this.prompts.clear();
        this.checkers.clear();
    }

}
