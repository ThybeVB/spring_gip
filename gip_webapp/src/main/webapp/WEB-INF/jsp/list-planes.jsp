<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">

	<h1>(((LIST PLANES)))</h1>
	
	<c:forEach items="${planes}" var="plane">
		<p>${plane.brand} ${plane.name}</p>
		<p>${plane.description}</p>
		<fmt:formatNumber value="${plane.price}" currencySymbol="&euro; " type="currency" maxFractionDigits="2" minIntegerDigits="2"/>
		<a href="/moetditnogmaken" class="btn btn-success">Aflossingstabel</a>
		<c:if test="${name != null}">
			<a href="/update-plane?id=${plane.id}" class="btn btn-warning">Bewerk dit vliegtuig</a>
			<a href="/delete-plane?id=${plane.id}" class="btn btn-danger">Verwijder dit vliegtuig</a>
		</c:if>
		<hr />
	</c:forEach>
	
	<c:if test="${name != null}">
		<a href="/add-plane" class="btn btn-primary mb-5">Voeg een vliegtuig toe</a>
	</c:if>
	
</div>
<%@include file ="common/footer.jspf" %>