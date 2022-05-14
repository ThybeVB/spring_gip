<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container">

	<c:if test="${name != null}">
		<p>abc</p>
	</c:if>
	<p>
		Welkom ${name}!! <a href="/list-sims">Klik hier</a> om een simulatie te maken.
	</p>
</div>

<%@include file="common/footer.jspf"%>