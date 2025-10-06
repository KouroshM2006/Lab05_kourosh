/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lab05_kourosh;


import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.geometry.Pos;
import javafx.scene.Scene;
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
public class Lab05_kourosh extends Application{

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
        Label bagStyleLbl = new Label("Select Bag Style");
        Label quantityLabel = new Label("Select Quantity:");
        
        
        String[] bags = {"Full Decorative", "Beaded", "Pirate Design", "Fringed", "Leather", "Plain"};
        ListView<String> listView = new ListView<>();
        listView.setItems(FXCollections.observableArrayList(bags));
        listView.setPrefSize(300, 300);
        
        //creating combo box
        ComboBox<Integer> comboBox = new ComboBox<>();
        comboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        
        RadioButton smallRadioButton = new RadioButton("Small");
        RadioButton medRadioButton = new RadioButton("Medium");
        RadioButton largeRadioButton = new RadioButton("Large");
        
        ToggleGroup toggleGroup = new ToggleGroup();
        smallRadioButton.setToggleGroup(toggleGroup);
        medRadioButton.setToggleGroup(toggleGroup);
        largeRadioButton.setToggleGroup(toggleGroup);
        
        
        
        
        //adding nodes to root
        root.setCenter(listView);
        root.setLeft(bagStyleLbl);
        root.setRight(vBox);
        
        
        
        //creating grid pane
        GridPane grid = new GridPane();
        
        //setting scene 
        Scene scene = new Scene(root);
        
        
        primaryStage.setTitle("Bag Order Form");
        primaryStage.setScene(scene); 
        
        primaryStage.show();
        
    }
    
}
