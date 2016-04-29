package nappydevelopment.nappy_the_ingenious.data;
//### IMPORTS ##############################################################################################################################

//Class that represent an active game:
public class Game {
	
//### ATTRIBUTES ###########################################################################################################################

	private boolean isActive;
	private boolean isFinish;
	
	private int noOfQuestionsNappy;
	private WikiCharacter characterThatNappyGuessed;
	private boolean isNappyRight;
	
	private int noOfQuestionsPlayer;
	private WikiCharacter characterThatNappyChoose;
	private WikiCharacter characterPlayer;
	private boolean isPlayerRight;
	
	public boolean isNappyRight() {
		return isNappyRight;
	}

	public void setNappyRight(boolean isNappyRight) {
		this.isNappyRight = isNappyRight;
	}
	
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
		this.isFinish = false;
		
		this.noOfQuestionsNappy = 0;
		this.characterThatNappyGuessed = null;
		this.isNappyRight = false;
		
		this.noOfQuestionsPlayer = 0;
		this.characterPlayer = null;
		this.isPlayerRight = false;
		
	}
//### INITIAL METHODS ######################################################################################################################


public boolean isFinish() {
		return isFinish;
	}

	public void setFinish(boolean isFinish) {
		this.isFinish = isFinish;
	}

	public WikiCharacter getCharacterNappy() {
		return characterThatNappyGuessed;
	}

	public void setCharacterNappy(WikiCharacter characterNappy) {
		this.characterThatNappyGuessed = characterNappy;
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