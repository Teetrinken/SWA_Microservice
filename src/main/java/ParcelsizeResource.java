import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path( "size" )
public class ParcelsizeResource
{
  @POST
  @Path( "calculate" )
  @Produces(MediaType.APPLICATION_JSON)
  public Response calculateParcelSize(RequestBody request){
	  System.out.println("Calculating size...");
	  int result = request.length + 2 * request.width + 2 * request.height;
	  
	  MySQLAccess access = new MySQLAccess();
	  try {
		  request.size = access.getSize(result);
	  } catch(Exception e) {
		  System.out.println(e.getMessage());
	  }
	  
	  String jsonString = "{\"length\": " + request.length + ", \"width\": " + 
			  request.width + ", \"height\": " + request.height + ", \"size\": \"" + request.size + "\"}";
	  
	  return Response.ok(jsonString, MediaType.APPLICATION_JSON).build();
	}
}
