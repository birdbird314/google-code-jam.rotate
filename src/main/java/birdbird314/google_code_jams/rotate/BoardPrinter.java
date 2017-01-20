package birdbird314.google_code_jams.rotate;

import static birdbird314.google_code_jams.rotate.GameBoard.BLUE;
import static birdbird314.google_code_jams.rotate.GameBoard.EMPTY;
import static birdbird314.google_code_jams.rotate.GameBoard.RED;

/**
 * Created by Kamil on 2017-01-10.
 */
class BoardPrinter {
    void printBoard(GameBoard board) {
        for(int row =0; row<board.size(); row++) {
            for (int col = 0; col < board.size(); col++)
                System.out.print( symbolOf( board.getEntry(row, col) ) );
            System.out.println();
        }
    }

    private String symbolOf(char entry) {
        if(entry == EMPTY)
            return ".";
        else if(entry == RED)
            return "R";
        else if(entry == BLUE)
            return "B";
        return "-1";
    }
}
