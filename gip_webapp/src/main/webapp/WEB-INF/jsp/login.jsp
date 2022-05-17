<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">
	<form:form method="POST" modelAttribute="user">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="name">Gebruikersnaam:</form:label>
			<form:input path="name" name="name" type="text" required="required"
				class="form-control" />
			<form:errors path="name" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="password">Paswoord:</form:label>
			<form:input path="password" id="password" class="form-control"
				required="required" type="password"></form:input>
			<form:errors path="password" cssClass="text-warning"></form:errors>
		</fieldset>
		<button class="btn btn-success mt-3" type="submit">Login</button>
	</form:form>
</div>

<%@include file="common/footer.jspf"%>