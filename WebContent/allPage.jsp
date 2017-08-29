<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="xmlParser.*, java.util.*"%>
    <%--<jsp:forward page= "${pageContent.request.contextPath}/xmlServlet" /> --%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Curation</title>
</head>

<!-- BootStrap  and jquery stuff -->
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">


<body>


<% 

ArrayList<OregonNewsRoom> allData = printer.getAll();
int numberDisplay = allData.size() -18;


%>

<jsp:include page = "/header.jsp"/>

<label id = "numDisplay"> Number Display: </label> 
<label id ="displayCount"><a href = 'defaultPage.jsp'>10</a></label>
<label id ="displayCount"><a href = '100page.jsp'> 100</a></label>
<label id ="displayCount"><a href = '1000page.jsp'> 1000</a></label>
<label id ="displayCount"><a href = 'allPage.jsp'> All</a></label>


<table id = "infoTable" class = "table table-striped"> 
	<thead>
		<tr>
			
			<th> Entry</th>
			<th> Headline </th>
			<th> Agency </th>
			<th> Date Entered </th>
			<th> Entered By </th>
		</tr>
	</thead>
		<%	
			for(int i = 0; i < numberDisplay;++i){
				Random r = new Random();
				int randNum = r.nextInt(allData.size() -18) + 1;
				out.println("<tr>");
				out.println("<td>" + allData.get(randNum).getRow_position() + "</td>");
				out.println("<td>" + allData.get(randNum).getHeadline() + "</td>");
				out.println("<td>" + allData.get(randNum).getAgency() + "</td>");
				out.println("<td>" + allData.get(randNum).getDateEntered().substring(0,10) + "</td>");
				out.println("<td>" + allData.get(randNum).getEnteredBy() + "</td>");
				out.println("</tr>");
			}
			
			
		
		%>
	<tbody>

				
	</tbody>
	
</table>



</body>
</html>