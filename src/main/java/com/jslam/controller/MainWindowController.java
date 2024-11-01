package com.jslam.controller;

import java.net.URL;
import java.util.ResourceBundle;

import com.jslam.model.SourceGame.Track;
import com.jslam.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;

public class MainWindowController extends BaseController implements Initializable {

    @FXML
    private ProgressBar progressBar;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<Track> trackTable;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    void gameComboBoxAction(ActionEvent event) {

    }

    @FXML
    void importButtonAction(ActionEvent event) {

    }

    @FXML
    void playKeyButtonAction(ActionEvent event) {

    }

    @FXML
    void progressBarAction(MouseEvent event) {

    }

    @FXML
    void settingsButtonAction(ActionEvent event) {
        try {
            viewFactory.showSettingsWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    void trackTableAction(ActionEvent event) {

    }

    @FXML
    void ytLinkButtonAction(ActionEvent event) {
        try {
            viewFactory.showAudioWindow();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        
    }


}
