package birdbird314.google_code_jams.io;

import birdbird314.google_code_jams.case_solver.TestCase;
import birdbird314.google_code_jams.rotate.GameBoard;

import java.util.StringTokenizer;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-23.
 */
class CaseParser {
    private StringTokenizer lineTokenizer;
    private int K, N;

    TestCase parse(String stringTestCase) {
        lineTokenizer = new StringTokenizer(stringTestCase, "\n");

        String firstLine = lineTokenizer.nextToken();
        extractKandNFromFirstLine(firstLine);

        GameBoard gameBoard = extractGameBoard();

        return new TestCase(gameBoard, K);
    }

    private GameBoard extractGameBoard() {
        char[][] gameBoardArray = new char[N][N];

        for(int i=0; i<N; i++)
            gameBoardArray[i] = extractLine(lineTokenizer.nextToken());

        return new GameBoard(gameBoardArray);
    }

    private void extractKandNFromFirstLine(String firstLine) {
        StringTokenizer tokenizer = new StringTokenizer(firstLine, " ");

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
    }

    private char[] extractLine(String line) {
        char[] result = new char[N];

        for(int i=0; i<N; i++) {
            switch (line.charAt(i)) {
                case '.':
                    result[i] = GameBoard.EMPTY;
                    break;
                case 'B':
                    result[i] = GameBoard.BLUE;
                    break;
                case 'R':
                    result[i] = GameBoard.RED;
                    break;
            }
        }

        return result;
    }

}
