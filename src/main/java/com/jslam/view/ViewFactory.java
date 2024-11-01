package com.jslam.view;

import java.io.IOException;
import java.util.ArrayList;

import com.jslam.controller.BaseController;
import com.jslam.controller.MainWindowController;
import com.jslam.controller.SettingsWindowController;
import com.jslam.controller.TrimAudioWindowController;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ViewFactory {
    
    private ArrayList<Stage> activeStages;
    private static SettingsWindowController settingsWindowController;
    private static TrimAudioWindowController trimAudioWindowController;

    public ViewFactory() {
        activeStages = new ArrayList<Stage>();
    }

    public void showMainWindow() {
        System.out.println("Main window intiailized");

        BaseController controller = new MainWindowController(this, "MainWindow.fxml");

        try {
            initializeStage(controller);
        } catch(IOException | IllegalStateException e) {
            ViewFactory.settingsWindowController = null;
            System.out.println("CAUGHT: " + e);
        } 
    }

    private Stage initializeStage(BaseController baseController) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(baseController.getFxmlName()));
        fxmlLoader.setController(baseController);
        Parent parent;

        parent = fxmlLoader.load();
        Scene scene = new Scene(parent);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();
        activeStages.add(stage);

        stage.setOnCloseRequest(event -> {
            closeStage(stage);
        });
        
        return stage;
    }

    public void closeStage(Stage stageToClose) {
        if (stageToClose != null) {
            stageToClose.close();
            activeStages.remove(stageToClose);
            System.out.println("Stage closed successfully");
        }
        
    }

    public void showSettingsWindow() throws IOException {
        System.out.println("Settings button triggered");

        try {
            if (ViewFactory.settingsWindowController == null) {
                ViewFactory.settingsWindowController = new SettingsWindowController(this, "SettingsWindow.fxml");
    
                Stage stage = initializeStage(ViewFactory.settingsWindowController);
    
                stage.setOnCloseRequest(event -> {
                    System.out.println("Closing settings window");
                    (ViewFactory.settingsWindowController).closeHandler();
                    ViewFactory.settingsWindowController = null;
                    closeStage(stage);
    
                });
        
                stage.show();
            } 
        } catch (IOException | IllegalStateException e) {
            ViewFactory.settingsWindowController = null;
            System.out.println("CAUGHT: " + e);
        }
        System.out.println("Settings window shown");
    }

    public void showAudioWindow() {
        System.out.println("Audio window intiailized");

        BaseController controller = new TrimAudioWindowController(this, "TrimAudioWindow.fxml");
        

        try {
            initializeStage(controller);
        } catch(IOException | IllegalStateException e) {
            ViewFactory.trimAudioWindowController = null;
            System.out.println("CAUGHT: " + e);
        } 
    }
}
