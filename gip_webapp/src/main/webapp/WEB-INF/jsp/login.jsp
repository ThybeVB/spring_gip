<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container mt-3">

	${errorMessage}
	<form method="POST">
	
		Name:<input type="text" name="name">
		Password:<input type="password" name="password">
		<input type="submit" value="Submit query"> 	
	
	</form>
	
</div>
	
<%@ include file="common/footer.jspf" %>