package alpha.data.servlets;

import java.io.IOException;
import java.util.Map;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.google.gson.Gson;

import alpha.data.conectores.CochesDAO;
import alpha.data.conectores.CochesImpl;
import alpha.data.log4j.LogConsole;
import alpha.data.models.Coche;

/**
 * Servlet implementation class ServletCall2Reception
 */
public class ServletCall2Reception extends HttpServlet {
	private static final long serialVersionUID = 1L;
       private CochesDAO daoCars= new CochesImpl();
       static Logger log = Logger.getLogger(ServletCall2Reception.class);
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletCall2Reception() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		log.info("has entrado a post call2");
		// esta bien los opcional pero a veces crean mucha logica 
		// este ejemplo quizás sea mejor comprobar si es nulo o vacio y devolver response con status por ejemplo
		// asi luego se comprueba en el front 
		
		log.info("has entrado a post call2 "+ request.getAttribute("id"));
		
		Optional<String> id =Optional.ofNullable(request.getAttribute("id").toString());
		log.info("Json {}"+ id.get());
		
		Map<String,String>mapas =daoCars.getCarMap(id.orElse("").toString());//si esta nulo le mandamos vacio
		
		Gson gson = new Gson();
		
		String res =  gson.toJson(mapas);
		
		Coche coche = gson.fromJson(res, Coche.class);
		
		log.info(coche.toString());
		
		log.info("Json"+ mapas);
		
		response.getWriter().append(res);
		
	}
	
	


}
