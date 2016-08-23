package task01;

/**
 * Created by SDem on 23.08.2016.
 * ver: 001
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

    private boolean checkDigitInString (String str) {
        boolean isDigit;
        for (int i = 0; i < str.length(); i++) {
            isDigit = Character.isDigit(str.charAt(i));
            if ( !isDigit ) {
                return false;
            }
        }
        return true;
    }

    boolean checkAccountName(String accountName) {
        if  (accountName.length() != 10) {
            throw new InputException("Account length must be 10 characters");
        } else if (checkDigitInString(accountName)) {
            throw new InputException("Account must contained only digit");
        } else if (!CommonFunctions.isStringFound(accountName,ACCOUNTS)) {
            throw new AccountNoFoundException("Account not found");
        } else {
            return true;
        }
    }
}
