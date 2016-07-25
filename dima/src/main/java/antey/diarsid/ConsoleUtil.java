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
class ConsoleUtil {
    
    private final static String[] EXIT_PATTERNS;
    static {
        EXIT_PATTERNS = new String[] {"exit", "q", "stop"};
    }
    
    private ConsoleUtil() {
    }
    
    static boolean isNotExitCommand(String input) {
        input = input.trim();
        for (String exitPattern : EXIT_PATTERNS) {
            if ( exitPattern.equals(input) ) {
                return false;
            }
        } 
        return true;
    }
}
