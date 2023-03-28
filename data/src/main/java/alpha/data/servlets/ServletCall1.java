package alpha.data.servlets;

import java.io.IOException;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletCall1
 */

public class ServletCall1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCall1() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// mandamos por un post key ferari, value 1
		Optional<String> valor = Optional.ofNullable(request.getParameter("Ferrari"));
		String peticion = valor.orElse("Vacio");
		
		request.setAttribute("id", peticion);
		
		new ServletCall2Reception().doPost(request, response);

		/*
		 * Con operador String valor = request.getParameter("valor1"); String respuesta=
		 * valor.equalsIgnoreCase("1234")?"tiene valor":"no tiene valor";
		 */

	
	}

}
