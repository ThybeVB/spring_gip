<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
	<h1>Your todo's ${name}</h1>
	<table class="table table-striped caption-top">
		<caption>Your todo's are</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target Date</th>
				<th>Is Done?</th>
				<th>UPDATE</th>
				<th>DELETE</th>
			</tr>		
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}" pattern="dd/MM/yyy" /> </td>
					<td>${todo.done}</td>
					<td><a class="btn btn-warning" href="/update-todo?id=${todo.id}" >Update</a> </td>
					<td><a class="btn btn-danger" href="/delete-todo?id=${todo.id}" >Delete</a> </td>			
				</tr>
			</c:forEach>		
		</tbody>
	</table>	
	
	<a class="btn btn-primary" href="/add-todo">Add a todo</a>
	
	</div>
	
<%@ include file="common/footer.jspf" %>	