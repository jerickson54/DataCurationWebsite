package xmlParser;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class pageManager
 */
@WebServlet("/pageManager")
public class pageManager extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public pageManager() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String nextOrPrev = request.getParameter("nextOrPrev");
		
		System.out.println("Start");
		System.out.println(searchBean.getStart());
		System.out.println("End");
		System.out.println(searchBean.getEnd());
		System.out.println("Different");
		System.out.println(searchBean.getDifference());
		System.out.println("Iterate");
		System.out.println(searchBean.getIterateTo());
		System.out.println();
		System.out.println();
		
		if(nextOrPrev.equals("Next")){
			searchBean.setStart(searchBean.getStart()+10);
		
			if((searchBean.getIterateTo() + 10) > searchBean.getEnd()){
				searchBean.setIterateTo(searchBean.getEnd());
				//just set to a number that is not 9
				searchBean.setDifference(5);
			}
			else
				searchBean.setIterateTo(searchBean.getIterateTo()+10);
		}
		if(nextOrPrev.equals("Previous")){
			if((searchBean.getStart()-searchBean.getIterateTo() != 1)){
				searchBean.setDifference(9);
				searchBean.setIterateTo(searchBean.getStart());
				searchBean.setStart(searchBean.getStart() - 10);
				
			}
			else{
			searchBean.setStart(searchBean.getStart()-10);
			searchBean.setIterateTo(searchBean.getIterateTo() - 10);
			}
		}
		
		
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
