<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Find Films</title>
</head>
<body>
    <div class="container theme-showcase" role="main">
    
	<form action="findannualgross" method="post">
	    <div class="jumbotron">
		<h1>Search the Annual Gross for a Film!</h1>
		</div>
		<p>
			<h2><label for="filmname">Please Enter Film Name</label></h2>
			<input id="filmname" name="filmname" value="${fn:escapeXml(param.filmname)}">
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-primary">
			<br/><br/>
		</p>
	</form>
	<div class="alert alert-info" role="alert">
	<h2><span id="successMessage"><b>${messages.success}</b></span></h2>
	</div>
	<br/>
	<h1>Results: </h1>
        <table class="table table-striped">
            <thead><tr>
                <th>AnnualGrossId</th>
                <th>Year</th>
                <th>FilmName</th>
                <th>Gross</th>
                <th>TotalGross</th>
                <th>Theaters</th>
                <th>DistributorName</th>
            </tr></thead>
            <c:forEach items="${annualGrosses}" var="annualGross" >
                <tbody><tr>
                    <td><c:out value="${annualGross.getAnnualGrossId()}" /></td>
                    <td><c:out value="${annualGross.getYear()}" /></td>
                    <td><c:out value="${annualGross.getFilmName()}" /></td>
                    <td><c:out value="${annualGross.getGross()}" /></td>
                    <td><c:out value="${annualGross.getTotalGross()}" /></td>
                    <td><c:out value="${annualGross.getTheaters()}" /></td>
                    <td><c:out value="${annualGross.getDistributorName()}" /></td>
                </tr></tbody>
            </c:forEach>
       </table>
       
    </div>
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
       
</body>
</html>