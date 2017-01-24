package birdbird314.google_code_jams;

import birdbird314.google_code_jams.case_solver.CaseSolver;
import birdbird314.google_code_jams.case_solver.TestCase;
import birdbird314.google_code_jams.check_board.GameResult;
import birdbird314.google_code_jams.io.GameResultPrinter;
import birdbird314.google_code_jams.io.TestCasesIterator;

import java.io.*;

/**
 * Created by Kamil on 2017-01-24.
 */
public class App {
    private static TestCasesIterator testCasesIterator;
    private static GameResultPrinter gameResultPrinter;
    private static CaseSolver caseSolver = new CaseSolver();

    public static void main(String[] args) throws IOException {
        if(args.length != 2) {
            System.out.println("Invalid Arguments\nSyntax:\nRotate [source file] [destination file]");
        }

        init(args);

        while(testCasesIterator.hasNext()) {
            TestCase currentCase = testCasesIterator.next();

            GameResult gameResult = caseSolver.solve(currentCase);

            gameResultPrinter.printNextResult(gameResult);
        }
    }

    private static void init(String[] args) throws IOException {
        String source = args[0];
        String destination = args[1];
        BufferedReader reader = new BufferedReader(new FileReader(source));
        PrintStream printStream = new PrintStream(destination);

        testCasesIterator = new TestCasesIterator(reader);
        gameResultPrinter = new GameResultPrinter(printStream);
    }
}
