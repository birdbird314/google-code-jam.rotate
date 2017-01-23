package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.check_board.GameResult;
import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-23.
 */
public class CaseSolverTest {
    CaseSolver caseSolver = new CaseSolver();

    @Test
    public void shouldCheckIfOnlyBlueWins() {
        char[][] gameboardArray = {
                {BLUE , EMPTY, EMPTY, },
                {RED  , BLUE , EMPTY, },
                {RED  , BLUE , EMPTY, },
        };
        final int K = 3;
        GameBoard gameBoard = new GameBoard(gameboardArray);
        TestCase testCase = new TestCase(gameBoard, K);

        GameResult result = caseSolver.solve(testCase);

        Assert.assertTrue(result.blueWins());
        Assert.assertFalse(result.redWins());
    }

    @Test
    public void shouldCheckIfOnlyRedWins() throws Exception {
        char[][] gameboardArray = {
                {RED  , EMPTY, EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY}
        };
        final int K = 4;
        GameBoard gameBoard = new GameBoard(gameboardArray);
        TestCase testCase = new TestCase(gameBoard, K);

        GameResult result = caseSolver.solve(testCase);

        Assert.assertFalse(result.blueWins());
        Assert.assertTrue(result.redWins());
    }

    @Test
    public void shouldCheckIfBothWins() throws Exception {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, RED  , EMPTY, EMPTY, EMPTY, RED  },
                {EMPTY, RED  , EMPTY, EMPTY, BLUE , BLUE },
                {EMPTY, RED  , EMPTY, RED  , BLUE , RED  },
                {RED  , BLUE , EMPTY, BLUE , BLUE , BLUE }
        };
        final int K = 4;
        GameBoard gameBoard = new GameBoard(gameboardArray);
        TestCase testCase = new TestCase(gameBoard, K);

        GameResult result = caseSolver.solve(testCase);

        Assert.assertTrue(result.blueWins());
        Assert.assertTrue(result.redWins());
    }

    @Test
    public void shouldCheckIfNobodyWins() throws Exception {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, RED  , EMPTY, EMPTY, EMPTY},
                {EMPTY, EMPTY, EMPTY, BLUE , BLUE , EMPTY, EMPTY},
                {EMPTY, EMPTY, BLUE , RED  , BLUE , EMPTY, EMPTY},
                {EMPTY, RED  , RED  , BLUE , RED  , EMPTY, EMPTY}
        };
        final int K = 3;
        GameBoard gameBoard = new GameBoard(gameboardArray);
        TestCase testCase = new TestCase(gameBoard, K);

        GameResult result = caseSolver.solve(testCase);

        Assert.assertFalse(result.blueWins());
        Assert.assertFalse(result.redWins());
    }
}
