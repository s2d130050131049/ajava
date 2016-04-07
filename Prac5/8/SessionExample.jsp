<%@ page language="java"
         contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<html>
	<head><title>session Example</title></head>
	<body>
	<% 
		session.setAttribute("name", "Alay");
	%>
		<h4>Enroll no: 130050131049</h4>
		Name is: <% out.println(session.getAttribute("name")); %>
		Session Creation time: <%=session.getCreationTime()%>
	</body>
</html>