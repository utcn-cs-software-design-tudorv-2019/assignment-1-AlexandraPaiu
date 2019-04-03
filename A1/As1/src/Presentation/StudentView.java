package Presentation;

import java.sql.SQLException;
import java.util.ArrayList;

import Business.CourseBll;
import Business.EnrollmentBll;
import Business.StudentBll;
import Data.Course;
import Data.GradeCourse;
import Data.Student;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class StudentView extends Application{

	
	String identification;
	Student s;
	StudentBll sb = new StudentBll();
	
	public StudentView(String email, String password) {
		this.identification=email;
		
		s = sb.findByMail(identification);
		if (!s.getPassword().equals(password)) {
			s = null;
			System.out.println("Incorect");
			return;
			}
	}


	Stage stage;
	Scene scenefist;
	
	 @Override
	 public void start(Stage primaryStage) throws Exception {
		 	stage = primaryStage;
	        primaryStage.setTitle("Student Info");

	        GridPane gridPane = createRegistrationFormPane();
	        addUIControls(gridPane);
	        Scene scene = new Scene(gridPane, 800, 500);	
	        scenefist = scene;
	        primaryStage.setScene(scene);      
	        primaryStage.show();
	    }
	
	 private GridPane createRegistrationFormPane() {
	        GridPane gridPane = new GridPane();	  
	        gridPane.setAlignment(Pos.CENTER);
	        gridPane.setPadding(new Insets(40, 40, 40, 40));
	        gridPane.setHgap(10);
	        gridPane.setVgap(10);
	        ColumnConstraints columnOneConstraints = new ColumnConstraints(100, 100, Double.MAX_VALUE);
	        columnOneConstraints.setHalignment(HPos.RIGHT);
	        ColumnConstraints columnTwoConstrains = new ColumnConstraints(200,200, Double.MAX_VALUE);
	        columnTwoConstrains.setHgrow(Priority.ALWAYS);
	        gridPane.getColumnConstraints().addAll(columnOneConstraints, columnTwoConstrains);
	        return gridPane;
	    }
	 
	 private void addUIControls(GridPane gridPane) {
	        // Add Header
	        Label headerLabel = new Label("Student");
	        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	        gridPane.add(headerLabel, 0,0,2,1);
	        GridPane.setHalignment(headerLabel, HPos.CENTER);
	        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	        Label nameLabel = new Label("Name: ");
	        gridPane.add(nameLabel, 0, 2);
	        TextField nameField = new TextField();
	        nameField.setPrefHeight(40);
	        nameField.setText(s.getName());
	        gridPane.add(nameField, 1, 2);

	        Label addressLabel = new Label("Address: ");
	        gridPane.add(addressLabel, 0, 3);
	        TextField addressField = new TextField();
	        addressField.setPrefHeight(40);
	        addressField.setText(s.getAddress());
	        gridPane.add(addressField, 1, 3);

	        Label cnpLabel = new Label("CNP: ");
	        gridPane.add(cnpLabel, 0, 4);
	        TextField cnpField = new TextField();
	        cnpField.setPrefHeight(40);
	        cnpField.setText(s.getCnp());
	        gridPane.add(cnpField, 1, 4);
	        
	        Label groupLabel = new Label("Group: ");
	        gridPane.add(groupLabel, 0, 5);
	        TextField groupField = new TextField();
	        groupField.setPrefHeight(40);
	        groupField.setText( "" +s.getGroup() );
	        gridPane.add(groupField, 1, 5);
	        

	        Button LoginButton = new Button("See Courses");
	        LoginButton.setPrefHeight(40);
	        LoginButton.setDefaultButton(true);
	        LoginButton.setPrefWidth(200);
	        gridPane.add(LoginButton, 0, 6, 2, 1);
	        GridPane.setHalignment(LoginButton, HPos.LEFT);
	        GridPane.setMargin(LoginButton, new Insets(20, 0,20,0));

	        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
	            @SuppressWarnings({ "unchecked", "rawtypes" })
				@Override
	            public void handle(ActionEvent event) {
	            	
	            	ScrollPane scrollPane = new ScrollPane();
	            	  TableView<Course> table = new TableView<Course>();
	            	 table.setEditable(true);
	            	  TableColumn nameCol = new TableColumn("Name");
	            	  nameCol.setMinWidth(100);
	            	  nameCol.setCellValueFactory(
	                          new PropertyValueFactory<>("name"));
	            	  
	                  TableColumn emailCol = new TableColumn("Location");
	                  emailCol.setMinWidth(100);
	                  emailCol.setCellValueFactory(
	                          new PropertyValueFactory<>("location"));
	                  TableColumn addressCol = new TableColumn("StartHour");
	                  addressCol.setMinWidth(100);
	                  addressCol.setCellValueFactory(
	                          new PropertyValueFactory<>("startHour"));
	                  TableColumn cnpCol = new TableColumn("EndHour");
	                  cnpCol.setMinWidth(100);
	                  cnpCol.setCellValueFactory(
	                          new PropertyValueFactory<>("endHour"));
                 
	                  Label namecourse = new Label("Course : ");      
		      	        TextField namecourseFi = new TextField();
		      	        namecourseFi.setPrefHeight(40);  
	                  
	                  Button editButton = new Button("Enroll");
	                  editButton.setPrefHeight(40);
	                  editButton.setDefaultButton(true);
	                  editButton.setPrefWidth(200);
	                  
	                  editButton.setOnAction(new EventHandler<ActionEvent>() {
	      	            public void handle(ActionEvent event) {
	      	            	
	      	            	String numeDorit = namecourseFi.getText();
	      	            	EnrollmentBll eb = new EnrollmentBll();
	      	            	eb.addCourse(numeDorit, s.getId());
	      	            	System.out.println("apasat");
	      	            	}
	      	            });
	                  
	                  CourseBll sb = new CourseBll();
	                  ArrayList<Course> as = sb.allCourse();
	                  ObservableList<Course> data = FXCollections.observableArrayList(as);      
	                  
	                  table.setItems(data);
	                  table.getColumns().addAll(nameCol, emailCol, addressCol,cnpCol);
	                  
	                  
	                    	      
	                  
 
	                 GridPane sc = new GridPane();
	                 sc.add(editButton,2,0); 
	                 sc.add(namecourse, 3, 0);
	                 sc.add(namecourseFi, 4, 0);
	                 sc.add(table, 2,2);
	                 scrollPane.setContent(sc);
	                 scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);	             
	                 scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);	          
	                 Scene scene = new Scene(scrollPane, 650, 600);                 
	                 stage.setScene(scene);
	                 stage.show();
	            	
	            }
	        });
	    

        Button SigninButton = new Button("See my Grades");
        SigninButton.setPrefHeight(40);
        SigninButton.setDefaultButton(true);
        SigninButton.setPrefWidth(200);
        gridPane.add(SigninButton, 0, 6, 3, 1);
        GridPane.setHalignment(SigninButton, HPos.CENTER);
        GridPane.setMargin(SigninButton, new Insets(20, 0,20,0));

        SigninButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				EnrollmentBll eb = new EnrollmentBll();
				ArrayList<GradeCourse> str = null;
				try {
					str = eb.show();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				  TableView<GradeCourse> table = new TableView<GradeCourse>();
	            	 table.setEditable(true);
	            	  TableColumn nameCol = new TableColumn("Grade");
	            	  nameCol.setMinWidth(100);
	            	  nameCol.setCellValueFactory(
	                          new PropertyValueFactory<>("grade"));
	            	  
	                  TableColumn emailCol = new TableColumn("CourseName");
	                  emailCol.setMinWidth(100);
	                  emailCol.setCellValueFactory(
	                          new PropertyValueFactory<>("course"));
				
	                  
	                  ObservableList<GradeCourse> data = FXCollections.observableArrayList(str);      
	                  
	                  table.setItems(data);
	                  table.getColumns().addAll(nameCol, emailCol);
	                  
				 GridPane sc = new GridPane();
				 sc.add(table, 0, 0);
				Scene scene = new Scene(sc, 650, 600);                 
                stage.setScene(scene);
                stage.show();
				
			}
                     
        });
        
        Button saveButton = new Button("Save Updates");
        saveButton.setPrefHeight(40);
        saveButton.setDefaultButton(true);
        saveButton.setPrefWidth(200);
        gridPane.add(saveButton, 0, 6, 4, 1);
        GridPane.setHalignment(saveButton, HPos.RIGHT);
        GridPane.setMargin(saveButton, new Insets(20, 0,20,0));

        saveButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				
				String nume = nameField.getText();
				String adresa = addressField.getText();
				String cnp = cnpField.getText();
				String group = groupField.getText();

				sb.updates(s,nume,adresa,cnp, group);
					
				
			}               
        });
        
        Button deleteButton = new Button("Delete Profile");
        deleteButton.setPrefHeight(40);
        deleteButton.setDefaultButton(true);
        deleteButton.setPrefWidth(200);
        gridPane.add(deleteButton, 0, 7, 5, 1);
        GridPane.setHalignment(deleteButton, HPos.LEFT);
        GridPane.setMargin(deleteButton, new Insets(20, 0,20,0));

        deleteButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				sb.sterge(s);
				
			}               
        });
    }
}
