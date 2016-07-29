/**
 * @author Mark Lobanov (29.07.2016)
 */
package run;

import java.util.Scanner;

public class RunMain {
    // proxy object for console input
    private static Scanner in;

    // console messages
    private static final String MSG_FINAL_WORD = "Exit commant entered. Closing...";
    private static final String MSG_CYCLE_PROMPT = "Enter account name: ";
    private static final String MSG_HEAD1 = "Wellcome to account check program.\nEnter account name or ";
    private static final String MSG_HEAD2 = "for exit\n\n";
    private static final String MSG_ACCOUNT_IS_VALID = "OK";
    private static final String MSG_ACCOUNT_NOT_FOUND_EXCEPTION = "AccountNotFoundException: Account is invalid";
    private static final String MSG_ILLEGAL_ARGUMENT_EXCEPTION = "IllegalArgumentException: Account value has non numeric characters";

    // Returning codes
    private static final int ACCOUNT_IS_VALID = 0;
    private static final int ACCOUNT_NON_NUMBERS_ERROR = -1;
    private static final int ACCOUNT_SIGNATURE_NOT_VALID = -2;
    // Quit commands
    private static final String[] QUIT_SIGNATURES = { "e", "q", "exit", "quit" };
    // Account array
    private static final String[] ACCOUNTS = {  "1212121212", "2323232323",
                                                "3434343434", "4545454545",
                                                "5656565656", "6767676767",
                                                "7878787878", "8989898989",
                                                "9090909090", "1010101010" };

    // Does the string contain numbers only?
    private static boolean isDigitStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i)))
                return false;
        }
        return true;
    }

    // account checking
    private static int checkInputString(String inputString) {
        if (!isDigitStr(inputString)) {
            return ACCOUNT_NON_NUMBERS_ERROR;
        } else if (!isStringFound(inputString, ACCOUNTS)) {
            return ACCOUNT_SIGNATURE_NOT_VALID;
        } else
            return ACCOUNT_IS_VALID;
    }

    // search inputString in String array
    private static boolean isStringFound(String inputString, String[] arr) {
        inputString = inputString.trim().toLowerCase();
        for (String str : arr) {
            if (str.equals(inputString)) {
                return true;
            }
        }
        return false;
    }

    // find account in ACCOUNTS array
    private static boolean isAccountFound(String inputString) {
        return isStringFound(inputString, ACCOUNTS);
    }

    // Does exit command entered?
    private static boolean isExitCommand(String inputString) {
        return isStringFound(inputString, QUIT_SIGNATURES);
    }

    // get account name from input
    public static String getAccountName() {
        String res = "";
        System.out.print(MSG_CYCLE_PROMPT);
        res = in.nextLine();
        return res;
    }

    // print common information about program
    private static void init() {
        System.out.print(MSG_HEAD1);
        for (String str : QUIT_SIGNATURES) {
            System.out.print("\"" + str + "\" ");
        }
        System.out.print(MSG_HEAD2);
        in = new Scanner(System.in);
    }

    /***********************************************************************
     *
     *                          Main method
     *
     ***********************************************************************/
    public static void main(String[] args)
            throws javax.security.auth.login.AccountNotFoundException, java.lang.IllegalArgumentException {
        // temporary variable for input
        String tmp = "";

        init();

        while ( !isExitCommand( tmp = getAccountName() ) ) {

            try {
                switch ( checkInputString(tmp) ) {
                case ACCOUNT_IS_VALID:
                    System.out.println( MSG_ACCOUNT_IS_VALID );
                    break;
                case ACCOUNT_NON_NUMBERS_ERROR:
                    throw new IllegalArgumentException( MSG_ILLEGAL_ARGUMENT_EXCEPTION );
                case ACCOUNT_SIGNATURE_NOT_VALID:
                    throw new AccountNotFoundException( MSG_ACCOUNT_NOT_FOUND_EXCEPTION );
                default:
                    break;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.print( MSG_FINAL_WORD );
    }
}
