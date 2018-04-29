import org.junit.Test;
import org.junit.Assert;

public class ParcelsizeServerTest {
	
	@Test public void serverHasStarted() {
        String[] args = {};
        ParcelsizeServer.main(args);
        Assert.assertNotNull(ParcelsizeServer.getServer().getAddress());
    }
}
