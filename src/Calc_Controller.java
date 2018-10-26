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
import javafx.scene.layout.HBox;
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


public class Calc_Controller extends Application {
	private final TextField num1 = new TextField();
	private final TextField num2 = new TextField();
	private final ComboBox<String> comboBox = new ComboBox();
	private Text answer = new Text();
	
	public static void main(String[] args) {
		launch(args);
	}
	
	// Skip to the bottom for the new shiz Cassens...
	
	// Passing to start via reference.

	@Override
	public void start(Stage primaryStage) throws Exception {
		FlowPane base = new FlowPane();		
		String instructions = this.readFile();
		base.widthProperty();
		Text direction = new Text(0,0, instructions);
		HBox myBox = new HBox(direction);
		myBox.setPadding(new Insets(40,40,100,100));
		base.getChildren().add(myBox);
		
		

		
        num1.setPromptText("Enter a number");
        num1.setPrefColumnCount(10);
        num1.getText();
        base.getChildren().add(num1);
        

		ObservableList<String> options = 
		    FXCollections.observableArrayList(
		        "+",
		        "-",
		        "/",
		        "*"
		    );
		comboBox.getItems().addAll(options);
		base.getChildren().add(comboBox);

		
        num2.setPromptText("Enter a number");
        num2.setPrefColumnCount(10);
        num2.getText();
        base.getChildren().add(num2);
		
		HBox myBox2 = new HBox(answer);
		base.getChildren().add(myBox2);
        
        Button myButton = new Button("Calculate");
		myButton.setOnAction(this::calculate);
		base.getChildren().add(myButton);
		
		Group root = new Group(base);
		
		Scene scene = new Scene(root, 1000, 600, Color.GAINSBORO);
		
		primaryStage.setTitle("My Calculator");
		primaryStage.setScene(scene);
		primaryStage.show();

	}
	
	public String readFile() throws FileNotFoundException {

		File myFile = new File("./src/Instructions");	
		Scanner myFileScanner = new Scanner(myFile);	
		String instructions = "";
		
		while(myFileScanner.hasNextLine())
		{
			String line  = myFileScanner.nextLine();
			
			instructions += line+"\n";	
			
		}
		return instructions;
	}
	
	public void calculate(ActionEvent args) {
		
		String answerText = "";
		if (isNumeric(num1.getText()) && isNumeric(num2.getText())) {
			Eval eval = new Eval(num1.getText()+(String) comboBox.getValue()+num2.getText());
			System.out.println(eval.start());
			answerText = " = "+ Double.toString(eval.start());
		} else {
			answerText = "ERROR: Make sure you entered numbers into the fields.";
		}
		
		answer.setText(answerText);

	}
	// Passing to isNumeric via value.

	private boolean isNumeric(String s) {  
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}

}
