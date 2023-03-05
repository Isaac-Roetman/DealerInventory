<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style>
* {
	box-sizing: border-box;
}
.row {
	display: flex;
}
.column {
	flex: 50%;
	padding: 10px;
	height: 300px;
	margin: 10px;
}
body {
	background-color: lightblue;
}
a {
	color: black;
	font-family: Arial, Helvetica, sans-serif;
}
input {
	margin-bottom: 10px;
}
</style>
<title>Create a new Inventory</title>
</head>
<body>
<h1 style="text-align: center;">Create a new Inventory</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form action="createNewInventoryServlet" method="post">
			Buyer Name: <input type="text" name="inventoryName"><br />
			Acquisition Date: <input type="text" name="month" placeholder="mm" size="4">
			<input type="text" name="day" placeholder="dd" size="4">
			<input type="text" name="year" placeholder="yyyy" size="4">
			Model : <input type="text" name="modelName"><br />

			Available Cars:<br />
			<select style="width: 100px;" name="allDescriptionsToAdd" multiple size="6">
				<c:forEach items="${requestScope.allDescriptions}" var="currentdescription">
					<option style="color: black" value="${currentDescription.id}">${currentDescription.name}</option>
				</c:forEach>
			</select>
			<br />
			<input type="submit" value="Create Inventory and Add Cars">
		</form>
	</div>
</div>
<a href="index.html">Or Add Models or Descriptions</a>
</body>
</html>