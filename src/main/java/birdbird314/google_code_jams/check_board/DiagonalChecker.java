package birdbird314.google_code_jams.check_board;

import birdbird314.google_code_jams.rotate.GameBoard;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Kamil on 2017-01-20.
 */
class DiagonalChecker {
    private boolean blueWins, redWins;
    GameBoard gameBoard;
    private int K;

    GameResult checkDiagonals(GameBoard gameBoard, int K) {
        blueWins = redWins = false;
        this.K = K;
        this.gameBoard = gameBoard;

        checkDescendingDiagonals();
        checkAscendingDiagonals();

        return new GameResult(blueWins, redWins);
    }

    private void checkDescendingDiagonals() {
        for(int[] diagonalBeginning : generateDescendingDiagonalBeginnings())
            checkOneDiagonal(generateDescendingDiagonalIterator(diagonalBeginning));
    }

    private void checkAscendingDiagonals() {
        for(int[] diagonalBeginning : generateAscendingDiagonalBeginnings())
            checkOneDiagonal(generateAscendingDiagonalIterator(diagonalBeginning));
    }

    private void checkOneDiagonal(Iterator<Character> diagonalIterator) {
        int blueAmount, redAmount;
        blueAmount = redAmount = 0;
        char lastEntry, currentEntry;

        lastEntry = diagonalIterator.next();
        while(diagonalIterator.hasNext()) {
            currentEntry = diagonalIterator.next();

            if(currentEntry != lastEntry) {
                blueAmount = redAmount = 0;
            }
            else if(currentEntry == GameBoard.BLUE) {
                blueAmount++;
                if(blueAmount >= K-1)
                    blueWins=true;
            }
            else if(currentEntry == GameBoard.RED) {
                redAmount++;
                if(redAmount >= K-1)
                    redWins=true;
            }

            lastEntry = currentEntry;
        }
    }

    private int[][] generateDescendingDiagonalBeginnings() {
        final int BEGINNINGS_AMOUNT = gameBoard.size()*2 - 1;
        int[][] result = new int[BEGINNINGS_AMOUNT][2];

        for(int i=0; i<gameBoard.size(); i++) {
            result[i] = new int[]{i, 0};
        }

        for(int i=gameBoard.size(); i<BEGINNINGS_AMOUNT; i++) {
            result[i] = new int[]{0, i-gameBoard.size()+1};
        }

        return result;
    }

    private int[][] generateAscendingDiagonalBeginnings() {
        final int BEGINNINGS_AMOUNT = gameBoard.size()*2 - 1;
        int[][] result = new int[BEGINNINGS_AMOUNT][2];

        for(int i=0; i<gameBoard.size(); i++) {
            result[i] = new int[]{i, 0};
        }

        for(int i=gameBoard.size(); i<BEGINNINGS_AMOUNT; i++) {
            result[i] = new int[]{gameBoard.size()-1, i-gameBoard.size()+1};
        }

        return result;
    }

    private Iterator<Character> generateDescendingDiagonalIterator(int[] diagonalBeginning) {
        List<Character> diagonalEntrys = new ArrayList<Character>();
        final int DIAGONAL_LENGHT = descendingDiagonalLenght(diagonalBeginning);

        for(int i = 0; i<DIAGONAL_LENGHT; i++) {
            char currentEntry = gameBoard.getEntry(diagonalBeginning[0] + i, diagonalBeginning[1] + i);
            diagonalEntrys.add(currentEntry);
        }

        return diagonalEntrys.iterator();
    }

    private int descendingDiagonalLenght(int[] diagonalBeginning) {
        return gameBoard.size() - diagonalBeginning[0] - diagonalBeginning[1];
    }

    private Iterator<Character> generateAscendingDiagonalIterator(int[] diagonalBeginning) {
        List<Character> diagonalEntrys = new ArrayList<Character>();
        final int DIAGONAL_LENGHT = ascendingDiagonalLenght(diagonalBeginning);

        for(int i = 0; i<DIAGONAL_LENGHT; i++) {
            char currentEntry = gameBoard.getEntry(diagonalBeginning[0] - i, diagonalBeginning[1] + i);
            diagonalEntrys.add(currentEntry);
        }

        return diagonalEntrys.iterator();
    }

    private int ascendingDiagonalLenght(int[] diagonalBeginning) {
        if(diagonalBeginning[1] == 0)
            return diagonalBeginning[0]+1;
        else
            return gameBoard.size() - diagonalBeginning[1];
    }
}
