package nappydevelopment.nappy_the_ingenious.data.settings;
//### IMPORTS ##############################################################################################################################
public enum GameMode {
	BOTH_MODES(true), ONLY_MODE1(false);
	
	private final boolean afgm2;
	
	private GameMode(boolean afgm2) {
		this.afgm2 = afgm2;
	}
	
	public boolean askForGamemode2() {
		return this.afgm2;
	}
}

//### EOF ##################################################################################################################################