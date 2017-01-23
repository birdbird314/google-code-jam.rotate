package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;

/**
 * Created by Kamil on 2017-01-23.
 */
public class ResultChecker {
    ColumnChecker columnChecker = new ColumnChecker();
    RowChecker rowChecker = new RowChecker();
    DiagonalChecker diagonalChecker = new DiagonalChecker();

    public GameResult check(GameBoard gameBoard, int K) {
        GameResult columnResult = columnChecker.checkColumns(gameBoard, K);
        GameResult rowResult = rowChecker.checkRows(gameBoard, K);
        GameResult diagonalResult = diagonalChecker.checkDiagonals(gameBoard, K);

        GameResult finalResult = new GameResult(
                columnResult.blueWins() || rowResult.blueWins() || diagonalResult.blueWins(),
                columnResult.redWins() || rowResult.redWins() || diagonalResult.redWins()
        );

        return finalResult;
    }
}
