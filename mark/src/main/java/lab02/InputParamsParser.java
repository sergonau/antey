package lab02;

/**
 * Parser for triangle parameters that comes as some string
 *
 * @author Mark Lobanov (23.08.2016)
 * @version 2.0.3
 */
public class InputParamsParser {
    // any spaces
    private static final String SINGLE_SPACE = " ";



    /**
     * Method than converts string to double
     * @param str input string
     * @return converted double
     * @throws NumberFormatException than input string does not contain proper double value
     */
    private double parseStringToDouble(String str) {
        String tmp = str.trim().replace(",", ".");
        try {
            return Double.parseDouble( tmp );
        } catch (NumberFormatException e) {
            throw new NumberFormatException( String.format( MsgConsts.MSG_PARSE_ERROR_IS_NOT_DOUBLE_VALUE.toString(), str.trim() ));
        }
    }


    /**
     * Method than converts string to double
     * @param str input string
     * @return converted double
     * @throws NumberFormatException than input string does not contain proper integer value
     * @throws IllegalArgumentException than input string is empty
     */
    public TrialgleCalculationKind parseStringToTrialgleCalculationKind(String str) {
        String tmp = str.trim();


        if ( Utils.isStrEmpty(tmp) ) {
            throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_EMPTY_CHOICE.toString() );
        } else {
            int i = Integer.parseInt(tmp);
            if ( (i < 1) || (i > 3) ) {
                throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_PARAM_1_3.toString() + i);
            } else {
                switch (i) {
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
        }
    }


    /**
     * Triangle setup method #1
     * accepts one side and the height drawn to it values as some string
     *
     * @param params string with triangle parameters
     * @return double array with parsed parameters
     *
     * @throws IllegalArgumentException then - params string empty or null
     *                                       - params count is not two
     * @throws NumberFormatException than one of parameters is not a double value
     */
    public double[] parseSideAndHeight(String params) {

        if ( Utils.isStrEmpty( params ) ) {
            throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_EMPTY_PARAMS.toString() );
        } else {
            double[] arr = new double[2];
            int cnt = Utils.partCount( params , SINGLE_SPACE);

            if (cnt != 2) {
                throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_MUST_BE_2_PARAMS.toString() + cnt );
            } else {
                // Side
                arr[0] = parseStringToDouble( Utils.partAt(0, params, SINGLE_SPACE) );
                if ( arr[0] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDE_SIZE.toString() + arr[0] );
                }
                // Height
                arr[1] = parseStringToDouble( Utils.partAt(1, params, SINGLE_SPACE) );
                if ( arr[1] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_HEIGHT_SIZE.toString() + arr[0] );
                }
            }
            return arr;
        }
    }

    /**
     * Triangle setup method #2
     * accepts three triangle sides lengths as some string
     * and sets inner sideA..C fields
     *
     * @param params string with triangle parameters
     * @return double array with parsed parameters
     * @throws IllegalArgumentException then - params string empty or null
     *                                       - one of sides is less then zero
     *                                       - one of sides is greater than or equal to the sum of the other two
     *                                       - params count is not three
     * @throws NumberFormatException than one of parameters is not a double value
     */
    public double[] parseThreeSides(String params) {

        if ( Utils.isStrEmpty( params ) ) {
            throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_EMPTY_PARAMS.toString() );
        } else {
            double[] arr = new double[3];
            int cnt = Utils.partCount(params, SINGLE_SPACE);

            if (cnt != 3) {
                throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_MUST_BE_3_1_PARAMS.toString() + cnt);
            } else {
                // SideA
                arr[0] = parseStringToDouble( Utils.partAt(0, params, SINGLE_SPACE) );
                if ( arr[0] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDEA_SIZE.toString() + arr[0] );
                }
                // SideB
                arr[1] = parseStringToDouble( Utils.partAt(1, params, SINGLE_SPACE) );
                if ( arr[1] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDEB_SIZE.toString() + arr[1] );
                }
                // SideC
                arr[2] = parseStringToDouble( Utils.partAt(2, params, SINGLE_SPACE) );
                if ( arr[2] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDEC_SIZE.toString() + arr[2] );
                }
                // all sides value checking
                if ( ((arr[0] + arr[1]) <= arr[2]) || ((arr[0] + arr[2]) <= arr[1] ) || ((arr[1] + arr[2]) <= arr[0]) ) {
                    throw new IllegalArgumentException( String.format( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDES_SUM.toString(), arr[0], arr[1], arr[2] ) );
                }
            }
            return arr;
        }
    }

    /**
     * Triangle setup method #3
     * accepts two triangle sides lengths and angle size in degrees between them
     * as some string
     *
     * @param params string with triangle parameters
     * @return double array with parsed parameters
     * @throws IllegalArgumentException than - parameters count is not three
     *                                       - one of sides is less than zero
     *                                       - angle size is less than zero or greater or equal then 180
     * @throws NumberFormatException than one of parameters is not a double value
     */
    public double[] parseTwoSidesAndAngle(String params) {

        if ( Utils.isStrEmpty( params ) ) {
            throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_EMPTY_PARAMS.toString() );
        } else {
            double[] arr = new double[3];
            int cnt = Utils.partCount(params, SINGLE_SPACE);

            if (cnt != 3) {
                throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_MUST_BE_3_2_PARAMS.toString() + cnt);
            } else {
                // SideA
                arr[0] = parseStringToDouble( Utils.partAt(0, params, SINGLE_SPACE) );
                if ( arr[0] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDEA_SIZE.toString() + arr[0] );
                }
                // SideB
                arr[1] = parseStringToDouble( Utils.partAt(1, params, SINGLE_SPACE) );
                if ( arr[1] <= 0 ) {
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_SIDEB_SIZE.toString() + arr[1] );
                }
                // Angle
                arr[2] = parseStringToDouble( Utils.partAt(2, params, SINGLE_SPACE) );
                if ( ( arr[2] <= 0 ) || ( arr[2] >= 180 ) ){
                    throw new IllegalArgumentException( MsgConsts.MSG_PARSE_ERROR_INVALID_ANGLE_SIZE.toString() + arr[2] );
                }
            }
            return arr;
        }
    }
}
