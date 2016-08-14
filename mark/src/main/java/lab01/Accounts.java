package lab01;

import lab01.Utils;
import java.lang.IllegalArgumentException;
import lab01.AccountNotFoundException;

/**
 * Account names container
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.4
 */
public class Accounts {
    /** Acceptable account length */
    private static final int ACCOUNT_LEN = 10;
    /** Account names array */
    private static final String[] ACCOUNTS = {  "1212121212", "2323232323",
                                                "3434343434", "4545454545",
                                                "5656565656", "6767676767",
                                                "7878787878", "8989898989",
                                                "9090909090", "1010101010" };
    /**
     * Account checking method
     * @param accountName String that contains account name for cheching
     * @return true If String was found
     * @throws IllegalArgumentException if accountName contains non-numeric characters
     * @throws AccountNotFoundException if accountName not found
     */
    public boolean checkAccountName(String accountName) {
        if ( ( accountName.length() != ACCOUNT_LEN ) || !Utils.isDigitStr( accountName ) ) {
            throw new IllegalArgumentException();

        } else if ( !Utils.isStringFound( accountName, ACCOUNTS ) ) {
            throw new AccountNotFoundException();
        } else {
            return true;
        }
    }
}
