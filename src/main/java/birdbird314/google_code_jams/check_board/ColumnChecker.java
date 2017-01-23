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
        int lastEntry = gameBoard.getEntry(0, column);

        for (int i = 1; i < gameBoard.size(); i++) {
            char currentEntry = gameBoard.getEntry(i, column);

            if(lastEntry != currentEntry) {
                redAmount = blueAmount = 0;
            }
            else if(lastEntry == GameBoard.BLUE) {
                blueAmount++;
                if(blueAmount >= K-1) //K-1 because we count entries from 0
                    blueWins = true;
            }
            else if(lastEntry == GameBoard.RED) {
                redAmount++;
                if(redAmount >= K-1)
                    redWins = true;
            }

            lastEntry = currentEntry;
        }
    }
}
