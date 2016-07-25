/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antey.diarsid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Diarsid
 */
class ConsoleListener {
    
    private final BufferedReader reader;
    
    ConsoleListener() {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(System.console().reader());
        } catch (NullPointerException e) {
            bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        }
        this.reader = bufferedReader;
    }
    
    String waitForNextUserInput() throws IOException {
        return this.reader.readLine().trim();
    }
}
