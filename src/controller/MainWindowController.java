package controller;

import view.ViewFactory;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;

public class MainWindowController extends BaseController {

    @FXML
    private ComboBox<?> gameComboBox;

    @FXML
    private Button importButton;

    @FXML
    private Button playKeyButton;

    @FXML
    private Button settingsButton;

    @FXML
    private Label statusLabel;

    @FXML
    private TableView<?> trackTable;

    @FXML
    private Button ytLinkButton;

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

}