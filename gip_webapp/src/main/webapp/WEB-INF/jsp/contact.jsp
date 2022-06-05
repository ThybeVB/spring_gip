<%@include file ="common/header.jspf" %>

<div class="welcomebg">
<%@include file ="common/navigation.jspf" %>
    <div class="container">
      <div class="card border-0 mt-5 mx-5 px-3">

       <form name="contactform" action="#" onsubmit="return validateForm(); return false;" class="card-text float-right">
        <h1 class="card-title pt-3">Contacteer ons</h1>
        <hr>

        <div class="col-lg-5">
          <div class="input-group mb-2">
            <div class="input-group-prepend">
              <div class="input-group-text py-3"><i class="fa fa-at"></i></div>
            </div>
            <input type="email" class="form-control" id="inlineFormInputGroup" name="email" placeholder="Je e-mailadres">
          </div>
        </div>

        <div class="col-lg-5">
          <div class="input-group mb-2">
            <div class="input-group-prepend">
              <div class="input-group-text py-3"><i class="fa fa-user"></i></div>
            </div>
            <input type="text" class="form-control" id="inlineFormInputGroup" name="name" placeholder="Je naam">
          </div>
        </div>

        <div class="form-group col-lg-5">
          <label for="comment">Je bericht:</label>
          <textarea class="form-control" rows="5" id="comment" name="message"></textarea>
        </div>

        <div class="input-group col-lg-5 pb-3">
          <div class="custom-file">
            <label class="custom-file-label" for="myfile">Kies een bestand (optioneel)</label>
            <input type="file" class="custom-file-input" id="myfile" name="annex">
          </div>
        </div>
       
        <div class="pb-3 col">
          <input type="hidden" name="form_submitted" value="1">
          <button class="btn btn-primary btn-outline" type="submit">
            Verzenden
          </button>
        </div>

       </form> 
      </div>
    </div>
    
</div>
<%@include file ="common/footer.jspf" %>