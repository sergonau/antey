/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package antey.diarsid;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

/**
 *
 * @author Diarsid
 */
class ConsolePrinter {
    
    private final BufferedWriter writer;
    
    ConsolePrinter() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(System.console().writer());
        } catch (NullPointerException e) {
            bufferedWriter = new BufferedWriter(new OutputStreamWriter(System.out));
        }
        this.writer = bufferedWriter;
    }
    
    void print(String out) throws IOException {
        this.printToConsole(out);
    }
    
    void printException(Exception e) throws IOException {
        this.printToConsole(
                "Exception occured: ", 
                e.getClass().getSimpleName(), 
                e.getMessage());
    }
    
    private void printToConsole(String... description) throws IOException {
        for (String s : description) {
            this.writer.write(" " + s);
            this.writer.newLine();
        }
        this.writer.write(" > ");
        this.writer.flush();
    }
}
