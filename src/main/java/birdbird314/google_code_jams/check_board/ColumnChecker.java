package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;

/**
 * Created by Kamil on 2017-01-19.
 */
class ColumnChecker {
    private boolean blueWins, redWins;
    private int K;

    GameResult checkColumns(GameBoard gameBoard, int K) {
        blueWins = false;
        redWins = false;
        this.K = K;

        checkColumns(gameBoard);

        return new GameResult(blueWins, redWins);
    }

    private void checkColumns(GameBoard gameBoard) {
        for(int column=0; column<gameBoard.size(); column++) {
            checkOneColumn(gameBoard, column);
        }
    }

    private void checkOneColumn(GameBoard gameBoard, int column) {
        int redAmount = 0;
        int blueAmount = 0;

        for (int i = 0; i < gameBoard.size(); i++) {
            if(gameBoard.getEntry(i, column) == GameBoard.BLUE)
                blueAmount++;
            else if(gameBoard.getEntry(i, column) == GameBoard.RED)
                redAmount++;
        }

        blueWins = blueWins || blueAmount >= K;
        redWins  = redWins || redAmount >= K;
    }
}
