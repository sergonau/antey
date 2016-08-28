package task01;

/**
 * Created by SDem on 23.08.2016.
 * ver: 003
 */

class Accounts {

    private static final String[] ACCOUNTS = {
        "1111111111",
        "2222222222",
        "3333333333",
        "4444444444",
        "5555555555",
        "6666666666",
        "7777777777",
        "8888888888",
        "9999999999",
        "0000000000" };

    boolean checkAccountName(String accountName) {
        for ( String account : ACCOUNTS ) {
            if ( account.equals(accountName) ) {
                return true;
            }
        }
        throw new AccountNoFoundException(MsgOutToConsole.MSG_ACCOUNT_NOT_FOUND.toString());
    }
}
