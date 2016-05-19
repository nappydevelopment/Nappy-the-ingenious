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

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	private Answer answer;

	public String getText() {
		if(answer == null){
			return "";
		}
		return this.answer.getText();
	}
	
	public QuestAnsElement(String question) {
		
		this.question = question;
		this.answer = null;
		this.position = -1;
	}
	
	public String toString() {return this.question;}
}
//### EOF ##################################################################################################################################