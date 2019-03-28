package Data;

import java.util.ArrayList;
import java.util.Hashtable;

public class Enrollment {

	private int id;
	private int idStudent;
	private String exam;
	private ArrayList<Student> studenti = new ArrayList<Student>();
	private float []grades;
	private int idCourse;
	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	public int getIdStudent() {
		return idStudent;
	}

	public void setIdStudent(int idStudent) {
		this.idStudent = idStudent;
	}

	public String getExam() {
		return exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public ArrayList<Student> getStudenti() {
		return studenti;
	}
	public void setStudenti(ArrayList<Student> studenti) {
		this.studenti = studenti;
	}
	public float[] getGrades() {
		return grades;
	}
	public void setGrades(float[] grades) {
		this.grades = grades;
	}
	
	public String getGrade() {
		return exam;
	}
	public void setGrade(String exam) {
		this.exam = exam;
	}

	public int getIdCourse() {
		return idCourse;
	}
	public void setIdCourse(int course) {
		this.idCourse = course;
	}
	
	
}