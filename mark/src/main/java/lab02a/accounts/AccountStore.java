package lab02a.accounts;

import static lab02a.accounts.AccountConsts.MSG_ANFE;
import static lab02a.common.Utils.isStringFound;

/**
 * Account names container
 * @author Mark Lobanov (04.08.2016)
 * @version 2.2.0
 */
public class AccountStore {
    /** Acceptable account length */
    private static final int ACCOUNT_LEN = 10;
    /** Account names array */
    private static final String[] ACCOUNTS = {  "1212121212", "2323232323",
                                                "3434343434", "4545454545",
                                                "5656565656", "6767676767",
                                                "7878787878", "8989898989",
                                                "9090909090", "1010101010" };

    public String isAccountFound(String accountName) {
        if ( isStringFound( accountName, ACCOUNTS ) ) {
            return accountName;
        } else {
            throw new AccountNotFoundException( String.format(MSG_ANFE.toString(), accountName) );
        }
    }
}
