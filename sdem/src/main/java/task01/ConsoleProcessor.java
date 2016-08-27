package task01;

import java.io.IOException;
import static task01.CommonFunctions.isExitCommand;
/**
 * Created by sdem on 27.08.2016.
 * ver 002
 */
class ConsoleProcessor {

    private ConsoleIn consIn;
    private ConsoleOut consOut;
    private CheckingValues checkingValues;

    ConsoleProcessor(ConsoleIn consIn, ConsoleOut consOut) {
        this.consIn = consIn;
        this.consOut = consOut;
        this.checkingValues = new CheckingValues();
    }

    void writeLine(String msg) {

        this.consOut.writeLine(msg);

    }

    void writeLine(Exception e) throws IOException {

        this.consOut.writeLine(e);

    }

    String getInValue() {

        String inValue = this.consIn.getInValue();
        if (!isExitCommand(inValue)) {
            this.checkingValues.setValueToCheck(inValue);
            this.checkingValues.checkLength();
            this.checkingValues.checkDigitInString();
        }

        return inValue;

    }

}
