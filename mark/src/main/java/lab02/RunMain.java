package lab02;

/**
 * Java with Sergey Naumovich
 * Homework #2
 * Main runnable class
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.3
 */
public class RunMain {

    public static void main(String[] args) {
        // main worker class initialization
        Worker worker = new Worker(new TriangleCalculatorFactory(),
                                   new TriangleTransferData(),
                                   new ConsoleInOut(),
                                   new InputParamsParser());
        // working start
        worker.runWork();
    }

}
