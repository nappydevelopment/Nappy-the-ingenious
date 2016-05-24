package nappydevelopment.nappyTheIngenious.data;

import java.util.LinkedList;

//### IMPORTS ##############################################################################################################################
public class QuestAnsList extends LinkedList<QuestAnsElement>{

	public void setAnswer(String question, Answer answer) {
		this.stream()
			.filter(qae -> question.equals(qae.getQuestion()))
			.forEach(qae -> qae.setAnswer(answer));
		this.sort(
			(a, b) -> Boolean.compare(a.getAnswer() == null, b.getAnswer() == null)
		);
	}
}
//### EOF ##################################################################################################################################