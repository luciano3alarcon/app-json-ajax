package filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import nutzer.EingeloggteNutzer;

//f�ngt die Zug�nge zu anderen Seite ab, bevor es �ber Login l�uft.
//Mit dem * werden alles Seite in dem Ordner Pages 
@WebFilter(urlPatterns = { "/pages/*" })
public class FilterAuthentifizierung implements Filter {

//	Tut etwas, wenn die Applikation ausgefallen ist,
	@Override
	public void destroy() {
	}

	// f�ngt alle requests ab
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest  req = (HttpServletRequest) request;
		HttpSession session = req.getSession(); 
		
		//Das ist f�r generische Authentifizierung
		String urlZurAuthentifizieren = req.getServletPath(); 
		
		EingeloggteNutzer eingeloggteNutzer  =  (EingeloggteNutzer) session.getAttribute("username");
		
		//Bei der ersten Anmeldung kommt der username mit Wert null
		if(eingeloggteNutzer == null && !urlZurAuthentifizieren.equalsIgnoreCase("/pages/ServletAuthentifizierung") ) {	
			//
			RequestDispatcher dispatcher = request.getRequestDispatcher("/authentifizierung.jsp?url="+urlZurAuthentifizieren);
			//Wenn der Nutzer noch nicht eingeloggt ist, wird er zu Login-Seite geschickt.
			dispatcher.forward(request, response);
			
			return; // Bei nicht eingeloggtem Nutzer wird die Seite-Login zur�ckgeschickt.  
		}
		
		
		//Der Filter muss �ber den Aufruf chain.doFilter durchlaufen, sonst wird die Seite nicht angezeigt
		chain.doFilter(request, response);
		
	}

	// F�hrt etwas durch, wenn die Applikation gestartet wird.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
