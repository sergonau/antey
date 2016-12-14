package common;

import java.util.Random;
/**
 * Created by Mark Lobanov on 21.10.2016.
 */
public class RandomStringGenerator {
    private final String alphabetUpper = "-~!^@ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private final String alphabetLower = "_=$&#abcdefghijklmnopqrstuvwxyz";
    private Random random = new Random();
    private StringBuilder buf = new StringBuilder();
    private int minLen;
    private int maxLen;
    private int alphabetLen;
    private long strCount;

    /**
     * Class constructor
     *
     * @param minLen - minimal string len
     * @param maxLen - maximal string len
     */
    public RandomStringGenerator(int minLen, int maxLen) {
        this.minLen = minLen;
        this.maxLen = maxLen;
        this.alphabetLen = alphabetUpper.length();
        this.strCount = 0;
    }

    /**
     * Method that generates random integer value in specified range
     *
     * @param min low range boundary
     * @param max high range boundary
     * @return random integer value
     */
    private int randomInt(int min, int max) {
        int diff = max - min;
        /*max -= min;
        return (int) (random.nextDouble() * ++max) + min;*/
        return min + this.random.nextInt(diff + 1);
    }

    /**
     * Random string generating method
     *
     * @return string that consists random characters and has length in range, specified in constructor
     */
    public synchronized String newRandomString() {
        char ch;

        if (strCount != Long.MAX_VALUE) {
            buf.setLength( 0 );
            int strLen = randomInt(minLen, maxLen) + buf.append( ++strCount ).append( " " ).length();

            while (buf.length() < strLen) {

                switch ( randomInt(1, 3) ) {
                    case 1: {
                        ch = alphabetLower.charAt( randomInt(0, alphabetLen - 1) );
                        break;
                    }
                    case 2: {
                        ch = alphabetUpper.charAt( randomInt(0, alphabetLen - 1) );
                        break;
                    }
                    default: {
                        ch = ' ';
                        break;
                    }
                }
                // duplicated symbols are prohibited
                if (buf.charAt(buf.length() - 1) != ch) {
                    buf.append( ch );
                }
            }

            return buf.toString().trim();
            } else {
            return "";
        }
    }


}
