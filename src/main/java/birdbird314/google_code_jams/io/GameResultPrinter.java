package birdbird314.google_code_jams.io;

import birdbird314.google_code_jams.check_board.GameResult;

import java.io.PrintStream;

/**
 * Created by Kamil on 2017-01-24.
 */
public class GameResultPrinter {
    private PrintStream printStream;
    private int currentCaseNum;

    GameResultPrinter(PrintStream printStream) {
        this.printStream = printStream;
        currentCaseNum = 0;
    }

    void printNextResult(GameResult gameResult) {
        currentCaseNum++;
        printStream.println("Case #" + currentCaseNum + ": " + gameResult);
    }
}
