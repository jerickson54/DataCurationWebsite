package xmlParser;

import java.util.ArrayList;
import java.util.List;


public class searchBean {

	private static ArrayList<OregonNewsRoom> searchResults = new ArrayList<OregonNewsRoom>();
	private static OregonNewsRoom detail;
	private static List<String> extractedInformation;
	private static int start = 0;
	private static int end;
	private static int iterateTo;
	private static int difference;
	
	
	
	
	public searchBean(){
		
	
	}
	
	public static OregonNewsRoom findByHeadline(String headline){
		

		for(OregonNewsRoom c:searchResults){
			if(c.getHeadline().trim().equals(headline.trim()))
				return c;
			
			
		}
		
		
		
		return searchResults.get(0);
	}
	
	
	
	
	public static int getDifference() {
		return difference;
	}

	public static void setDifference(int difference) {
		searchBean.difference = difference;
	}

	public static int getIterateTo() {
		return iterateTo;
	}

	public static void setIterateTo(int iterateTo) {
		searchBean.iterateTo = iterateTo;
	}

	public static int getStart() {
		return start;
	}

	public static void setStart(int start) {
		searchBean.start = start;
	}

	public static int getEnd() {
		return end;
	}

	public static void setEnd(int end) {
		searchBean.end = end;
	}

	public static OregonNewsRoom getDetail() {
		return detail;
	}



	public static void setDetail(OregonNewsRoom detail) {
		searchBean.detail = detail;
	}



	



	public static List<String> getExtractedInformation() {
		return extractedInformation;
	}



	public static void setExtractedInformation(List<String> extractedInformation) {
		searchBean.extractedInformation = extractedInformation;
	}



	public ArrayList<OregonNewsRoom> getSearchResults() {
		return searchResults;
	}

	public static void setSearchResults(ArrayList<OregonNewsRoom> searchResults) {
		searchBean.searchResults = searchResults;
	}

	
	

	
}
