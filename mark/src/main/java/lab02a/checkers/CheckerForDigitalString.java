package lab02a.checkers;

import static lab02a.common.Utils.isDigitStr;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public class CheckerForDigitalString implements IInputChecker {
    /** Acceptable account length */
    private int accountLength;

    public CheckerForDigitalString(int accountLength) {
        this.accountLength = accountLength;
    }

    @Override
    public boolean lastInputValueIsCorrect(String value) {
        if ( (value.length() == accountLength) && isDigitStr( value ) ) {
            return true;
        } else {
            throw new NumberFormatException( String.format(CheckerConsts.MSG_STR_NFE.toString(), value) );
        }
    }
}
