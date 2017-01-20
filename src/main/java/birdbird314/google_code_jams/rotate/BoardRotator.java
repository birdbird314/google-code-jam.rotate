package birdbird314.google_code_jams.rotate;

/**
 * Created by Kamil on 2017-01-09.
 */
public class BoardRotator {
    public GameBoard rotate(GameBoard gameBoard) {
        char[][] rotatedBoardArray = new char[gameBoard.size()][gameBoard.size()];

        for(int i=0; i<gameBoard.size(); i++)
            for(int j=0; j<gameBoard.size(); j++)
                rotatedBoardArray[i][j] = gameBoard.getEntry(j, i);

        return new GameBoard(rotatedBoardArray);
    }
}
