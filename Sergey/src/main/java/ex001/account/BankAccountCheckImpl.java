package ex001.account;

import ex001.exc.AccountNotFoundException;

public class BankAccountCheckImpl implements IAccountCheck {
    private static final int ACCOUNT_LENGTH = 10;
    private final String[] accounts;

    public BankAccountCheckImpl(String[] accounts) {
        this.accounts = accounts;
    }

    public boolean isAccountValid(String account) {
        if ((account.length() != ACCOUNT_LENGTH) || !isAccountContainString(account)) {
            throw new IllegalArgumentException(String.format("Account length should be %s and contain only numbers", ACCOUNT_LENGTH));
        } else if (!isAccountApplicable(account, accounts)) {
            throw new AccountNotFoundException();
        } else {
            return true;
        }
    }

    private static boolean isAccountApplicable(String inputString, String[] arr) {
        inputString = inputString.trim().toLowerCase();
        for (String str : arr) {
            if (str.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    private static boolean isAccountContainString(String account) {
        for (int i = 0; i < account.length(); i++) {
            if (!Character.isDigit(account.charAt(i)))
                return false;
        }
        return true;
    }
}