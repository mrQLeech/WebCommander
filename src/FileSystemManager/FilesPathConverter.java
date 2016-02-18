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

    public  static String getNewPath(String old, String selected) throws IOException {
        if (old.isEmpty()){
            return  getRoot() + "\\\\";
        }

        String[] spl = old.split("\\\\");

        StringBuilder sb = new StringBuilder();
        if (selected == ".."){

            for (int i = 0; i < spl.length -1; i++){
                if (i == 0) {
                    sb.append(getRoot());
                    sb.append("\\\\");
                    continue;
                }
                sb.append(spl[i]);
                sb.append("\\\\");
            }
        }else{
            sb.append(old );
            sb.append("\\\\");
            sb.append(selected);
        }

        return  sb.toString();
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

    private static String getRoot () throws IOException {
        String rootPseudo = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);

        return rootPseudo;
    }


}
