<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">
	<form:form method="POST" modelAttribute="todo">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="desc">Description</form:label>
			<form:input path="desc" name="desc" types="text" required="required"
				class="form-control" />
			<form:errors path="desc" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="targetDate">Target date:</form:label>
			<form:input path="targetDate" id="targetDate" class="form-control"
				required="required" type="text"></form:input>
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>
		</fieldset>

		<button class="btn btn-success mt-3" type="submit">Add</button>
	</form:form>
</div>
<%@include file ="common/footer.jspf" %>