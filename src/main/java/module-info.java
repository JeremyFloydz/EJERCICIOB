module org.example.ejeb {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ejeb to javafx.fxml;
    exports org.example.ejeb;
}