package xmlParser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class xmlServlet
 */
@WebServlet(urlPatterns="/xmlServlet",displayName="xmlServlet")
public class xmlServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public xmlServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//get parameters fro search.jsp
		String searchInput = request.getParameter("searchInput").toLowerCase();
		String searchType = request.getParameter("searchType");
		CharSequence seq = searchInput;
		
		
		printer.parseFromXML();
		ArrayList<OregonNewsRoom> allData = printer.getAll();
		ArrayList<OregonNewsRoom> toSearchBean = new ArrayList<OregonNewsRoom>();
		
		for(OregonNewsRoom c: allData){
		
		if(searchType.equals("Advanced") && c.getContent().toLowerCase().contains(seq))
			toSearchBean.add(c);
			
		if(searchType.equals("Agency") && c.getAgency().toLowerCase().contains(seq))
			toSearchBean.add(c);
		if(searchType.equals("Headline") && c.getHeadline().toLowerCase().contains(seq))
			toSearchBean.add(c);
		
		if(searchType.equals("Date") && c.getDateEntered().substring(0,10).equals(searchInput))
			toSearchBean.add(c);
		if(searchType.equals("City") && c.getCity().toLowerCase().equals(searchInput))
			toSearchBean.add(c);
		if(searchType.equals("Contact Name") && c.getContact1()!= null){
				if((c.getContact1().getName().toLowerCase().contains(seq)))
					toSearchBean.add(c);
				
		}
		if(searchType.equals("Contact Name") && c.getContact2()!= null){
			if((c.getContact2().getName().toLowerCase().contains(seq)))
				toSearchBean.add(c);
			
		}
			
		}
			
		
			
		
		
		searchBean.setSearchResults(toSearchBean);
		searchBean.setEnd(toSearchBean.size());
		searchBean.setIterateTo(9);
		searchBean.setDifference(9);
		searchBean.setStart(0);
		
		
		
		
		
		//alter the value of search bean and then display in results page 
		request.getRequestDispatcher("/results.jsp").forward(request,response);
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}