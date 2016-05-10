package nappydevelopment.nappyTheIngenious.data;

/**
 * Created by Marc on 04.04.2016.
 */
public class Player {

    private String playerName;
    private double score;
    private int questions_nappy;
    private int questions_player;


    public Player(String anzeigename, int questions_nappy, int questions_player, double score) {
        this.playerName = anzeigename;
        this.questions_nappy = questions_nappy;
        this.questions_player = questions_player;
        this.score = score;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getQuestions_nappy() {
        return questions_nappy;
    }

    public int getQuestions_player() {
        return questions_player;
    }

    public double getScore() {
        return score;
    }
}

