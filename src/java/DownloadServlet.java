import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
public class DownloadServlet extends HttpServlet
{@Override
 public void doGet(HttpServletRequest request, HttpServletResponse response)
throws ServletException, IOException
{ response.setContentType("APPLICATION/OCTET-STREAM");
String filename = request.getParameter("filename");
ServletContext context = getServletContext();
ServletOutputStream os;
    try (InputStream is = context.getResourceAsStream("//temp/" + filename)) {
        os = response.getOutputStream();
        response.setHeader("Content-Disposition","attachment; filename=\"" + filename + "\"");
        // if comment this statement then it will ask you about the editor with which you want to open the file
        int i;  byte b[]=new byte[1024];
        while ((i=is.read(b)) != -1) {
            os.write(b);
        }   }
os.close();
}
}