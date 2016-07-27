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
class ConsoleManager {
    
    private final ConsoleListener consoleListener;
    private final ConsolePrinter consolePrinter;    
    private final InputValidator validator;
    
    ConsoleManager( 
            ConsoleListener consListener,
            ConsolePrinter consPrinter,
            InputValidator validator) {        
        this.consoleListener = consListener;
        this.consolePrinter = consPrinter;
        this.validator = validator;
    }
    
    String waitForNextUserInput() throws IOException {
        String input = this.consoleListener.waitForNextUserInput();
        if ( isNotExitCommand(input) ) {
            this.validator.validateGivenAccount(input);            
        } 
        return input;
    }
    
    void print(String out) throws IOException {
        this.consolePrinter.print(out);
    }
    
    void printException(Exception e) throws IOException {
        this.consolePrinter.printException(e);
    }
}
