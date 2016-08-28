package task01;

import java.io.IOException;
import static task01.CommonFunctions.isExitCommand;

/**
 * Created by SDem on 22.08.2016.
 * ver: 004
 */
class TaskRun {

    private Accounts accounts;
    private ConsoleProcessor consoleProcessor;

    TaskRun(ConsoleProcessor consoleProcessor, Accounts accounts) {
        this.consoleProcessor = consoleProcessor;
        this.accounts = accounts;
    }

    void doWork() throws IOException {
        String inputValue;
        while (true) {
            try {
                this.consoleProcessor.proposeUserToInputValue();
                inputValue = this.consoleProcessor.getInValue();
                if (!isExitCommand(inputValue)) {
                    if (this.accounts.checkAccountName(inputValue)) {
                        this.consoleProcessor.writeLine(MsgOutToConsole.MSG_ACCOUNT_IS_VALID.toString());
                    }
                } else {
                    this.consoleProcessor.goodbye();
                    break;
                }
            } catch (AccountNoFoundException | InputException e) {
                this.consoleProcessor.writeException(e);
            }
        }
    }
}
