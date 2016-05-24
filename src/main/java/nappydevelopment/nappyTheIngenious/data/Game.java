package nappydevelopment.nappyTheIngenious.data;
//### IMPORTS ##############################################################################################################################

import nappydevelopment.nappyTheIngenious.data.character.Character;

//Class that represent an active game:
public class Game {
	
//### ATTRIBUTES ###########################################################################################################################

	private QuestAnsList qal;
	
	public QuestAnsList getQal() {
		return qal;
	}

	public void setQal(QuestAnsList qal) {
		this.qal = qal;
	}

	private boolean isActive;
	private boolean isGamemode2Active;
	public boolean isGamemode2Active() {
		return isGamemode2Active;
	}

	public void setGamemode2Active(boolean isGamemode2Active) {
		this.isGamemode2Active = isGamemode2Active;
	}

	private boolean isFinish;
	
	private int noOfQuestionsNappy;
	private Character characterThatNappyGuessed;
	private Answer isNappyRight;
	private int idontkowCounter;
	
	private int noOfQuestionsPlayer;
	private Character characterThatNappyChoose;
	private Character characterPlayer;
	private boolean isPlayerRight;
	
	public Answer isNappyRight() {
		return isNappyRight;
	}

	public void setNappyRight(Answer isNappyRight) {
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
		
		this.qal = new QuestAnsList();
		
		this.isActive = false;
		this.isFinish = false;
		this.isGamemode2Active = false;
		
		this.idontkowCounter = 0;
		this.noOfQuestionsNappy = 0;
		this.characterThatNappyGuessed = null;
		this.isNappyRight = null;
		
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

	public Character getCharacterNappy() {
		return characterThatNappyGuessed;
	}

	public void setCharacterNappy(Character characterNappy) {
		this.characterThatNappyGuessed = characterNappy;
	}

	public Character getCharacterPlayer() {
		return characterPlayer;
	}

	public void setCharacterPlayer(Character characterPlayer) {
		this.characterPlayer = characterPlayer;
	}
	
	public void increaseIdontKnow() {
		this.idontkowCounter++;
	}
	
	public boolean isIdontKnowTooMuch() {
		return (this.idontkowCounter >= 4);
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