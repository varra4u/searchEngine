<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hi there....

<!-- normal Expression Language -->
Expression Language:${name}

<!-- used to skip some special charecters -->
JSTL: <c:out value="${name}"></c:out> 

<!-- Add the JDBC JAR and make sure you have the USERDETAILS table in the data base  -->

<sql:query var="rs" dataSource="jdbc/h2">
select * from userdetails
</sql:query>

<c:forEach var="row" items="${rs.rows}">
    ID ${row.USERID}<br/>
    NAME ${row.USERNAME}<br/>
</c:forEach>

</body>
</html>