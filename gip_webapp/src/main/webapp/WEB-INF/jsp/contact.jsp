<%@include file ="common/header.jspf" %>

<div class="contactbg">
<%@include file ="common/navigation.jspf" %>
    <div class="container d-flex justify-content-center align-items-center">
      <div class="card border-0 mt-5 mx-5 px-3 col-lg-7">

       <form:form method="POST" enctype="multipart/form-data" modelAttribute="contactform" class="card-text float-right">
       <form:hidden path="id" />
       
        <h1 class="card-title pt-3">Contacteer ons</h1>
        <hr>

        <div class="col-lg">
          <div class="input-group mb-2">
            <div class="input-group-prepend">
              <div class="input-group-text py-3"><i class="fa fa-at"></i></div>
            </div>
            <form:input path="email" type="email" class="form-control" name="email" placeholder="Je e-mailadres" required="required" />
          	<form:errors path="email" cssClass="text-warning"></form:errors>
          </div>
        </div>

        <div class="col-lg">
          <div class="input-group mb-2">
            <div class="input-group-prepend">
              <div class="input-group-text py-3"><i class="fa fa-user"></i></div>
            </div>
            <form:input path="name" type="text" class="form-control" name="name" placeholder="Je naam" required="required" />
          	<form:errors path="name" cssClass="text-warning"></form:errors>
          </div>
        </div>

        <div class="form-group col-lg">
          <label for="message">Je bericht:</label>
          <form:textarea class="form-control" path="message" id="message" type="text" required="required" rows="5"></form:textarea>
		  <form:errors path="message" cssClass="text-warning"></form:errors>
        </div>

        <div class="input-group col-lg py-3">
          <div class="custom-file">
            <label class="custom-file-label" for="myfile">Kies een bestand (optioneel):</label>
            <form:input type="file" class="custom-file-input form-control" path="picture" id="picture" name="picture" />
            <form:errors path="picture" cssClass="text-warning"></form:errors>
          </div>
        </div>
       
        <div class="pb-3 col-lg">
          <button class="btn btn-primary btn-outline" type="submit">
            Verzenden
          </button>
        </div>

       </form:form> 
      </div>
    </div>
    
</div>
<%@include file ="common/footer.jspf" %>