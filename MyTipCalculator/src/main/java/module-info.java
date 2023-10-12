module duc.mytipcalculator {
    requires javafx.controls;
    requires javafx.fxml;

    opens duc.mytipcalculator to javafx.fxml;
    exports duc.mytipcalculator;
}
