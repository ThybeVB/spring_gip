<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">

	<h1>(((LIST PLANES)))</h1>
	
	<c:forEach items="${planes}" var="plane">
		<p>${plane.brand} ${plane.name}</p>
		<p>${plane.description}</p>
		<fmt:formatNumber value="${plane.price}" currencySymbol="&euro; " type="currency" maxFractionDigits="2" minIntegerDigits="2"/>
		<a href="/plane-annuity-dialog?id=${plane.id}" class="btn btn-success">Aflossingstabel</a>
		<c:if test="${name != null}">
			<a href="/update-plane?id=${plane.id}" class="btn btn-warning">Bewerk dit vliegtuig</a>
			<a href="/delete-plane?id=${plane.id}" class="btn btn-danger">Verwijder dit vliegtuig</a>
		</c:if>
		<hr />
	</c:forEach>
	
	<div class="card">
            <img class="card-img-top" src="" alt="">
            <div class="card-body">
              <h4 class="card-title mb-0">Naam vliegtuig</h4>
              <h6 class="card-subtitle text-muted py-2">
              </h6>
              <p class="card-text">
               Beschrijving vliegtuig
              </p>
              <a class="btn btn-primary" href="/plane-annuity-dialog?id=${plane.id}">Aflossingstabel</a>
            </div>
          </div>
	
	<c:if test="${name != null}">
		<a href="/add-plane" class="btn btn-primary my-5">Voeg een vliegtuig toe</a>
	</c:if>
	
</div>
<%@include file ="common/footer.jspf" %>