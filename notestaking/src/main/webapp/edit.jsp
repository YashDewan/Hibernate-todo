<!doctype html>
<%@page import="com.entities.NotesTaking"%>
<%@page import="com.helper.FactorySetup"%>
<%@page import="org.hibernate.Session"%>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Notes Taking Website</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-9ndCyUaIbzAi2FUVXJi0CjmCapSmO7SnpJef0486qhLnuZ2cdeRhO02iuK6FUUVM" crossorigin="anonymous">
  </head>
  <body>
  	<%@include file = "navbar.jsp" %>
  	<div class="container">
  		<%
  		int notesid = Integer.parseInt(request.getParameter("noteid").trim());
  		Session s = FactorySetup.getFactory().openSession();
		NotesTaking nt = (NotesTaking)s.get(NotesTaking.class,notesid);  		
  		%>
  		<h1>Edit your Note!</h1>
	    <form action="EditServlet" method="post">
	      <input value=<%= nt.getId()%> name="noteid" type="hidden">
		  <div class="mb-3">
		    <label for="title" class="form-label">Title</label>
		    <input type="text" class="form-control" name="title" id="title" aria-describedby="emailHelp" value = <%= nt.getTitle() %>>
		  </div>
		  <div class="form-group">
		    <label for="content">Content</label>
		    <textarea class="form-control" name="content" id="content" rows="3"><%= nt.getContent() %></textarea>
		  </div>
		  <br/>
		  <button type="submit" class="btn btn-primary">Save</button>
		  <br/>
		  <br/>
		</form>
  	</div>
  	<%
  	s.close();
  	%>
  	
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js" integrity="sha384-geWF76RCwLtnZ8qwWowPQNguL3RmwHVBC9FhGdlKrxdiJJigb/j/68SIy3Te4Bkz" crossorigin="anonymous"></script>
  </body>
</html>