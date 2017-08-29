<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style>
b{
	display:block;
}
p{
	display:block;
	text-indent:50px;
}
</style>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Data Curation</title>
<jsp:useBean id = "searchBean" class = "xmlParser.searchBean" scope = "application"/>
</head>
<body>
<jsp:include page = "/header.jsp"/>

<div style = "border:2px solid black">
<h1 align = "center"><c:out value = "${searchBean.getDetail().getHeadline()}"/></h1>
<b> Agency: <c:out value = "${searchBean.getDetail().getAgency()}"/> </b>
<b> Date Entered: <c:out value = "${searchBean.getDetail().getDateEntered().substring(0,10)}"/> </b>
<b> City: <c:out value = "${searchBean.getDetail().getCity()}"/> </b>
<b> Entered by: <c:out value = "${searchBean.getDetail().getEnteredBy()}"/> </b>

<br/>
<p> <c:out value = "${searchBean.getDetail().getContent()}"/> </p>
<br/>
<b> Date Last Modified: <c:out value = "${searchBean.getDetail().getDate_last_modified().substring(0,10)}"/> </b>
<b> Contact: <c:out value = "${searchBean.getDetail().getContact1()}"/> </b>
<b> Contact: <c:out value = "${searchBean.getDetail().getContact2()}"/> </b>
</div>

<form action = 'extraction' method = 'GET'>

<input type = "submit" value = "Extract Keywords" />
 <input type = "submit" value = "Extract People" />
  <input type = "submit" value = "Extract Organizations" />
   <input type = "submit" value = "Extract Locations" />
 
 </form>

</body>
</html>