package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.rotate.GameBoard;

/**
 * Created by Kamil on 2017-01-23.
 */
public class TestCase {
    private GameBoard gameBoard;
    private final int K;

    public TestCase(GameBoard gameBoard, int k) {
        this.gameBoard = gameBoard;
        K = k;
    }

    public GameBoard getGameBoard() {
        return gameBoard;
    }

    public int getK() {
        return K;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TestCase testCase = (TestCase) o;

        if (K != testCase.K) return false;
        return gameBoard != null ? gameBoard.equals(testCase.gameBoard) : testCase.gameBoard == null;
    }

    @Override
    public int hashCode() {
        int result = gameBoard != null ? gameBoard.hashCode() : 0;
        result = 31 * result + K;
        return result;
    }
}
