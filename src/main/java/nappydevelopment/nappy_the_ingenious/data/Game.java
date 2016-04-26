package nappydevelopment.nappy_the_ingenious.data;
//### IMPORTS ##############################################################################################################################

//Class that represent an active game:
public class Game {
	
//### ATTRIBUTES ###########################################################################################################################

	private boolean isActive;
	private boolean isFinish;
	
	private Gamemode activeGamemode;
	private boolean isGamemode1Finish;
	
	private int noOfQuestionsNappy;
	private WikiCharacter characterNappy;
	private boolean isNappyRight;
	
	public boolean isNappyRight() {
		return isNappyRight;
	}

	public void setNappyRight(boolean isNappyRight) {
		this.isNappyRight = isNappyRight;
	}

	private int noOfQuestionsPlayer;
	private WikiCharacter characterPlayer;

	
	public boolean isWinNappy() {
		return winNappy;
	}

	public void setWinNappy(boolean winNappy) {
		this.winNappy = winNappy;
	}

	public boolean isWinPlayer() {
		return winPlayer;
	}

	public void setWinPlayer(boolean winPlayer) {
		this.winPlayer = winPlayer;
	}

	private boolean winNappy;
	private boolean winPlayer;
	
	
//### COMPONENTS ###########################################################################################################################

//### CONSTRUCTORS #########################################################################################################################
	public Game() {
		this.isActive = false;
		this.isGamemode1Finish = false;
		this.activeGamemode = Gamemode.NONE;
		
		this.noOfQuestionsNappy = 0;
		this.noOfQuestionsPlayer = 0;
	}
//### INITIAL METHODS ######################################################################################################################


public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public boolean isGamemode1Finish() {
		return isGamemode1Finish;
	}

	public void setGamemode1Finish(boolean isGamemode1Finish) {
		this.isGamemode1Finish = isGamemode1Finish;
	}

	public WikiCharacter getCharacterNappy() {
		return characterNappy;
	}

	public void setCharacterNappy(WikiCharacter characterNappy) {
		this.characterNappy = characterNappy;
	}

	public WikiCharacter getCharacterPlayer() {
		return characterPlayer;
	}

	public void setCharacterPlayer(WikiCharacter characterPlayer) {
		this.characterPlayer = characterPlayer;
	}

	//### GETTER/SETTER ########################################################################################################################
	public boolean isActive() {
		return isActive;
	}
	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}
	public Gamemode getActiveGamemode() {
		return activeGamemode;
	}
	public void setActiveGamemode(Gamemode activeGamemode) {
		this.activeGamemode = activeGamemode;
	}
	public int getNoOfQuestionsNappy() {
		return noOfQuestionsNappy;
	}
	
	public float getNoOfQuestionsNappyInPercent() {
		return ((float)this.noOfQuestionsNappy * 0.05F);
	}
	public void setNoOfQuestionsNappy(int noOfQuestionsNappy) {
		this.noOfQuestionsNappy = noOfQuestionsNappy;
	}
	public int getNoOfQuestionsPlayer() {
		return noOfQuestionsPlayer;
	}
	public void increaseNoOfQuestionsNappy() {
		this.noOfQuestionsNappy++;
	}
	public void setNoOfQuestionsPlayer(int noOfQuestionsPlayer) {
		this.noOfQuestionsPlayer = noOfQuestionsPlayer;
	}
	public void increasNoOfQuestionsPlayer() {
		this.noOfQuestionsPlayer++;
	}

//### METHODS ##############################################################################################################################}
}
//### EOF ##################################################################################################################################