package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;

/**
 * Created by Kamil on 2017-01-20.
 */
class DiagonalChecker {
    private boolean blueWins, redWins;

    GameResult checkDiagonals(GameBoard gameBoard, int i) {
        blueWins = redWins = false;

        checkDescendingDiagonals(gameBoard);
        checkAscendingDiagonals(gameBoard);

        return new GameResult(blueWins, redWins);
    }

    private void checkDescendingDiagonals(GameBoard gameBoard) {
        for(int[] diagonalBeginning : generateDescendingDiagonalBeginnings(gameBoard))
            checkOneDescendingDiagonal(gameBoard, diagonalBeginning);
    }

    private int[] generateDescendingDiagonalBeginnings(GameBoard gameBoard) {
        final int BEGINNINGS_AMOUNT = gameBoard.size()*2 - 1;
        int[] result = new int[BEGINNINGS_AMOUNT];
        //TODO
        return result;
    }
}
