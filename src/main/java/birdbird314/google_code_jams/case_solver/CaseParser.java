package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.rotate.GameBoard;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-23.
 */
class CaseParser {
    TestCase parse(String stringTestCase) {
        char[][] gameboardArray = {
                {RED  , EMPTY, EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY}
        };
        GameBoard gameBoard = new GameBoard(gameboardArray);

        return new TestCase(gameBoard, 3);
    }
}
