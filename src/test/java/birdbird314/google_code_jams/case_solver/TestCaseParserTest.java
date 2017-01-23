package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-23.
 */
public class TestCaseParserTest {
    CaseParser caseParser = new CaseParser();

    @Test
    public void shouldParseTestCase() {
        String stringTestCase =
                "4 3" + "\n" +
                "R..." + "\n" +
                "BR.." + "\n" +
                "BR.." + "\n" +
                "BR.."
                ;
        char[][] expectedGameboardArray = {
                {RED  , EMPTY, EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY}
        };
        GameBoard expectedGameBoard = new GameBoard(expectedGameboardArray);
        final int expectedK = 3;
        TestCase expectedTestCase = new TestCase(expectedGameBoard, expectedK);

        TestCase actualTestCase = caseParser.parse(stringTestCase);

        Assert.assertEquals(expectedTestCase, actualTestCase);
    }
}
