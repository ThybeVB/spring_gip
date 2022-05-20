<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="welcomebg">
<div class="container">

<div class="d-flex justify-content-center align-items-center">
<div class="card mt-5 rounded col-md-5">
	<div class= card-body>
	<h4 class="card-title">Een aflossingstabel opvragen voor de ${plane.brand} ${plane.name}</h4>

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

		<button class="btn btn-outline-dark mt-3" type="submit">Vraag op</button>
	</form:form>
	</div>
	</div>
	</div>
</div>
</div>
<%@include file ="common/footer.jspf" %>