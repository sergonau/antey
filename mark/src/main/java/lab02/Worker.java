package lab02;

/**
 * Main work method
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.3
 */
public class Worker {
    /** Console reader/writer private class member */
    private ConsoleInOut cons;
    /** Factory for triangle calculators */
    private TriangleCalculatorFactory fact;
    /** triangle params parser */
    private InputParamsParser parser;
    /** triangle transfer object */
    private TriangleTransferData data;


    /**
     * Class constructor
     *
     * @param aFactory Triangle factory
     * @param aConsole Console reader/writer
     * */
    public Worker(TriangleCalculatorFactory aFactory, TriangleTransferData aData, ConsoleInOut aConsole, InputParamsParser aParser) {
        this.fact = aFactory;
        this.data = aData;
        this.cons = aConsole;
        this.parser = aParser;
    }

    /**
     * Method that sets .data.trialgleCalculationKind
     * by value inputed at menu level 1
     *
     * */
    private void setCurrentTrialgleCalculationKind() {
        try {

            data.setTriangleCalculationKind( parser.parseStringToTrialgleCalculationKind( cons.getLastInputValueLevel1() ) );

        } catch (NumberFormatException e) {
            data.canNotBeUsed();
            cons.writeStringLn( MsgConsts.MSG_NFE.toString() + String.format(MsgConsts.MSG_PARSE_ERROR_IS_NOT_NUMERIC_VALUE.toString(), cons.getLastInputValueLevel1() ));
        } catch (IllegalArgumentException e) {
            data.canNotBeUsed();
            cons.writeStringLn(MsgConsts.MSG_IAE.toString() + e.getMessage());
        }
    }

    /**
     * Method that checks .data correctness after menu level 1 choice
     *
     * */
    private boolean correctLastInputValueOnLevel1() {
        return data.getTriangleCalculationKind() != TrialgleCalculationKind.NOTHING;
    }


    /**
     * Method that sets Trialgle Calculation params
     * by value inputed at menu level 2
     *
     * */
    private void setCurrentTrialgleCalculationParams() {
        double[] params_arr;
        String tmp = cons.getLastInputValueLevel2();

        try {

            switch ( data.getTriangleCalculationKind() ) {
                case SIDE_AND_HEIGHT: {
                    params_arr = parser.parseSideAndHeight( tmp );
                    data.setSideAndHeight(params_arr[0], params_arr[1]);
                    break;
                }
                case THREE_SIDES: {
                    params_arr = parser.parseThreeSides( tmp );
                    data.setThreeSides(params_arr[0], params_arr[1], params_arr[2]);
                    break;
                }
                case TWO_SIDES_AND_ANGLE: {
                    params_arr = parser.parseTwoSidesAndAngle( tmp );
                    data.setTwoSidesAndAngle(params_arr[0], params_arr[1], params_arr[2]);
                    break;
                }
                default: {
                    data.canBeUsed();
                    break;
                }
            }

        } catch (NumberFormatException e) {
            data.canNotBeUsed();
            cons.writeStringLn(MsgConsts.MSG_NFE.toString() + e.getMessage());
        } catch (IllegalArgumentException e) {
            data.canNotBeUsed();
            cons.writeStringLn(MsgConsts.MSG_IAE.toString() + e.getMessage());
        }

    }

    private boolean correctLastInputValueOnLevel2() {
        return this.correctLastInputValueOnLevel1() && data.canBeUsed();
    }


    /** main working method */
    public void runWork() {

        cons.writeString( MsgConsts.MSG_WELLCOME.toString() );
        // working on 1 level
        while ( cons.hasProperLevel1InputString() ) {
            // parce input value into triangle calculation kind
            setCurrentTrialgleCalculationKind();
            if (correctLastInputValueOnLevel1()) {

                // creating the triangle calculator of selected kind
                TriangleCalculator triCalculator = fact.newTriangleCalculator(data.getTriangleCalculationKind());

                // working on 2 level
                while ( cons.hasProperLevel2InputString( data.getTriangleCalculationKind() ) ) {
                    // parce input values into triangle calculation params
                    setCurrentTrialgleCalculationParams();
                    if (correctLastInputValueOnLevel2()) {
                        try {
                            // triangle calculator initialization from the transfer object
                            triCalculator.initFrom( data );
                            // calculating triangle area abd printing it
                            cons.writeStringLn("TriangleArea=" + triCalculator.calculateArea() + " (OK)" );

                        } catch (IllegalArgumentException e) {
                            cons.writeStringLn( MsgConsts.MSG_IAE.toString() + e.getMessage() );
                        }
                    }
                    cons.writeString( MsgConsts.MSG_NEW_LINE.toString() );
                }
            }
        }
        cons.writeString( MsgConsts.MSG_FINAL.toString() );
    }

}
