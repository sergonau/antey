package task01;

/**
 * Created by sdem on 24.08.2016.
 * ver 002
 */
enum MsgOutToConsole {

    MSG_INPUT_ACCOUNT("Enter account name:"),
    MSG_ACCOUNT_IS_VALID("Entered account is valid"),
    MSG_ACCOUNT_NOT_FOUND("Account not found"),
    MSG_ACCOUNT_LENGTH_NO_VALID("Account length must be 10 characters"),
    MSG_ACCOUNT_MUST_CONTAINED_ONLY_DIGIT("Account must contained only digit"),
    MSG_GOODBYE("Goodbye");



    private String msg;
    MsgOutToConsole(String msg){
        this.msg = msg;
    }

    @Override
    public String toString() {
        return this.msg;
    }
}
