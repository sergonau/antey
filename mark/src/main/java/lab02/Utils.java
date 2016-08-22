package lab02;

/**
 * Some useful functions
 * @author Mark Lobanov (04.08.2016)
 * @version 2.0.1
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

    /**
     * Returns the word count in CSV string with specific delimiter
     * @param str source CSV string
     * @param delimiter char for part separation
     * @return count of the words in source CSV string 
     */
    public static int partCount(String str, String delimiter) {

        if ( isStrEmpty( str ) ) {
            return 0;
        } else {
            int res = 1;
            for (int i = 0; i < str.length(); i++) {
                if ( delimiter.charAt(0) == str.charAt(i)  ) {
                    res++;
                }
            }
            return res;
        }

    }
    
    /**
     * Extracts a part of CSV (char delimited) string 
     * @param num part place 0..wordCount-1
     * @param str source CSV string
     * @param delimiter char for part separation
     * @return string at position <b>num</b> in source string
     */
    public static String partAt(final int num, final String str, final String delimiter) {
    	String[] tmp = str.trim().split( delimiter );
    	int cnt = partCount(str.trim(), delimiter);
    	
    	if ( delimiter.length() != 1 ) {
    		throw new IllegalArgumentException("Delimiter must contain only one char instead of <" + delimiter + ">");
    	} else {
        	if ( ( num >= 0) && ( num < cnt ) ){
        		if ( str.trim().endsWith(delimiter) && ( num == cnt-1 ) ) {
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
