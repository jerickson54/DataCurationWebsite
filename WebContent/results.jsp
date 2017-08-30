<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Curation</title>
<jsp:useBean id = "searchBean" class = "xmlParser.searchBean" scope = "application"/>
</head>
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<body>

<jsp:include page = "/header.jsp"/>

<table id = "infoTable" class = "table table-striped"> 
	<thead>
		<tr>
			
			<th> Entry</th>
			<th> Headline </th>
			<th> Agency </th>
			<th>City</th>
			<th> Date Entered </th>
			<th> Entered By </th>
			
		</tr>
	</thead>


<c:if test = "${empty searchBean.getSearchResults()}">
<b>Sorry no matching datasets were found</b>
</c:if>

<c:if test = "${fn:length(searchBean.getSearchResults()) lt 10}">
<c:forEach begin ="${searchBean.getStart()}" end= "${searchBean.getEnd()}" var = "v" items="${searchBean.getSearchResults()}">
		<tr>
			<td>${v.getRow_position()}</td>
			<td><a href = "contentPage?value=${v.getHeadline()}"> ${v.getHeadline()}</a></td>
			<td>${v.getAgency()}</td>
			<td>${v.getCity()}</td>
			<td>${v.getDateEntered().substring(0,10)}</td>
			<td>${v.getEnteredBy()}</td>
			
		</tr>
		</c:forEach>
</c:if>

<c:if test = "${fn:length(searchBean.getSearchResults()) gt 10}">
<c:forEach begin ="${searchBean.getStart()}" end= "${searchBean.getIterateTo()}" var = "v" items="${searchBean.getSearchResults()}">
		<tr>
			<td>${v.getRow_position()}</td>
			<td><a href = "contentPage?value=${v.getHeadline()}"> ${v.getHeadline()}</a></td>
			<td>${v.getAgency()}</td>
			<td>${v.getCity()}</td>
			<td>${v.getDateEntered().substring(0,10)}</td>
			<td>${v.getEnteredBy()}</td>
			
		</tr>
		</c:forEach>
</c:if>

	</table>
	
<form action = 'pageManager' method = 'GET'>


<c:if test = "${searchBean.getStart() != 0}">
<input type = "submit" name = "nextOrPrev" value = "Previous" style = "float:left;"/>
</c:if>

<c:if test = "${fn:length(searchBean.getSearchResults()) gt 10}">
<c:if test = "${searchBean.getDifference() == 9 }">
<input type = "submit" name = "nextOrPrev" value = "Next" style = "float:right;"/>
</c:if>
</c:if>


</form>


</body>
</html>