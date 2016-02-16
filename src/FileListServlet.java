import FileSystemManager.FilesPathConverter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Q on 15.02.2016.
 */

@WebServlet(name = "FileListServlet")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Writer pw = response.getWriter();
        response.setContentType("text/html");

        String markup = getFilesList(request.getParameter("path"));

        pw.write(markup);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ServletException ex = new ServletException();
        throw ex;
    }

    private String getFilesList(String pseudoPath){
        StringBuilder res = new StringBuilder();
        try{
            String path = FilesPathConverter.ConvertToPath(pseudoPath);
            File dir = new File(path);
            if (dir.exists() && dir.isDirectory()){
                File[] listOfFiles = dir.listFiles();
                for (File f: listOfFiles){

                }
            }
        }catch (Exception ex){

        }

        return res.toString();
    }
}
