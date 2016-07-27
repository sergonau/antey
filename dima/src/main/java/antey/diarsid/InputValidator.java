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
class InputValidator {
    
    private final int properInputLength;
    private final String onlyNumericRegExp;
    
    InputValidator() {
        this.properInputLength = 10;
        this.onlyNumericRegExp = "[0-9]+";
    }
    
    boolean validateGivenAccount(String consoleInput) {
        if ( this.inputContainsOnlyNumericChars(consoleInput) ) {
            if ( this.inputHasProperLength(consoleInput) ) {
                return true;
            } else {
                throw new IllegalArgumentException("Account string should contain 10 characters!");
            }
        } else {
            throw new IllegalArgumentException("Account string should contain only digit characters!");
        }
    }
    
    private boolean inputContainsOnlyNumericChars(String input) {
        return input.matches(this.onlyNumericRegExp);
    }
    
    private boolean inputHasProperLength(String input) {
        return ( this.properInputLength == input.length() );
    }
}
