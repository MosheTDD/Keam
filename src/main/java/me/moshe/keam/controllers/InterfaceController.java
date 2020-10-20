package me.moshe.keam.controllers;

import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.FlowPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import me.moshe.keam.utils.ui.AlertBox;

import javax.swing.*;
import javax.swing.filechooser.FileSystemView;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class InterfaceController implements Initializable {

    @FXML
    private Label LABEL;

    @FXML
    private ImageView IMAGE;

    @FXML
    private AnchorPane ANCHOR;

    @FXML
    private Button BUTTON;

    @FXML
    private FlowPane FLOWPANE;

    @FXML
    public void focus(){
        ANCHOR.requestFocus();
    }

    public static Label staticLabel;
    public static ImageView staticImage;

    @FXML
    public void addGame() {
        BUTTON.setOnAction(e -> {
            try {
                submitGame((Stage) ANCHOR.getScene().getWindow());
            } catch (ClassNotFoundException | UnsupportedLookAndFeelException | InstantiationException | IllegalAccessException ex) {
                ex.printStackTrace();
            }
        });

    }

    @FXML
    public static void submitGame(Stage stage) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException{
        File file;
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        FileChooser chooser = new FileChooser();
        chooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Executable Files", "*.exe"));
        chooser.setTitle("Please select a game...");
        file = chooser.showOpenDialog(stage.getOwner());
        if(file == null)return;
        staticLabel.setText(file.getName());
        ImageIcon icon = (ImageIcon) FileSystemView.getFileSystemView().getSystemIcon(file);
        BufferedImage bufferedImage = (BufferedImage) icon.getImage();
        Image image = SwingFXUtils.toFXImage(bufferedImage, null);
        staticImage.setImage(image);
    }

    public static String stripExtension(String str){
        int pos = str.lastIndexOf('.');
        if (pos == -1)
            return str;

        return str.substring(0, pos);
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        staticLabel = LABEL;
        staticImage = IMAGE;
    }
}
