package antey.max;

/**
 * Created by Max on 09/08/16.
 */

public class AccountFeasibilityChecker {

    // # Vars and constants #

    // Feasible account IDs
    private static final String[] ACCOUNT_IDS = {"1234567890", "1212121212", "0000000000"};

    // Account ID to check
    private String inputAccountId;

    // # Constructors #
    public AccountFeasibilityChecker(){
    }

    // # Methods #

    // Check if the account ID length is proper
    boolean checkIsAccountIdFeasible(String inputAccountId){
        for (String feasibleAccountId : ACCOUNT_IDS) {
            if ( feasibleAccountId.equals( inputAccountId ) ) {
                return true;
            }
        }
        throw new AccountIdMissingException("Account " + inputAccountId + " is NOT FOUND!");
    }

}
