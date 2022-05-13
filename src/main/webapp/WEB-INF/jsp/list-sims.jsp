<%@include file ="common/header.jspf" %>
<%@include file ="common/navigation.jspf" %>
<div class="container">
	<h1>Simulaties van ${name}</h1>
	<table class="table table-striped caption-top">
		<caption>Alle simulaties</caption>
		<thead>
			<tr>
				<th>Kapitaal</th>
				<th>Looptijd in maanden</th>
				<th>Jaarrente</th>
				<th>Aflossingstabel</th>
				<th>Aanpassen</th>
				<th>Verwijderen</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${sims}" var="sim">
				<tr>
					<td><fmt:formatNumber value="${sim.kapitaal}" currencySymbol="&euro; " type="currency" maxFractionDigits="3" minIntegerDigits="2"/></td>
					<td>${sim.loopTijd}</td>
					<td>${sim.jaarRente}%</td>
					<td><a class="btn btn-success"
						href="/show-simulation?id=${sim.id}">Aflossingstabel</a></td>
					<td><a class="btn btn-warning"
						href="/update-simulation?id=${sim.id}">Pas aan</a></td>
					<td><a class="btn btn-danger" href="/delete-sim?id=${sim.id}">Verwijder</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/simulation" class="btn btn-primary">Voeg een simulatie toe</a>
</div>
<%@include file ="common/footer.jspf" %>