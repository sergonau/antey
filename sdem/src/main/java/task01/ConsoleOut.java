package task01;

import java.io.IOException;

/**
 * Created by Сергей on 27.08.2016.
 * ver 003
 */
class ConsoleOut {

    void writeLine(String str) {
        System.out.println(str);
    }

    void writeLine(Exception e) throws IOException {
        System.out.println(e.getMessage());
    }
}
