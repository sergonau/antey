package lab02a;

import lab01.Accounts;

import lab02.TriangleCalculatorFactory;
import lab02.TriangleTransferData;
import lab02.InputParamsParser;

/**
 * Java with Sergey Naumovich
 * Homework #2a
 *
 * Main runnable class
 *
 * @author Mark Lobanov (31.08.2016)
 * @version 2.1.0
*/
public class RunMainLab2a {
    private static final String logAccountsValidation = "reports/accounts_validation/mark.acc.report.%03d.txt";
    private static final String logGeometryCalculation = "reports/geometry_calculation/mark.geom.report.%03d.txt";

    public static void main(String[] args) {
        // main worker class initialization
        WorkerLab2a worker = new WorkerLab2a(new Accounts(),
                                   new TriangleCalculatorFactory(),
                                   new TriangleTransferData(),
                                   new ConsoleIOWithLogging( new LogManager() ),
                                   new InputParamsParser());

        // setting 1st log
        worker.setFullLogFileName( logAccountsValidation );
        if ( worker.loggedIn() ) {
            // switching to 2nd log
            worker.setFullLogFileName( logGeometryCalculation );
            // working start
            worker.runWork();
        }
    }

}
