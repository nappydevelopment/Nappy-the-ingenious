package nappydevelopment.nappyTheIngenious.data;
//### IMPORTS ##############################################################################################################################
public class QuestAnsElement {

	private int    position;
	private String question;
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	private String answer;
	
	public QuestAnsElement(String question) {
		
		this.question = question;
		this.answer = "";
		this.position = -1;
	}
	
	public String toString() {return this.question;}
}
//### EOF ##################################################################################################################################