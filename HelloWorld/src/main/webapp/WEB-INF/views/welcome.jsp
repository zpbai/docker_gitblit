<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<title>Spring 4 MVC Hello World Example with Maven Eclipse</title>
<link rel='stylesheet' href='<c:url value="/resources/css/style.css" />'
	type='text/css' media='all' />
</head>
<body>
	<h2>Hello World, Spring MVC</h2>

	<p>Welcome, ${name}</p>

	<form action="${pageContext.request.contextPath}/add" method="post">
		<input name="user">
		<input type="submit" value="Add User" />
	</form>
</body>
</html>