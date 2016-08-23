package task01;

import java.io.IOException;

/**
 * Created by SDem on 23.08.2016.
 * ver: 001
 */
public class TaskMain {

    public static void main(String[] args) throws IOException {
        TaskRun taskRun = new TaskRun(new ConsoleIn(), new Accounts());
        taskRun.Run();
    }

}
