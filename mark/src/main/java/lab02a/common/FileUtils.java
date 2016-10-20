package lab02a.common;

import java.io.File;

/**
 * Created by Mark Lobanov on 19.10.2016.
 */
public class FileUtils {

    public static boolean pathExists(String path) {
        File f = new File( path );
        return (path.length() != 0) && f.exists() && ( f.isDirectory() );
    }

    public static boolean fileExists(String fileName) {
        File f = new File( fileName );
        return (fileName.length() != 0) && f.exists() && ( f.isFile() );
    }

    public static String extractDirectoryFromFileName(String fileName) {
        File f = new File( fileName );
        String path = f.getParent();
        if (path != null) {
            return path;
        } else {
            return "";
        }
    }

    public static boolean isPathAvailableForFile(String fileName) {
        try {
            String path = extractDirectoryFromFileName( fileName );
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

}
