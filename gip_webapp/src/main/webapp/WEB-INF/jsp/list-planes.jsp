<%@include file ="common/header.jspf" %>

<div class="shopbg">
<%@include file ="common/navigation.jspf" %>
<div class="container">
  <h1 class="my-3">Onze vliegtuigen</h1>
  <div class="row">
    <c:forEach items="${planes}" var="plane">
      <c:if test="">
      </c:if>
      <div class="col-12 col-lg-4 pb-4 d-flex align-items-stretch">
        <div class="card">
          <img class="card-img-top" src="../../../plane-photos/${plane.id}/${plane.pictureUrl}" alt=""/>
          <div class="card-body d-flex flex-column">
            <h4 class="card-title mb-0">${plane.brand} ${plane.name}</h4>
            <h6 class="card-subtitle text-muted py-2">
            	<fmt:formatNumber value="${plane.price}" currencySymbol="&euro; " type="currency" maxFractionDigits="2" minIntegerDigits="2"/>
            </h6>
            <p class="card-text">
              ${plane.description}
            </p>
            <div class="mt-auto">
            <c:if test="${name != null}">
              <a href="/update-plane?id=${plane.id}" class="btn btn-outline-dark btn-sm p-2"><i class="fa fa-pen"></i></a>
              <a href="/delete-plane?id=${plane.id}" class="btn btn-outline-dark btn-sm p-2"><i class="fa fa-trash-alt"></i></a>
              <br>              
            </c:if>
            
            <a href="/plane-annuity-dialog?id=${plane.id}" class="btn btn-outline-dark mt-2">Aflossingstabel</a>          
            </div>
  			</div>
        </div>
      </div>
    </c:forEach>
  </div>
  <c:if test="${name != null}">
    <a href="/add-plane" class="btn btn-outline-light p-3 mb-5 rounded-circle"><i class="fa fa-plus"></i></a>
  </c:if>
</div>
</div>
<%@include file ="common/footer.jspf" %>