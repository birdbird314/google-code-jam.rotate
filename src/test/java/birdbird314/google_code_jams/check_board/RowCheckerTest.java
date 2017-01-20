package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;
import static org.junit.Assert.*;

/**
 * Created by Kamil on 2017-01-20.
 */
public class RowCheckerTest {
    RowChecker rowChecker = new RowChecker();

    @Test
    public void shouldCheckIfOnlyBlueWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, RED ,  EMPTY, EMPTY},
                {EMPTY, BLUE,  BLUE,  BLUE },
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = rowChecker.checkRows(gameBoard, 3);

        Assert.assertTrue(result.blueWins() && !result.redWins());
    }

    @Test
    public void shouldCheckIfOnlyRedWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, RED ,  EMPTY, EMPTY},
                {EMPTY, BLUE,  EMPTY, BLUE },
                {BLUE,  RED,   RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = rowChecker.checkRows(gameBoard, 3);

        Assert.assertTrue(!result.blueWins() && result.redWins());
    }

    @Test
    public void shouldCheckIfBothWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, RED ,  EMPTY, EMPTY},
                {EMPTY, BLUE,  BLUE,  BLUE },
                {BLUE,  RED,   RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = rowChecker.checkRows(gameBoard, 3);

        Assert.assertTrue(result.blueWins() && result.redWins());
    }

    @Test
    public void shouldCheckIfNobodyWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {RED  , EMPTY, RED,   EMPTY},
                {BLUE , BLUE,  RED,   EMPTY},
                {BLUE , BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = rowChecker.checkRows(gameBoard, 3);

        Assert.assertTrue(!result.blueWins() && !result.redWins());
    }
}