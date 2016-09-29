package lab02a.checkers;

import lab02a.common.CommonConsts;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public class CheckerForInt implements IInputChecker {
    private int minValue;
    private int maxValue;

    public CheckerForInt() {
    }

    public CheckerForInt setRange(int minValue, int maxValue) {
        this.minValue = minValue;
        this.maxValue = maxValue;
        return this;
    }

    @Override
    public boolean lastInputValueIsCorrect(String value) {
        int i;
        try {
            i = Integer.parseInt( value );
        } catch (NumberFormatException e) {
            throw new NumberFormatException( String.format(CheckerConsts.MSG_INT_NFE.toString(), value) );
        }

        if ((i >= minValue) && (i <= maxValue)) {
            return true;
        } else {
            throw new IllegalArgumentException( String.format(CheckerConsts.MSG_INT_IAE.toString(), minValue, maxValue, i) );
        }
    }
}
