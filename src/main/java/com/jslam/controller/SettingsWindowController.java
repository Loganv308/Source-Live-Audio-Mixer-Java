package com.jslam.controller;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import javax.swing.JFileChooser;

import com.jslam.controller.config.Config;
import com.jslam.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

public class SettingsWindowController extends BaseController implements Initializable{
    
    // Initialized methods
    private final static Logger LOGGER = Logger.getLogger(SettingsWindowController.class.getName());
    private static Config config = new Config();
    private static FileHandler fh;
    
    // Constructor
    public SettingsWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
        setupLogger();
    }

    private void setupLogger() {
        if (fh == null) {  // Ensure the FileHandler is only created once
            try {
                fh = new FileHandler("src/main/java/com/jslam/logs/logs.log", true);
                fh.setFormatter(new SimpleFormatter());
                Logger logger = Logger.getLogger(SettingsWindowController.class.getName());
                logger.addHandler(fh);
                logger.setLevel(Level.ALL);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    // Function to close the FileHandler
    public void closeHandler() {
        if (fh != null) {
            fh.close();  // Ensure the FileHandler is closed properly
            System.out.println("FileHandler closed");
        }
    }

    @FXML
    private CheckBox folderDetectionBox;

    @FXML
    private CheckBox logErrorBox;

    @FXML
    private CheckBox minSysTrayBox;

    @FXML
    private CheckBox startEnabledBox;

    @FXML
    private CheckBox startMiniBox;

    @FXML
    private Button steamAppsButton;

    @FXML
    private TextField steamAppsTextField;

    @FXML
    private Button userDataButton;

    @FXML
    private TextField userDataTextFieldBox;

    @FXML
    void folderDetectionAction(ActionEvent event) {

    }

    @FXML
    void logErrorAction(ActionEvent event) {
        boolean isSelected = logErrorBox.isSelected();
        if(isSelected) {
            logMessage("Logger Started", Level.FINE);
        }
        else {
            logMessage("Logger ended", Level.FINE);
        }
    }

    @FXML
    void minSysTrayAction(ActionEvent event) {

    }

    @FXML
    void startEnabledAction(ActionEvent event) {

    }

    @FXML
    void startMiniAction(ActionEvent event) {

    }

    @FXML
    void steamAppsButtonAction(ActionEvent event) {
        if(folderDetectionBox.isSelected()) {
            logMessage("FolderDetectionBox is checked" ,Level.FINE);
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            logMessage("FileChooser set to Directories only mode", Level.FINE);
            int option = jFileChooser.showOpenDialog(jFileChooser);
            if(option == JFileChooser.APPROVE_OPTION) {
                logMessage("FileChooser menu opened" ,Level.FINE);
                File file = jFileChooser.getSelectedFile();
                steamAppsTextField.setText(file.getAbsolutePath());
                logMessage("steamAppsTextField set to " + file.getAbsolutePath() ,Level.FINE);
            }
        }
        else {
            Alert a = new Alert(AlertType.NONE);
            logMessage("FolderOverride not enabled", Level.WARNING);
            a.setAlertType(AlertType.INFORMATION);
            a.setTitle("JSLAM Information");
            a.setHeaderText("Enable Override Folder Detection");
            a.setContentText("Please enable Override Folder Detection");
            a.show();
        }
        
    }

    @FXML
    void steamAppsTextFieldAction(ActionEvent event) {

    }

    @FXML
    void userDataButtonAction(ActionEvent event) {
        if(folderDetectionBox.isSelected()) {
            logMessage("FolderDetectionBox is checked" ,Level.FINE);
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            logMessage("FileChooser set to Directories only mode", Level.FINE);
            int option = jFileChooser.showOpenDialog(jFileChooser);
            if(option == JFileChooser.APPROVE_OPTION) {
                logMessage("FileChooser menu opened" ,Level.FINE);
                File file = jFileChooser.getSelectedFile();
                userDataTextFieldBox.setText(file.getAbsolutePath());
                logMessage("userDataTextFieldBox set to " + file.getAbsolutePath() ,Level.FINE);
            }
        }
        else {
            Alert a = new Alert(AlertType.NONE);
            logMessage("FolderOverride not enabled", Level.WARNING);
            a.setAlertType(AlertType.INFORMATION);
            a.setTitle("JSLAM Information");
            a.setHeaderText("Enable Override Folder Detection");
            a.setContentText("Please enable Override Folder Detection");
            a.show();
        }
    }

    // Custom function to log only if the Log Error box is checked.
    void logMessage(String message, Level level) {
        if (logErrorBox.isSelected()) {  // Log only if the box is checked
            LOGGER.log(level, message);
        }
    }
            
    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        config.loadXMLFromFile();
        logMessage("Loaded config: " + config.toString(), Level.FINE);

        logErrorBox.setSelected(config.getLogErrors());
        startEnabledBox.setSelected(config.getStartEnabled());
        minSysTrayBox.setSelected(config.getMinSystemTray());
        startMiniBox.setSelected(config.getStartMini());
        folderDetectionBox.setSelected(config.getFolderOverride());

        logErrorBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            config.setLogErrors(newValue);
            logMessage("Set logMessage to: " + newValue, Level.FINE);
            config.saveXMLToFile();
            logMessage("Saved logMessage to: " + config.getPath(), Level.FINE);
        });
        
        startEnabledBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            config.setStartEnabled(newValue);
            logMessage("Set startEnabled to: " + newValue, Level.FINE);
            config.saveXMLToFile();
            logMessage("Saved startEnabled to: " + config.getPath(), Level.FINE);
        });

        minSysTrayBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            config.setMinSystemTray(newValue);
            logMessage("Set setMinSystemTray to: " + newValue, Level.FINE);
            config.saveXMLToFile();
            logMessage("Saved setMinSystemTray to: " + config.getPath(), Level.FINE);
        });

        startMiniBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            config.setStartMini(newValue);
            logMessage("Set setStartMini to: " + newValue, Level.FINE);
            config.saveXMLToFile();
            logMessage("Saved setStartMini to: " + config.getPath(), Level.FINE);
        });

        folderDetectionBox.selectedProperty().addListener((observable, oldValue, newValue) -> {
            config.setFolderOverride(newValue);
            logMessage("Set FolderOverride to: " + newValue, Level.FINE);
            config.saveXMLToFile();
            logMessage("Saved FolderOverride to: " + config.getPath(), Level.FINE);
        });
    }
}