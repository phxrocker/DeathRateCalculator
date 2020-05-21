/*
//
//		Death rate calculator finds the current death rate
//		It is a simple percentage calculation
//		Divide number of deaths by number of cases and return percentage
//
 */

import javafx.application.Application;
import javafx.geometry.*;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import java.text.DecimalFormat;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;


public class CovidDeathCalc extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		
		//Remove default window title bar
		primaryStage.initStyle(StageStyle.UNDECORATED);
		
		//Create main pane
		BorderPane mainPane = new BorderPane();
		mainPane.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, null, null)));
				
		//Create labels for text fields
		Label label1 = new Label("Number of current cases");
		Label label2 = new Label("Death toll");
		label1.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		label2.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		label1.setStyle("-fx-text-fill: white;");
		label2.setStyle("-fx-text-fill: white;");
		
		//Create text input field
		TextField inputField1 = new TextField();
		TextField inputField2 = new TextField();
		inputField1.setMaxWidth(200);
		inputField2.setMaxWidth(200);
		inputField1.setStyle("-fx-background-color: #67888D; -fx-text-inner-color: white;");
		inputField2.setStyle("-fx-background-color: #67888D; -fx-text-inner-color: white;");
		
		//Create  calculation button
		Button button1 = new Button("Calculate Death Rate");
		button1.setStyle("-fx-background-color: #67888D; -fx-text-fill: white;");
		
		//Create exit button
		Button button2 = new Button("x");
		button2.setStyle("-fx-font: 22 arial; -fx-text-fill: white; -fx-background-color: transparent;");
		
		//Set exit action for button 2
		EventHandler<ActionEvent> quitHandler = quitEvent -> {
	        System.exit(0);
	    };
	    button2.setOnAction(quitHandler);		
				
		//Create Vbox 1 
		VBox vbox1 = new VBox(10);
		vbox1.setAlignment(Pos.TOP_CENTER);
		vbox1.setPadding(new Insets(30,0,0,30));
		vbox1.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, null, null)));
		vbox1.getChildren().addAll(label1, inputField1, label2, inputField2, button1);
		mainPane.setCenter(vbox1);
		mainPane.setRight(button2);
		
		//Create scene 1
		Scene scene1 = new Scene(mainPane, 500, 300, Color.STEELBLUE);
		primaryStage.setScene(scene1);
		primaryStage.show();
				
		//Create button 3
		Button button3 = new Button("Calculate New Death Rate");
		button3.setStyle("-fx-background-color: #67888D; -fx-text-fill: white;");
		
		//Set action for button 3
		button3.setOnAction(new EventHandler<ActionEvent>() {
		    @Override 
		    public void handle(ActionEvent e) {
		    	mainPane.setCenter(vbox1);
		    }
		});
		
		
		//Set action for button 1
		button1.setOnAction(new EventHandler<ActionEvent>() {
			
		@Override
		public void handle(ActionEvent event) {
							
			//Find death rate and convert to percentage
			double caseNumber = Integer.parseInt(inputField1.getText());
			double tollNumber = Integer.parseInt(inputField2.getText());
			double deathRate = ((tollNumber / caseNumber) * 100);
				
			//Set percentage to one decimal place
			DecimalFormat df = new DecimalFormat("#.0");
			
			//Set new label
			Label label3 = new Label("The current death rate is " + df.format(deathRate) + "%");
			label3.setFont(Font.font("Arial", FontWeight.BOLD, 20));
			
			//Set vbox 2
			VBox vbox2 = new VBox(40);
			vbox2.setAlignment(Pos.TOP_CENTER);
			vbox2.setPadding(new Insets(100, 0, 0, 30));
			vbox2.setBackground(new Background(new BackgroundFill(Color.STEELBLUE, null, null)));
			vbox2.getChildren().addAll(label3, button3);
			mainPane.setCenter(vbox2);
							
			}
		});
	}

	
	public static void main(String[] args) {		
		Application.launch(args);
	}
	
}
