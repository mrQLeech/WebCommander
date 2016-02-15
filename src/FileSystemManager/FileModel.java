package FileSystemManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;
import java.util.Date;
import java.util.jar.Pack200;

/**
 * Created by Q on 16.02.2016.
 */
public class FileModel {
    private String name;
    private long size;
    private Date editDate;
    private String attributes;

    public  FileModel(File file) throws IOException {
        this.name = file.getName();
        this.size = file.length();
        this.editDate = new Date(file.lastModified());

        Path path = Paths.get(file.getPath());

        DosFileAttributes ra =  Files.readAttributes(path, DosFileAttributes.class);
       
    }
}
