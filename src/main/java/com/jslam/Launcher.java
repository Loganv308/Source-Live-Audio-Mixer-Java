package com.jslam;

import javafx.application.Application;
import javafx.stage.Stage;
import com.jslam.view.ViewFactory;
public class Launcher extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        ViewFactory viewFactory = new ViewFactory();

        viewFactory.showMainWindow();
    }
}
