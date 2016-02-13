import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

/**
 * Created by Q on 13.02.2016.
 */
public class ApplicationPropertyClass {
    private static Properties _prop;
    public static String getProperty(String name) throws IOException {
        if (_prop == null){
            _prop = new Properties();
            String path = new File(".").getCanonicalPath();
            _prop.load(new FileInputStream("C:/prop.txt"));
        }

        return _prop.getProperty(name);
    }
}
