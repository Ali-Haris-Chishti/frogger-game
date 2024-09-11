module com.example.projectfrogger {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;

    requires com.almasb.fxgl.all;

    opens com.example.projectfrogger to javafx.fxml;
    exports com.example.projectfrogger;
    exports com.example.projectfrogger.actor;
    opens com.example.projectfrogger.actor to javafx.fxml;
    exports com.example.projectfrogger.level;
    opens com.example.projectfrogger.level to javafx.fxml;
}