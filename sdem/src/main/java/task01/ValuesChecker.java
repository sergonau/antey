package task01;

/**
 * Created by Сергей on 27.08.2016.
 * ver 003
 */
class ValuesChecker {

    private final int checkValueLength;

    ValuesChecker() {
        checkValueLength = 10;
    }

    private boolean checkLength(String valueToCheck) {
        if  (valueToCheck.length() != this.checkValueLength) {
            throw new InputException(MsgOutToConsole.MSG_ACCOUNT_LENGTH_NO_VALID.toString());
        }
        return true;
    }

    private boolean checkDigitInString(String valueToCheck) {
        boolean isDigit;
        for (int i = 0; i < valueToCheck.length(); i++) {
            isDigit = Character.isDigit(valueToCheck.charAt(i));
            if ( !isDigit ) {
                throw new InputException(MsgOutToConsole.MSG_ACCOUNT_MUST_CONTAINED_ONLY_DIGIT.toString());
            }
        }
        return true;
    }

    boolean checkInValue(String valueToCheck) {
        return checkLength(valueToCheck) && checkDigitInString(valueToCheck);
    }
}
