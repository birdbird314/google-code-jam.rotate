package birdbird314.google_code_jams.rotate;

import java.util.Arrays;

/**
 * Created by Kamil on 2017-01-07.
 */
public class GameBoard {
    public static final char EMPTY = 0;
    public static final char RED = 1;
    public static final char BLUE = 2;

    private char[][] gameBoardArray;

    public GameBoard(char[][] gameboardArray) {
        if(gameboardArray.length > 0)
            if(gameboardArray.length != gameboardArray[0].length)
                throw new IllegalArgumentException();

        this.gameBoardArray = gameboardArray;
    }

    public char getEntry(int i, int j) {
        return gameBoardArray[i][j];
    }

    public int size() {
        return gameBoardArray.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        GameBoard gameBoard = (GameBoard) o;

        return Arrays.deepEquals(gameBoardArray, gameBoard.gameBoardArray);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(gameBoardArray);
    }
}
