package xmlParser;





import java.net.URISyntaxException;
import java.util.List;

import unsw.curation.api.domain.ExtractNamedEntity;
import unsw.curation.api.extractnamedentity.ExtractEntityFile;
import unsw.curation.api.extractnamedentity.ExtractEntitySentence;

public class APImaster {
	
	public static void main(String args[]) throws URISyntaxException{
		
	//ExtractEntityFile fEntity = new ExtractEntityFile();
	ExtractEntitySentence fSentence = new ExtractEntitySentence();
	
	List<String> person = fSentence.ExtractPerson("California, New York , THINGS. Lebron James. Kobe Bryant. Luffy. Kill Me. Finish me while you have the chance! Hurry! End it now. Bill Gates is very rich. He has money and has an organization. HE lives in Oregon.");
	for(String s: person){
		System.out.println(s);
	}
	}
	
}
