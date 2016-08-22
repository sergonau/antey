package lab02;

/**
 * Java with Sergey Naumovich
 * 
 * Main runnable class
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.1
 */
public class RunMain {

    public static void main(String[] args) {
        // main worker class initialization
        Worker worker = new Worker( new TriangleFactory(), new ConsoleInOut() );
        // working start
        worker.runWork();
    }

}
