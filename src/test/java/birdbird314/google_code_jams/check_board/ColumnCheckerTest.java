package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-19.
 */
public class ColumnCheckerTest {
    private ColumnChecker columnChecker = new ColumnChecker();

    @Test
    public void shouldCheckIfOnlyBlueWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, BLUE,  EMPTY, EMPTY},
                {EMPTY, BLUE,  RED,   EMPTY},
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = columnChecker.checkColumns(gameBoard, 3);

        Assert.assertTrue(result.blueWins() && !result.redWins());
    }

    @Test
    public void shouldCheckIfOnlyredWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, RED,   EMPTY},
                {EMPTY, BLUE,  RED,   EMPTY},
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = columnChecker.checkColumns(gameBoard, 3);

        Assert.assertTrue(!result.blueWins() && result.redWins());
    }

    @Test
    public void shouldCheckIfBothWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {BLUE , EMPTY, RED,   EMPTY},
                {BLUE , BLUE,  RED,   EMPTY},
                {BLUE ,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = columnChecker.checkColumns(gameBoard, 3);

        Assert.assertTrue(result.blueWins() && result.redWins());
    }

    @Test
    public void shouldCheckIfNobodyWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {RED  , EMPTY, RED,   EMPTY},
                {BLUE , BLUE,  BLUE,  EMPTY},
                {BLUE , BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = columnChecker.checkColumns(gameBoard, 3);

        Assert.assertTrue(!result.blueWins() && !result.redWins());
    }
}
