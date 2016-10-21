package lab02a.accounts;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public enum AccountConsts {
    MSG_ACC_WELLCOME("Accout seacher is here!\nRule: account should have 10 characters length and should not contain non-numeric characters!\n"),
    MSG_ACC_FINAL_WORD("Exit commant entered. Accout seacher is closing ..."),
    MSG_ACC_PROMPT("Enter account name or %sfor exit: "),
    MSG_ACC_FOUND("Account <%s> was found. (OK)"),

    MSG_ANFE("AccountNotFoundException: Account <%s> was not found"),
    MSG_IOE("IOException: Error writing to file <%s>");


    // inner message field
    private String msg;

    // hidden constructor
    private AccountConsts(String message) {
        this.msg = message;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}