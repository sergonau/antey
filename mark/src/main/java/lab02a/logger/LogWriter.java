package lab02a.logger;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import lab02a.common.IStringWriter;

import static lab02a.common.FileUtils.isPathAvailableForFile;

/**
 * Created by Mark Lobanov on 08.09.2016.
 */
public class LogWriter implements IStringWriter {
    private String fileName;

    private String getCurrentDate() {
        DateFormat format = new SimpleDateFormat("yyyyMMdd");
        return format.format( new Date() );
    }


    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileMask) {
        if (fileMask.length() != 0) {
            String tmp = String.format(fileMask, getCurrentDate());
            Pattern p = Pattern.compile( ".*[&*?>%<\\:\"'`].*" );
            Matcher m = p.matcher( tmp );
            if ( m.find() ) {
                throw new InvalidFileNameException();
            } else {
                fileName = String.format(fileMask, getCurrentDate());
            }
        } else {
            throw new InvalidFileNameException();
        }

    }

    @Override
    public void writeStrLn(String str) throws IOException {

        if ( isPathAvailableForFile( fileName ) ) {
            try ( BufferedWriter bWriter = new BufferedWriter( new FileWriter(fileName, true) ) ) {
                DateFormat format = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
                String datetimeString = format.format( new Date() )+" ";
                StringBuffer buf = new StringBuffer( Byte.MAX_VALUE );

                bWriter.append( buf.append( datetimeString ).append( str ).append( "\n" ).toString() );
                bWriter.close();
            }

        }
    }

}
