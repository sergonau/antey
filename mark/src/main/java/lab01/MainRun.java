package lab01;

import lab01.Accounts;
import lab01.ConsoleInOut;
import lab01.Worker;

/**
 * Main module
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public class MainRun {

    public static void main(String[] args) {
        // main worker class initialization
        Worker worker = new Worker( new Accounts(), new ConsoleInOut() );
        // working start
        worker.runWork();
    }
}
