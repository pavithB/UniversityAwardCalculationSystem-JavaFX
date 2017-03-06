package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class LogInController extends Main {

	@FXML
	private TextField username;

	@FXML
	private TextField password;

	@FXML
	private Label lbl;

	@FXML
	private Button log;
	
	
	//load login window if user enter valid username and password

	public void Login(ActionEvent event) throws Exception {
		 if(username.getText().equals("gugsi") &&
			password.getText().equals("devil")){
		Stage primaryStage = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("/application/Home.fxml"));
		Scene scene = new Scene(root, 600, 500);
		((javafx.scene.Node)event.getSource()).getScene().getWindow().hide();
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setTitle("AWARD CALCULATION SYSTEM                  - U O G -                 No Where Particular");
		primaryStage.setResizable(false);

		}else{
		 lbl.setText("->The username or password you�ve entered doesn�t match<-");
		 }
	}

}
