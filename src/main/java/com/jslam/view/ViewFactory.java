package com.jslam.view;

import java.io.IOException;

import com.jslam.controller.BaseController;
import com.jslam.controller.MainWindowController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    public ViewFactory() {

    }

    public void showMainWindow() {
        System.out.println("Main window intiailized");

        BaseController controller = new MainWindowController(this, "MainWindow.fxml");

        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(fxmlLoader);
        
        Parent parent;

        try {
            parent = fxmlLoader.load();
        }
        catch(IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
    }
}
