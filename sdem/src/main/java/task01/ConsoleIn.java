package task01;

import java.util.Scanner;

/**
 * Created by SDem on 23.08.2016.
 * ver: 003
 */
class ConsoleIn {

    private Scanner sc;

    ConsoleIn() {
        this.sc = new Scanner(System.in);
    }

    String getInValue() {
        return this.sc.nextLine().trim();
    }
}
