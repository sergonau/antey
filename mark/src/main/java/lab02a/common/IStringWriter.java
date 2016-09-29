package lab02a.common;

import java.io.IOException;

/**
 * Created by Mark Lobanov on 28.09.2016.
 */
public interface IStringWriter {

    /**
     * Writes string with \n to output device
     *
     * @param str String that should be written
     */
    void writeStrLn(String str) throws IOException;

}
