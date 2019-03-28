package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBA.Conexiune;

public class CourseRepository {

	private static Connection con;
	private Statement sts;
	protected static final Logger LOGGER = Logger.getLogger(StudentRepository.class.getName());
	private static final String insertStatementString = "INSERT INTO course (email,telefon,nume,oras,strada)"
			+ " VALUES (?,?,?,?,?)";
	private final static String deleteStatementString ="DELETE FROM course where id = ?";
	
	public CourseRepository(Connection con){
		CourseRepository.con = con;
		try{sts = this.con.createStatement();}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void show(Course course) 
	{
		
	}
	
	
}
