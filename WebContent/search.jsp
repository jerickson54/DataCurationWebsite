<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ page import="xmlParser.*, java.util.*"%>
     
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>



<style>
#searchBar{

margin-bottom: 12px;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Curation</title>
</head>
<body>

<jsp:include page = "/header.jsp"/>


<form action = 'xmlServlet' method = 'GET'>

<label>Search Type: 
<select id ="searchType" name = "searchType">
<option value = "Agency" >Agency</option>
<option value = "Headline">Headline</option>
<option value = "Date">Date</option>
<option value = "City">City</option>
<option value = "Contact Name"> Contact Name</option>
<option value = "Advanced"> Advanced Search</option>



</select></label>

<input type = "text" id = "searchBar" name = "searchInput" placeholder = "Search: " />
 <input type = "submit" value = "Search" />
 
 
 </form>
 
 <b> * Please note that date follows this form: year-month-day, xxxx-xx-xx</b>
 <br/>
 <b> * Please also note that advanced search searches context with regard to containing user input</b>



</body>
</html>