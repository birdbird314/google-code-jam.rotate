package birdbird314.google_code_jams.check_board;

/**
 * Created by Kamil on 2017-01-19.
 */
public class GameResult {
    private boolean blueWins;
    private boolean redWins;

    public GameResult(boolean blueWins, boolean redWins) {
        this.blueWins = blueWins;
        this.redWins = redWins;
    }

    public boolean blueWins() {
        return blueWins;
    }

    public boolean redWins() {
        return redWins;
    }

    @Override
    public String toString() {
        if(blueWins && redWins)
            return "Both";
        else if(blueWins && !redWins)
            return "Blue";
        else if(!blueWins && redWins)
            return "Red";
        else
            return "Neither";
    }
}
