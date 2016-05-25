package nappydevelopment.nappyTheIngenious.data;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class QuestAnsListTest{

	@Test
	public void listIsSorted(){
		QuestAnsList qal = new QuestAnsList();
		qal.add(new QuestAnsElement("string"));
		qal.add(new QuestAnsElement("string1"));
		qal.add(new QuestAnsElement("string2"));

		qal.setAnswer("string", Answer.NO);

		Assert.assertTrue(isSorted(qal));
	}

	private boolean isSorted(List<QuestAnsElement> l){
		boolean firstNullAnswer = false;
		for(QuestAnsElement aL : l){
			if(firstNullAnswer && aL.getAnswer() != null){
				return false;
			}
			if(aL.getAnswer() == null){
				firstNullAnswer = true;
			}
		}
		return true;
	}
}