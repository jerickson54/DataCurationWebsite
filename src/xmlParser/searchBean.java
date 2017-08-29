package xmlParser;

import java.util.ArrayList;


public class searchBean {

	private static ArrayList<OregonNewsRoom> searchResults = new ArrayList<OregonNewsRoom>();
	private static OregonNewsRoom detail;
	
	
	
	
	public searchBean(){
		
	
	}
	


	public static OregonNewsRoom getDetail() {
		return detail;
	}



	public static void setDetail(OregonNewsRoom detail) {
		searchBean.detail = detail;
	}







	public ArrayList<OregonNewsRoom> getSearchResults() {
		return searchResults;
	}

	public static void setSearchResults(ArrayList<OregonNewsRoom> searchResults) {
		searchBean.searchResults = searchResults;
	}

	
	

	
}
