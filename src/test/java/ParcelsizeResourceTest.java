import org.junit.Test;
import org.junit.Assert;
import org.junit.Before;

public class ParcelsizeResourceTest {
	ParcelsizeResource resource;
	
    @Before public void initialize() {
       resource= new ParcelsizeResource();
       resource.setAccess(new TestAccess());
    }

	@Test public void checkResultForXS() {
        RequestBody request = new RequestBody(1, 1, 1, "");
        String expected = "{\"length\": 1, \"width\": 1, \"height\": 1, \"size\": \"XS\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForS() {
        RequestBody request = new RequestBody(15, 7, 7, "");
        String expected = "{\"length\": 15, \"width\": 7, \"height\": 7, \"size\": \"S\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForM() {
        RequestBody request = new RequestBody(20, 10, 10, "");
        String expected = "{\"length\": 20, \"width\": 10, \"height\": 10, \"size\": \"M\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForL() {
        RequestBody request = new RequestBody(20, 15, 15, "");
        String expected = "{\"length\": 20, \"width\": 15, \"height\": 15, \"size\": \"L\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForXL() {
        RequestBody request = new RequestBody(80, 50, 50, "");
        String expected = "{\"length\": 80, \"width\": 50, \"height\": 50, \"size\": \"XL\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForZero() {
        RequestBody request = new RequestBody(0, 0, 0, "");
        String expected = "{\"length\": 0, \"width\": 0, \"height\": 0, \"size\": \"Keine passende Größe gefunden.\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
	
	@Test public void checkResultForSizeOverXL() {
        RequestBody request = new RequestBody(150, 100, 100, "");
        String expected = "{\"length\": 150, \"width\": 100, \"height\": 100, \"size\": \"Keine passende Größe gefunden.\"}";
        Assert.assertTrue(expected.equals(resource.calculateParcelSize(request).getEntity()));
    }
}
