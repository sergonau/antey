package task01;

/**
 * Created by SDem on 23.08.2016.
 * ver: 003
 */
final class CommonFunctions {

    private static final String[] QUIT_COMMAND = { "e", "q", "exit", "quit" };
    private CommonFunctions() {

    }

    static boolean isExitCommand(String inputString) {
        inputString = inputString.trim().toLowerCase();
        for (String str : QUIT_COMMAND) {
            if ( str.equals( inputString ) ) {
                return true;
            }
        }
        return false;
    }
}
