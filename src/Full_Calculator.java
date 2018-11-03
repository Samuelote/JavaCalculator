import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

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

public class Full_Calculator {
	
	private final TextField num1 = new TextField();
	private final TextField num2 = new TextField();
	private final ComboBox<String> comboBox = new ComboBox();
	private Text answer = new Text();
	private String equation = "";
	
	public void start(Stage primaryStage) {
		FlowPane base = new FlowPane();		
		String versionType = "This is the paid version. Will be formatted beautifully in the future.";
		base.widthProperty();
		Text Title = new Text(0,0, versionType);
		HBox myBox = new HBox();
		base.getChildren().add(Title);

		myBox.setPadding(new Insets(40,40,100,100));
		for (int i = 0; i <= 14; i++) {
			Button num;
			if (i == 14) {
				num = new Button("=");
				num.setOnAction(this::calculate);
				myBox.getChildren().add(num);
				break;
			}
			
			
			switch(i) {
			
			case 10:
				num = new Button("+");
				break;
			case 11:
				num = new Button("-");
				break;

			case 12:
				num = new Button("*");
				break;

			case 13:
				num = new Button("/");
				break;

			default:
				num = new Button(""+i);

			}
			num.setOnAction(a-> {
				equation += num.getText();
			});
			myBox.getChildren().add(num);
		}
		base.getChildren().add(myBox);
		
		HBox myBox2 = new HBox(answer);
		base.getChildren().add(myBox2);
		
		Group root = new Group(base);
		
		Scene scene = new Scene(root, 1000, 600, Color.GAINSBORO);

		primaryStage.setScene(scene);

		primaryStage.show();
	}
	

	private void calculate(ActionEvent args) {
		String answerText = "";
		Eval eval = new Eval(equation);
		answerText = Double.toString(eval.start());
		answer.setText(answerText);
		equation = "";

	}
	// Passing to isNumeric via value.

	private boolean isNumeric(String s) {  
		return s != null && s.matches("[-+]?\\d*\\.?\\d+");  
	}
}
