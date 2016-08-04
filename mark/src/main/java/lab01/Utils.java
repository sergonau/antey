package lab01;


/**
 * Some useful functions
 * @author Mark Lobanov (04.08.2016)
 * @version 1.0.3
 */
public class Utils {

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
     * Does the string contain numbers only?
     * @param str String that must contain only numbers
     * @return true If String contains only numbers
     */
    public static boolean isDigitStr(String str) {
        for (int i = 0; i < str.length(); i++) {
            if ( !Character.isDigit( str.charAt(i) ) )
                return false;
        }
        return true;
    }
}
