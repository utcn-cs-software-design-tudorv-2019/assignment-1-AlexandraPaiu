package Business;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import DBA.Conexiune;
import Data.Course;
import Data.CourseRepository;

public class CourseBll {

	public CourseBll() {
		
	}
	
	public ArrayList<Course> allCourse(){
		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		ArrayList<Course> as = new ArrayList<Course>();
		try {
			CourseRepository c = new CourseRepository(conex);
			
			try {
				as = c.show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}		
		} catch (HeadlessException e) {
			e.printStackTrace();
		}
		return as;
	}
	
}
