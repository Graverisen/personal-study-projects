package studyJSP;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Response;

/**
 * Servlet implementation class Localization
 */
@WebServlet("/Localization")
public class Localization extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Localization() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		ResourceBundle rb = ResourceBundle.getBundle("ResourceBundleAll.ResourceBundle");
		
		
		response.setContentType("text/html");
		PrintWriter print = response.getWriter();
		print.println("<html>");
		print.println("<body>");
		print.println(rb.getString("SIGN_IN"));
		print.println("<br>");
		print.println(rb.getString("USERNAME"));
		print.println("<br>");
		print.println(request.getLocale());
		print.println("<input type=\"text\" name=\"username\">");
		print.println("<br>");
		print.println(rb.getString("PASSWORD"));
		print.println("<br>");
		print.println("<input type=\"text\" name=\"password\">");
		print.println("<br>");
		print.println("<input type=\"submit\" name=\"action\" value=\""+rb.getString("sign_in")+"\">");
		print.println("<br>");
		print.println("</body>");
		print.println("</html>");
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
