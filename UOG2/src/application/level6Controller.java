package application;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class level6Controller {
	@FXML
	private TextField l6m41;
	@FXML
	private TextField l6m21;
	@FXML
	private TextField l6m51;
	@FXML
	private TextField l6m11;
	@FXML
	private TextField l6m31;
	@FXML
	private TextField l6m42;
	@FXML
	private TextField l6m12;
	@FXML
	private TextField l6m32;
	@FXML
	private TextField l6m22;
	@FXML
	private TextField l6m52;
	@FXML
	private TextField l6m13;
	@FXML
	private TextField l6m23;
	@FXML
	private Button viewcredit6;
	@FXML
	private Button leave6;
	@FXML
	private Button checkbtn6;
	@FXML
	private Label checklbl6;
	@FXML
	private Label lvl6atemp;
	@FXML
	private Label ECSI630result;
	@FXML
	private Label ECSI604result;
	@FXML
	private Label ECSI610result;
	@FXML
	private Label ECSI600result;
	@FXML
	private Label ECSI612result;

	
	private static int module61;
	private static int module62;
	private static int module63;
	private static int module64;
	private static int module65;
	private static int qualify =0;
	int x ;
	
	private static int credit; 
	
	// coding the process of Button "leave"
	@FXML
	public void leave6(ActionEvent event) throws IOException {
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/viewCredit.fxml"));
		Scene scene = new Scene(root, 600, 500);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
		primaryStage.setResizable(false);
		}
	/*
	 * calculate the average marks of level_05 modules 
	 */
	@FXML
	public void CheckMarksL6(ActionEvent event) {
	try{
		credit = 0 ;
		int ecsi630 = (Integer.parseInt(l6m11.getText()) + Integer.parseInt(l6m12.getText())+ Integer.parseInt(l6m13.getText())) / 3;
		if(ecsi630 > 40){
			ECSI630result.setText("PASS");
			credit = credit + 20 ;
		}else{
			ECSI630result.setText("FAIL");
		}
		int ecsi612 = (Integer.parseInt(l6m21.getText()) + Integer.parseInt(l6m22.getText())+ Integer.parseInt(l6m23.getText())) / 3;
		if(ecsi612 > 40){
			ECSI612result.setText("PASS");
			credit = credit + 20 ;
		}else{
			ECSI612result.setText("FAIL");
		}
		int ecsi604 = (Integer.parseInt(l6m31.getText()) + Integer.parseInt(l6m32.getText())) / 2;
		if(ecsi604 > 40){
			ECSI604result.setText("PASS");
			credit = credit + 20 ;
		}else{
			ECSI604result.setText("FAIL");
		}
		int ecsi610 = (Integer.parseInt(l6m41.getText()) + Integer.parseInt(l6m42.getText())) / 2;
		if(ecsi610 > 40){
			ECSI610result.setText("PASS");
			credit = credit + 20 ;
		}else{
			ECSI610result.setText("FAIL");
		}
		int ecsi600 = (Integer.parseInt(l6m51.getText()) + Integer.parseInt(l6m52.getText())) / 2;
		if(ecsi600 > 40){
			ECSI600result.setText("PASS");
			credit = credit + 40 ;
		}else{
			ECSI600result.setText("FAIL");
			}	
		
		
		DataBase database = new DataBase ();
		
		database.setModule61(ecsi630);
		database.setModule62(ecsi612);
		database.setModule63(ecsi604);
		database.setModule64(ecsi610);
		database.setModule65(ecsi600);

		
	}catch (Exception d) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INVALID INPUT");
		alert.setHeaderText("you enter invalid input ");
		alert.setContentText("please enter valid inputs");
		alert.showAndWait();
	}
		
		
		}
	
	// coding the process of Button "level_06"
		@FXML
		public void cont6(ActionEvent event) throws IOException {
			switch(credit){
	         case 120 :{
	        	 checklbl6.setText("press viewcredit to continue");
	        	 Alert alert = new Alert(AlertType.CONFIRMATION);
	        	 alert.setTitle("C O N T I N U E - - O P T I O N");
	        	 alert.setHeaderText("Continue To view credits Or Exit With non-honest ");
	        	 alert.setContentText("Choose your option.");

	        	 ButtonType nonhon = new ButtonType("non-honest");
	        	 ButtonType viewcredit = new ButtonType("view_credit");
	        	 


	        	 alert.getButtonTypes().setAll(nonhon, viewcredit);

	        	 Optional<ButtonType> result = alert.showAndWait();
	        	 if (result.get() == nonhon){
	        		 DataBase.setQualify(3);
	        		 Stage primaryStage = new Stage();
	        			Parent root = FXMLLoader.load(getClass().getResource("/application/viewCredit.fxml"));
	        			Scene scene = new Scene(root, 600, 500);
	        			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
	        			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
	        			primaryStage.setScene(scene);
	        			primaryStage.show();
	        			primaryStage.setTitle("AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
	        			primaryStage.setResizable(false);

	        		 
	        	 } else if (result.get() == viewcredit) {
	        		 DataBase.setQualify(4);
	        		 	Stage primaryStage = new Stage();
		        		Parent root = FXMLLoader.load(getClass().getResource("/application/viewCredit.fxml"));
		        		Scene scene = new Scene(root, 600, 500);
		        		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		        		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		        		primaryStage.setScene(scene);
		        		primaryStage.show();
		        		primaryStage.setTitle("AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
		        		primaryStage.setResizable(false);
		         		
	        	 
	        	 		}
	         		}
	            break;
	         case 100 :
	        	 checklbl6.setText("able to continue first enter resit marks");
	        	 /*
	 			 * this code is to count the attempt,
	 			 *if student exhausted the maximum permitted number of attempts'
	 			 *error message will pop up
	 			 */
	        	 x++;
	        	 switch(x){
	        	 	 case 1 :
	        	 		 lvl6atemp.setText("R E S I T");
	        		 break;
	        	 	 case 2 :
	        	 		lvl6atemp.setText("R E T A K E");
	        	 	break;
	        	 	 case 3 :
	        	 		lvl6atemp.setText("R E S I T");
	        	 	break;
	        	 	default :
	        	 		Alert alert = new Alert(AlertType.INFORMATION);
	        	 		alert.setTitle("maximum attempt ");
	        	 		alert.setHeaderText("unable to continue student reach the number of maximum attempts");
	        	 		alert.setContentText("please press leave");
	        	 		alert.showAndWait();
	        	 		
	        	 		}	
	             break;
	             
	             default :
	        	 checklbl6.setText("unable to continue enter resit marks");	 
	        	 /*
	 			 * this code is to count the attempt,
	 			 *if student exhausted the maximum permitted number of attempts'
	 			 *error message will pop up
	 			 */
	        	 		x++;
				        	 switch(x){
				        	 	 case 1 :
				        	 		 lvl6atemp.setText("R E S I T");
				        		 break;
				        	 	 case 2 :
				        	 		lvl6atemp.setText("R E T A K E");
				        	 	break;
				        	 	 case 3 :
				        	 		lvl6atemp.setText("R E S I T");
				        	 	break;
				        	 	default :
				        	 		Alert alert = new Alert(AlertType.INFORMATION);
				        	 		alert.setTitle("maximum attempt ");
				        	 		alert.setHeaderText("unable to continue student reach the number of maximum attempts");
				        	 		alert.setContentText("please press leave");
				        	 		alert.showAndWait();
	        	 		}
		  		
		  

				}
			
			
		
		}
}
