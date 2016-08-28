package task01;

/**
 * Created by SDem on 23.08.2016.
 * ver: 003
 */
class AccountNoFoundException extends RuntimeException {

    AccountNoFoundException(String str) {
        super(str);
    }
}