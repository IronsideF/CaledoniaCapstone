module com.capstone.caledonia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;

    opens com.capstone.caledonia to javafx.fxml;
    exports com.capstone.caledonia;
}