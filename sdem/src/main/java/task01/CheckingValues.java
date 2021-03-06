package task01;

/**
 * Created by Сергей on 27.08.2016.
 * ver 002
 */
class CheckingValues {

    private final int checkValueLength;
    private String valueToCheck;

    CheckingValues() {

        checkValueLength = 10;

    }

    void setValueToCheck(String valueToCheck) {
        this.valueToCheck = valueToCheck;
    }

    boolean checkLength() {

        if  (this.valueToCheck.length() != this.checkValueLength) {
            throw new InputException(MsgOutToConsole.MSG_ACCOUNT_LENGTH_NO_VALID.toString());
        }

        return true;

    }

    boolean checkDigitInString() {
        boolean isDigit;
        for (int i = 0; i < this.valueToCheck.length(); i++) {
            isDigit = Character.isDigit(this.valueToCheck.charAt(i));
            if ( !isDigit ) {
                throw new InputException(MsgOutToConsole.MSG_ACCOUNT_MUST_CONTAINED_ONLY_DIGIT.toString());
            }
        }
        return true;
    }

}
