package com.jslam.view;

import java.io.IOException;
import java.util.ArrayList;

import com.jslam.controller.BaseController;
import com.jslam.controller.MainWindowController;
import com.jslam.controller.SettingsWindowController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    
    private ArrayList<Stage> activeStages;
    
    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showMainWindow() {
        System.out.println("Main window intiailized");

        BaseController controller = new MainWindowController(this, "MainWindow.fxml");

        initializeStage(controller);
    }

    private void initializeStage(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        
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
        activeStages.add(stage);
    }

    private void closeStage(Stage stageToClose) {
        stageToClose.close();
        activeStages.remove(stageToClose);
    }

    public void showSettingsWindow() {
        System.out.println("Settings button triggered");

        BaseController controller = new SettingsWindowController(this, "SettingsWindow.fxml");

        initializeStage(controller);
    }
}
