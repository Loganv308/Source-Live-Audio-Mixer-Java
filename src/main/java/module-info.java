module com.jslam {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;
    requires java.logging;
    requires java.xml.bind;

    opens com.jslam.controller;
    opens com.jslam.view;
    opens com.jslam.model;
    opens com.jslam to javafx.fxml;
    exports com.jslam;
}
