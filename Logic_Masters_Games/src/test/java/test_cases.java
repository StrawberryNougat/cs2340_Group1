
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

    @Test
    public void test_riddleLibrary_select_med() throws IOException { //Aaron
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

        Riddle[] easies = {a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};

        RiddleLibrary riddleLibrary = new RiddleLibrary(3, 5, easies, mediums, hards);
        RiddleLibrary riddleLibraryClone = new RiddleLibrary(3, 5, easies, mediums, hards);

        Riddle riddle_test = riddleLibrary.select(4);

        // assert that riddle_test was indeed from the "med level" stack of riddles.
        assertTrue(riddleLibraryClone.availableRiddlesMed.contains(riddle_test));
    }

    public void test_easyLibrary_becoming_empty() throws IOException { //Aaron
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

        // create arrays of riddles to pass into RiddleLibrary constructor.
        Riddle[] easies = {a, a, a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};

        // create a test RiddleLibrary object.
        RiddleLibrary testRiddleLibrary = new RiddleLibrary(3, 5, easies, mediums, hards);

        // call select with currScore that is less than EM_threshold
        // for three times, so that the availableRiddlesEasy becomes empty.
        Riddle riddle_test1 = testRiddleLibrary.select(2);
        Riddle riddle_test2 = testRiddleLibrary.select(1);
        Riddle riddle_test3 = testRiddleLibrary.select(0);

        // assert that availableRiddlesEasy is empty.
        assertTrue(testRiddleLibrary.availableRiddlesEasy.empty());
    }

    @Test
    public void test_change_win_score() {
        GameOneController gameOneController = new GameOneController();
        gameOneController.changeWinningScore(5);
        assertEquals(gameOneController.getScore_to_win(), 5);
    }

    @Test
    public void riddlesRemaining() {
        Riddle a = new Riddle("What's more useful when it is broken?", "Easy", "An egg", "People", "Computer");
        Riddle b = new Riddle("I am an odd number. Take away a letter and I become even. What number am I?", "Med",
                "Seven", "Three", "Five");
        Riddle c = new Riddle("What can go through glass without breaking it?", "Hard",
                "Light", "Finger", "Stick");
        Riddle[] easies = {a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};
        RiddleLibrary ridLib = new RiddleLibrary(3, 5, easies, mediums, hards);
        assertTrue(ridLib.areRiddlesRemaining(0));
    }

    @Test
    public void riddlesNotRemaining() {
        Riddle a = new Riddle("What's more useful when it is broken?", "Easy", "An egg", "People", "Computer");
        Riddle b = new Riddle("I am an odd number. Take away a letter and I become even. What number am I?", "Med",
                "Seven", "Three", "Five");
        Riddle c = new Riddle("What can go through glass without breaking it?", "Hard",
                "Light", "Finger", "Stick");
        Riddle[] easies = {a};
        Riddle[] mediums = {b};
        Riddle[] hards = {c};
        RiddleLibrary ridLib = new RiddleLibrary(3, 5, easies, mediums, hards);
        Riddle easyRiddle = ridLib.selectByDifficultyLevel(0);
        Riddle easyRiddle = ridLib.selectByDifficultyLevel(1);
        Riddle easyRiddle = ridLib.selectByDifficultyLevel(2);
        assertFalse(ridLib.areRiddlesRemaining(0));
    }

    @Test
    public void add_easy_riddle() { //Mei
        Riddle a = new Riddle("Who's the smarterst?", "Easy", "Me", "Einstein", "Newton");
        Riddle a1 = new Riddle("What has a neck but no head?", "Easy", "bottle", "neck", "human");
        Riddle[] easies = {a};
        Riddle[] mediums = null;
        Riddle[] hards = null;
        RiddleLibrary rl = new RiddleLibrary(3, 5, easies, mediums, hards);
        rl.addRiddle(1, a1);
        assertTrue(rl.availableRiddlesEasy.contians(a1));
    }

    @Test
    public void add_med_riddle() { //Mei
        Riddle b = new Riddle(
                "I follow you all the time and copy your every move, but you can’t touch me or catch me. What am I?",
                "Medium",
                "Your shadow",
                "Your face",
                "Your legs");
        Riddle b1 = new Riddle(
                "Why is Europe like a frying pan?",
                "Medium",
                "it has Greece at the bottom.",
                "it is a country",
                "it is a continent");
        Riddle[] easies = null;
        Riddle[] mediums = {b};
        Riddle[] hards = null;
        RiddleLibrary rl = new RiddleLibrary(3, 5, easies, mediums, hards);
        rl.addRiddle(4,b1);
        assertTrue(rl.availableRiddlesMed.contians(b1));
    }

}
