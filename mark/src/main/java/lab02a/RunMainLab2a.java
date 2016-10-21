package lab02a;

import lab02a.accounts.AccountStore;
import lab02a.accounts.AccountWorker;
import lab02a.checkers.CheckerForInt;
import lab02a.checkers.CheckerForDigitalString;
import lab02a.consoles.ConsoleInputData;
import lab02a.consoles.ConsoleManager;
import lab02a.logger.LogWriter;
import lab02a.triangles.InputParamsParser;
import lab02a.triangles.TriangleCalculatorFactory;
import lab02a.triangles.TriangleWorker;
import lab02a.workerspool.WorkersPool;
import lab02a.workerspool.WorkerKeyInfo;

import static lab02a.consoles.ConsoleConsts.MSG_MAIN_PROMPT;
import static lab02a.consoles.ConsoleConsts.MSG_MAIN_WELLCOME;
import static lab02a.consoles.ConsoleConsts.MSG_MAIN_FINAL_WORD;

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
    private static final int ACCOUNT_LEN = 10;

    public static void main(String[] args) {
        WorkersPool workers = new WorkersPool();

        ConsoleManager console;
        AccountStore accountStore = new AccountStore();
        CheckerForInt menuChecker = new CheckerForInt();
        LogWriter logger = new LogWriter();

        console = new ConsoleManager();
        console.setInputData( new ConsoleInputData() );
        console.addInputDatalevel().
                setPrompt( MSG_MAIN_PROMPT.toString() ).
                setChecker( menuChecker );

        console.addInputDatalevel(); // empty 2 data level
        console.addInputDatalevel(); // empty 3 data level

        // AccountWorker item
        workers.addWorker(new WorkerKeyInfo("1"), new AccountWorker( console,
                new CheckerForDigitalString( ACCOUNT_LEN ),
                accountStore,
                logger ) );
        // TriangleWorker item
        workers.addWorker(new WorkerKeyInfo("2"), new TriangleWorker( console,
                menuChecker,
                new TriangleCalculatorFactory(),
                new InputParamsParser(),
                logger ) );

        console.writeStrLn( MSG_MAIN_WELLCOME.toString() );

        // main work cycle
        while ( console.hasProperInputString() ) {
            menuChecker.setMenuInputValueRange(1, 2);
            if ( console.lastInputValueIsCorrect() ) {
                workers.getWorker( console.getLastInputValueAsString() ).runWork();
            }
            console.newLine();
        }
        workers.clear();
        console.writeStrLn( MSG_MAIN_FINAL_WORD.toString() );
    }
}
