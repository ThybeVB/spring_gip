<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">

	<c:if test="${name != null}">
		<p>Welkom ${name}!</p>
	</c:if>
	<a href="/list-planes">Klik hier</a> om naar de shop te gaan.
</div>

<%@include file="common/footer.jspf"%>