package Presentation;

import java.util.ArrayList;

import Business.StudentBll;
import Business.TeacherBll;
import Data.Student;
import Data.Teacher;
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
import javafx.scene.control.ScrollPane.ScrollBarPolicy;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class TeacherView extends Application{

	String identification;
	Teacher t;
	TeacherBll tb = new TeacherBll();
	
	public TeacherView(String email, String pass) {
		this.identification=email;	
		
		t = tb.findByMail(identification);
		if (!t.getPassword().equals(pass)) {
			t = null;
			System.out.println("Incorect");
			return;
		}
	}
	
	Stage stage;
	Scene scenefist;
	private ArrayList<Student> as;
	private int y;
	 @Override
	 public void start(Stage primaryStage) throws Exception {
		 	stage = primaryStage;
	        primaryStage.setTitle("Teacher Info");
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
	        Label headerLabel = new Label("Teacher");
	        headerLabel.setFont(Font.font("Arial", FontWeight.BOLD, 24));
	        gridPane.add(headerLabel, 0,0,2,1);
	        GridPane.setHalignment(headerLabel, HPos.CENTER);
	        GridPane.setMargin(headerLabel, new Insets(20, 0,20,0));

	        Label nameLabel = new Label("Name: ");
	        gridPane.add(nameLabel, 0, 2);
	        TextField nameField = new TextField();
	        nameField.setPrefHeight(40);
	        nameField.setText(t.getName());
	        gridPane.add(nameField, 1, 2);

	        Label addressLabel = new Label("Address: ");
	        gridPane.add(addressLabel, 0, 3);
	        TextField addressField = new TextField();
	        addressField.setPrefHeight(40);
	        addressField.setText(t.getAddress());
	        gridPane.add(addressField, 1, 3);

	        Label cnpLabel = new Label("CNP: ");
	        gridPane.add(cnpLabel, 0, 4);
	        TextField cnpField = new TextField();
	        cnpField.setPrefHeight(40);
	        System.out.println(t.getCnp());
	        cnpField.setText(t.getCnp());
	        gridPane.add(cnpField, 1, 4);
	        

	        Button LoginButton = new Button("See Students");
	        LoginButton.setPrefHeight(40);
	        LoginButton.setDefaultButton(true);
	        LoginButton.setPrefWidth(200);
	        gridPane.add(LoginButton, 0, 6, 2, 1);
	        GridPane.setHalignment(LoginButton, HPos.LEFT);
	        GridPane.setMargin(LoginButton, new Insets(20, 0,20,0));

	        LoginButton.setOnAction(new EventHandler<ActionEvent>() {
	            @SuppressWarnings("unchecked")
				@Override
	            public void handle(ActionEvent event) {

	            	 ScrollPane scrollPane = new ScrollPane();
	            	  TableView<Student> table = new TableView<Student>();
	            	 table.setEditable(true);
	            	  TableColumn nameCol = new TableColumn("Name");
	            	  nameCol.setMinWidth(100);
	            	  nameCol.setCellValueFactory(
	                          new PropertyValueFactory<>("name"));
	            	  
	                  TableColumn emailCol = new TableColumn("Email");
	                  emailCol.setMinWidth(100);
	                  emailCol.setCellValueFactory(
	                          new PropertyValueFactory<>("email"));
	                  TableColumn addressCol = new TableColumn("Address");
	                  addressCol.setMinWidth(100);
	                  addressCol.setCellValueFactory(
	                          new PropertyValueFactory<>("address"));
	                  TableColumn cnpCol = new TableColumn("Cnp");
	                  cnpCol.setMinWidth(100);
	                  cnpCol.setCellValueFactory(
	                          new PropertyValueFactory<>("cnp"));
	                  TableColumn groupCol = new TableColumn("Group");
	                  groupCol.setMinWidth(100);
	                  groupCol.setCellValueFactory(
	                          new PropertyValueFactory<>("group"));
	                 
	                  
	                  
	                  
	                  Button editButton = new Button("Edit");
	                  editButton.setPrefHeight(40);
	                  editButton.setDefaultButton(true);
	                  editButton.setPrefWidth(200);
	                  Button addButton = new Button("Add");
	                  addButton.setPrefHeight(40);
	                  addButton.setDefaultButton(true);
	                  addButton.setPrefWidth(200);
	                 
	                  TextField ntx= new TextField();
	                  ntx.setPromptText("name");
	                  TextField mtx= new TextField();
	                  mtx.setPromptText("mail");
	                  TextField ptx= new TextField();
	                  ptx.setPromptText("password");
	                  TextField atx= new TextField();
	                  atx.setPromptText("address");
	                  TextField ctx= new TextField();
	                  ctx.setPromptText("cnp");
	                  TextField gtx= new TextField();
	                  gtx.setPromptText("group");
	                  
	                  StudentBll sb = new StudentBll();
	                  as = sb.allStud();
	                  
	                  ObservableList<Student> data = FXCollections.observableArrayList(as);       
	                 
	                  
	                  table.setItems(data);
	                  table.getColumns().addAll(nameCol, emailCol, addressCol,cnpCol,groupCol);
	                  
	                  addButton.setOnAction(new EventHandler<ActionEvent>() {
	                      @Override
	                      public void handle(ActionEvent e) {
	                          StudentBll sba = new StudentBll(ntx.getText(),mtx.getText(),ptx.getText(),atx.getText(),ctx.getText(),gtx.getText());
	                          sba.adauga();
	                          as = sba.allStud();
	                          y=1;
	                          ObservableList<Student> data = FXCollections.observableArrayList(as);     
	                          table.setItems(data);
	    	                  table.getColumns().addAll(nameCol, emailCol, addressCol,cnpCol,groupCol);
	                      }
	                  });
	                  
	                  
	                  Button deleteButton = new Button("Delete");
	                  deleteButton.setPrefHeight(40);
	                  deleteButton.setDefaultButton(true);
	                  deleteButton.setPrefWidth(200);
	                  
	                  deleteButton.setOnAction(new EventHandler<ActionEvent>() {
	                      @Override
	                      public void handle(ActionEvent e) {
	                          StudentBll sba = new StudentBll();
	                          sba.sterge(mtx.getText());
	                          ObservableList<Student> data = FXCollections.observableArrayList(as);     
	                          table.setItems(data);
	    	                  table.getColumns().addAll(nameCol, emailCol, addressCol,cnpCol,groupCol);
	                      }
	                  });
	                  
	                 
             
	                 GridPane sc = new GridPane();
	                 sc.add(addButton, 0, 0);
	                 sc.add(ntx, 0, 1);
	                 sc.add(mtx, 0, 2);
	                 sc.add(ptx, 0, 3);
	                 sc.add(atx, 0, 4);
	                 sc.add(ctx, 0, 5);
	                 sc.add(gtx, 0, 6);
	                 sc.add(deleteButton, 1, 0);
	                 sc.add(editButton,2,0); 
	                 sc.add(table,1,1);
	                 scrollPane.setContent(sc);
	                 scrollPane.setVbarPolicy(ScrollBarPolicy.ALWAYS);	             
	                 scrollPane.setHbarPolicy(ScrollBarPolicy.AS_NEEDED);	          
	                 Scene scene = new Scene(scrollPane, 650, 600);                 
	                 stage.setScene(scene);
	                 stage.show();
	            }
	        });
	    

        Button SigninButton = new Button("Generate Report");
        SigninButton.setPrefHeight(40);
        SigninButton.setDefaultButton(true);
        SigninButton.setPrefWidth(200);
        gridPane.add(SigninButton, 0, 6, 3, 1);
        GridPane.setHalignment(SigninButton, HPos.CENTER);
        GridPane.setMargin(SigninButton, new Insets(20, 0,20,0));

        SigninButton.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				
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
				tb.updates(t,nume,adresa,cnp);
				t = tb.findByMail(identification);
				nameField.setText(t.getName());
				addressField.setText(t.getAddress());
				cnpField.setText(t.getCnp());
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
				tb.sterge(t);
				
			}               
        });
    }
	
}
