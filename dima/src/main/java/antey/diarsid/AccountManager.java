/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antey.diarsid;

import java.io.IOException;

import static antey.diarsid.ConsoleUtil.isNotExitCommand;

/**
 *
 * @author Diarsid
 */
class AccountManager {
    
    private final AccountStorage accountStorage;
    private final ConsoleManager consoleManager;
    
    AccountManager(
            AccountStorage accStorage,
            ConsoleManager consManager) {
        this.accountStorage = accStorage;
        this.consoleManager = consManager;
    }
    
    public void doWork() throws IOException {
        String consoleInput = "";
        boolean exitNotPrintedYet = true;
        this.consoleManager.print("Account Manager v.1.0:");        
        while ( exitNotPrintedYet ) { 
            try {
                consoleInput = this.consoleManager.waitForNextUserInput();
                if ( isNotExitCommand(consoleInput) ) {
                    if ( this.accountStorage.containsAccount(consoleInput) ) {
                        this.consoleManager.print("given account is Ok.");
                    } 
                } else {
                    exitNotPrintedYet = false;
                }                               
            } catch (IllegalArgumentException|
                    AccountStringNotFoundException e) {
                this.consoleManager.printException(e);
            } 
        }
    }
}
