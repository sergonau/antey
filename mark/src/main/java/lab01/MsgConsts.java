package lab01;

/**
 * String constants container for output
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public enum MsgConsts {
    MSG_FINAL_WORD("Exit commant entered. Closing..."),
    MSG_CYCLE_PROMPT("Enter account name: "),
    MSG_HEAD1("Wellcome to account check program.\nEnter account name or "),
    MSG_HEAD2("for exit\n\n"),
    MSG_ACCOUNT_IS_VALID("OK\n"),
    MSG_ACCOUNT_NOT_FOUND_EXCEPTION("AccountNotFoundException: Account was not found\n"),
    MSG_ACCOUNT_FORMAT_EXCEPTION("IllegalArgumentException: Account should have 10 characters length and should not contain non-numeric characters\n");

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
