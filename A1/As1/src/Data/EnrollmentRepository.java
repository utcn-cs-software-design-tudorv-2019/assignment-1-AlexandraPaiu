package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBA.Conexiune;

public class EnrollmentRepository {

	private static Connection con;
	private Statement sts;
	protected static final Logger LOGGER = Logger.getLogger(StudentRepository.class.getName());
	private static final String insertStatementString = "INSERT INTO enrollment (email,telefon,nume,oras,strada)"
			+ " VALUES (?,?,?,?,?)";
	private final static String deleteStatementString ="DELETE FROM enrollment where id = ?";
	
	public EnrollmentRepository(Connection con){
		EnrollmentRepository.con = con;
		try{sts = this.con.createStatement();}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void insert(Enrollment enroll) 
	{
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		try {
			
			insertStatement = con.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			
			ArrayList<Student> studenti = enroll.getStudenti();
			float []grades = enroll.getGrades();
			
			for(int i=0;i<studenti.size();i++) {
				
			insertStatement.setInt(1+i, enroll.getId());
			insertStatement.setInt(2+i, enroll.getIdCourse());
			insertStatement.setInt(3+i, studenti.get(i).getId());
			insertStatement.setFloat(4+i, grades[i]);
				
			}
			
			insertStatement.executeUpdate();

			ResultSet rs = insertStatement.getGeneratedKeys();
			if (rs.next()) {
				insertedId = rs.getInt(1);
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EnrollmentRepository:insert " + e.getMessage());
		} finally {
			Conexiune.close(insertStatement);
		//	Conexiune.close(con);
		}
	}
	

	
}