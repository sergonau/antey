package task01;

/**
 * Created by SDem on 23.08.2016.
 * ver: 001
 */
class CommonFunctions {

    static boolean isStringFound(String inputString, String[] arr) {
        inputString = inputString.trim().toLowerCase();
        for (String str : arr) {
            if ( str.equals( inputString ) ) {
                return true;
            }
        }
        return false;
    }

}
