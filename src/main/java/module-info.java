module test.x4_1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;

    opens test.x4_1 to javafx.fxml;
    exports test.x4_1;
}
