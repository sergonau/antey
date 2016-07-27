/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antey.diarsid;

import java.io.IOException;

/**
 *
 * @author Diarsid
 */
public class Main {
    
    private Main() {
    }
    
    public static void main(String[] args) throws IOException {
        InputValidator validator = new InputValidator();
        ConsoleListener listener = new ConsoleListener();
        ConsolePrinter printer = new ConsolePrinter();
        AccountStorage storage = new AccountStorage();
        
        ConsoleManager consoleManager = new ConsoleManager(listener, printer, validator);
        AccountManager accountManager = new AccountManager(storage, consoleManager);
        accountManager.doWork();
    }
}
