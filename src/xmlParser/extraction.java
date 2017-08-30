package xmlParser;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.stanford.nlp.io.EncodingPrintWriter.out;
import unsw.curation.api.extractnamedentity.ExtractEntitySentence;

/**
 * Servlet implementation class extraction
 */
@WebServlet("/extraction")
public class extraction extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public extraction() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String type = request.getParameter("extract");
		//String keyword = request.getParameter("extractInput");
		String content = searchBean.getDetail().getContent();
		
		ExtractEntitySentence fSentence = new ExtractEntitySentence();
		List<String> nothing = new ArrayList<String>();
		nothing.add("Sorry no results");
		
		if(type.equals("Extract Keywords")){
			try {
				List<String> keywords = fSentence.ExtractOrganization(content);
				keywords.addAll(fSentence.ExtractPerson(content));
				keywords.addAll(fSentence.ExtractLocation(content));
				searchBean.setExtractedInformation(keywords);
			} catch (URISyntaxException e) {
				searchBean.setExtractedInformation(nothing);
			}
		}
		
		if(type.equals("Extract People")){
			try {
				List<String> person = fSentence.ExtractPerson(content);
				searchBean.setExtractedInformation(person);
			} catch (URISyntaxException e) {
				searchBean.setExtractedInformation(nothing);
			}
		}

		if(type.equals("Extract Organizations")){
			try {
				List<String> organizations = fSentence.ExtractCompany(content);
				searchBean.setExtractedInformation(organizations);
			} catch (URISyntaxException e) {
				searchBean.setExtractedInformation(nothing);
			}
		}

		if(type.equals("Extract Locations")){
			try {
				List<String> locations = fSentence.ExtractLocation(content);
				searchBean.setExtractedInformation(locations);
			} catch (URISyntaxException e) {
				searchBean.setExtractedInformation(nothing);
			}
		}
		request.getRequestDispatcher("/extractionResults.jsp").forward(request,response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
