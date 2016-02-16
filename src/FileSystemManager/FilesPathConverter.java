package FileSystemManager;

import PropertyManagement.ApplicationPropertyClass;
import PropertyManagement.PropertyField;

import javax.imageio.IIOException;
import java.io.IOException;

/**
 * Created by Q on 13.02.2016.
 */
public class FilesPathConverter {

    public static String ConvertToPath(String pseudoPath) {
        String res;
        try{

            String pseudoPathRoot = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);
            String localFileHolderPath = ApplicationPropertyClass.getProperty(PropertyField.LOCAL_FILE_HOLDER_DIRECTORY);
            if (pseudoPath.contains(pseudoPathRoot)){
                res = pseudoPath.replaceFirst(pseudoPathRoot, localFileHolderPath);
            }else{
                res = localFileHolderPath;
            }
        }catch (IOException ex){
            res = "";
        }
        return res;
    }


    public static String ConvertToPseudoPath(String path) {
        String res;
        try {
            String pseudoPathRoot = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);
            String localFileHolderPath = ApplicationPropertyClass.getProperty(PropertyField.LOCAL_FILE_HOLDER_DIRECTORY);

            res = path.replaceFirst(localFileHolderPath, pseudoPathRoot);
        }catch (IOException ex) {
           res = "";
        }
        return res;
    }



}
