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
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.ActionEvent;

import javafx.scene.control.Label;

public class level5Controller {
	@FXML
	private TextField l5m41;
	@FXML
	private TextField l5m21;
	@FXML
	private TextField l5m51;
	@FXML
	private TextField l5m11;
	@FXML
	private TextField l5m61;
	@FXML
	private TextField l5m31;
	@FXML
	private TextField l5m42;
	@FXML
	private TextField l5m12;
	@FXML
	private TextField l5m32;
	@FXML
	private TextField l5m22;
	@FXML
	private TextField l5m52;
	@FXML
	private TextField l5m62;
	@FXML
	private TextField l5m13;
	@FXML
	private TextField l5m23;
	@FXML
	private Button level6;
	@FXML
	private Button leavedip;
	@FXML
	private Button checkbtn5;
	@FXML
	private Label checklbl5;
	@FXML
	private Label lvl5atemp;
	@FXML
	private Label ECSI530result;
	@FXML
	private Label ECSI512result;
	@FXML
	private Label ECSI504result;
	@FXML
	private Label ECSI510result;
	@FXML
	private Label ECSI500result;
	@FXML
	private Label ECSI521result;

	private static int module51;
	private static int module52;
	private static int module53;
	private static int module54;
	private static int module55;
	private static int module56;
	private static int qualify =0;
	int credit;
	int x;

	// coding the process of Button "leave"
	@FXML
	public void leave5(ActionEvent event) throws IOException {

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

	// coding the process of Button "check"
	@FXML
	public void checkmarks5(ActionEvent event) {
	try {
		credit = 0;
		
	/*
	 * calculate the average marks of level_05 modules 
	 */
		int ecsi530 = (Integer.parseInt(l5m11.getText()) + Integer.parseInt(l5m12.getText())
				+ Integer.parseInt(l5m13.getText())) / 3;
		if (ecsi530 > 40) {
			ECSI530result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI530result.setText("FAIL");
		}
		int ecsi512 = (Integer.parseInt(l5m21.getText()) + Integer.parseInt(l5m22.getText())
				+ Integer.parseInt(l5m23.getText())) / 3;
		if (ecsi512 > 40) {
			ECSI512result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI512result.setText("FAIL");
		}
		int ecsi504 = (Integer.parseInt(l5m31.getText()) + Integer.parseInt(l5m32.getText())) / 2;
		if (ecsi504 > 40) {
			ECSI504result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI504result.setText("FAIL");
		}
		int ecsi510 = (Integer.parseInt(l5m41.getText()) + Integer.parseInt(l5m42.getText())) / 2;
		if (ecsi510 > 40) {
			ECSI510result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI510result.setText("FAIL");
		}
		int ecsi500 = (Integer.parseInt(l5m51.getText()) + Integer.parseInt(l5m52.getText())) / 2;
		if (ecsi500 > 40) {
			ECSI500result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI500result.setText("FAIL");
		}
		int ecsi521 = (Integer.parseInt(l5m61.getText()) + Integer.parseInt(l5m62.getText())) / 2;
		if (ecsi521 > 40) {
			ECSI521result.setText("PASS");
			credit = credit + 20;
		} else {
			ECSI521result.setText("FAIL");
		}

		DataBase database = new DataBase();

		database.setModule51(ecsi530);
		database.setModule52(ecsi512);
		database.setModule53(ecsi504);
		database.setModule54(ecsi510);
		database.setModule55(ecsi500);
		database.setModule56(ecsi521);
	}catch (Exception c) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("INVALID INPUT");
		alert.setHeaderText("you enter invalid input ");
		alert.setContentText("please enter valid inputs");
		alert.showAndWait();
	}
	}

	// coding the process of Button "level_06"
	@FXML
	public void cont5(ActionEvent event) throws IOException {
		switch (credit) {
		case 120: {
			checklbl5.setText("press level5 to continue");
			Alert alert = new Alert(AlertType.CONFIRMATION);
			alert.setTitle("C O N T I N U E - - O P T I O N");
			alert.setHeaderText("Continue To Level6 Or Exit With D.I.P.H.E");
			alert.setContentText("Choose your option.");

			ButtonType DIP = new ButtonType("DIPHE");
			ButtonType LEV6 = new ButtonType("LEVEL6");

			alert.getButtonTypes().setAll(DIP, LEV6);

			Optional<ButtonType> result = alert.showAndWait();
			if (result.get() == DIP) {
					DataBase.setQualify(2);
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

			} else if (result.get() == LEV6) {

				Stage primaryStage = new Stage();
				Parent root = FXMLLoader.load(getClass().getResource("/application/level6.fxml"));
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
		case 100:
			checklbl5.setText("able to continue first enter resit marks");
			/*
			 * this code is to count the attempt,
			 *if student exhausted the maximum permitted number of attempts'
			 *error message will pop up
			 */
			x++;
			switch (x) {
			case 1:
				lvl5atemp.setText("R E S I T");
				break;
			case 2:
				lvl5atemp.setText("R E T A K E");
				break;
			case 3:
				lvl5atemp.setText("R E S I T");
				break;
			default:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("maximum attempt ");
				alert.setHeaderText("unable to continue student reach the number of maximum attempts");
				alert.setContentText("please press leave");
				alert.showAndWait();

			}
			break;

		default:
			checklbl5.setText("unable to continue enter resit marks");
			x++;
			/*
			 * this code is to count the attempt,
			 *if student exhausted the maximum permitted number of attempts'
			 *error message will pop up
			 */
			switch (x) {
			case 1:
				lvl5atemp.setText("R E S I T");
				break;
			case 2:
				lvl5atemp.setText("R E T A K E");
				break;
			case 3:
				lvl5atemp.setText("R E S I T");
				break;
			default:
				Alert alert = new Alert(AlertType.INFORMATION);
				alert.setTitle("maximum attempt ");
				alert.setHeaderText("unable to continue student reach the number of maximum attempts");
				alert.setContentText("please press leave");
				alert.showAndWait();
			}
		}

	}

}

