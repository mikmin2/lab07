package com.mikmin.lab07;

import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        Rectangle pathRectangle = new Rectangle(10, 10, 480, 480);
        pathRectangle.setFill(null);
        pathRectangle.setStroke(Color.BLACK);
        Circle pathCircle = new Circle(5);
        
        PathTransition pTrans = new PathTransition(new Duration(10000), pathRectangle, pathCircle);
        pTrans.setInterpolator(Interpolator.LINEAR);
        pTrans.setRate(-1);
        
        pTrans.play();
        
        Pane animationPane = new Pane();
        Scene scene = new Scene(new Pane(pathRectangle, pathCircle), 500, 500);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

}