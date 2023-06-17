
import com.example.logic_masters_games.GameOneController;
import com.example.logic_masters_games.RiddleLibrary;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

public class test_cases {
    @Test
    public boolean score_change_test() throws IOException {
        GameOneController gameOneController = new GameOneController();
        gameOneController.setCurrentScore(0);
        gameOneController.answerChoiceOne(new ActionEvent());
        assertNotEquals(gameOneController.getCurrentScore(), 0);
        return true;
    }
}
