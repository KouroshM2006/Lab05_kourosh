/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

//git link: https://github.com/KouroshM2006/Lab05_kourosh

package lab05_kourosh;

import java.io.ObjectInputStream;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 *
 * @author 2440557
 */
public class Lab05_kourosh extends Application {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {

        //creating root border pane
        BorderPane root = new BorderPane();

        //creating labels
        Label bagStyleLbl = new Label("Select Bag Style: ");
        Label quantityLabel = new Label("Select Quantity: ");
        Label sizeLabel = new Label("Select Size: ");
        Label messageLabel = new Label("");

        //creating grid pane
        GridPane grid = new GridPane();

        String[] bags = {"Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain"};
        ListView<String> listView = new ListView<>();
        listView.setItems(FXCollections.observableArrayList(bags));
        listView.setPrefSize(300, 170);

        //creating combo box
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        comboBox.setValue(1);

        //creating radio buttons and toggle group
        RadioButton smallRadioButton = new RadioButton("Small");
        RadioButton medRadioButton = new RadioButton("Medium");
        RadioButton largeRadioButton = new RadioButton("Large");

        ToggleGroup toggleGroup = new ToggleGroup();
        smallRadioButton.setToggleGroup(toggleGroup);
        medRadioButton.setToggleGroup(toggleGroup);
        largeRadioButton.setToggleGroup(toggleGroup);

        VBox vBox = new VBox(smallRadioButton, medRadioButton, largeRadioButton);

        // creating buttons
        Button orderBtn = new Button("Place Order");
        Button clearBtn = new Button("clear Button");

        //adding nodes to grid pane
        grid.add(quantityLabel, 0, 0);
        grid.add(comboBox, 1, 0);
        grid.add(sizeLabel, 0, 1);
        grid.add(vBox, 1, 1);
        grid.add(orderBtn, 0, 3);
        grid.add(clearBtn, 1, 3);

        grid.setAlignment(Pos.CENTER);
        grid.setHgap(5);
        grid.setVgap(5);

        //adding nodes to root
        root.setCenter(listView);
        root.setLeft(bagStyleLbl);
        root.setRight(grid);
        root.setPadding(new Insets(25, 25, 25, 25));
        root.setBottom(messageLabel);

        BorderPane.setMargin(listView, new Insets(10, 10, 10, 10));
        BorderPane.setAlignment(bagStyleLbl, Pos.CENTER);
        BorderPane.setAlignment(messageLabel, Pos.CENTER);

        //setting events for buttons
        orderBtn.setOnAction(e -> {

            String s = "bag";

            String bag = listView.getSelectionModel().getSelectedItem();

            RadioButton selectedRB = (RadioButton) toggleGroup.getSelectedToggle();

            if (bag != null && selectedRB != null && comboBox.getValue() != null) {
                Integer quantity = comboBox.getValue();
                String size = selectedRB.getText();

                if (quantity != null & quantity > 1) {
                    s = "bags";
                }
                
                messageLabel.setText(String.format("You ordered %s %s %s %s", quantity, size, bag, s));
            } else {
                messageLabel.setText("error: you need to select all parameters");
            }

        });
        
        clearBtn.setOnAction(e -> {
            comboBox.setValue(1);
            messageLabel.setText("");
            listView.getSelectionModel().clearSelection();
            
            if (toggleGroup.getSelectedToggle() != null) {
                toggleGroup.getSelectedToggle().setSelected(false);
            }
        });

        //setting scene 
        Scene scene = new Scene(root);

        primaryStage.setTitle("Bag Order Form");
        primaryStage.setScene(scene);

        primaryStage.show();

    }

}
