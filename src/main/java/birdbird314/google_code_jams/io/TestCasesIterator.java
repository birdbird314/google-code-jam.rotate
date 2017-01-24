package birdbird314.google_code_jams.io;

import birdbird314.google_code_jams.case_solver.TestCase;
import birdbird314.google_code_jams.rotate.GameBoard;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 * Created by Kamil on 2017-01-24.
 */
public class TestCasesIterator {
    private BufferedReader reader;
    private final int NUMBER_OF_CASES;
    private int currentCase;

    private int K, N;

    public TestCasesIterator(BufferedReader reader) throws IOException {
        this.reader = reader;

        NUMBER_OF_CASES = Integer.parseInt(reader.readLine());
        currentCase = 0;
    }

    public boolean hasNext() {
        return currentCase<NUMBER_OF_CASES;
    }

    public TestCase next() throws IOException {
        extractKandN();
        GameBoard gameBoard = extractGameBoard();
        currentCase++;

        return new TestCase(gameBoard, K);
    }

    private void extractKandN() throws IOException {
        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());

        N = Integer.parseInt(tokenizer.nextToken());
        K = Integer.parseInt(tokenizer.nextToken());
    }

    private GameBoard extractGameBoard() throws IOException {
        char[][] gameBoardArray = new char[N][N];
        String currentLine;

        for(int row=0; row<N; row++) {
            currentLine = reader.readLine();
            for(int i=0; i<N; i++)
                gameBoardArray[row][i] = parseGameBoardEntry(currentLine.charAt(i));
        }

        return new GameBoard(gameBoardArray);
    }

    private char parseGameBoardEntry(char c) {
        if(c == 'B')
            return GameBoard.BLUE;
        else if(c == 'R')
            return GameBoard.RED;
        else
            return GameBoard.EMPTY;
    }
}
