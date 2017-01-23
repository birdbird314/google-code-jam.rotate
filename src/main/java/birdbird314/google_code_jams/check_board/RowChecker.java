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

        checkRows(gameBoard);

        return new GameResult(blueWins, redWins);
    }

    private void checkRows(GameBoard gameBoard) {
        for(int row=0; row<gameBoard.size(); row++) {
            checkOneRow(gameBoard, row);
        }
    }

    private void checkOneRow(GameBoard gameBoard, int row) {
        int redAmount = 0;
        int blueAmount = 0;
        char lastEntry, currentEntry;

        lastEntry = gameBoard.getEntry(row, 0);
        for (int i = 1; i < gameBoard.size(); i++) {
            currentEntry = gameBoard.getEntry(row, i);

            if (lastEntry != currentEntry) {
                blueAmount = redAmount = 0;
            } else if (currentEntry == GameBoard.BLUE) {
                blueAmount++;
                if (blueAmount >= K - 1)
                    blueWins = true;
            } else if (currentEntry == GameBoard.RED) {
                redAmount++;
                if (redAmount >= K - 1)
                    redWins = true;
            }

            lastEntry = currentEntry;
        }
    }
}
