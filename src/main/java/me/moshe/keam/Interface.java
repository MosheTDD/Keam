package me.moshe.keam;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import me.moshe.keam.controllers.InterfaceController;
import me.moshe.keam.utils.URLUtils;
import me.moshe.keam.utils.ui.DraggableHelper;

import java.io.IOException;

public class Interface extends Application {

    private Stage window;

    public void start(String[] args){
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        this.window = primaryStage;
        openMainMenu();
    }

    private void openMainMenu() throws IOException {
        window.setTitle("Keam");
        window.getIcons().add(new Image("/assets/icon.png"));
        window.setResizable(false);

        FXMLLoader loader = new FXMLLoader(URLUtils.getURL("/view/Interface.fxml"));
        Parent root = loader.load();
        InterfaceController interfaceController = loader.getController();
        window.setScene(new Scene(root, 1280, 800));
        DraggableHelper.addDraggableListener(window, root);
        window.show();

        interfaceController.focus();
    }
}
