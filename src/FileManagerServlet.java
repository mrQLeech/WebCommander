import FileSystemManager.FilesPathConverter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.nio.file.PathMatcher;

/**
 * Created by Q on 19.02.2016.
 */
public class FileManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String pseudoPath = request.getParameter("path");
        String selected = request.getParameter("objectName");
        String crudDoName = request.getParameter("whatWeDo");

        PrintWriter pw = response.getWriter();
        response.setContentType("text/html");

        if (crudDoName.equals("createFolder")){
            try {
                String path = FilesPathConverter.getNewPath(pseudoPath, selected);
                path =  FilesPathConverter.convertToPath(path);

                File f = new File(path);
                f.mkdir();
            }catch (Exception ex){
                pw.append(ex.getMessage());
            }
        }

        pw.close();
        pw.flush();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) {

    }
}
