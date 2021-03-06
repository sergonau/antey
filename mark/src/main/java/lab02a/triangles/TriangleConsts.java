package lab02a.triangles;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public enum TriangleConsts {
    MSG_TRI_WELLCOME("Triangle calculator is here!\n"),
    MSG_TRI_FINAL_WORD("Exit commant entered. Triangle calculator is closing ..."),
    MSG_TRI_PROMPT("Enter calculation method:\n1. By the side and the height drawn to it\n2. By three sides\n3. By two sides and the angle between them\nor %sfor exit: "),

    MSG_IOE("IOException: Error writing to file <%s>"),

    MSG_AREA_CALCULATED("Triangle area=%f (OK)"),

    MSG_PROMPT_SIDE_AND_HEIGHT("Enter side and the height drawn to it length values separated by space or %sfor exit: "),
    MSG_PROMPT_THREE_SIDES("Enter three sides length values separated by space or %sfor exit: "),
    MSG_PROMPT_TWO_SIDES_AND_ANGLE("Enter two sides length values and size of an angle in degrees separated by space or %sfor exit: "),

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
    MSG_PARSE_ERROR_INVALID_ANGLE_SIZE("Angle value must in 1..179. Actual size=");



    // inner message field
    private String msg;
    // hidden constructor
    private TriangleConsts(String message) {
        this.msg = message;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
