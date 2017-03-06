package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class HomeController  {

	@FXML
	private Label lbl2;

	@FXML
	private Button viewbtn;

	@FXML
	private Button enterbtn;

	public void viewmarks(ActionEvent event) throws Exception {

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

	public void entermarks(ActionEvent event) {
		try {
			Stage primaryStage = new Stage();
			Parent root = FXMLLoader.load(getClass().getResource("/application/level4.fxml"));
			Scene scene2 = new Scene(root, 600, 500);
			((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
			scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene2);
			primaryStage.show();
			primaryStage.setTitle(
					"AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
			primaryStage.setResizable(false);

		} catch (Exception e1) {

		}
	}
}
