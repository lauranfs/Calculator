package sample;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{

        Controller controller = new Controller();
        CalculatorBrain brain = new CalculatorBrain();

        CalculatorUI ui = new CalculatorUI(controller);
        controller.setUi(ui);
        controller.setBrain(brain);

        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Calculator");
        Scene scene = new Scene(ui.grid, 300, 300);
        scene.getStylesheets().add("style.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
