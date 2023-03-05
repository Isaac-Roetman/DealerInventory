<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
<title>Edit a Model</title>
</head>
<body>
<h1 style="text-align: center;">Edit a Model</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<form action = "editModelServlet" method="post">
			Name: <input type = "text" name = "modelName" value = "${modelToEdit.modelName}">
			<input type = "hidden" name = "id" value = "${modelToEdit.id}">
			<input type="submit" value = "Save Item">
		</form>
	</div>
</div>
</body>
</html>