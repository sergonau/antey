package lab01;
/**
 * Exception that occurs when an account contains non-numeric characters
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public class AccountFormatException extends RuntimeException {
    /** default class constructor */
    public AccountFormatException() {
        super();
    }
    /**
     * Overloaded class constructor with custom message
     * @param msg Custom message while Exception occurs
     */
    public AccountFormatException(String msg) {
        super(msg);
    }
}
