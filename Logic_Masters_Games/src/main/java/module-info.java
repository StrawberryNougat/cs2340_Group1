module com.example.logic_masters_games {
    requires javafx.controls;
    requires javafx.fxml;
            
                            
    opens com.example.logic_masters_games to javafx.fxml;
    exports com.example.logic_masters_games;
}