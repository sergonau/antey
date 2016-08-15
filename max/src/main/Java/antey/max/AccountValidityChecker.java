package antey.max;

/**
 * Created by Max on 09/08/16.
 */
public class AccountValidityChecker {

    // # Vars and constants #

    // Proper input length
    private final int ACCOUNT_ID_LENGTH = 10;

    // # Constructors #
    public AccountValidityChecker(){
    }

    // # Methods #

    // Check if account the account ID length is proper
    boolean checkIsAccountIdProperLength(String inputAccountId){
        if ( inputAccountId.length() == ACCOUNT_ID_LENGTH ) {
            return true;
            } else {
                throw new IllegalArgumentException("Account ID must be 10-DIGIT LONG!");
            }
    }

    // Check if the account ID characters are all digits
    boolean checkIsAccountIdOnlyDigit(String inputAccountId){
            for (int i = 0; i < inputAccountId.length(); i++) {
                if (!Character.isDigit(inputAccountId.charAt(i))) {
                    throw new IllegalArgumentException("Account ID must contain DIGITS ONLY!");
                }
            }
            return true;
      }

}
