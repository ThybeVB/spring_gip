<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

	<div class="container">
		
		<form:form method="post" modelAttribute="todo" >
			<fieldset class="form-group">
			
			<form:hidden path="id"/>
			<form:label path="desc">Description:</form:label> 
			<form:input path="desc" type="text" name="desc" class="form-control" required="required"/>
			<form:errors path="desc" cssClass="text-warning"></form:errors>	
			
			</fieldset>
			
			<fieldset class="form-group">
			
			<form:label path="targetDate">Target Date:</form:label> 
			<form:input path="targetDate" type="text" name="targetDate" class="form-control" required="required"/>
			<form:errors path="targetDate" cssClass="text-warning"></form:errors>	
			
			</fieldset>
			
			
			<input type="submit" value="Verzenden" class="btn btn-success mt-3">
		</form:form>
		${todo}	
	</div>
<%@ include file="common/footer.jspf" %>	
	