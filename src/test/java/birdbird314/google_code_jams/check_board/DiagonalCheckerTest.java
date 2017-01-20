package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.*;

/**
 * Created by Kamil on 2017-01-20.
 */
public class DiagonalCheckerTest {
    private DiagonalChecker diagonalChecker = new DiagonalChecker();

    @Test
    public void shouldCheckIfOnlyBlueWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, BLUE,  EMPTY, EMPTY},
                {EMPTY, BLUE,  BLUE,  EMPTY},
                {RED,   BLUE,  RED,   BLUE }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = diagonalChecker.checkDiagonals(gameBoard, 3);

        Assert.assertTrue(result.blueWins() && !result.redWins());
    }

    @Test
    public void shouldCheckIfOnlyRedWins() {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, BLUE,  RED  , EMPTY},
                {EMPTY, RED ,  BLUE,  EMPTY},
                {RED,   BLUE,  RED,   BLUE }
        };

        GameBoard gameBoard = new GameBoard(gameboardArray);

        GameResult result = diagonalChecker.checkDiagonals(gameBoard, 3);

        Assert.assertTrue(!result.blueWins() && result.redWins());
    }
}