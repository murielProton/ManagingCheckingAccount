module com.example.accountmanagementprimefaces {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.example.accountmanagementprimefaces to javafx.fxml;
    exports com.example.accountmanagementprimefaces;
}