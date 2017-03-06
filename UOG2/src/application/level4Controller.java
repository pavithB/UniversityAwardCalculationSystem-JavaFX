package application;

import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class level4Controller {

	@FXML
	private TextField stuname, stuid, l4m11, l4m12, l4m13, l4m21, l4m22, l4m23, l4m31, l4m32, l4m41, l4m42, l4m51,
			l4m52, l4m61, l4m62;

	@FXML
	private Label checklbl4, lvl4atemp, ECSI410result, ECSI412result, ECSI404result, ECSI400result, ECSI415result,
			ECSI450result;

	@FXML
	private Button checkbtn4, leave4, level5;
	int avgmrk = 0;

	private static int x = 0;
	 int y = 0;
	private static int credit = 0;
	int  size = 0;
	private static int qualify=0;
	private static String studentName;
	
	
	//call constructor to initialize variable
	DataBase DataBase = new DataBase();

	//coding the purpose of button "check"
	
	public void checkmarks4(ActionEvent event) throws Exception {
	try{
		System.out.println(DataBase.getStudentID());
	
		
		//add student id to database class
		String studentid = stuid.getText();
		DataBase.setStudentID(studentid);
		String studentName = stuname.getText();
		DataBase.setStudentName(studentName);
	

		credit = 0;
		
		//calculate average marks for each module
		int ecsi410 = (Integer.parseInt(l4m11.getText()) + Integer.parseInt(l4m12.getText())
				+ Integer.parseInt(l4m13.getText())) / 3;
		if (ecsi410 > 40) {
			ECSI410result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI410result.setText("FAIL");
		}
		int ecsi412 = (Integer.parseInt(l4m21.getText()) + Integer.parseInt(l4m22.getText())
				+ Integer.parseInt(l4m23.getText())) / 3;
		if (ecsi412 > 40) {
			ECSI412result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI412result.setText("FAIL");
		}
		int ecsi404 = (Integer.parseInt(l4m31.getText()) + Integer.parseInt(l4m32.getText())) / 2;
		if (ecsi404 > 40) {
			ECSI404result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI404result.setText("FAIL");
		}
		int ecsi400 = (Integer.parseInt(l4m41.getText()) + Integer.parseInt(l4m42.getText())) / 2;
		if (ecsi400 > 40) {
			ECSI400result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI400result.setText("FAIL");
		}
		int ecsi415 = (Integer.parseInt(l4m51.getText()) + Integer.parseInt(l4m52.getText())) / 2;
		if (ecsi415 > 40) {
			ECSI415result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI415result.setText("FAIL");
		}
		int ecsi450 = (Integer.parseInt(l4m61.getText()) + Integer.parseInt(l4m62.getText())) / 2;
		if (ecsi450 > 40) {
			ECSI450result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI450result.setText("FAIL");
		}
		
		/* 
		 * adding modules to an array what get average marks between 30 to 39,
			this array used to give condone marks :)
			*/
		int[] lev4 = { ecsi410, ecsi412, ecsi404, ecsi400, ecsi415, ecsi450 };
		for (int check : lev4) {
			if (check <= 39.0 && check >= 30.0) {
				
				ArrayList<Integer> condoned = new ArrayList<Integer>(5);
				condoned.add(check);
				size = size + condoned.size();	
			}
		}
		
		if (size == 1) {
			credit = credit + 20;
		} else if (size == 2) {
			credit = credit + 40;
		} else if (size > 2) {
			y++;
			size = 0 ;
		}
	}catch (Exception b) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INVALID INPUT");
		alert.setHeaderText("you enter invalid input ");
		alert.setContentText("please enter valid inputs");
		alert.showAndWait();
	}

	}

	
	//coding the purpose of button "Leave"(button to leave from the process)
	public void leave4(ActionEvent event) throws Exception {

		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/viewCredit.fxml"));
		Scene scene = new Scene(root, 600, 500);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage
				.setTitle("AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
		primaryStage.setResizable(false);

	}

	
	//coding the purpose of button "leve_05"(button to continue the process)
	public void cont4(ActionEvent event) throws Exception {
		System.out.println(DataBase.getStudentID());
		
		// process the credits that student get to continue
		switch (credit) {
		/*
		 * if user get 120 credits student able to continue to level 05 or leave the degree programme with cert.H.E
		 */
		case 120: {
			//if student have more than 2 modules marks between 30 to 39 alert message will pop up
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("C O N T I N U E - - O P T I O N");
			alert.setHeaderText("Continue To Level5 Or Exit With CERT.H.E");
			alert.setContentText("Choose your option.");

			ButtonType CERT = new ButtonType("CERT.HE");
			ButtonType LEV5 = new ButtonType("LEVEL5");

			alert.getButtonTypes().setAll(CERT, LEV5);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == CERT) {
					DataBase.setQualify(1);
				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/viewCredit.fxml"));
				Scene scene = new Scene(root, 600, 500);
				((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle(
						"AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
				primaryStage.setResizable(false);

			} else if (result.get() == LEV5) {

				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/level5.fxml"));
				Scene scene = new Scene(root, 600, 500);
				((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
				scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
				primaryStage.setScene(scene);
				primaryStage.show();
				primaryStage.setTitle(
						"AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
				primaryStage.setResizable(false);
			}
		}
			break;
		case 100: {
			/*
			 * if user get 100 credits user need to sit exams in that module again ,
			 * if failed modules marks are between 30 to 39 student need to sit again except highest performing 2 module
			 */
			if (y >= 1) {
				 y = 0;
				Alert condonealert = new Alert(AlertType.INFORMATION);
				condonealert.setTitle("condone ");
				condonealert.setHeaderText(
						"two condone credit are given to modules what have maximum between mark range 30 to 39");
				condonealert.setContentText("please enter next attempt mark ");
				condonealert.showAndWait();
				

			}
			checklbl4.setText("able to continue, but first enter resit marks");
			
			/*
			 * this code is to count the attempt,
			 */
			x++;
			switch (x) {
			case 1:
				lvl4atemp.setText("R E S I T");
				break;
			case 2:
				lvl4atemp.setText("R E T A K E");
				break;
			case 3:
				lvl4atemp.setText("R E S I T");
				break;
			default:
				/*if student exhausted the maximum permitted number of attempts'
				 *error msg will pop up
				*/
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("maximum attempt ");
				alert.setHeaderText("unable to continue student reach the number of maximum attempts");
				alert.setContentText("please press leave");
				alert.showAndWait();

			}
		}
			break;
		default: {/*
			 * if user get 100 credits user need to sit exams in that module again ,
			 * if failed modules marks are between 30 to 39 student need to sit again except highest performing 2 module
			 */
			
			if (y >= 1) {
				 y = 0;
				Alert condonealert = new Alert(AlertType.INFORMATION);
				condonealert.setTitle("condone ");
				condonealert.setHeaderText(
						"two condone credit are given to modules what have maximum between mark range 30 to 39");
				condonealert.setContentText("please enter next attempt marks what's modules marks between 30 to 39 ");
				condonealert.showAndWait();
			}
			checklbl4.setText("unable to continue enter resit marks");
			x++;
			switch (x) {
			case 1:
				lvl4atemp.setText("R E S I T");
				break;
			case 2:
				lvl4atemp.setText("R E T A K E");
				break;
			case 3:
				lvl4atemp.setText("R E S I T");
				break;
			default:
				/*if student exhausted the maximum permitted number of attempts'
				 *error msg will pop up
				*/
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("maximum attempt ");
				alert.setHeaderText("unable to continue student reach the number of maximum attempts");
				alert.setContentText("please press leave");
				alert.showAndWait();
			}
		}
		}

	}

}
