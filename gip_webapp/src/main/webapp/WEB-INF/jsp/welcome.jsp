<%@include file="common/header.jspf"%>
<%@include file="common/navigation.jspf"%>
<div class="welcomebg d-flex justify-content-center align-items-center">
	<div class="content text-center">
			<img src="../../../images/wicova_airplanes_logo.png" alt="Logo">
			<br>
			<c:if test="${name != null}">
				<p class="text-white">Welkom ${name}!</p>
			</c:if>
			<br>
			<a href="/list-planes" class="btn btn-primary rounded-pill px-3">Shop</a>
	</div>
</div>
<%@include file="common/footer.jspf"%>

