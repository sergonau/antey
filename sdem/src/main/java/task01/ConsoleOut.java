package task01;

import java.io.IOException;

/**
 * Created by SDem on 23.08.2016.
 * ver: 001
 */
class ConsoleOut {

    static void writeLine(String str) {
        System.out.println(str);
    }

    static void writeException(Exception e) throws IOException {
        System.out.println(e.getMessage());
    }

}
