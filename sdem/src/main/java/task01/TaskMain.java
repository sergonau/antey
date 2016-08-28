package task01;

import java.io.IOException;

/**
 * Created by SDem on 23.08.2016.
 * ver: 003
 */
public class TaskMain {

    public static void main(String[] args) throws IOException {

        ConsoleProcessor consoleProcessor = new ConsoleProcessor(new ConsoleIn(),new ConsoleOut());
        Accounts accounts = new Accounts();

        TaskRun taskRun = new TaskRun(consoleProcessor, accounts);
        taskRun.doWork();
    }
}
