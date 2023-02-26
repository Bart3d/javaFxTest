package application;
	
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Pane root = new Pane();
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			Button btn1 = new Button("Close Program");
			btn1.setOnAction(e -> {
				closeProgram(primaryStage);
			});
			root.getChildren().add(btn1);
			
			primaryStage.setScene(scene);
			primaryStage.show();
			
			primaryStage.setOnCloseRequest(e -> {
				e.consume();
				closeProgram(primaryStage);
			});
			
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	private void closeProgram(Stage stage) {
		boolean answer = AlertBox.confirmation();
		if (answer) {
			System.out.println("Closing app");
			stage.close();
		}

	}
}
