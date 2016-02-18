import FileSystemManager.FileModel;
import FileSystemManager.FilesPathConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Created by Q on 15.02.2016.
 */

@WebServlet(name = "FileListServlet")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer pw = response.getWriter();
        response.setContentType("text/html");

        String path = request.getParameter("path");
        String selected = request.getParameter("selected");

        String nPath = FilesPathConverter.getNewPath(path, selected);
        String markup = getFilesList(path);

        StringBuilder sb = new StringBuilder();

        sb.append("{\"markup\":");
        sb.append("\"");
        sb.append(markup);
        sb.append("\",");
        sb.append("\"path\":\"");
        sb.append(nPath);
        sb.append("\"");
        sb.append("}");


        pw.write(sb.toString());
    }


    private String getFilesList(String pseudoPath){
        StringBuilder res = new StringBuilder();
        try{
            String path = FilesPathConverter.convertToPath(pseudoPath);
            File dir = new File(path);
            if (!FilesPathConverter.isRoot(pseudoPath) && !pseudoPath.isEmpty() ){
                FileModel file = new FileModel();
                res.append(file.toString());
            }

            if (dir.exists() && dir.isDirectory()){
                File[] listOfFiles = dir.listFiles();
                for (File f: listOfFiles){
                    FileModel file = new FileModel(f);
                    res.append(file.toString());
                }
            }
        }catch (Exception ex){
            res = new StringBuilder();
        }

        return res.toString();
    }



    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ServletException ex = new ServletException();
        throw ex;
    }

}
