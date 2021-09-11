package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import nutzer.EingeloggteNutzer;

@WebServlet("/pages/ServletAuthentifizierung")
public class ServletAuthentifizierung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public ServletAuthentifizierung() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	
	//doPost entspricht den Method Post auf der JSP-Seite 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String username = request.getParameter("username");
		String passwort = request.getParameter("passwort");
		String url = request.getParameter("url");
		
		if(username.equalsIgnoreCase("admin")  && passwort.equalsIgnoreCase("123") ) {
		//hier wird true erwartet.
			
			EingeloggteNutzer eingeloggteNutzer = new EingeloggteNutzer();
			eingeloggteNutzer.setUsername(username);
			eingeloggteNutzer.setPassword(passwort);
			
			HttpServletRequest req  = (HttpServletRequest) request;
			HttpSession session = req.getSession();
			session.setAttribute("username", eingeloggteNutzer);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher(url);
			dispatcher.forward(request, response);
			
		} else {
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/authentifizierung.jsp");
			
		}
		
		doGet(request, response);
	}

}
