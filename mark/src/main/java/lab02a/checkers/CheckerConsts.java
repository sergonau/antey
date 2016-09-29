package lab02a.checkers;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public enum CheckerConsts {
    SINGLE_SPACE(" "),
    MSG_STR_NFE("NumberFormatException: Entered value should have 10 characters length and should not contain non-numeric characters! Actual value=%s"),
    MSG_DBL_NFE("NumberFormatException: Entered value <%s> is not a double value"),
    MSG_DBL_IAE("IllegalArgumentException: Entered value should be have a %d parts! Actual value=%d"),
    MSG_INT_NFE("NumberFormatException: Entered value should be a positive number value or exit command! Actual value=%s"),
    MSG_INT_IAE("IllegalArgumentException: Entered number value should be in %d..%d interval! Actual value=%d");

    // inner message field
    private String msg;
    // hidden constructor
    private CheckerConsts(String message) {
        this.msg = message;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
