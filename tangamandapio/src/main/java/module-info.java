module com.javeriana {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.javeriana to javafx.fxml;
    exports com.javeriana;
}
