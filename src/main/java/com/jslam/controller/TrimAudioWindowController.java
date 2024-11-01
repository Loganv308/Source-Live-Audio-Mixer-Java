package com.jslam.controller;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import com.jslam.model.AdvWaveViewer;
import com.jslam.view.ViewFactory;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class TrimAudioWindowController extends BaseController implements Initializable {

    public String wavFile;
    public int startPos;
    public int endPos; 
    private AdvWaveViewer waveViewer;

    // Constructor
    public TrimAudioWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Canvas waveCanvas;

    @FXML
    private Button doneButton;

    @FXML
    private Button playButton;

    @FXML
    private Button resetButton;

    @FXML
    private Spinner<Integer> endSampleValue;

    @FXML
    private Spinner<Integer> endSecondValue;

    @FXML
    private Spinner<Integer> startSampleValue;

    @FXML
    private Spinner<Integer> startSecondValue;

    @FXML
    void doneButtonAction(ActionEvent event) {
        waveViewer.stop();
    }   

    @FXML
    void playButtonAction(ActionEvent event) {
        waveViewer.play();
    }

    @FXML
    void resetButtonAction(ActionEvent event) {

    }

    public void loadAudioFile(Stage stage) {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Open Audio File");
        fileChooser.getExtensionFilters().addAll(
            new FileChooser.ExtensionFilter("Audio Files", "*.wav", "*.mp3")
        );
        
        File selectedFile = fileChooser.showOpenDialog(stage);
        if (selectedFile != null) {
            try {
                waveViewer.loadAudio(selectedFile.getAbsolutePath());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        waveViewer = new AdvWaveViewer();
        waveViewer.setWidth(waveCanvas.getWidth());
        waveViewer.setHeight(waveCanvas.getHeight());
    }
}