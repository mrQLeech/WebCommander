package FileSystemManager;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.text.SimpleDateFormat;
import java.util.Date;
import IconManager.IconManager;


/**
 * Created by Q on 16.02.2016.
 */
public class FileModel {
    private String iconPath = "";

    private String name;
    private long size;
    private Date editDate;
    private String attributes;
    private boolean isRoot = false;
    private boolean isFolder;
    private boolean isExist = true;

    /**
     * create root model
     */
    public FileModel(){

        isRoot = true;
    }

    /**
     * create file/directory model
     * @param file/directory
     * @throws IOException
     */
    public  FileModel(File file) throws IOException {
        if (!file.exists()){
            isExist = false;
            return;
        }

        iconPath = IconManager.getFileIconPath(file);

        this.name = file.getName();
        this.size = file.length()/8;
        this.editDate = new Date(file.lastModified());
        Path path = Paths.get(file.getPath());

        DosFileAttributes ra =  Files.readAttributes(path, DosFileAttributes.class);

        StringBuilder attr = new StringBuilder();
        if (ra.isReadOnly()){
            attr.append(separateAttributeAppender(attr));
            attr.append("RO");
        }

        if (ra.isSystem()){
            attr.append(separateAttributeAppender(attr));
            attr.append("SYS");
        }

        if (ra.isHidden()){
            attr.append(separateAttributeAppender(attr));
            attr.append("HID");
        }

        if (ra.isArchive()){
            attr.append(separateAttributeAppender(attr));
            attr.append("ARC");
        }
        attributes = attr.toString();
        isFolder = file.isDirectory();
    }

    private String separateAttributeAppender(StringBuilder sb){
        String res;
        res = sb.length() > 0 ? "/": "";
        return  res;
    }


    public String toString(){
        StringBuilder res = new StringBuilder();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd  HH:mm:ss");
        res.append("<tr>");

        String alt = isFolder? "dir":"file";

        if (isExist && !isRoot){

            res.append("<td class='border-area-inner'><img class=\'file-icon\' src=\'" + iconPath + "\' alt=\'" + alt + "\' /></td>");
            res.append("<td class='border-area-inner'>" + name + "</td>");
            res.append("<td class='border-area-inner'>" + size + "</td>");
            res.append("<td class='border-area-inner'>" +  dateFormat.format(editDate)  + "</td>");
            res.append("<td class='border-area-inner'>" + attributes + "</td>");
        }else if (isRoot){
            res.append("<td class='border-area-inner'></td>");
            res.append("<td class='border-area-inner'>..</td>");
            res.append("<td class='border-area-inner'></td>");
            res.append("<td class='border-area-inner'></td>");
            res.append("<td class='border-area-inner'></td>");
        }

        res.append("</tr>");

        return res.toString();
    }
}
