package birdbird314.google_code_jams.rotate;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-09.
 */
public class BoardRotatorTest {
    GameBoard gameBoard;
    BoardRotator rotator = new BoardRotator();

    @Before
    public void setUp() {
        char[][] gameBoardArray = {
                { EMPTY, RED, EMPTY, EMPTY },
                { EMPTY, BLUE, BLUE, EMPTY },
                { BLUE,  RED,  RED , RED   },
                { RED ,  RED, BLUE,  BLUE  }
        };

        gameBoard = new GameBoard(gameBoardArray);
    }

    @Test
    public void shouldRotateGameBoard() {
        GameBoard rotatedBoard = rotator.rotate(gameBoard);

        for(int i=0; i<gameBoard.size(); i++)
            for(int j=0; j<gameBoard.size(); j++)
                Assert.assertEquals(gameBoard.getEntry(j,i), rotatedBoard.getEntry(i, j));
    }

    @Test
    public void shouldIgnoreEmptyArray() throws Exception {
        GameBoard emptyBoard = new GameBoard(new char[0][0]);
        GameBoard rotatedBoard;

        rotatedBoard = rotator.rotate(emptyBoard);

        Assert.assertEquals(emptyBoard, rotatedBoard);
    }
}