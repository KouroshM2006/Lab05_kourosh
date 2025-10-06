/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package lab05_kourosh;

import java.util.HashMap;
import java.util.Map;
import javafx.application.Application;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

/**
 *
 * @author 2440557
 */
public class task02 extends Application {
    private Map<String, Double> prices = new HashMap<>();
    
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        
        String[] itemNames = {
            "Coffee", "Tea", "Soft Drink", "Water", "Milk", "Juice",
            "Soup", "Salad", "Spring Rolls", "Garlic Bread", "Chips and Salsa",
            "Steak", "Grilled Chicken", "Chicken Alfredo", "Turkey Club",
            "Shrimp Scampi", "Pasta", "Fish and Chips",
            "Apple Pie", "Carrot Cake", "Mud Pie", "Pudding", "Apple Crisp"
        };

        double[] itemPrices = {
            2.50, 2.00, 1.75, 2.95, 1.50, 2.50,
            4.50, 3.75, 5.25, 3.00, 6.95,
            15.00, 13.50, 13.95, 11.90,
            18.99, 11.75, 12.25,
            5.95, 4.50, 4.75, 3.25, 5.98
        };
        
        for (int i = 0; i < itemNames.length; i++) {
            prices.put(itemNames[i], itemPrices[i]);
        }
        
        ComboBox<String> beverageBox = new ComboBox<>();
        ComboBox<String> appetizerBox = new ComboBox<>();
        ComboBox<String> mainCourseBox = new ComboBox<>();
        ComboBox<String> dessertBox = new ComboBox<>();
        
        ComboBox<String>[] comboBoxes = new ComboBox[]{beverageBox, appetizerBox, mainCourseBox, dessertBox};
        
        for (String item : itemNames) {
            String s = "Coffee";
            
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
        
        HBox hBox = new HBox(beverageBox, appetizerBox, mainCourseBox, dessertBox);
        
        
        
    }

}
