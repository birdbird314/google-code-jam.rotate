package birdbird314.google_code_jams.case_solver;

import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-23.
 */
@RunWith(Parameterized.class)
public class CaseParserTest {
    private CaseParser caseParser = new CaseParser();
    private String stringTestCase;
    private TestCase expectedTestCase;

    static final String STRING_TEST_CASE1 =
                    "4 3"  + "\n" +
                    "R..." + "\n" +
                    "BR.." + "\n" +
                    "BR.." + "\n" +
                    "BR..";

    static final TestCase EXPECTED_TEST_CASE1;
    static {
        final char[][] expectedGameBoardArray = {
                {RED  , EMPTY, EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY}
        };
        EXPECTED_TEST_CASE1 = new TestCase(new GameBoard(expectedGameBoardArray), 3);
    }

    static final String STRING_TEST_CASE2 =
            "3 2" + "\n" +
            ".B." + "\n" +
            "RB." + "\n" +
            "RRR"
            ;

    static final TestCase EXPECTED_TEST_CASE2;
    static {
        final char[][] expectedGameBoardArray = {
                {EMPTY, BLUE , EMPTY},
                {RED  , BLUE , EMPTY},
                {RED  , RED  , RED  }
        };
        EXPECTED_TEST_CASE2 = new TestCase(new GameBoard(expectedGameBoardArray), 2);
    }

    @Parameterized.Parameters
    public static Iterable data() {
        return Arrays.asList(
        new Object[][]{
                {STRING_TEST_CASE1, EXPECTED_TEST_CASE1},
                {STRING_TEST_CASE2, EXPECTED_TEST_CASE2}
        });
    }

    public CaseParserTest(String stringTestCase, TestCase expectedTestCase) {
        this.stringTestCase = stringTestCase;
        this.expectedTestCase = expectedTestCase;
    }

    @Test
    public void shouldParseTestCase() {
        TestCase actualTestCase = caseParser.parse(stringTestCase);

        Assert.assertEquals(expectedTestCase, actualTestCase);
    }

}
