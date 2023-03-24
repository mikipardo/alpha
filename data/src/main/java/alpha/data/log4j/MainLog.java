package alpha.data.log4j;

import org.apache.log4j.Logger;

public class MainLog {

	public static void main(String[] args) {

		Logger logger = Log.getLogger(MainLog.class);
		
		
		logger.error("este es un mensaje de error");
		
		
		String nulito = null;
		
		try {
			if(nulito.getBytes().length>=1) {
				logger.error("no sale");
			}
		} catch (Exception e) {
			// TODO: handle exception
			logger.error("se ha dado error",e);
		}
		
	
	}
}
