package lab02a.checkers;

import static lab02a.checkers.CheckerConsts.MSG_INT_IAE;
import static lab02a.checkers.CheckerConsts.MSG_INT_NFE;

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
            throw new NumberFormatException( String.format(MSG_INT_NFE.toString(), value) );
        }

        if ((i >= minValue) && (i <= maxValue)) {
            return true;
        } else {
            throw new IllegalArgumentException( String.format(MSG_INT_IAE.toString(), minValue, maxValue, i) );
        }
    }
}
