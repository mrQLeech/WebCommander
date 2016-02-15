import PropertyManagement.ApplicationPropertyClass;
import PropertyManagement.PropertyField;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.StringReader;
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

    private String getFilesList(String panelPath){
        StringBuilder res = new StringBuilder();
        try{
            String rootFolderId = ApplicationPropertyClass.getProperty(PropertyField.PSEUDO_ROOT_FOLDER_NAME);
            String discPrefix = ApplicationPropertyClass.getProperty(PropertyField.LOCAL_PSEUDO_DISC_PREFIX_NAME);
            String localFileHolder = ApplicationPropertyClass.getProperty(PropertyField.LOCAL_FILE_HOLDER_DIRECTORY);




        }catch (Exception ex){

        }

        return res.toString();
    }
}
