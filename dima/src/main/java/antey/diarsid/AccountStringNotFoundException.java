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
public class AccountStringNotFoundException extends RuntimeException {

    /**
     * Creates a new instance of <code>AccountStringNotFoundException</code> without detail message.
     */
    public AccountStringNotFoundException() {
        super();
    }

    /**
     * Constructs an instance of <code>AccountStringNotFoundException</code> with the specified
     * detail message.
     *
     * @param msg the detail message.
     */
    public AccountStringNotFoundException(String msg) {
        super(msg);
    }
}
