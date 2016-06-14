package nappydevelopment.nappyTheIngenious.data;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collector;

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
		
		QuestAnsList out = new QuestAnsList();
		Iterator<QuestAnsElement> iterator = this.iterator();
		while (iterator.hasNext()) {
			QuestAnsElement curQAL = iterator.next();
			if(filter.isEmpty() || curQAL.getQuestion().toLowerCase().contains(filter.toLowerCase())) {
				out.add(curQAL);
			}
		}
		
		return out;
//		return this.stream()
//			.filter(c -> {
//				if(filter.isEmpty()){return true;}
//				return c.getQuestion().toLowerCase().contains(filter);
//			})
//			.collect(Collector.of(
//				QuestAnsList::new,
//				QuestAnsList::add,
//				(left,right)->{left.addAll(right); return left;}
//			));
	}


}
//### EOF ##################################################################################################################################
