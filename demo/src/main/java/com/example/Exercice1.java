package com.example;

import java.io.IOException;

import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Exercice1 extends Application {
    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        TilePane root = new TilePane();

        Scene scene = new Scene(root, 400, 400);
        
        stage.setTitle("Gestion de la souris et du clavier");

        Circle cercle = new Circle(80);
        cercle.setFill(Color.AQUA);

        Rectangle rectangle = new Rectangle(150, 150);
        rectangle.setFill(Color.AQUA);

        TilePane tilePane = new TilePane();
        tilePane.setOrientation(Orientation.HORIZONTAL);


        tilePane.getChildren().addAll(cercle, rectangle);

        Pane pane = new Pane();
        pane.setStyle("-fx-border-color: blue; -fx-border-width: 10;");

        root.getChildren().addAll(tilePane, pane);

        stage.setScene(scene);
        stage.show();


        cercle.setFocusTraversable(true);
        rectangle.setFocusTraversable(true);
        cercle.requestFocus();

        
        scene.setOnKeyPressed(event -> {
            System.out.println("Circle focused: " + cercle.isFocused());
            if (event.getCode() == KeyCode.C && cercle.isFocused()) {
                cercle.setFill(Color.RED);
                rectangle.setFill(Color.AQUA);
                rectangle.requestFocus();
                System.out.println("Rectangle focused: " + rectangle.isFocused());
            }

            if (event.getCode() == KeyCode.R && rectangle.isFocused()) {
                cercle.setFill(Color.AQUA);
                rectangle.setFill(Color.RED);
                cercle.requestFocus();
                System.out.println("Rectangle focused: " + rectangle.isFocused());
            }
        });

        cercle.setOnMouseClicked(event -> {
            cercle.setFill(Color.YELLOW);
        });

        rectangle.setOnMouseEntered(event -> {
            rectangle.setFill(Color.YELLOW);
        });

        rectangle.setOnMouseExited(event -> {
            rectangle.setFill(Color.CYAN);
        });

        pane.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                Text texte = new Text("Vous avez cliqué droit sur le panneau");

                // endroit du clic
                texte.setLayoutX(e.getX());
                texte.setLayoutY(e.getY());

                // police
                texte.setStyle("-fx-font-weight: bold; -fx-font-size: 15px;");

                // couleur
                texte.setFill(Color.WHITE);

                // contour
                texte.setStroke(Color.BLACK);

                // ajout du texte au pane
                pane.getChildren().add(texte);
            }

            if (e.getButton() == MouseButton.PRIMARY) {
                pane.getChildren().clear();                
            }

        });     
        cercle.setFocusTraversable(true);
        rectangle.setFocusTraversable(true);
    }
        


    public static void main(String[] args) {
        launch();
    }
}
