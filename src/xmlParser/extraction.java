package xmlParser;

import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.stanford.nlp.io.EncodingPrintWriter.out;
import unsw.curation.api.extractnamedentity.ExtractEntitySentence;
import unsw.curation.api.tokenization.ExtractionKeywordImpl;

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
			ExtractionKeywordImpl ek = new ExtractionKeywordImpl();
			
			URL url =printer.class.getResource("/");

			String file = url.getPath() + "xmlParser/englishStopwords.txt";
			
			try {
				String keys = ek.ExtractSentenceKeyword(content, new File(file));
				System.out.println(keys);
				List<String> keywords = Arrays.asList(keys.split("\\s*,\\s*"));
				searchBean.setExtractedInformation(keywords);
				
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
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
