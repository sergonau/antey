package task01;

import java.io.IOException;
import static task01.CommonFunctions.isExitCommand;
/**
 * Created by sdem on 27.08.2016.
 * ver 004
 */
class ConsoleProcessor {

    private ConsoleIn consIn;
    private ConsoleOut consOut;
    private ValuesChecker valuesChecker;

    ConsoleProcessor(ConsoleIn consIn, ConsoleOut consOut) {
        this.consIn = consIn;
        this.consOut = consOut;
        this.valuesChecker = new ValuesChecker();
    }

    void writeLine(String msg) {
        this.consOut.writeLine(msg);
    }

   String getInValue() {
        String inValue = this.consIn.getInValue();
        if (!isExitCommand(inValue)) {
            this.valuesChecker.checkInValue(inValue);
        }
        return inValue;
    }

    void proposeUserToInputValue() {
        this.writeLine(MsgOutToConsole.MSG_INPUT_ACCOUNT.toString());
    }

    void goodbye() {
        this.writeLine(MsgOutToConsole.MSG_GOODBYE.toString());
    }

    void writeException(Exception e) throws IOException {
        this.consOut.writeException(e);
    }
}
