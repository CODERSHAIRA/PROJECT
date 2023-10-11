<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
	<head>
		<link href=" webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	    <title>List Todos Page</title>
	    
	</head>
	<! the use of class container is to centered the contents and we remove everyhing because it contains the contents in the container > 
	<! Similarly bootstrap provides a number of classes for your tables as well >
	<body>
	 
	   <div class="container">
		
		<h1>Your Todos are:</h1>
		<table class= "table">
		
		<thead>
			<th>Description</th>
			<th>Target Date</th>
			<th>Is Done?</th>
			<th></th>
			<th></th>
		</thead>
		<tbody>
		
		</tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.description}</td>
					<td>${todo.targetDate}</td>
					<td>${todo.done}</td>
				    <td><a href="delete-todo?id=${todo.id}" class="btn btn-warning">Delete</a></td>
					<td><a href="update-todo?id=${todo.id}" class="btn btn-success">Update</a></td>
				</tr>
			</c:forEach>
		</table>
		<a href="add-todo" class="btn btn-success">Add Todo</a>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.min.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		
 
	</body>
</html>