package IconManager;

import java.io.File;
import java.io.FilenameFilter;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Q on 16.02.2016.
 */
public class IconManager {
    private  static List<String> iconList;

    public static String getFileIconPath(File file){
        String res = "";

        if (iconList == null){
            iconList = new ArrayList<String>();


            Thread thread = Thread.currentThread();
            ClassLoader classLoader = thread.getContextClassLoader();
            String p = classLoader.getResource("../../img/icons").getFile();
            File f = new File(p);
            File [] ff = f.listFiles(new FilenameFilter() {
                @Override
                public boolean accept(File dir, String name) {
                    return name.contains(".png");
                }
            });


            for (int i = 0; i <  ff.length; i++){
                String iconName = ff[i].getName();

                iconList.add(iconName.substring(0, iconName.indexOf(".")));
            }
        }

        String ext = getExtension(file);
        res = "/img/icons/" +  ext + ".png";
        return res;
    }

    private static String getExtension(File file){
        String res = "_blank";

        if (file.isDirectory()){
            res = "folder";
        }

        String fileName = file.getName();
        String fileExt = fileName.substring(fileName.indexOf(".") + 1);
        fileExt = fileExt.toLowerCase();
        String imgName = fileExt + ".png";

        if (iconList.contains(imgName)){
            res = fileExt;
        }

        return res;
    }
}
