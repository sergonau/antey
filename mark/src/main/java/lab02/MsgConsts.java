package lab02;

/**
 * String constants container for output
 *
 * @author Mark Lobanov (04.08.2016)
 * @version 2.0.3
 */
public enum MsgConsts {
    MSG_WELLCOME("Wellcome to triangle area calculator!\n"),
    MSG_FINAL("Exit commant entered. Closing..."),
    MSG_NEW_LINE("\n"),

    MSG_IAE("IllegalArgumentException: "),
    MSG_NFE("NumberFormatException: "),

    MSG_ERROR_TRIALGLE_KIND_IS_NOT_SIDE_AND_HEIGHT("triangleKind != TrialgleCalculationKind.SIDE_AND_HEIGHT"),
    MSG_ERROR_TRIALGLE_KIND_IS_NOT_THREE_SIDES("triangleKind != TrialgleCalculationKind.THREE_SIDES"),
    MSG_ERROR_TRIALGLE_KIND_IS_NOT_TWO_SIDES_AND_ANGLE("triangleKind != TrialgleCalculationKind.TWO_SIDES_AND_ANGLE"),

    MSG_PARSE_ERROR_IS_NOT_NUMERIC_VALUE("<%s> is not a numeric value"),
    MSG_PARSE_ERROR_IS_NOT_DOUBLE_VALUE("<%s> is not a double value"),
    MSG_PARSE_ERROR_EMPTY_CHOICE("Calculation param cannot be empty"),
    MSG_PARSE_ERROR_PARAM_1_3("Calculation param must be in 1..3. Actual value="),
    MSG_PARSE_ERROR_EMPTY_PARAMS("Triangle params string cannot be empty or null"),
    MSG_PARSE_ERROR_MUST_BE_2_PARAMS("Triangle params count must be two: <Side> and <Height>. Actual params count="),
    MSG_PARSE_ERROR_INVALID_SIDE_SIZE("Side value must be greater than zero. Actual size="),
    MSG_PARSE_ERROR_INVALID_HEIGHT_SIZE("Height value must be greater than zero. Actual size="),
    MSG_PARSE_ERROR_MUST_BE_3_1_PARAMS("Triangle params count must be three: <SideA>  <SideB> and <SideC>. Actual params count="),
    MSG_PARSE_ERROR_INVALID_SIDEA_SIZE("SideA value must be greater than zero. Actual size="),
    MSG_PARSE_ERROR_INVALID_SIDEB_SIZE("SideB value must be greater than zero. Actual size="),
    MSG_PARSE_ERROR_INVALID_SIDEC_SIZE("SideC value must be greater than zero. Actual size="),
    MSG_PARSE_ERROR_INVALID_SIDES_SUM("The sum of the lengths of any two sides must be greater than the length of the third side. Actual sizes: <%f> <%f> <%f>"),
    MSG_PARSE_ERROR_MUST_BE_3_2_PARAMS("Triangle params count must be three: <SideA>  <SideB> and <angle>. Actual params count="),
    MSG_PARSE_ERROR_INVALID_ANGLE_SIZE("Angle value must in 1..179. Actual size="),

    MSG_INIT_ERROR_NOT_SIDE_AND_HEIGHT("Illegal init source. data.getTriangleCalculationKind() != TrialgleCalculationKind.SIDE_AND_HEIGHT"),
    MSG_INIT_ERROR_NOT_THREE_SIDES("Illegal init source. data.getTriangleCalculationKind() != TrialgleCalculationKind.THREE_SIDES"),
    MSG_INIT_ERROR_NOT_TWO_SIDES_AND_ANGLE("Illegal init source. data.getTriangleCalculationKind() != TrialgleCalculationKind.TWO_SIDES_AND_ANGLE"),

    MSG_LEVEL1_INVALID_CHICE("Invalid choice! Must be 1..3 or exit command. Actual enter: "),

    MSG_PROMPT_LEVEL1("Enter calculation method:\n1. By the side and the height drawn to it\n2. By three sides\n3. By two sides and the angle between them\nor "),
    MSG_PROMPT_LEVEL1add("for exit\nYour choice: "),
    MSG_PROMPT_SIDE_AND_HEIGHT("\nEnter side and the height drawn to it length values separated by space or "),
    MSG_PROMPT_THREE_SIDES("\nEnter three sides length values separated by space or "),
    MSG_PROMPT_TWO_SIDES_AND_ANGLE("\nEnter two sides length values and size of an angle in degrees separated by space or "),
    MSG_PROMPT_LEVEL2add("for exit: ");


    // inner message field
    private String msg;
    // hidden constructor
    private MsgConsts(String message) {
        this.msg = message;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
