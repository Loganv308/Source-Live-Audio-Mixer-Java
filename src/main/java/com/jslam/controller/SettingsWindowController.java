package com.jslam.controller;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFileChooser;

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
    
    public SettingsWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
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
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = jFileChooser.showOpenDialog(jFileChooser);
            if(option == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                steamAppsTextField.setText(file.getAbsolutePath());
            }
        }
        else {
            Alert a = new Alert(AlertType.NONE);
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
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
            int option = jFileChooser.showOpenDialog(jFileChooser);
            if(option == JFileChooser.APPROVE_OPTION) {
                File file = jFileChooser.getSelectedFile();
                userDataTextFieldBox.setText(file.getAbsolutePath());
            }
        }
        else {
            Alert a = new Alert(AlertType.NONE);
            a.setAlertType(AlertType.INFORMATION);
            a.setTitle("JSLAM Information");
            a.setHeaderText("Enable Override Folder Detection");
            a.setContentText("Please enable Override Folder Detection");
            a.show();
        }
    }
            

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }
    
}