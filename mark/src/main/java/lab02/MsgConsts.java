package lab02;

/**
 * String constants container for output
 * @author Mark Lobanov (04.08.2016)
 * @version 2.0.1
 */
public enum MsgConsts {
    MSG_WELLCOME("Wellcome to triangle area calculator!\n"),
    MSG_FINAL("Exit commant entered. Closing..."),
//    MSG_ACCOUNT_NOT_FOUND_EXCEPTION("AccountNotFoundException: Account %s was not found\n"),
//    MSG_ACCOUNT_FORMAT_EXCEPTION("IllegalArgumentException: Account should have 10 characters length and should not contain non-numeric characters\n"),

    MSG_NEW_LINE("\n"),
    MSG_MENU_LEVEL1("Enter calculation method:\n1. By the side and the height drawn to it\n2. By three sides\n3. By two sides and the angle between them\nor "),
    MSG_MENU_LEVEL1add("for exit\nYour choice: "),
    MSG_MENU_LEVEL1_1("\nEnter side and the height drawn to it length values separated by space or "),
    MSG_MENU_LEVEL1_2("\nEnter three sides length values separated by space or "),
    MSG_MENU_LEVEL1_3("\nEnter two sides length values and size of an angle in degrees separated by space or "),
    MSG_MENU_LEVEL2add("for exit: "),
	MSG_SETUP_TRIANGLE_ERROR("(setupTriangle error): ");
	
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
