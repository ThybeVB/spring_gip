<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">

	<h1>Voeg een vliegtuig toe:</h1>

	<form:form method="POST" enctype="multipart/form-data" modelAttribute="plane">
		<fieldset class="form-group">
			<form:hidden path="id" />
			<form:label path="brand">Merk:</form:label>
			<form:input path="brand" name="brand" type="text" required="required"
				class="form-control" />
			<form:errors path="brand" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="name">Naam:</form:label>
			<form:input path="name" id="name" class="form-control"
				required="required" type="text"></form:input>
			<form:errors path="name" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="description">Beschrijving:</form:label>
			<form:input path="description" id="description" class="form-control"
				required="required" type="text"></form:input>
			<form:errors path="description" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="pictureUrl">Foto:</form:label>
			<form:input path="pictureUrl" id="pictureUrl" class="form-control"
				required="required" type="file" accept="image/png, image/jpeg" />
			<form:errors path="pictureUrl" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="price">Prijs:</form:label>
			<form:input path="price" id="price" class="form-control"
				required="required" type="number"></form:input>
			<form:errors path="price" cssClass="text-warning"></form:errors>
			<form:hidden path="pmt" />
			<form:hidden path="loopTijd" />
			<form:hidden path="jaarRente" />
		</fieldset>

		<button class="btn btn-success mt-3" type="submit">Voeg toe</button>
	</form:form>
</div>
<%@include file ="common/footer.jspf" %>