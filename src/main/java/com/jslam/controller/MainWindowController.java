package com.jslam.controller;

import com.jslam.model.SourceGame;
import com.jslam.model.SourceGame.Track;
import com.jslam.view.ViewFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class MainWindowController extends BaseController {

    @FXML
    private ComboBox<SourceGame> gameComboBox;

    @FXML
    private Button importButton;

    @FXML
    private Button playKeyButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<Track> trackTable;

    @FXML
    private Button ytLinkButton;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

}
