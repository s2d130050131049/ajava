<%@ page import="java.sql.*, java.util.*" %>
<%@ page import="javax.servlet.http.*, javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<html>
	<head><title>Employee Information</title></head>
	<body>
	
		<sql:setDataSource var="snapshot" driver="org.postgresql.Driver"
			url="jdbc:postgresql://127.0.0.1:5433/s2d130050131049"
			user="postgres" password="postgres" />
		
		<c:set var="temp" value="${param.emp_id}"/>
		<%
			String tempID = pageContext.getAttribute("temp").toString();
			int emp_id = Integer.parseInt(tempID);
			pageContext.setAttribute("emp_id", emp_id);
		%>
		
		
		<sql:query dataSource="${snapshot}" var="result">
			SELECT emp_id from employees;
		</sql:query>
		
		<c:set var="flag" value="false"/> <!-- for checking if the id already exists we use a boolean flag -->
		<c:forEach var="row" items="${result.rows}">
			<c:if test="${row.emp_id eq emp_id}">
				<c:set var="flag" value="true"/>
			</c:if>
		</c:forEach>
		
		<c:choose>
			<c:when test="${flag eq 'false'}">
				<sql:update dataSource="${snapshot}" var="result">
					INSERT INTO employees(emp_id, emp_name) VALUES (?, ?)
					<sql:param value="${emp_id}"/>
					<sql:param value="${param.emp_name}"/>
				</sql:update>
				<% RequestDispatcher rd = request.getRequestDispatcher("EmployeeInformation.jsp"); 
					rd.include(request, response);	
				%>
					<h2 align="center">Data successfully inserted.</h2>
			</c:when>
			<c:otherwise>
				<script type="text/javascript">
					alert("This Emp ID already exists.");
				</script>
			</c:otherwise>
		</c:choose>
	</body>
</html>