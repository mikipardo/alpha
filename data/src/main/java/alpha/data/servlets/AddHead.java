package alpha.data.servlets;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;

import alpha.data.log4j.Log;
import alpha.data.log4j.MainLog;

/**
 * Servlet implementation class AddHead
 */

public class AddHead extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Log.getLogger(AddHead.class);

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddHead() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Enumeration<String> parameterNames = request.getParameterNames();
		Map <String, String>map = new LinkedHashMap<>();
		while (parameterNames.hasMoreElements()) {
			String paramName = parameterNames.nextElement();
			String key = request.getParameter(paramName);
			map.put(paramName, key);
		
		}
		
		Cookie c = new Cookie("userName","Chaitanya");
		c.setMaxAge(-1);  //-1 represents that the given cookie exists until the browser is shut down or 1800 seconds,100 seconds.
		
		System.out.println("La sesion es la de "+request.getSession());
		response.addCookie(c);
		
		
		HttpSession session = request.getSession();
		session.setAttribute("cookie", "Galleta");
		session.getAttribute("cookie");
		
		
		response.addHeader("token","123456");
		map.forEach((k,v)-> {
			logger.info("Key: "+k+"| Valor: "+v);
			try {
		
				response.getWriter().append("Key: "+k).append("| Valor: "+v);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});
		
		// mapa.entrySet().stream().forEach(x->System.out.println(x.getValue()));
	}

}
