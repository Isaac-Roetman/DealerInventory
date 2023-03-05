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
<title>Edit a Description</title>
</head>
<body>
<h1 style = "text-align: center;">Edit a Description</h1>

<div class="row">
	<div class="column" style="background-color: white;">
		<h2>Edit a Car Description</h2>
		<form action = "editDescriptionServlet" method="post">
			Color: <input type = "text" name = "color" value = "${descriptionToEdit.color}">
			Year: <input type = "text" name = "year" value = "${descriptionToEdit.year}">
			Acquisition Date: <input type = "text" name = "acquisitionDate" value = "${descriptionToEdit.acquisitionDate}">
 			<input type = "hidden" name = "id" value = "${descriptionToEdit.id}">
			<input type="submit" value = "Save Edited Item">
		</form>
	</div>
</div>
</body>
</html>