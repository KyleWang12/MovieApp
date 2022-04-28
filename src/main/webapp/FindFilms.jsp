<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<!-- Bootstrap -->
<link href="css/bootstrap.min.css" rel="stylesheet">
<title>Find Films</title>
</head>
<body>
    <div class="container theme-showcase" role="main">
    
	<form action="findfilms" method="post">
	    <div class="jumbotron">
		<h1>Search for a Film!</h1>
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
	<div id="filmCreate"><h3><a href="filmcreate">Create Film</a></h3></div>
	<br/>
	<div class="alert alert-info" role="alert">
	<h2><span id="successMessage"><b>${messages.success}</b></span></h2>
	</div>
	<br/>
	<h1>Matching Films</h1>
        <table class="table table-striped">
            <thead><tr>
                <th>Tconst</th>
                <th>FilmName</th>
                <th>ReleaseDate</th>
                <th>isAdult</th>
                <th>title</th>
                <th>Delete Film</th>
                <th>Update Film</th>
            </tr></thead>
            <c:forEach items="${films}" var="film" >
                <tbody><tr>
                    <td><c:out value="${film.getTconst()}" /></td>
                    <td><c:out value="${film.getFilmName()}" /></td>
                    <td><c:out value="${film.getReleaseDate()}" /></td>
                    <td><c:out value="${film.isAdult()}" /></td>
                    <td><c:out value="${film.getTitle()}" /></td>
                    <td><a href="filmdelete?tconst=<c:out value="${film.getTconst()}"/>">Delete</a></td>
                    <td><a href="filmupdate?tconst=<c:out value="${film.getTconst()}"/>">Update</a></td>
                </tr></tbody>
            </c:forEach>
       </table>
       
    </div>
     
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <!-- Include all compiled plugins (below), or include individual files as needed -->
    <script src="js/bootstrap.min.js"></script>
       
</body>
</html>