import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.Writer;

/**
 * Created by Q on 19.02.2016.
 */
public class FileManagerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String path = request.getParameter("path");
        String selected = request.getParameter("objectName");
        String crudDoName = request.getParameter("whatWeDo");



        Writer pw = response.getWriter();
        response.setContentType("text/html");
    }
}
