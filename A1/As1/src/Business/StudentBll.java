package Business;

import java.awt.HeadlessException;
import java.sql.SQLException;
import java.util.ArrayList;

import DBA.Conexiune;
import Data.Student;
import Data.StudentRepository;
import Data.Teacher;
import Data.TeacherRepository;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class StudentBll {

	Stage scena;
	Student student;
	
	public StudentBll() {
		
	}
	
	public StudentBll(String name, String email,String password,String cnp,String address, String group) {
		this.student = new Student(name,email,password,cnp, address, Integer.parseInt(group));
	}
	
	public ArrayList<Student> allStud(){
		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		ArrayList<Student> as = new ArrayList<Student>();
		try {
			StudentRepository c = new StudentRepository(conex);
			
			try {
				as = c.show();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			this.showAt(scena, "Show cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
		return as;
	}
	
	public void updates(Student nw,  String name, String address, String cnp, String group) {
		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		try {
			StudentRepository c = new StudentRepository(conex);
			
			c.updates(nw,name,address,cnp, group);
			this.showAt(scena, "Update cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
	}
	
	public void sterge(Student t) {

		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		try {
			StudentRepository c = new StudentRepository(conex);
			
			c.delete(t.getEmail());
			this.showAt(scena, "Stergere cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
	}
	
	public void sterge(String t) {

		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		try {
			StudentRepository c = new StudentRepository(conex);
			
			c.delete(t);
			this.showAt(scena, "Stergere cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
	}
	
	public void adauga(){
		Conexiune co = new Conexiune();
		java.sql.Connection conex = co.getConex();
		try {
			StudentRepository c = new StudentRepository(conex);
			c.insert(student);
			this.showAt(scena, "Adaugare cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
		}
	
	public Student findByMail(String mail) {
		Conexiune co = new Conexiune();
		Student s = new Student();
		java.sql.Connection conex = co.getConex();
		try {
			StudentRepository c = new StudentRepository(conex);
			s = c.findbyMail(mail);
			this.showAt(scena, "Adaugare cu succes StudentBll");
		} catch (HeadlessException e) {
			this.showAt(scena, "Eroare la introducere");
			e.printStackTrace();
		}
		return s;
	}
	
	private void showAt(final Stage primaryStage, String text) {
	    	 final Stage dialog = new Stage();
             dialog.initModality(Modality.APPLICATION_MODAL);
             dialog.initOwner(primaryStage);
             VBox dialogVbox = new VBox(20);
             dialogVbox.getChildren().add(new Text(text.toString()));
             Scene dialogScene = new Scene(dialogVbox, 300, 200);
             dialog.setScene(dialogScene);
             dialog.show();
	    }
}
