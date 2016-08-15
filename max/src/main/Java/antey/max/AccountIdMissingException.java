package antey.max;

/**
 * Created by Max on 03/08/16.
 */

public class AccountIdMissingException extends RuntimeException {

    // # Constructors #
    public AccountIdMissingException() {
        super();
    }

    public AccountIdMissingException(String message) {
        super(message);
    }

}