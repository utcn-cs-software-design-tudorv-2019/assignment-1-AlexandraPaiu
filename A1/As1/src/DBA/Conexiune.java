package DBA;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Conexiune {
private static final Logger LOGGER = Logger.getLogger(Conexiune.class.getName());
private static final String DRIVER_NAME="com.mysql.jdbc.Driver";
private static final String URL="jdbc:mysql://localhost:3306/mydb";

	public Conexiune(){
		
	}
	
	static
    {
        try
        {
            System.out.println("searching for driver");
            Class.forName(DRIVER_NAME);
        }
        catch(ClassNotFoundException cnfe)
        {                               
        }
    }
	
	public Connection getConex(){
		Connection con=null;
	try{
			con = DriverManager.getConnection(URL,"root","");
	}
	catch(Exception e){
		e.printStackTrace();
	}
		return con;
	}
	
	public static void close(Connection connection) {
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the connection");
			}
		}
	}
	
	public static void close(Statement statement) {
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the statement");
			}
		}
	}

	public static void close(ResultSet resultSet) {
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				LOGGER.log(Level.WARNING, "An error occured while trying to close the ResultSet");
			}
		}
	}
}
