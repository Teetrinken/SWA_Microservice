import java.net.URI;

import javax.swing.JOptionPane;

import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

import com.sun.net.httpserver.HttpServer;


public class ParcelsizeServer {

	public static void main(String[] args) {
		ResourceConfig rc = new ResourceConfig(ParcelsizeResource.class);
		rc.register(new CORSFilter());
		
		 HttpServer server = JdkHttpServerFactory.createHttpServer( 
		    URI.create( "http://localhost:8000/parcel" ), rc 
		 );
	}

}
