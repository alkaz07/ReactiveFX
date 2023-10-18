module com.example.reactivefx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.reactivefx to javafx.fxml;
    exports com.example.reactivefx;
}