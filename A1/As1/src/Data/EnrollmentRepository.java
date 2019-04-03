package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

import DBA.Conexiune;

public class EnrollmentRepository {

	private static Connection con;
	private Statement sts;
	protected static final Logger LOGGER = Logger.getLogger(StudentRepository.class.getName());
	private static final String insertStatementString = "INSERT INTO enrollment (grade,exam,Student_idStudent,Course_idCourse)"
			+ " VALUES (?,?,?,?)";
	
	public EnrollmentRepository(Connection con){
		EnrollmentRepository.con = con;
		try{sts = this.con.createStatement();}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public ArrayList<GradeCourse> show() throws SQLException{
		String y = "SELECT * FROM enrollment;";
		 ResultSet rs = sts.executeQuery(y);
		 ArrayList<GradeCourse> as = new ArrayList<GradeCourse>();
		 String h;
		 while(rs.next()) {
			 GradeCourse gc = new GradeCourse();
			 gc.setGrade(rs.getInt("grade"));
			gc.setId(rs.getInt("Course_idCourse"));
			as.add(gc);
		 }
		 
		 for(int i=0;i<as.size();i++) {
		  h = "SELECT * FROM course where idCourse = " + as.get(i).getId() + ";";
			 ResultSet rss = sts.executeQuery(h);
			 if(rss.next())
				 as.get(i).setCourse((rss.getString("name")));
		 }
		 return as;
	}
	
	public void insert(String curs, int student) 
	{
		PreparedStatement insertStatement = null;
		int insertedId = -1;
		int id =0 ;
		try {
				
			String y = "SELECT * FROM course where name = '" + curs + "';";
			 ResultSet rrs = sts.executeQuery(y);
			 if (rrs.next()) {
				id = rrs.getInt("idCourse");
			}
			 
			insertStatement = con.prepareStatement(insertStatementString, Statement.RETURN_GENERATED_KEYS);
			Random rn = new Random();
			int rand = rn.nextInt(10 - 5 + 1) + 5;
			insertStatement.setInt(1, rand);
			insertStatement.setString(2,"10/08/2019");
			insertStatement.setInt(3, student);
			insertStatement.setInt(4, id);
			insertStatement.executeUpdate();
			System.out.println("enrollmentReo: ins");
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "EnrollmentRepository:insert " + e.getMessage());
		} finally {
			Conexiune.close(insertStatement);
		}
	}
	

	
}
