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



        StringBuilder sb = new StringBuilder();
        String markup = getFilesList(path);
        sb.append("{\"markup\":");
        sb.append("\"" + markup + "\",");
        sb.append("\"path\":");


        pw.write(markup);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ServletException ex = new ServletException();
        throw ex;
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


}
