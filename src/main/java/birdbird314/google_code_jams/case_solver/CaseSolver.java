package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.check_board.GameResult;
import birdbird314.google_code_jams.check_board.ResultChecker;
import birdbird314.google_code_jams.rotate.BoardRotator;
import birdbird314.google_code_jams.rotate.GameBoard;
import birdbird314.google_code_jams.rotate.Gravity;

/**
 * Created by Kamil on 2017-01-23.
 */
public class CaseSolver {
    private BoardRotator rotator = new BoardRotator();
    private Gravity gravity = new Gravity();
    private ResultChecker resultChecker = new ResultChecker();

    public GameResult solve(TestCase testCase) {
        return solve(testCase.getGameBoard(), testCase.getK());
    }

    private GameResult solve(GameBoard gameBoard, int K) {
        GameBoard rotatedBoard = rotator.rotate(gameBoard);
        GameBoard roatedAndGravitatedBoard = gravity.gravitate(rotatedBoard);

        return resultChecker.check(roatedAndGravitatedBoard, K);
    }
}
