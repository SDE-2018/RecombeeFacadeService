package util;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;

public class FacadeUtil {
	private static FileHandler fileHandler = null;
	
	public static FileHandler getDefaultFileHandler() {
		if (fileHandler != null) {
			return fileHandler;
		}
	    FileHandler fileHandler = null;  
	    try {  
	    	fileHandler = new FileHandler("facade-server-logs.log");  
	        SimpleFormatter formatter = new SimpleFormatter();  
	        fileHandler.setFormatter(formatter);  
	    } catch (SecurityException e) {  
	        e.printStackTrace();  
	    } catch (IOException e) {  
	        e.printStackTrace();  
	    }  
	    return fileHandler;
	}
}
