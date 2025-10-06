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
    
    //tip percentage changable
    private double tipPercent = 0;
    
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
        Label sliderValueLabel = new Label("Tip percentage: 0%");
        Label tipLabel = new Label("Tip: 0$");
        Label subtotalLabel = new Label("Total: 0$");
        Label totalLabel = new Label("Total: 0$");
        
        //creating button
        Button clearButton = new Button("Clear");
        
        //adding a listener to slider
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            tipPercent = newValue.doubleValue();
            sliderValueLabel.setText(String.format("Tip percentage: %.2f", tipPercent) + "%");
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

            });
        }

        grid.add(slider, 0, 0);
        grid.add(sliderValueLabel, 1, 0);
        grid.add(subtotalLabel, 0, 1);
        grid.add(tipLabel, 0, 2);
        grid.add(totalLabel, 0, 3);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);

        BorderPane.setMargin(grid, new Insets(10, 10, 10, 10));
        HBox hBox = new HBox(new Label("Beverage:"), beverageBox, new Label("Appetizer:"), appetizerBox, new Label("Main Course:"), mainCourseBox, new Label("Dessert:"), dessertBox);
        hBox.setSpacing(5);
        root.setTop(hBox);
        root.setCenter(grid);
        root.setBottom(clearButton);
        root.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
