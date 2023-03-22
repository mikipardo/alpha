package alpha.data.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import alpha.data.conectores.CochesImpl;
import alpha.data.log4j.Log;
import alpha.data.log4j.MainLog;
import alpha.data.models.Coche;

/**
 * Servlet implementation class ServletCar
 */

public class ServletCar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	Logger logger = Log.getLogger(ServletCar.class);
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		logger.info("este es un mensaje desde servlet para ver que funciona");
		
		Coche car = new Coche(0, null, null, 0);
		
		List <Coche> listCars = new CochesImpl().getAllCars();
		
		Gson gson = new Gson();
		
		String json = gson.toJson(listCars);
		
		
		
		response.getWriter().append("Served at: ").append(json);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
