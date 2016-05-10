package nappydevelopment.nappyTheIngenious.data;

import java.util.LinkedList;
import java.util.ListIterator;

//### IMPORTS ##############################################################################################################################
public class QuestAnsList extends LinkedList<QuestAnsElement>{

	public void setAnswer(String question, String answer) {
		
        ListIterator<QuestAnsElement> listIterator = this.listIterator();
        
        while (listIterator.hasNext()) {
        	
        	//Read out current character:
        	QuestAnsElement qae = listIterator.next();
        	
        	if(qae.getQuestion() == question) {
        		qae.setAnswer(answer);
        	}
        }
	}
}
//### EOF ##################################################################################################################################