<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">

	<h1>Voeg een nieuwe simulatie toe:</h1>

	<form:form method="POST" modelAttribute="sim">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="kapitaal">Kapitaal</form:label>
			<form:input path="kapitaal" name="kapitaal" type="number" required="required"
				class="form-control" />
			<form:errors path="kapitaal" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="loopTijd">Looptijd</form:label>
			<form:input path="loopTijd" id="loopTijd" class="form-control"
				required="required" type="number"></form:input>
			<form:errors path="loopTijd" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="jaarRente">Jaarrente</form:label>
			<form:input path="jaarRente" id="jaarRente" class="form-control"
				required="required" type="number"></form:input>
			<form:errors path="jaarRente" cssClass="text-warning"></form:errors>
		</fieldset>

		<button class="btn btn-success mt-3" type="submit">Add</button>
	</form:form>
</div>
<%@include file ="common/footer.jspf" %>