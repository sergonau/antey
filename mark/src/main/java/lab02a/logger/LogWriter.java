package lab02a.logger;

import lab02a.common.IStringWriter;

import java.io.File;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Mark Lobanov on 08.09.2016.
 */
public class LogWriter implements IStringWriter {
    private String fileMask;
    private String fileName;

    private String getCurrentDate() {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        String datetimeString = format.format( new Date() );
        return datetimeString;
    }

    private boolean pathExists(String path) {
        File f = new File( path );
        return f.exists() && ( f.isDirectory() );
    }

    private String extractDirectory() {
        File f = new File( fileName );
        String path = f.getParent();
        if (path != null) {
            return path;
        } else {
            return "";
        }
    }

    private boolean isPathAvailable() {
        try {
            String path = extractDirectory();
            if ( !path.isEmpty() ) {

                File dirs = new File ( path );
                if ( !pathExists( path ) ) {
                    return dirs.mkdirs();
                } else {
                    return true;
                }

            } else {
                return true;
            }

        } catch (RuntimeException e) {
            return false;
        }
    }


    public String getFileName() {
        return fileName;
    }

    public void setParam(String fileMask) {
        this.fileMask = fileMask;
        fileName = String.format(fileMask, getCurrentDate());
    }

    @Override
    public void writeStrLn(String str) throws IOException {
        BufferedWriter bWriter;
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String datetimeString = format.format( new Date() )+" ";

        if ( isPathAvailable() ) {
            bWriter = new BufferedWriter( new FileWriter(fileName, true) );
            bWriter.append(datetimeString + str + "\n");
            bWriter.flush();
        }
    }

}
