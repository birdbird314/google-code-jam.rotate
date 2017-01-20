package birdbird314.google_code_jams.rotate;

import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-09.
 */
public class GravityTest {
    @Test
    public void shouldGravitateBoardElement() {
        Gravity gravity = new Gravity();
        GameBoard notGravitatedBoard = new GameBoard(getNotGravitatedBoardArray());

        GameBoard gravitatedBoard  = gravity.gravitate(notGravitatedBoard);

        Assert.assertEquals(new GameBoard(getGravitatedBoardArray()), gravitatedBoard);
    }

    private char[][] getNotGravitatedBoardArray() {
        return new char[][]{
                    { RED  , EMPTY, EMPTY, EMPTY },
                    { RED  , BLUE , BLUE , EMPTY },
                    { BLUE , RED  , EMPTY, EMPTY },
                    { EMPTY, EMPTY, EMPTY, EMPTY }
                };
    }

    private char[][] getGravitatedBoardArray() {
        return new char[][]{
                    { EMPTY, EMPTY, EMPTY, EMPTY },
                    { RED  , EMPTY, EMPTY, EMPTY },
                    { RED  , BLUE , EMPTY, EMPTY },
                    { BLUE , RED  , BLUE , EMPTY }
                };
    }
}