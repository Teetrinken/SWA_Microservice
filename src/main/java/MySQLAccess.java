import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MySQLAccess implements AccessObject {
	private String dbUrl = "jdbc:mysql://mysql_parcelsize:3306/Parcelsize";
    private Connection dbConnection = null;
    private Statement statement = null;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    
    public String getSize(int size) throws Exception {
    	try {
    		dbConnection = DriverManager.getConnection(dbUrl, "myuser", "mypass");
    		
			String sqlString = "SELECT paketgroesse FROM groesseneinheiten "
			+ "WHERE gurtmass_max >= ? AND gurtmass_min < ?";
			
			String result = "Keine passende Größe gefunden.";

        	preparedStatement = dbConnection.prepareStatement(sqlString);
        	preparedStatement.setInt(1, size);
        	preparedStatement.setInt(2, size);
        	
        	ResultSet rs = preparedStatement.executeQuery();
        	
        	while (rs.next()) {
				result = rs.getString("paketgroesse");
			}
        	
        	System.out.println("Result: " + result);
        	return result;

		} catch (SQLException e) {
			System.out.println(e.getMessage());
			return "Error";

		} finally {
			if (preparedStatement != null) {
				preparedStatement.close();
			}

			if (dbConnection != null) {
				dbConnection.close();
			}

		}
    }

}