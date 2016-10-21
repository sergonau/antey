package lab02a.logger;

/**
 * Created by Mark Lobanov on 19.10.2016.
 */
public class InvalidFileNameException extends RuntimeException {
    /** default class constructor */
    public InvalidFileNameException() {
        super();
    }
    /**
     * Overloaded class constructor with custom message
     * @param msg Custom message while Exception occurs
     */
    public InvalidFileNameException(String msg) {
        super(msg);
    }
}
