package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;

/**
 * Created by Kamil on 2017-01-20.
 */
class RowChecker {
    private boolean blueWins, redWins;
    private int K;

    GameResult checkRows(GameBoard gameBoard, int K) {
        blueWins = false;
        redWins = false;
        this.K = K;

        checkColumns(gameBoard);

        return new GameResult(blueWins, redWins);
    }

    private void checkColumns(GameBoard gameBoard) {
        for(int row=0; row<gameBoard.size(); row++) {
            checkOneColumn(gameBoard, row);
        }
    }

    private void checkOneColumn(GameBoard gameBoard, int row) {
        int redAmount = 0;
        int blueAmount = 0;

        for (int i = 0; i < gameBoard.size(); i++) {
            if(gameBoard.getEntry(row, i) == GameBoard.BLUE)
                blueAmount++;
            else if(gameBoard.getEntry(row, i) == GameBoard.RED)
                redAmount++;
        }

        blueWins = blueWins || blueAmount >= K;
        redWins  = redWins || redAmount >= K;
    }
}
