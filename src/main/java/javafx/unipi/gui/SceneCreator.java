package javafx.unipi.gui;

import javafx.scene.Scene;

public abstract class SceneCreator {
    double width;
    double height;

    public SceneCreator(double width, double height) {
        this.width = width;
        this.height = height;
    }

    public Scene createScene() {
        // TODO Auto-generated method stub
        return null;
    }

    //abstract Scene createScene();
}
