import com.example.logic_masters_games.BattleBoat;
import com.example.logic_masters_games.Board;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Field;
import static org.junit.jupiter.api.Assertions.*;
public class test_cases_sprint4 {
        @Test //Taewoon
        public void testKaboom() throws NoSuchFieldException, IllegalAccessException {
            // Create a BattleBoat with type 3 and vertical orientation
            BattleBoat battleBoat = new BattleBoat(3, true);

            // Access the private field 'strength' using reflection
            Field strengthField = BattleBoat.class.getDeclaredField("strength");
            strengthField.setAccessible(true);

            // Get the initial value of 'strength'
            int initialStrength = (int) strengthField.get(battleBoat);

            // Call kaboom method once
            battleBoat.kaboom();

            // Get the updated value of 'strength'
            int updatedStrength = (int) strengthField.get(battleBoat);

            // Check if the strength is decremented by 1
            assertEquals(initialStrength - 1, updatedStrength);
        }

        @Test //Taewoon
        public void testHasSurvived() throws NoSuchFieldException, IllegalAccessException {
            // Create a BattleBoat with type 2 and horizontal orientation
            BattleBoat battleBoat = new BattleBoat(2, false);

            // Access the private field 'strength' using reflection
            Field strengthField = BattleBoat.class.getDeclaredField("strength");
            strengthField.setAccessible(true);

            // Set the value of 'strength' to 1
            strengthField.set(battleBoat, 1);

            // Check if the BattleBoat has initially survived
            assertTrue(battleBoat.hasSurvived());

            // Call kaboom method once
            battleBoat.kaboom();

            // Check if the BattleBoat has not survived anymore
            assertFalse(battleBoat.hasSurvived());
        }
    }

