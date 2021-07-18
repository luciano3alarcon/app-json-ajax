package servException;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//fängt die Zugänge zu anderen Seite ab, bevor es über Login läuft.
@WebFilter(urlPatterns = { "/*" })
public class FilterAuthentifizierung implements Filter {

//	Tut etwas, wenn die Applikation ausgefallen ist,
	@Override
	public void destroy() {
	}

	// fängt alle requests ab
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		//Der Filter muss über den Aufruf chain.doFilter durchlaufen, sonst wird die Seite nicht angezeigt
		chain.doFilter(request, response);
		
		System.out.println("Abfang"); 
		
	}

	// Führt etwas durch, wenn die Applikation gestartet wird.
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
	}

}
