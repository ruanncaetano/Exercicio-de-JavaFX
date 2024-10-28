module ruan.caetano.ex1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;
    requires org.json;

    opens ruan.caetano.ex1 to javafx.fxml;
    exports ruan.caetano.ex1;
}