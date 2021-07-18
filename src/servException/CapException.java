package servException;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet({ "/CapException", "/pages/captureExceptions" })
public class CapException extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public CapException() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {


	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {		

		try {
			
			String createException =request.getParameter("eingabeParam"); 
			Integer.parseInt(createException);
			
			response.setStatus(200); // 200 ist gleich okay (sucess) 
			response.getWriter().write("Processed sucessfull");
			
		} catch (Exception e) {
			response.setStatus(500); // 500 ist nicht gut gelaufen (intern error)
			response.getWriter().write("failled by process. Details: " + e.getMessage());
		}

	}

}
