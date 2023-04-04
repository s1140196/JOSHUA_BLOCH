module com.hsleiden.groep30.joshua_bloch_ipose {
    requires javafx.controls;
    requires javafx.fxml;

    requires com.almasb.fxgl.all;

    opens com.hsleiden.groep30.joshua_bloch_ipose to javafx.fxml;
    exports com.hsleiden.groep30.joshua_bloch_ipose;
}