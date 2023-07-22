<%@page import="java.util.List"%>
<%@page import="org.hibernate.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.helper.FactorySetup"%>
<%@page import="com.entities.NotesTaking" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Show All Notes</title>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
</head>

<body>
<%@include file = "navbar.jsp" %>
<div class="container">
	<br/>
	<h1>All Notes!</h1>
 	<%
	Session s = FactorySetup.getFactory().openSession();
	Query q = s.createQuery("from NotesTaking");
	List<NotesTaking> lst = q.list();
	for(NotesTaking note : lst){
	%>
	<div class="card mt-3 w-100" style="width: 18rem;">
	<div class="card-body">
    	<h5 class="card-title"><%= note.getId() %> - <%= note.getTitle() %></h5>
	    <p class="card-text"><%= note.getContent() %></p>
	    <a href="edit.jsp?noteid=<%= note.getId() %>" class="btn btn-primary">Edit</a>
	    <a href="DeleteServlet?noteid=<%= note.getId() %>" class="btn btn-danger">Delete</a>
  	</div>
	</div>
	<%
	}
	s.close();
	%>
</div>
  	
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  	
</body>
</html>