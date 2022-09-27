module com.capstone.caledonia {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.ikonli.javafx;
    requires com.almasb.fxgl.all;
    requires java.desktop;
    requires junit;

    opens com.capstone.caledonia to javafx.fxml;
    exports com.capstone.caledonia;
    exports com.capstone.caledonia.player;
//    exports com.capstone.caledonia.testing;
    exports com.capstone.caledonia.map;
    exports com.capstone.caledonia.node;
}