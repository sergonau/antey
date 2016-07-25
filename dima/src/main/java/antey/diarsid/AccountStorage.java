/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antey.diarsid;

/**
 *
 * @author Diarsid
 */
class AccountStorage {
    
    private final String[] accounts;
    
    AccountStorage() {
        this.accounts = new String[10];
        this.accounts[0] = "0123456789";
        this.accounts[1] = "0000000000";
        this.accounts[2] = "1111111111";
        this.accounts[3] = "2222222222";
        this.accounts[4] = "3333333333";
        this.accounts[5] = "4444444444";
        this.accounts[6] = "5555555555";
        this.accounts[7] = "6666666666";
        this.accounts[8] = "7777777777";
        this.accounts[9] = "8888888888";
    }
    
    boolean containsAccount(String givenAccount) {
        for ( String account : this.accounts ) {
            if ( account.equals(givenAccount) ) {
                return true;
            }
        }
        throw new AccountStringNotFoundException("account not found.");
    }
}
