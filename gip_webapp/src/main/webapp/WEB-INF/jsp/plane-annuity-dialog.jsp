<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="welcomebg">
<div class="container">

	<h1>Een aflossingstabel opvragen voor de ${plane.brand} ${plane.name}</h1>

	<form:form method="POST" modelAttribute="plane">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:input path="price" name="price" type="hidden" required="required"
				class="form-control" value="${plane.price}" />
			<form:errors path="price" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="pmt">Prijs</form:label>
			<form:input path="pmt" name="pmt" type="number" required="required"
				class="form-control" readonly="true" value="${plane.price}" />
			<form:errors path="pmt" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="loopTijd">Looptijd in maanden</form:label>
			<form:input path="loopTijd" name="loopTijd" type="number" required="required"
				class="form-control" />
			<form:errors path="loopTijd" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="jaarRente">Jaarrente</form:label>
			<form:input path="jaarRente" name="jaarRente" type="number" required="required"
				class="form-control" step="0.001" />
			<form:errors path="jaarRente" cssClass="text-warning"></form:errors>
		</fieldset>

		<button class="btn btn-success mt-3" type="submit">Vraag op</button>
	</form:form>
</div>
</div>
<%@include file ="common/footer.jspf" %>