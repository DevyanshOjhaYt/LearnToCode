<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<!--  <form action="add">
		Adding Two Numbers: <br>
		First No:<input type=text name="num1"><br>
		Second No:<input type=text name="num2"><br> 
		<input type="submit">
	</form> -->
	<form action="addStud" method="post">
		Enter Student Details: <br>
		Id:<input type="text" name="id"><br>
		Name:<input type="text" name="name"><br> 
		<input type="submit">
	</form>
	<hr>
	<form action="getStudById" method="get">
		Enter Student Id: <br>
		Id:<input type="text" name="id"><br>
		<input type="submit">
	</form>
	
	<hr>
	<form action="getStudByName" method="get">
		Enter Student Name: <br>
		Name:<input type="text" name="name"><br>
		<input type="submit">
	</form>
	
	<hr>
	
</body>
</html>