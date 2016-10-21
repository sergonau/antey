package lab02a.consoles;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public enum ConsoleConsts {
    MSG_MAIN_WELLCOME("Wellcome to double-worker!\n"),
    MSG_MAIN_FINAL_WORD("Exit commant entered. Closing..."),
    MSG_MAIN_PROMPT("Select mode of:\n1. Account checking\n2. Triangle calculation\nor %sfor exit: ");

    // inner message field
    private String msg;
    // hidden constructor
    private ConsoleConsts(String message) {
        this.msg = message;
    }
    @Override
    public String toString() {
        return this.msg;
    }
}
