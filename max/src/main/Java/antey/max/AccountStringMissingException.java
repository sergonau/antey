package antey.max;

/**
 * Created by Max on 03/08/16.
 */
public class AccountStringMissingException extends RuntimeException {

    public AccountStringMissingException() {
        super();
    }

    public AccountStringMissingException(String message) {
        super(message);
    }
}