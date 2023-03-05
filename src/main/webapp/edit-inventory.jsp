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
<title>Edit an Existing Inventory</title>
</head>
<body>
<h1 style="text-align: center;">Edit an Existing Inventory</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form action="editInventoryDetailsServlet" method="post">
			<input type="hidden" name="id" value="${inventoryToEdit.id}">
			Inventory Name: <input type="text" name="inventoryName" value="${inventoryToEdit.inventoryName}"><br />

			Acquisition Date: <input type="text" name="month" placeholder="mm" size="4" value="${month}">
			<input type="text" name="day" placeholder="dd" size="4" value="${date}">
			<input type="text" name="year" placeholder="yyyy" size="4" value="${year}">

			Model Name: <input type="text" name="modelName" value="${inventoryToEdit.models.modelName}"><br />

			Available Cars:<br />

			<select style="width: 100px;" name="allDescriptionsToAdd" multiple size="6">
			<c:forEach items="${requestScope.allDescriptions}" var="currentDescription">
				<option value="${currentDescription.id}">${currentDescription.color}</option>
			</c:forEach>
			</select>
			<br />
			<input type="submit" value="Edit Inventory and Add Descriptions">
		</form>
	</div>
</div>
<a href="index.html">Add New Models or Descriptions</a>
</body>
</html>