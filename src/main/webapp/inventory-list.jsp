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
<title>Inventory List</title>
</head>
<body>
<h1 style="text-align: center;">Inventory List</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form method="post" action="inventoryDetailsNavigationServlet">
			<table>
				<c:forEach items="${requestScope.allInventories}" var="currentInventory">
					<tr>
						<td><input type="radio" name="id" value="${currentInventory.id}"></td>
						<td><h2>${currentInventory.inventoryName}</h2></td>
					</tr>
	
					<tr>
						<td colspan="3">Acquisition Date: ${currentInventory.acquisitionDate}</td>
					</tr>

					<tr>
						<td colspan="3">Model: ${currentInventory.models.modelName}</td>
					</tr>
					<c:forEach var="listVal" items="${currentInventory.listOfDescriptions}">
						<tr><td></td>
							<td colspan="3">
							${listVal.color}, ${listVal.year}, ${listVal.acquisitionDate}
							</td>
						</tr>
					</c:forEach>
				</c:forEach>
		</table>
		<input type="submit" value="edit" name="doThisToInventory">
		<input type="submit" value="delete" name="doThisToInventory">

		</form>
	</div>
</div>
<a href="addDescriptionForListServlet">Create a new Inventory</a><br />
<a href="index.html">Insert a new description</a>
</body>
</html>