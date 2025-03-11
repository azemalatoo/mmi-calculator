package org.example.bmicalculator;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/**
 * BMIController class handles the interactions between the BMIModel and BMIView.
 * It attaches event handlers to UI components and manages the flow of data.
 */
public class BMIController {

    private BMIModel model;
    private BMIView view;

    /**
     * Constructor for BMIController. Initializes the model, view, and attaches event handlers.
     *
     * @param model The BMIModel instance.
     * @param view  The BMIView instance.
     */
    public BMIController(BMIModel model, BMIView view) {
        this.model = model;
        this.view = view;
        attachEventHandlers();
    }

    /**
     * Attaches event handlers to the UI components in the BMIView.
     */
    private void attachEventHandlers() {
        // Calculate Button Action
        view.calculateButton.setOnAction(event -> calculateBMI());

        // Clear Button Action
        view.clearButton.setOnAction(event -> {
            view.weightField.clear();
            view.heightField.clear();
            view.resultLabel.setText("");
            view.statusLabel.setText("");
        });

        // Exit Menu Item Action
        view.menuBar.getMenus().get(0).getItems().get(0).setOnAction(event -> Platform.exit());

        // About Menu Item Action
        view.menuBar.getMenus().get(1).getItems().get(0).setOnAction(event -> {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("About BMI Calculator");
            alert.setHeaderText(null);
            alert.setContentText("Enter your weight and height to calculate your BMI. Select metric or English units. The application will then show your BMI and BMI status.");
            alert.showAndWait();
        });
    }

    /**
     * Calculates the BMI using the model and updates the view with the result.
     * Handles potential NumberFormatExceptions.
     */
    private void calculateBMI() {
        try {
            // Parse weight and height from input fields
            double weight = Double.parseDouble(view.weightField.getText());
            double height = Double.parseDouble(view.heightField.getText());
            // Determine if metric units are selected
            boolean isMetric = view.metricRadio.isSelected();

            // Calculate BMI and get status from the model
            double bmi = model.calculateBMI(weight, height, isMetric);
            String status = model.getBMIStatus(bmi);

            // Update the view with the calculated BMI and status
            view.resultLabel.setText("BMI: " + String.format("%.2f", bmi));
            view.statusLabel.setText("Status: " + status);

        } catch (NumberFormatException e) {
            // Handle invalid input (non-numeric values)
            view.resultLabel.setText("Invalid input. Please enter numbers.");
            view.statusLabel.setText("");
        }
    }
}