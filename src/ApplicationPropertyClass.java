import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Q on 13.02.2016.
 */
public class ApplicationPropertyClass {
    private static Properties _prop;
    public static String getProperty(String name) throws IOException {
        if (_prop == null){
            Thread thread = Thread.currentThread();
            ClassLoader classLoader = thread.getContextClassLoader();
            InputStream input = classLoader.getResourceAsStream("../prop.txt");

            _prop = new Properties();
            _prop.load(input);
        }

        return _prop.getProperty(name);
    }
}
