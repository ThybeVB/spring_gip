<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">
	<h1>Your todo's</h1>
	<table class="table table-striped caption-top">
		<caption>Your todo's are:</caption>
		<thead>
			<tr>
				<th>Description</th>
				<th>Target date</th>
				<th>Is it done?</th>
				<th>Update</th>
				<th>Delete</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${todos}" var="todo">
				<tr>
					<td>${todo.desc}</td>
					<td><fmt:formatDate value="${todo.targetDate}"
							pattern="dd/MM/yyyy" /></td>
					<td>${todo.done}</td>
					<td><a class="btn btn-warning"
						href="/update-todo?id=${todo.id}">Update</a></td>
					<td><a class="btn btn-danger"
						href="/delete-todo?id=${todo.id}">DELETE</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/todo" class="btn btn-primary">Add a todo</a>
</div>
<%@include file ="common/footer.jspf" %>