package com.mikmin.lab07;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import javafx.animation.PathTransition;
import javafx.animation.RotateTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
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
        Polygon animatedTriangle = new Polygon(225,300,275,300,250,250);

        PathTransition pTrans = new PathTransition(new Duration(12000), pathRectangle, pathCircle);
        pTrans.setInterpolator(Interpolator.LINEAR);
        pTrans.setRate(-1);

        pTrans.play();
        
        FadeTransition ftrans
                = new FadeTransition(new Duration(3000), animatedTriangle);
        ftrans.setFromValue(0.0);
        ftrans.setToValue(1);
       
        
        ScaleTransition strans
                = new ScaleTransition(new Duration(3000), animatedTriangle);
       
        strans.setToX(2.0);
        strans.setToY(2.0);
        strans.setInterpolator(Interpolator.EASE_IN);
        
        RotateTransition rtrans = new RotateTransition(new Duration(3000), animatedTriangle);
        rtrans.setFromAngle(0.0);
        rtrans.setToAngle(180);
        


        TranslateTransition ttrans
                = new TranslateTransition(new Duration(3000), animatedTriangle);
        ttrans.setToX(0);
        ttrans.setToY(-100);
     
        ttrans.setInterpolator(Interpolator.EASE_IN);
        
        SequentialTransition sequence = new SequentialTransition(animatedTriangle, ftrans, strans, rtrans, ttrans);
        sequence.play();
        
        Button startButton = new Button("Start");
        Button ResetButton = new Button("Reset");
        Button ExitButton = new Button("Exit");

        Pane animationPane = new Pane(pathRectangle, pathCircle, animatedTriangle);
        HBox buttonPane = new HBox();
        GridPane mainPane = new GridPane();
        
        Scene scene = new Scene(animationPane, 500, 500);
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }

}
