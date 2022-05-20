<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="welcomebg">
<div class="container">
	
<div class="d-flex justify-content-center align-items-center">
<div class="card mt-5 rounded col-12">
	<div class= card-body>
	<h4 class="card-title">Aflossingstabel voor ${plane.brand} ${plane.name}</h4>	

	<table class="table table-striped caption-top">
	<caption>Simulatie</caption>
		<thead>
			<tr>
				<th>Kapitaal</th>
				<th>Looptijd in maanden</th>
				<th>Jaarrente</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<td><fmt:formatNumber value="${plane.price}" currencySymbol="&euro;" type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
				<td>${plane.loopTijd}</td>
				<td>${plane.jaarRente}%</td>
			</tr>
		</tbody>
	</table>
	
	<table class="table table-striped caption-top">
		<caption>Aflossingstabel</caption>
		<thead>
			<tr>
				<th>nr aflossing</th>
				<th>termijn</th>
				<th>intrestgedeelte</th>
				<th>kapitaalgedeelte</th>
				<th>schuldsaldo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${aflossingen}" var="aflossing">
				<tr>
					<td>${aflossing.nrAflossing}</td>
					<td><fmt:formatNumber value="${aflossing.payment}" currencySymbol="&euro; " type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
					<td><fmt:formatNumber value="${aflossing.intrestPart}" currencySymbol="&euro; " type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
					<td><fmt:formatNumber value="${aflossing.capitalPart}" currencySymbol="&euro; " type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
					<td><fmt:formatNumber value="${aflossing.debtSaldo}" currencySymbol="&euro; " type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	
	<a href="/list-planes" class="btn btn-outline-dark">Terug naar vliegtuigen</a>
</div>
</div>
</div>
</div>
<%@include file ="common/footer.jspf" %>