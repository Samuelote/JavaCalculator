import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;



/*
 * *****************************************************
 * Author: Samuel Wood
 * Title: Simple Calculator!
 * Description: This is the visual aspect that calls the Eval class based on user inputs.
 * ******************************************************
 */


public class Driver extends Application {
	private final TextField Username = new TextField();
	private final TextField Password = new TextField();
	private Text Title = new Text(0,0, 
			"Paid version credentials: \n\n"+
			"- Username: paid \n" +
			"- Password: password \n\n" +
			"------------\n\n"+
			"Free version credentials: \n\n"+
			"- Username: unpaid \n" +
			"- Password: password \n\n\n"+
			"Sign in \n"
			);

	private Stage mainStage;
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		mainStage = primaryStage;

		GridPane base = new GridPane();		
		base.widthProperty();
		HBox myBox = new HBox(Title);
		myBox.setPadding(new Insets(10,10,10,10));

		
		Username.setPromptText("Enter your username");
		Username.setPrefColumnCount(10);
		
        Password.setPromptText("Enter your password");
        Password.setPrefColumnCount(10);

        
        Button myButton = new Button("Sign in");
		myButton.setOnAction(this::signIn);
		
		base.add(myBox, 0, 0);
		base.add(myButton,0,3);
        base.add(Username,0,1);
        base.add(Password,0,2);

		Group root = new Group(base);
		
		Scene scene = new Scene(root, 1000, 600, Color.GAINSBORO);
		
		mainStage.setTitle("My Calculator");
		mainStage.setScene(scene);
		mainStage.show();


	}
	
	private void signIn(ActionEvent args) {
		if (Username.getText().equals("unpaid") && Password.getText().equals("password")) {
			Basic_Calculator basic = new Basic_Calculator();
			basic.start(mainStage);
		} else if (Username.getText().equals("paid") && Password.getText().equals("password")) {
			Full_Calculator full = new Full_Calculator();
			full.start(mainStage);
		} 
		else {
			Title.setText("Paid version credentials: \n\n"+
					"- Username: paid \n" +
					"- Password: password \n\n" +
					"------------\n\n"+
					"Free version credentials: \n\n"+
					"- Username: unpaid \n" +
					"- Password: password \n\n\n"+
					"Wrong info... Try again. \n");
		}
	}
}
