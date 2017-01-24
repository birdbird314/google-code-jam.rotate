package birdbird314.google_code_jams;

import birdbird314.google_code_jams.case_solver.CaseSolver;
import birdbird314.google_code_jams.case_solver.TestCase;
import birdbird314.google_code_jams.check_board.GameResult;
import birdbird314.google_code_jams.io.GameResultPrinter;
import birdbird314.google_code_jams.io.TestCasesIterator;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintStream;

/**
 * Created by Kamil on 2017-01-24.
 */
public class App {
    public static void main(String[] args) throws IOException {
        String source = "D:\\A-small-practice.in";
        String destination = "D:\\solutionsmall.txt";
        BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintStream printStream = new PrintStream(destination);

        TestCasesIterator testCasesIterator = new TestCasesIterator(reader);
        GameResultPrinter gameResultPrinter = new GameResultPrinter(printStream);

        CaseSolver caseSolver = new CaseSolver();

        while(testCasesIterator.hasNext()) {
            TestCase currentCase = testCasesIterator.next();

            GameResult gameResult = caseSolver.solve(currentCase);

            gameResultPrinter.printNextResult(gameResult);
        }

        reader.close();
        printStream.close();
    }
}
