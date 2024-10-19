package com.jslam;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import com.jslam.view.ViewFactory;
public class Launcher extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        
        ViewFactory viewFactory = new ViewFactory();

        viewFactory.showMainWindow();

        // stage.setOnCloseRequest((WindowEvent event) -> {
            
        //     System.out.println(stage.getTitle() + " closed");
        //     viewFactory.closeStage(stage);
        // });
    }
}
