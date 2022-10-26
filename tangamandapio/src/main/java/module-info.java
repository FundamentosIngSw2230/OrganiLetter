module com.javeriana {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.json;
    requires com.fasterxml.jackson.databind;

    opens com.javeriana to javafx.fxml;

    exports com.javeriana;
}
