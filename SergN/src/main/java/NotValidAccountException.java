/**
 * Created by admin on 04.08.16.
 */
public class NotValidAccountException extends RuntimeException {
    public NotValidAccountException(){

        super();
    }
    public NotValidAccountException (String msg) {
        super(msg);
    }

}
