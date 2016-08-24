package lab02;

/**
 * Some useful common functions
 *
 * @author Mark Lobanov (17.08.2016)
 * @version 2.0.2
 */
public class Utils {

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
     * Extracts a part of DSV (char delimited) string
     * https://en.wikipedia.org/wiki/Delimiter-separated_values
     *
     * @param num part place 0..partCount-1
     * @param str source DSV string
     * @param delimiter char for part separation
     * @return string at position <b>num</b> in source string
     */
    public static String partAt(final int num, final String str, final String delimiter) {
        String str_t = str.trim();
    	String[] tmp = str_t.split( delimiter );
    	int cnt = partCount( str_t, delimiter );
    	
    	if ( delimiter.length() != 1 ) {
    		throw new IllegalArgumentException("Delimiter must contain only one char instead of <" + delimiter + ">");
    	} else {
        	if ( ( num >= 0) && ( num < cnt ) ){
        		if ( str_t.endsWith(delimiter) && ( num == cnt-1 ) ) {
        			return "";
        		} else {
        			return tmp[num];
        		}
        	} else {
        		throw new IllegalArgumentException("Part index <" + num + "> is out of bounds. partCount=" + cnt);
        	}
    	}
    }

}
