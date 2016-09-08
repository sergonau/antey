package lab02a;

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
public class LogManager {
    private String fullFileName;
    private BufferedWriter bWriter;

    public LogManager() {
        // TODO: implement
    }

    public String getFullFileName() {
        return fullFileName;
    }

    public void setFullFileName(String fullFileName) {
        this.fullFileName = fullFileName;
    }


    private boolean fileExists(String fileName) {
        File f = new File( fileName );
        return f.exists() && ( !f.isDirectory() );
    }

    private boolean isPathAvailable() {
        try {
            String path = extractDirectory();
            if ( !path.isEmpty() ) {
                File dirs = new File ( path );
                return dirs.mkdirs();
            } else {
                return true;
            }
        } catch (RuntimeException e) {
            return false;
        }
    }


    private String extractFileMask() {
        String[] tmp = fullFileName.split("/");
        if (tmp.length>0) {
            return tmp[ tmp.length-1 ];
        } else {
            return "";
        }
    }

    private String extractDirectory() {
        File f = new File( fullFileName );
        String path = f.getParent();
        if (path != null) {
            return path;
        } else {
            return "";
        }
    }

    private String mkFilename() {
        File folder = new File( extractDirectory() );
        File[] files = folder.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File dir, String name) {
                return name.matches(".*\\.\\d{3}\\..*");
            }
        });

        if ( files.length==0 ) {
            return String.format(fullFileName, 0);
        } else {
            String[] arr = files[files.length-1].getName().split("\\.");
            int i = Integer.parseInt( arr[3] )+1;
            return String.format(fullFileName, i);
        }
    }


    public boolean init() {
        try {
            if ( isPathAvailable() ) {
                String fn = mkFilename();
                bWriter = new BufferedWriter(new FileWriter(fn, true));
                return true;
            } else return false;
        } catch (IOException e) {
            return false;
        }
    }

    public void down() {
        try {
            if ( bWriter != null) {
                bWriter.close();
            }
        } catch (IOException e) {
        }
    }

    public void writeStrLn(String str) throws IOException {
        DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
        String datetimeString = format.format( new Date() )+" ";

        bWriter.write( datetimeString + str + "\n");
        bWriter.flush();
    }

}
