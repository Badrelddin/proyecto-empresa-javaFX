module com.example.empresa {
    requires javafx.controls;
    requires javafx.fxml;
                requires kotlin.stdlib;
    requires java.sql;


    opens com.example.empresa to javafx.fxml;
    exports com.example.empresa;
}