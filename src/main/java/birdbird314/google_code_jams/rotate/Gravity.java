package birdbird314.google_code_jams.rotate;

import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;

/**
 * Created by Kamil on 2017-01-09.
 */
public class Gravity {
    char[][] result;

    public GameBoard gravitate(GameBoard notGravitatedBoard) {
        initResult(notGravitatedBoard);

        for(int column=0; column<notGravitatedBoard.size(); column++)
            gravitateColumn(column);

        return new GameBoard(result);
    }

    private void initResult(GameBoard board) {
        result = new char[board.size()][board.size()];

        for (int i = 0; i < result.length; i++)
            for (int j = 0; j < result[i].length; j++)
                result[i][j] = board.getEntry(i, j);
    }

    private void gravitateColumn(int column) {
        for(int row=0; row<result.length-1; row++) {
            if(result[row][column] != EMPTY && result[row+1][column] == EMPTY)
                moveDown(column, row);
        }
    }

    private void moveDown(int column, int from) {
        for(int i=from; i>=0; i--)
            result[i+1][column] = result[i][column];
        result[0][column] = EMPTY;
    }
}
