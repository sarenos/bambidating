
 $(document).ready(function () {



     $('#login-form').submit(login_click_handler);
     $('#register-form').submit(register_click_handler);
     $("#close-alertLogin").click(close_alert_click_handler);
     $("#close-alertRegistr").click(close_alert_click_handler);
 });

 function close_alert_click_handler(){
         $('#server-errorLogin-alert').hide();
         $('#server-errorRegistr-alert').hide();
 }

 function login_click_handler() {
     $.ajax({
         url: "./authentication/login",
         type: "POST",
         data: {
             'email': $('#emailLogin').val(),
             'password': $('#passwordLogin').val()
         },
         beforeSend: function () {
                     $('#server-errorLogin-alert').hide();
                     hideFieldError("password");
                     hideFieldError("email");
         },
         success: function (data) {
            switch (data.status) {
                case 1: //SUCCESS
                    window.location = '/' + data.redirectUrl;
                    break;
                case 2: //SERVER_ERROR
                   $('#server-errorLogin-alert').show();
                    break;
                case 3: //CLIENT_ERROR
                    showClientError("login", data);
                    break;
                case 4: //VALIDATION_ERROR
                     showValidationError("login", data);
            }
         }
     });
     return false;
 }

  function register_click_handler() {
      $.ajax({
          url: "./authentication/registration",
          type: "POST",
          data: {
              'email': $('#emailRegist').val(),
              'name': $('#nameRegist').val(),
              'age': $('#ageRegist').val(),
              'name': $('#nameRegist').val(),
              'gender':  $('input[name=inlineRadioOptions]:checked', '#register-form').val(),
              'password': $('#passwordRegist').val()
          },
          beforeSend: function () {
                      $('#server-errorRegistr-alert').hide();
                      hideFieldError("password");
                      hideFieldError("emailLogin");
          },
          success: function (data) {
             console.log(data);
              switch (data.status) {
                 case 1: //SUCCESS
                     window.location = '/' + data.redirectUrl;
                     break;
                 case 2: //SERVER_ERROR
                    $('#server-errorRegistr-alert').show();
                     break;
                 case 3: //CLIENT_ERROR
                     showClientError("register", data);
                     break;
                 case 4: //VALIDATION_ERROR
                      showValidationError("register", data);
             }
          }
      });
      return false;
  }

 function showClientError(form, data){
    switch (data.clientErrorStatus) {
        case 2: //USER_NOT_FOUND
            showFieldError(form, "emailLogin", data.statusMessage);
            break;
        case 3: //WRONG_PASSWORD
           showFieldError(form, "password", data.statusMessage);
            break;
        case 4: //EMAIL_USED
           showFieldError(form, "emailRegist", data.statusMessage);
            break;
    }
 }

  function showValidationError(form, data){
        $.each( data.validateArrors, function( i, val ) {
            showFieldError(form, val.fieldName, val.errorMessage);
        });
    }

  function showFieldError(form, fieldName, errorMessage){
            $('#' + form + ' #' + fieldName + '-form-group').addClass("has-error");
            $('#' + form + ' form-' + fieldName + '-label').text(errorMessage);
            $('#' + form + ' form-' + fieldName +'-label').show();
  }

    function hideFieldError(fieldName){
              $('#' + fieldName + '-form-group').removeClass("has-error");
              $('#form-' + fieldName + '-label').text("");
              $('#form-' + fieldName +'-label').hide();
    }
