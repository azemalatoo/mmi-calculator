package org.example.bmicalculator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * BMICalculator class is the main entry point for the BMI calculator application.
 * It extends the JavaFX Application class and sets up the model, view, and controller,
 * then launches the application window.
 */
public class BMICalculator extends Application {

    /**
     * The start method is called when the application is launched.
     * It initializes the model, view, and controller, sets up the scene, and shows the primary stage.
     *
     * @param primaryStage The primary stage for this application, onto which
     * the application scene can be set.
     */
    @Override
    public void start(Stage primaryStage) {
        // Initialize the model, view, and controller
        BMIModel model = new BMIModel();
        BMIView view = new BMIView();
        new BMIController(model, view);

        // Create a scene with the root node from the view
        Scene scene = new Scene(view.getRoot(), 500, 400);

        // Set the scene to the primary stage
        primaryStage.setScene(scene);

        // Set the title of the primary stage
        primaryStage.setTitle("BMI Calculator");

        // Show the primary stage
        primaryStage.show();
    }

    /**
     * The main method is the entry point of the Java application.
     * It launches the JavaFX application.
     *
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        launch(args);
    }
}