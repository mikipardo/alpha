package alpha.data.log4j;

import org.apache.log4j.Logger;

public class LogConsole {

	 static Logger logger = Logger.getLogger(LogConsole.class);
	 
	    public static void main(String[] args) {
	    	// viene la configuracion en log.properties
	        // Logging The Output In The Console
	        logger.debug("Hello! Log4j Console Appender Configuration Is Successfully Completed...!");
	        logger.error("new mesage");
	    }
}
