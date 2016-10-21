package lab02a.checkers;

import static lab02a.checkers.CheckerConsts.MSG_DBL_IAE;
import static lab02a.checkers.CheckerConsts.MSG_DBL_NFE;
import static lab02a.common.Utils.prepareString;

/**
 * Created by Mark Lobanov on 29.09.2016.
 */
public class CheckerForDoubleArray implements IInputChecker {
    private String[] tmpArray;
    private int valuesCount;

    public CheckerForDoubleArray(int valuesCount) {
        this.valuesCount = valuesCount;
    }

    @Override
    public boolean lastInputValueIsCorrect(String value) {
        int len;
        // decimal separator must be once
        value = prepareString( value ).replace(",", ".");

        // checking for arguments count
        tmpArray = value.split( CheckerConsts.SINGLE_SPACE.toString() );
        len = tmpArray.length;
        if (len != valuesCount) {
            throw new IllegalArgumentException( String.format( MSG_DBL_IAE.toString(), valuesCount, len ) );
        }

        // checking for arguments format
        for (String tmpStr : tmpArray) {
            double dbl;
            try {
                dbl = Double.parseDouble( tmpStr );
            } catch (NumberFormatException e) {
                throw new NumberFormatException( String.format(MSG_DBL_NFE.toString(), tmpStr) );
            }
        }
        return true;
    }

}
