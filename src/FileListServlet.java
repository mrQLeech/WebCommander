import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Properties;

/**
 * Created by Q on 15.02.2016.
 */

@WebServlet(name = "FileListServlet")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        ServletException ex = new ServletException();
        throw ex;
    }

    private String getFilesList(String panelPath){
        StringBuilder res = new StringBuilder();
        try{
            String rootFolderId = ApplicationPropertyClass.getProperty("webRootFolderName");
            String discPrefix = ApplicationPropertyClass.getProperty("localFileSystemDiscPrefix");
            String localFileHolder = ApplicationPropertyClass.getProperty("localFileHolderFolder");


        }catch (Exception ex){

        }

        return res.toString();
    }
}
