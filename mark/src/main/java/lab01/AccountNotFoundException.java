package lab01;
/**
 * Exception that occurs in the case of not finding the account
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public class AccountNotFoundException extends RuntimeException {
    /** default class constructor */
    public AccountNotFoundException() {
        super();
    }
    /**
     * Overloaded class constructor with custom message
     * @param msg Custom message while Exception occurs
     */
    public AccountNotFoundException(String msg) {
        super(msg);
    }
}
