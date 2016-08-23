package task01;

import java.io.IOException;
import static task01.ConsoleOut.*;

/**
 * Created by SDem on 22.08.2016.
 * ver: 001
 */
class TaskRun {

    private Accounts accounts;
    private ConsoleIn input;

    TaskRun(ConsoleIn input, Accounts accounts) {
        this.input = input;
        this.accounts = accounts;
    }

    void Run() throws IOException {
        while (input.hasEnterValue()) {
            try {
                if (accounts.checkAccountName(input.getInValue())) {
                    writeLine("Account is valid");
                }
            } catch (AccountNoFoundException | InputException e) {
                writeException(e);
            }

        }
    }

}
