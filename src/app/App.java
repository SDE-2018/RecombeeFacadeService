package app;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Logger;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import util.FacadeUtil;

public class App {
	
    private static final Logger logger =
    				Logger.getLogger(App.class.getName());
    
	private static final URI BASE_URI = URI.create("http://localhost:5901/");

	public static void main(String[] args) throws IllegalArgumentException, IOException, URISyntaxException {
		logger.addHandler(FacadeUtil.getDefaultFileHandler());
		logger.info("Starting RecombeeFacadeService standalone HTTP server...");
		ResourceConfig rc = createApp();
		JdkHttpServerFactory.createHttpServer(BASE_URI, rc);
		logger.info("Server started on " + BASE_URI + "\n[kill the process to exit]");
	}

	public static ResourceConfig createApp() {
		logger.info("Starting RecombeeFacadeService REST services...");
		MyApplicationConfig config = new MyApplicationConfig();
		return config;
	}
}
