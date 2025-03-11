package org.example.bmicalculator;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

/**
 * BMIView class represents the user interface for the BMI calculator application.
 * It sets up the layout and UI components for input, calculation, and display.
 */
public class BMIView {

    public TextField weightField;
    public TextField heightField;
    public Label resultLabel;
    public Label statusLabel;
    public ToggleGroup unitGroup;
    public RadioButton metricRadio;
    public RadioButton englishRadio;
    public Button calculateButton;
    public Button clearButton;
    public MenuBar menuBar;

    private VBox root;

    /**
     * Constructor for BMIView. Initializes and sets up the UI components.
     */
    public BMIView() {
        // GridPane to organize input fields and labels
        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        // Weight Input
        Label weightLabel = new Label("Weight:");
        grid.add(weightLabel, 0, 0);

        weightField = new TextField();
        grid.add(weightField, 1, 0);

        // Height Input
        Label heightLabel = new Label("Height:");
        grid.add(heightLabel, 0, 1);

        heightField = new TextField();
        grid.add(heightField, 1, 1);

        // Unit Selection
        unitGroup = new ToggleGroup();
        metricRadio = new RadioButton("Metric (kg, cm)");
        englishRadio = new RadioButton("English (lbs, inches)");
        metricRadio.setToggleGroup(unitGroup);
        englishRadio.setToggleGroup(unitGroup);
        metricRadio.setSelected(true); // Default to metric

        // VBox to hold radio buttons for unit selection
        VBox unitBox = new VBox(5, metricRadio, englishRadio);
        grid.add(unitBox, 0, 2, 2, 1);

        // Calculate and Clear Buttons
        calculateButton = new Button("Calculate BMI");
        clearButton = new Button("Clear");
        // VBox to hold the calculate and clear buttons
        VBox buttons = new VBox(5, calculateButton, clearButton);
        buttons.setAlignment(Pos.CENTER);
        grid.add(buttons, 1, 3);

        // Result Labels
        resultLabel = new Label();
        grid.add(resultLabel, 0, 4, 2, 1);

        statusLabel = new Label();
        grid.add(statusLabel, 0, 5, 2, 1);

        // Menu Bar setup
        menuBar = new MenuBar();
        Menu fileMenu = new Menu("File");
        MenuItem exitItem = new MenuItem("Exit");

        fileMenu.getItems().addAll(exitItem);

        Menu helpMenu = new Menu("Help");
        MenuItem aboutItem = new MenuItem("About");
        helpMenu.getItems().add(aboutItem);

        menuBar.getMenus().addAll(fileMenu, helpMenu);

        // Root VBox to hold menu bar and grid
        root = new VBox(menuBar, grid);
    }

    /**
     * Returns the root VBox of the view.
     *
     * @return The root VBox containing all UI components.
     */
    public VBox getRoot() {
        return root;
    }
}