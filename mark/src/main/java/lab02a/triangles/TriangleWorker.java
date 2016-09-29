package lab02a.triangles;

import lab02a.checkers.CheckerForDoubleArray;
import lab02a.checkers.CheckerForInt;
import lab02a.common.IWorkRunnable;
import lab02a.consoles.ConsoleManager;
import lab02a.logger.LogWriter;

import java.io.IOException;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public class TriangleWorker implements IWorkRunnable {
    private static final String logGeometryCalculation = "reports/geometry_calculation/mark.geom.report.%s.txt";
    /** Console reader/writer private class member */
    private ConsoleManager console;
    /** Factory for triangle calculators */
    private TriangleCalculatorFactory factory;
    private InputParamsParser parser;
    private CheckerForInt checker;
    private TrialgleCalculationKind selectedKind;
    private ITriangleCalculator calculator;
    LogWriter logger;

    public TriangleWorker(ConsoleManager console, CheckerForInt checker, TriangleCalculatorFactory factory, InputParamsParser parser, LogWriter logger) {
        this.console = console;
        this.checker = checker;
        this.factory = factory;
        this.parser = parser;
        this.logger = logger;
    }


    private TrialgleCalculationKind parseIntToTrialgleCalculationKind(int value) {
        switch ( value ) {
            case 1: {
                return TrialgleCalculationKind.SIDE_AND_HEIGHT;
            }
            case 2: {
                return TrialgleCalculationKind.THREE_SIDES;
            }
            case 3: {
                return TrialgleCalculationKind.TWO_SIDES_AND_ANGLE;
            }
            default: {
                return TrialgleCalculationKind.NOTHING;
            }
        }
    }

    private String getPromptForCalculation() {
        switch ( selectedKind ) {
            case SIDE_AND_HEIGHT: {
                return TriangleConsts.MSG_PROMPT_SIDE_AND_HEIGHT.toString();
            }
            case THREE_SIDES: {
                return TriangleConsts.MSG_PROMPT_THREE_SIDES.toString();
            }
            case TWO_SIDES_AND_ANGLE: {
                return TriangleConsts.MSG_PROMPT_TWO_SIDES_AND_ANGLE.toString();
            }
            default: {
                return "";
            }
        }
    }

    @Override
    public void runWork() {
        logger.setParam( logGeometryCalculation );

        console.switchToNextLevel();
        console.setPrompt( TriangleConsts.MSG_TRI_PROMPT.toString() );
        console.setChecker( checker );

        console.newLine();
        console.writeStrLn( TriangleConsts.MSG_TRI_WELLCOME.toString() );
        while ( console.hasProperInputString() ) {

            checker.setRange(1, 3);
            if ( console.lastInputValueIsCorrect() ) {
                selectedKind = parseIntToTrialgleCalculationKind( console.getLastInputValueAsInt() );
                calculator = factory.newTriangleCalculator( selectedKind );
                if (calculator != null) {
                    CheckerForDoubleArray triangleParamChecker = new CheckerForDoubleArray( calculator.getParamsCount() );

                    console.switchToNextLevel();
                    console.setPrompt( getPromptForCalculation() );
                    console.setChecker( triangleParamChecker );

                    while ( console.hasProperInputString() ) {
                        if ( console.lastInputValueIsCorrect() ) {
                            double area;
                            try {
                                double[] transferData = parser.parse(selectedKind, console.getLastInputValueAsString() );
                                calculator.initFrom( transferData );
                                area = calculator.calculateArea();

                                String msg = String.format(TriangleConsts.MSG_AREA_CALCULATED.toString(), area);
                                console.writeStrLn( msg );
                                logger.writeStrLn( calculator.getParamToString()+msg );
                            } catch (NumberFormatException e) {
                                console.writeStrLn( e.getMessage() );
                            } catch (IllegalArgumentException e) {
                                console.writeStrLn( e.getMessage() );
                            } catch (IOException e) {
                                console.writeStrLn( String.format(TriangleConsts.MSG_IOE.toString(), logger.getFileName()) );
                            }
                        }
                    }
                    console.switchToPrevLevel();
                    console.newLine();
                }
            }
        }
        console.switchToPrevLevel();
        console.writeStrLn( TriangleConsts.MSG_TRI_FINAL_WORD.toString() );
    }

}
