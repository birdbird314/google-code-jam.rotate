package birdbird314.google_code_jams.check_board;

/**
 * Created by Kamil on 2017-01-19.
 */
class GameResult {
    private boolean blueWins;
    private boolean redWins;

    GameResult(boolean blueWins, boolean redWins) {
        this.blueWins = blueWins;
        this.redWins = redWins;
    }

    boolean blueWins() {
        return blueWins;
    }

    boolean redWins() {
        return redWins;
    }
}
