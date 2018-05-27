import static org.junit.Assert.assertEquals;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

public class ParcelsizeIntegrityTest {
	Connection connection;
	Statement statement = null;
	ResultSet resultSet = null;
	boolean passed = false;

    @Test
    public void connectToDatabase() {
    	try {
    		connection = DriverManager.getConnection("jdbc:mysql://mysql_parcelsize:3306/Parcelsize", "myuser", "mypass");
    		
    	    statement = connection.createStatement();
    	    resultSet = statement.executeQuery("SELECT COUNT(paketgroesse) FROM groesseneinheiten");
    	    
    	    connection.close();
			statement.close();
			resultSet.close();
			
			if(connection.isClosed() == true && statement.isClosed() == true && resultSet.isClosed() == true) {
				passed = true;
			}
    	}
    	catch (SQLException e) {
    		System.out.println(e.getMessage());
    	}
    	
    	assertEquals(passed, true);
    	
    }
}
