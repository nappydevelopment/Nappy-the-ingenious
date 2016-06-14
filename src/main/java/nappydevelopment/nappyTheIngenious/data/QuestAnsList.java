package nappydevelopment.nappyTheIngenious.data;

import java.util.LinkedList;
import java.util.stream.Collectors;

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

	public QuestAnsList filter(final String filter) {
		return (QuestAnsList) this.stream()
			.filter(c -> {
				if(filter.isEmpty()){return true;}
				return c.getText().toLowerCase().contains(filter);
			})
			.collect(Collectors.toList());
	}
}
//### EOF ##################################################################################################################################
