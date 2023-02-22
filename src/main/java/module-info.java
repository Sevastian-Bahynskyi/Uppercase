module com.example.ex1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.ex1 to javafx.fxml;
    opens com.example.ex1.view to javafx.fxml;
    exports com.example.ex1;
}