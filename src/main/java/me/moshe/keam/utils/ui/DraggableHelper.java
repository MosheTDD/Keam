package me.moshe.keam.utils.ui;

import javafx.scene.Parent;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicReference;

public class DraggableHelper {

    public static void addDraggableListener(Stage window, Parent root){
        addDraggableListener(window, root, 50);
    }

    public static void addDraggableListener(Stage window, Parent root, double maxY) {
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);
        root.setOnMousePressed(event -> {
            xOffset.set(event.getSceneX());
            yOffset.set(event.getSceneY());
        });

        root.setOnMouseDragged(event -> {
            if (event.getY() < maxY) {
                window.setX(event.getScreenX() - xOffset.get());
                window.setY(event.getScreenY() - yOffset.get());
            }
        });
    }
}