package ex001.exc;


public class AccountNotFoundException extends RuntimeException {
    public AccountNotFoundException(){

        super();
    }
    public AccountNotFoundException (String msg) {
        super(msg);
    }

}
