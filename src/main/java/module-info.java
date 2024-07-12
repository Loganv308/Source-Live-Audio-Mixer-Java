module com.jslam {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.jslam to javafx.fxml;
    exports com.jslam;
}
