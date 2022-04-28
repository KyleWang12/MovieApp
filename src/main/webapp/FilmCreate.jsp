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
<title>Create a Film</title>
</head>
<body>
	<div class="container theme-showcase" role="main">
	
	<div class="jumbotron">
	<h1>Create Film</h1>
	</div>
	<form action="filmcreate" method="post">
		<p>
			<h2><label for="filmName">FilmName</label></h2>
			<input id="filmName" name="filmName" value="">
		</p>
		<p>
			<h2><label for="tconst">Tconst</label></h2>
			<input id="tconst" name="tconst" value="">
		</p>
		<p>
			<h2><label for="releaseDate">ReleasedYear</label></h2>
			<input id="releaseDate" name="releaseDate" value="">
		</p>
		<p>
			<h2><label for="isAdult">isAdult</label></h2>
			<input id="isAdult" name="isAdult" value="">
		</p>
		<p>
			<h2><label for="title">Title</label></h2>
			<input id="title" name="title" value="">
		</p>
		<p>
			<input type="submit" class="btn btn-lg btn-primary">
		</p>
	</form>
	<br/><br/>
	<p>
		<div class="alert alert-success" role="alert">
		<span id="successMessage"><b>${messages.success}</b></span>
		</div>
	</p>
	
	</div>
	
    
</body>
</html>