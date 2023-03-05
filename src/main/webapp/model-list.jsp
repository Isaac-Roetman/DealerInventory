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
<title>Model List</title>
</head>
<body>
<h1 style="text-align: center;">Model List</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form method = "post" action="modelNavigationServlet">
			<table>
				<c:forEach items = "${requestScope.allModels}" var = "currentModel">
					<tr>
						<td><input type = "radio" name="id" value="${currentModel.id}"> </td>
						<td>${currentModel.modelName}</td>
					</tr>
				</c:forEach>
			</table>
			<input type ="submit" value = "edit" name="doThisToModel">
			<input type ="submit" value = "delete" name="doThisToModel">
			<input type ="submit" value = "add" name="doThisToModel">
		</form>
	</div>
</div>

</body>
</html>