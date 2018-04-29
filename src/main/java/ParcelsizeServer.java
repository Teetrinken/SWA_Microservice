import java.net.URI;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;


public class ParcelsizeServer {
	private static HttpServer server;
	
	public static void main(String[] args) {
		ResourceConfig rc = new ResourceConfig(ParcelsizeResource.class);
		rc.register(new CORSFilter());
		 server = JdkHttpServerFactory.createHttpServer( 
		    URI.create( "http://localhost:8000/parcel" ), rc 
		 );
	}
	
	public static HttpServer getServer() {
		return server;
	}

}
