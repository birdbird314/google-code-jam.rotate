package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;
import static org.junit.Assert.*;

/**
 * Created by Kamil on 2017-01-23.
 */
public class ResultCheckerTest {
    ResultChecker resultChecker = new ResultChecker();

    @Test
    public void shouldCheckIfOnlyBlueWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, RED  },
                {EMPTY, BLUE,  EMPTY, RED  },
                {EMPTY, BLUE,  BLUE,  BLUE },
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = resultChecker.check(gameBoard, 3);

        Assert.assertTrue(result.blueWins());
        Assert.assertFalse(result.redWins());
    }

    @Test
    public void shouldCheckIfOnlyRedWins() throws Exception {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, RED  },
                {EMPTY, RED,   EMPTY, RED  },
                {EMPTY, BLUE,  BLUE,  RED  },
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = resultChecker.check(gameBoard, 3);

        Assert.assertFalse(result.blueWins());
        Assert.assertTrue(result.redWins());
    }

    @Test
    public void shouldCheckIfBothWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, RED  },
                {EMPTY, RED,   EMPTY, RED  },
                {BLUE,  BLUE,  BLUE,  RED  },
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = resultChecker.check(gameBoard, 3);

        Assert.assertTrue(result.blueWins());
        Assert.assertTrue(result.redWins());
    }

    @Test
    public void shouldCheckIfNobodyWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, RED  },
                {EMPTY, RED,   EMPTY, RED  },
                {BLUE,  RED,   BLUE,  BLUE },
                {RED,   BLUE,  RED,   RED  }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = resultChecker.check(gameBoard, 3);

        Assert.assertFalse(result.blueWins());
        Assert.assertFalse(result.redWins());
    }
}