/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05_kourosh;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2440557
 */
public class task02 extends Application {

    //map of all prices and items
    private Map<String, Double> prices = new HashMap<>();

    //creating price variables
    private double tipPercent = 0;
    private double subtotal = 0;

    //array of item names
    private String[] itemNames = {
        "Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice",
        "Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa",
        "Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club",
        "Shrimp Scampi", "Pasta", "Fish and Chips",
        "Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp"
    };

    //array of item prices
    private double[] itemPrices = {
        2.50, 2.00, 1.75, 2.95, 1.50, 2.50,
        4.50, 3.75, 5.25, 3.00, 6.95,
        15.00, 13.50, 13.95, 11.90,
        18.99, 11.75, 12.25,
        5.95, 4.50, 4.75, 3.25, 5.98
    };

    public static void main(String[] args) {
        launch(args);
    }

    /**
     * method to calculate the subtotal;
     *
     * @param itemName
     */
    private void calculateSubTotal(String itemName) {
        subtotal += prices.get(itemName);
    }
    
    /**
     * method to calculate the values of labels
     * @param tipLabel
     * @param subtotalLabel
     * @param taxLabel
     * @param totalLabel 
     */
    private void calculateLabelValues(Label sliderValueLabel, Label tipLabel, Label subtotalLabel, Label taxLabel, Label totalLabel) {
        sliderValueLabel.setText(String.format("Tip percentage %.2f", tipPercent) + "%");
        subtotalLabel.setText(String.format("Subtotal: %.2f", subtotal) + "$");
        tipLabel.setText(String.format("Tip: %.2f", subtotal * (tipPercent / 100)) + "$");
        taxLabel.setText(String.format("Taxes: %.2f", subtotal * 0.15) + "$");
        totalLabel.setText(String.format("Total: %.2f", (subtotal * 1.15) + subtotal * (tipPercent / 100)) + "$");
    }

    @Override
    public void start(Stage primaryStage) {
        //creating border pane and grid pane
        BorderPane root = new BorderPane();
        GridPane grid = new GridPane();

        //creating slider
        Slider slider = new Slider(0, 20, 0);
        slider.setOrientation(Orientation.HORIZONTAL);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        //creating labels
        Label sliderValueLabel = new Label("Tip percentage: 0.00%");
        Label tipLabel = new Label("Tip: 0.00$");
        Label subtotalLabel = new Label("Subtotal: 0.00$");
        Label taxLabel = new Label("Taxes: 0.00$");
        Label totalLabel = new Label("Total: 0.00$");

        //creating button
        Button clearButton = new Button("Clear");

        //adding a listener to slider
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            tipPercent = newValue.doubleValue();
            
            calculateLabelValues(sliderValueLabel, tipLabel, subtotalLabel, taxLabel, totalLabel);
        });

        //maping the item names with their prices
        for (int i = 0; i < itemNames.length; i++) {
            prices.put(itemNames[i], itemPrices[i]);
        }

        //creating combo boxes
        ComboBox<String> beverageBox = new ComboBox<>();
        ComboBox<String> appetizerBox = new ComboBox<>();
        ComboBox<String> mainCourseBox = new ComboBox<>();
        ComboBox<String> dessertBox = new ComboBox<>();

        //array of combo boxes
        ComboBox<String>[] comboBoxes = new ComboBox[]{beverageBox, appetizerBox, mainCourseBox, dessertBox};

        //inserting food names into combo boxes by category
        String s = "Coffee";
        for (String item : itemNames) {

            if (item.equals("Soup")) {
                s = item;
            } else if (item.equals("Steak")) {
                s = item;
            } else if (item.equals("Apple Pie")) {
                s = item;
            }

            if (s.equals("Soup")) {
                appetizerBox.getItems().add(item);
            } else if (s.equals("Steak")) {
                mainCourseBox.getItems().add(item);
            } else if (s.equals("Apple Pie")) {
                dessertBox.getItems().add(item);
            } else {
                beverageBox.getItems().add(item);
            }
        }

        //setting action events on combo boxes
        for (ComboBox<String> comboBox : comboBoxes) {
            comboBox.setOnAction(e -> {
                if (comboBox.getValue() != null) {
                    calculateSubTotal(comboBox.getValue());
                    calculateLabelValues(sliderValueLabel, tipLabel, subtotalLabel, taxLabel, totalLabel);  
                }
            });
        }

        //button action event 
        clearButton.setOnAction(e -> {
            for (ComboBox<String> comboBox : comboBoxes) {
                comboBox.getSelectionModel().clearSelection();
            }
            slider.setValue(0);
            subtotal = 0;
            
            calculateLabelValues(sliderValueLabel, tipLabel, subtotalLabel, taxLabel, totalLabel);
        });
        
        //adding nodes to grid pane
        grid.add(slider, 0, 0);
        grid.add(sliderValueLabel, 1, 0);
        grid.add(subtotalLabel, 0, 1);
        grid.add(tipLabel, 0, 2);
        grid.add(taxLabel, 0, 3);
        grid.add(totalLabel, 0, 4);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        HBox hBox = new HBox(new Label("Beverage:"), beverageBox, new Label("Appetizer:"), appetizerBox, new Label("Main Course:"), mainCourseBox, new Label("Dessert:"), dessertBox);
        hBox.setSpacing(5);
        
        //adding nodes to border pane
        root.setTop(hBox);
        root.setCenter(grid);
        root.setBottom(clearButton);
        root.setPadding(new Insets(25, 25, 25, 25));
        
        BorderPane.setMargin(grid, new Insets(10, 10, 10, 10));
        
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("menu bill calculator");
        primaryStage.show();

    }

}
