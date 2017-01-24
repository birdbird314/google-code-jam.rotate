package birdbird314.google_code_jams.io;

import birdbird314.google_code_jams.case_solver.TestCase;
import birdbird314.google_code_jams.rotate.GameBoard;
import org.junit.*;

import java.io.*;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-24.
 */
public class TestCasesIteratorTest {
    private final String TEST_CASES =
            "4" + "\n" +
            "7 3" + "\n" +
            "......." + "\n" +
            "......." + "\n" +
            "......." + "\n" +
            "...R..." + "\n" +
            "...BB.." + "\n" +
            "..BRB.." + "\n" +
            ".RRBR.." + "\n" +
            "6 4" + "\n" +
            "......" + "\n" +
            "......" + "\n" +
            ".R...R" + "\n" +
            ".R..BB" + "\n" +
            ".R.RBR" + "\n" +
            "RB.BBB" + "\n" +
            "4 4" + "\n" +
            "R..." + "\n" +
            "BR.." + "\n" +
            "BR.." + "\n" +
            "BR.." + "\n" +
            "3 3" + "\n" +
            "B.." + "\n" +
            "RB." + "\n" +
            "RB."
    ;
    private BufferedReader reader;
    private TestCasesIterator testCasesIterator;

    @Before
    public void setup() throws IOException {
        reader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(TEST_CASES.getBytes())));
        testCasesIterator = new TestCasesIterator(reader);
    }

    @After
    public void tearDown() {
        try {
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void shouldHaveValidNumberOfCases() throws IOException {
        final int expectedNumberOfCases = 4;
        int actualNumberOfCases = 0;

        while(testCasesIterator.hasNext()) {
            actualNumberOfCases++;
            testCasesIterator.next();
        }

        Assert.assertEquals(expectedNumberOfCases, actualNumberOfCases);
    }

    @Test
    public void shouldReturnCurrentTestCase() throws IOException {
        char[][] expectedGameboardArray = {
                {RED  , EMPTY, EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY},
                {BLUE , RED  , EMPTY, EMPTY}
        };
        final int EXPECTED_K = 4;
        TestCase expectedTestCase = new TestCase(new GameBoard(expectedGameboardArray), EXPECTED_K);
        TestCase actualTestCase=null;

        for(int i=0; i<3; i++)
            actualTestCase = testCasesIterator.next();

        Assert.assertEquals(expectedTestCase, actualTestCase);
    }
}
