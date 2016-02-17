package FileSystemManager;

import PropertyManagement.ApplicationPropertyClass;
import PropertyManagement.PropertyField;

import javax.imageio.IIOException;
import java.io.IOException;

/**
 * Created by Q on 13.02.2016.
 */
public class FilesPathConverter {

    public static String convertToPath(String pseudoPath) {
        String res;
        try{
            res = replacePathByProp(pseudoPath, PropertyField.PSEUDO_ROOT_FOLDER_NAME, PropertyField.LOCAL_FILE_HOLDER_DIRECTORY);
        }catch (IOException ex){
            res = "";
        }
        return res;
    }


    public static String convertToPseudoPath(String path) {
        String res;
        try {

            res = replacePathByProp(path,  PropertyField.LOCAL_FILE_HOLDER_DIRECTORY, PropertyField.PSEUDO_ROOT_FOLDER_NAME);

        }catch (IOException ex) {
           res = "";
        }
        return res;
    }

    public  static String getNewPath(String old, String selected){
        String res = "";

        String[] spl = old.split("\\\\");

        if (selected == ".."){

        }else{

        }

        return  res;
    }

    private static String replacePathByProp(String path, PropertyField replaceableProp, PropertyField replacerProp) throws IOException {
        String res;
        String replaceable = ApplicationPropertyClass.getProperty(replaceableProp);
        String replacer = ApplicationPropertyClass.getProperty(replacerProp);

        if (path.contains(replaceable)){
            res = path.replaceFirst(replaceable, replacer);
        }else{
            res = replacer;
        }
        return  res;
    }

    public static boolean isRoot (String pseudoPath) throws IOException {
        String rootPseudo = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);
        if (pseudoPath == rootPseudo){
            return true;
        }
        return false;
    }


}
