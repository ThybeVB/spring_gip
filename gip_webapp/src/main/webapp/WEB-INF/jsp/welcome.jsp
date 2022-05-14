<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">

	<c:if test="${name != null}">
		<p>Welkom ${name}!</p>
	</c:if>
	<a href="/list-sims">Klik hier</a> om een simulatie te maken.
</div>

<%@include file="common/footer.jspf"%>