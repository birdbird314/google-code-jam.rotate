package birdbird314.google_code_jams.rotate;

import com.sun.javaws.exceptions.InvalidArgumentException;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-06.
 */
public class GameBoardTest {
    GameBoard gameBoard;

    @Before
    public void setUp() throws InvalidArgumentException {
        char[][] gameboardArray = {
                {EMPTY, EMPTY, EMPTY, EMPTY, EMPTY},
                {EMPTY, BLUE,  EMPTY, EMPTY, EMPTY},
                {EMPTY, BLUE,  RED,   EMPTY, EMPTY},
                {RED,   RED,   BLUE,  BLUE,  EMPTY},
                {RED,   RED,   RED,   BLUE,  EMPTY}
                };

        gameBoard = new GameBoard(gameboardArray);
    }

    @Test
    public void shouldReturnValidEntry() {
        Assert.assertEquals(BLUE, gameBoard.getEntry(2, 1));
    }

    @Test(expected = InvalidArgumentException.class)
    public void shouldThrowExceptionForInvalidArrayDimension() throws InvalidArgumentException {
        char[][] invalidArray = {
                {EMPTY, EMPTY},
                {RED, RED},
                {BLUE, BLUE}
                };

        GameBoard invalidGameBoard = new GameBoard(invalidArray);
    }

    @Test
    public void shouldReturnBoardSize() throws Exception {
        int boardSize = 5;

        Assert.assertEquals(boardSize, gameBoard.size());
    }
}