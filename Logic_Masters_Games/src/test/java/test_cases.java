
import com.example.logic_masters_games.GameOneController;
import com.example.logic_masters_games.Riddle;
import com.example.logic_masters_games.RiddleLibrary;
import com.example.logic_masters_games.ScreenController;
import javafx.event.ActionEvent;
import org.junit.jupiter.api.Test;



import static org.junit.jupiter.api.Assertions.*;
//import org.testfx.framework.junit.ApplicationTest;

import java.awt.*;
import java.io.IOException;
import java.util.Stack;

public class test_cases {
    @Test
    public void verify_riddle_library_full() throws IOException { //Eleanor
        Riddle a = new Riddle(
                "David’s parents have three sons: Snap, Crackle, and what’s the name of the third son?",
                "Easy",
                "David",
                "Snap",
                "Crackle");
        Riddle b = new Riddle(
                "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
                "Easy",
                "Your shadow",
                "Your face",
                "Your legs");
        Riddle c = new Riddle(
                "What has many keys but can’t open a single lock?",
                "Easy",
                "Piano",
                "Guitar",
                "Violin");
        //ScreenController screenController = new ScreenController();
       // GameOneController gameOneController = new GameOneController();
        Riddle[] easies = {a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};
        Stack<Riddle> easyStack = new Stack<>();
        easyStack.push(a);
        Stack<Riddle> mediumStack = new Stack<>();
        mediumStack.push(b);
        Stack<Riddle> hardStack = new Stack<>();
        hardStack.push(c);
        RiddleLibrary riddleLibrary = new RiddleLibrary(3, 5, easies, mediums, hards);
        assertTrue(easyStack.equals(riddleLibrary.availableRiddlesEasy));
        assertTrue(mediumStack.equals(riddleLibrary.availableRiddlesMed));
        assertTrue(hardStack.equals(riddleLibrary.availableRiddlesHard));
    }

    @Test
    public void test_riddleLibrary_select_easy() throws IOException { //Eleanor
        Riddle a = new Riddle(
                "David’s parents have three sons: Snap, Crackle, and what’s the name of the third son?",
                "Easy",
                "David",
                "Snap",
                "Crackle");
        Riddle b = new Riddle(
                "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
                "Easy",
                "Your shadow",
                "Your face",
                "Your legs");
        Riddle c = new Riddle(
                "What has many keys but can’t open a single lock?",
                "Easy",
                "Piano",
                "Guitar",
                "Violin");
        //ScreenController screenController = new ScreenController();
        // GameOneController gameOneController = new GameOneController();
        Riddle[] easies = {a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};
        Stack<Riddle> easyStack = new Stack<>();
        easyStack.push(a);
        Stack<Riddle> mediumStack = new Stack<>();
        mediumStack.push(b);
        Stack<Riddle> hardStack = new Stack<>();
        hardStack.push(c);
        RiddleLibrary riddleLibrary = new RiddleLibrary(3, 5, easies, mediums, hards);
        RiddleLibrary riddleLibraryClone = new RiddleLibrary(3, 5, easies, mediums, hards);
        Riddle riddle_test = riddleLibrary.select(2);
        assertTrue(riddleLibraryClone.availableRiddlesEasy.contains(riddle_test));
    }
}
