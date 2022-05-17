<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="container-fluid welcomepagebg">
	<div class="row">
		<div class="col-lg-12">
			<c:if test="${name != null}">
				<p>Welkom ${name}!</p>
			</c:if>
			<div class="text-center">
				<a href="/list-planes" class="btn btn-primary rounded-pill px-3">Shop</a>
			</div>
		</div>
	</div>
</div>
<%@include file="common/footer.jspf"%>

