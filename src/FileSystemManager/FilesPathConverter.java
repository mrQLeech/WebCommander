package FileSystemManager;

import PropertyManagement.ApplicationPropertyClass;
import PropertyManagement.PropertyField;

import javax.imageio.IIOException;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Created by Q on 13.02.2016.
 */
public class FilesPathConverter {

    public static String convertToPath(String pseudoPath) {
        String res;
        try{
            pseudoPath = pseudoPath.replace(getRoot(), getRoot() + "/");
            res = replacePathByProp(pseudoPath, PropertyField.PSEUDO_ROOT_FOLDER_NAME, PropertyField.LOCAL_FILE_HOLDER_DIRECTORY);
            res = parseToPath(res);
        }catch (IOException ex){
            res = "";
        }
        return res;
    }


    public static String convertToPseudoPath(String path) {
        String res;
        try {

            res = replacePathByProp(path,  PropertyField.LOCAL_FILE_HOLDER_DIRECTORY, PropertyField.PSEUDO_ROOT_FOLDER_NAME);
            res = parseToPseudoPath(res);
        }catch (IOException ex) {
           res = "";
        }
        return res;
    }

    public  static String getNewPath(String old, String selected) throws IOException {
        old = old.replace("//", "/");
        selected = selected == null ? "" : selected;

        if (old.isEmpty()){
            String res = getRoot();
            return res ;
        }

        String[] spl = old.split("/");

        StringBuilder sb = new StringBuilder();

        if (selected.equals("..")){

            for (int i = 0; i < spl.length -1; i++){
                if (i == 0) {
                    sb.append(getRoot());

                    continue;
                }
                sb.append(spl[i]);
                sb.append("/");
            }
        }else{

            sb.append(old );
            if (!old.equals(getRoot()) && old.lastIndexOf("/") < (old.length() -1)){
                sb.append("/");
            }

            sb.append(selected);
        }

        return  sb.toString();
    }

    private static String replacePathByProp(String path, PropertyField replaceableProp, PropertyField replacerProp) throws IOException {
        String res;
        String replaceable = ApplicationPropertyClass.getProperty(replaceableProp);
        String replacer = parseToPseudoPath(ApplicationPropertyClass.getProperty(replacerProp));


        if (path.contains(replaceable)){
            res = path.replaceFirst(replaceable, replacer);
        }else{
            res = replacer;
        }

        return  res;
    }

    public static boolean isRoot (String pseudoPath) throws IOException {
        String rootPseudo = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);
        if (pseudoPath.equals(rootPseudo)){
            return true;
        }
        return false;
    }

    private static String getRoot () throws IOException {
        String rootPseudo = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);

        return rootPseudo;
    }

    private  static String parseToPseudoPath(String path){
        String res = path.replace("\\", "/");
        return res;
    }

    private  static String parseToPath(String path){
        String res = path.replace("/", "\\\\");
        return res;
    }


}
