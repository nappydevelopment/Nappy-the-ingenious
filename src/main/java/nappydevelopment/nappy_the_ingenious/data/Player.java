package nappydevelopment.nappy_the_ingenious.data;

/**
 * Created by Marc on 04.04.2016.
 */
public class Player {

    private String playerName;
    private int score;
    private int questions_nappy;
    private int questions_player;


    public Player(String anzeigename, int questions_nappy, int questions_player, int score) {
        this.playerName = anzeigename;
        this.questions_nappy = questions_nappy;
        this.questions_player = questions_player;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        playerName = playerName;
    }

    public int getQuestions_nappy() {
        return questions_nappy;
    }

    public void setQuestions_nappy(int questions_nappy) {
        this.questions_nappy = questions_nappy;
    }

    public int getQuestions_player() {
        return questions_player;
    }

    public void setQuestions_player(int questions_player) {
        this.questions_player = questions_player;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
