package lab02a;

import static lab02a.consoles.ConsoleConsts.MSG_MAIN_PROMPT;
import static lab02a.consoles.ConsoleConsts.MSG_MAIN_WELLCOME;
import static lab02a.consoles.ConsoleConsts.MSG_MAIN_FINAL_WORD;
import lab02a.accounts.AccountStore;
import lab02a.accounts.AccountWorker;
import lab02a.checkers.CheckerForInt;
import lab02a.checkers.CheckerForDigitalString;
import lab02a.common.IWorkRunnable;
import lab02a.consoles.ConsoleInputData;
import lab02a.consoles.ConsoleManager;
import lab02a.logger.LogWriter;
import lab02a.triangles.InputParamsParser;
import lab02a.triangles.TriangleCalculatorFactory;
import lab02a.triangles.TriangleWorker;

import java.util.ArrayList;

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
        ArrayList<IWorkRunnable> workers = new ArrayList<>();
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

        // 0 item
        workers.add( new AccountWorker( console,
                new CheckerForDigitalString( ACCOUNT_LEN ),
                accountStore,
                logger ) );
        // 1 item
        workers.add( new TriangleWorker( console,
                menuChecker,
                new TriangleCalculatorFactory(),
                new InputParamsParser(),
                logger ) );

        console.writeStrLn( MSG_MAIN_WELLCOME.toString() );

        // maib work cycle
        while ( console.hasProperInputString() ) {
            menuChecker.setRange(1, 2);
            if ( console.lastInputValueIsCorrect() ) {
                workers.get( console.getLastInputValueAsInt()-1 ).runWork();
            }
            console.newLine();
        }

        console.writeStrLn( MSG_MAIN_FINAL_WORD.toString() );
    }

}
