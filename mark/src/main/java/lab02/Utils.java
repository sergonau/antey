package lab02;

/**
 * Some useful common functions
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.4
 */
public class Utils {

    /**
     * Method that prepares input string:
     * deletes lead, finish and all inner multiple spaces
     *
     * @param str Input string
     * @return Prepared string
     */
    public static String prepareString(String str) {
        return str.trim().replaceAll("\\s+"," ");
    }

    /**
     * Checks if a string is empty ("") or null
     * @param str the string to check, may be null
     * @return true if the string is empty or null
     */
    public static boolean isStrEmpty(final String str) {
        return ( str == null ) || ( str.trim().length() == 0 );
    }

    /**
     * Search String in String array
     * @param inputString String that have to be found
     * @param arr String array in which you want to search for a string
     * @return true If String was found in String array
     */
    public static boolean isStringFound(String inputString, String[] arr) {
        inputString = inputString.trim().toLowerCase();
        for (String str : arr) {
            if ( str.equals( inputString ) ) {
                return true;
            }
        }
        return false;
    }

    /**
     * Returns the word count in DSV string with specific delimiter
     * https://en.wikipedia.org/wiki/Delimiter-separated_values
     *
     * @param str source CSV string
     * @param delimiter char for part separation
     * @return count of the words in source CSV string
     */
    public static int partCount(String str, String delimiter) {

        if ( isStrEmpty( str ) ) {
            return 0;
        } else {
            int res = 1;
            int idx = 0;
            while ( (idx = str.indexOf(delimiter, idx)+1 ) > 0 ) {
                res++;
            }
            return res;
        }
    }

    /**
     * Extracts a part of DSV (Delimiter separated) string with specific delimiter
     * https://en.wikipedia.org/wiki/Delimiter-separated_values
     *
     * @param partIndex part place 0..partCount-1
     * @param str source CSV string
     * @param delimiter char for part separation
     * @return string at position <b>partIndex</b> in source string
     * @throws IndexOutOfBoundsException than (partIndex <= 0) or (partIndex > partCount-1)
     */
    public static String partAt(final int partIndex, final String str, final String delimiter) {
        String   strTmp    = str.trim();
        String[] strArr    = strTmp.split( delimiter );
        int      strArrLen = strArr.length;

        if ( ( partIndex >= 0) && ( (( partIndex < strArrLen ) && ( !strTmp.endsWith(delimiter) )) ||
                (( partIndex <= strArrLen ) && ( strTmp.endsWith(delimiter ) )) ) ) {
            if ( strTmp.endsWith(delimiter) && ( partIndex == strArrLen ) ) {
                return "";
            } else {
                return strArr[partIndex];
            }
        } else {
            throw new IndexOutOfBoundsException("Part index " + partIndex + " is out of bounds. partCount=" + partCount(strTmp, delimiter) );
        }
    }

}
