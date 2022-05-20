<%@include file ="common/header.jspf" %>

<div class="welcomebg">
<%@include file ="common/navigation.jspf" %>
<div class="container">

<div class="d-flex justify-content-center align-items-center">
<div class="card mt-5 rounded col-md-5">
	<div class= card-body>
	<h4 class="card-title">Pas een vliegtuig aan:</h4>

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
			<form:textarea class="form-control" path="description" id="description" type="text" required="required" rows="3"></form:textarea>
			<form:errors path="description" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="picture">Afbeelding:</form:label>
			<form:input path="picture" id="picture" class="form-control"
 type="file" accept="image/png, image/jpeg" value="../../../plane-photos/${plane.id}/${plane.pictureUrl}"></form:input>
			<form:errors path="picture" cssClass="text-warning"></form:errors>
		</fieldset>
		<fieldset class="form-group">
			<form:label path="price">Prijs:</form:label>
			<form:input path="price" id="price" class="form-control"
				required="required" type="number"></form:input>
			<form:errors path="price" cssClass="text-warning"></form:errors>
			<form:hidden path="pmt" />
			<form:hidden path="loopTijd" />
			<form:hidden path="jaarRente" />
			<form:hidden path="pictureUrl" />
		</fieldset>

		<button class="btn btn-outline-dark mt-3" type="submit">Update</button>
	</form:form>
	</div>
	</div>
	</div>
</div>
</div>
<%@include file ="common/footer.jspf" %>