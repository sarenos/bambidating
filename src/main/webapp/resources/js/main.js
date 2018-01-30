 $(document).ready(function () {
         $.ajax({
             url: "./user",
             type: "GET",
             data: {

             },
             beforeSend: function () {

             },
             success: function (data) {
                switch (data.status) {
                    case 1: //SUCCESS
                    $('#nameRegist').val(data.userProfile.name);
                    $('#ageRegist').val(data.userProfile.age);
                    $('#userBalance').text(data.userProfile.balance);
                    $('#userRating').text(data.userProfile.winn);
                    $('#profile-gender').val(data.userProfile.gender);


                            if (data.userProfile.country > 0)
                            {
                                $('#country').val(data.userProfile.country).change();
                            }
                            $('#city_main').attr('user_val', data.userProfile.city);

                                             $('#age_min_filter').val(data.filterModel.minAge);
                                                $('#age_max_filter').val(data.filterModel.maxAge);
                                                $('#sex_filter').val(data.filterModel.gender);
                                                $('#with_photo_filter').prop('checked', data.filterModel.photo == 1);
                                                $('#online_filter').prop('checked', data.filterModel.online == 1);



                            (function worker() {
                              $.ajax({
                                url: './authentication/online',
                                type: "PUT",
                                success: function(data) {
                                },
                                complete: function() {
                                  // Schedule the next request when the current one's complete
                                  setTimeout(worker, 300000);
                                }
                              });
                            })();

                        break;
                    case 2: //SERVER_ERROR
                       $('#server-errorLogin-alert').show();
                        break;
                    case 3: //CLIENT_ERROR
                        showClientError(data);
                        break;
                    case 4: //VALIDATION_ERROR
                         showValidationError(data);
                }
             }
         });
         show_dating_users_click_handler();

              $('#profile-form').submit(profile_update_click_handler);
              $('#showNextDatingUsers').click(show_dating_users_click_handler);
              $('#favoritesTab').click(show_favorite_users_click_handler);
              $('#message-form').submit(send_message_click_handler);
 });



   function profile_update_click_handler() {
       $.ajax({
           url: "./user",
           type: "POST",
           data: {
                 'name' : $('#nameRegist').val(),
                 'age' : $('#ageRegist').val(),
                 'gender':  $('#profile-gender').val(),
                 'country': $('#country').val(),
                 'city': $('#city_main').val() > 0 ? $('#city_main').val() : $('#city_other').attr('city_id'),
           },
           beforeSend: function () {
                $('#profile-form').find('button[type=submit]').attr('disabled','disabled');;
           },
           success: function (data) {
                $('#profile-form').find('button[type=submit]').removeAttr('disabled');
              switch (data.status) {
                  case 1: //SUCCESS
                      break;
                  case 2: //SERVER_ERROR
                     $('#server-errorRegistr-alert').show();
                      break;
                  case 3: //CLIENT_ERROR
                      break;
                  case 4: //VALIDATION_ERROR
              }
           }
       });
       return false;
   }

      function show_dating_users_click_handler() {
          $.ajax({
              url: "./dating",
              type: "GET",
              data: {

              },
              beforeSend: function () {

              },
              success: function (data) {
                 switch (data.status) {
                     case 1: //SUCCESS
                     show_dating_users(data.datingUsersList);

                     $('.dating_users').find(".btn_second").hide()
                     $('.dating_users').find(".btn_first").show()
                     $('#showNextDatingUsers').hide();
                         break;
                     case 2: //SERVER_ERROR
                        $('#server-errorRegistr-alert').show();
                         break;
                     case 3: //CLIENT_ERROR
                         break;
                     case 4: //VALIDATION_ERROR
                 }
              }
          });
          return false;
      }

      function show_dating_users(datingUsersList)
      {
              $.each( datingUsersList, function( i, val ) {
                $('#datingUserNumber_'+ i).attr('datingUserId',val.id);
                $('#datingUserName_' + i).text(val.name);
                $('#datingUserAge_' + i).text(val.age);
              });
      }


      function select_dating_user_click_handler(selectDatingUser) {
      var datingUserId = selectDatingUser.parentNode.parentNode.getAttribute('datingUserId');
          $.ajax({
              url: "./dating",
              type: "POST",
              data: {
                    'winnerUserId' : datingUserId,
              },
              beforeSend: function () {

              },
              success: function (data) {
                 switch (data.status) {
                     case 1: //SUCCESS

                     $('div[datingUserId="'+datingUserId+'"]').find(".btn_second").show()
                     $('.dating_users').find(".btn_first").hide()
                     $('#showNextDatingUsers').show();

                         break;
                     case 2: //SERVER_ERROR
                        $('#server-errorRegistr-alert').show();
                         break;
                     case 3: //CLIENT_ERROR
                         break;
                     case 4: //VALIDATION_ERROR
                 }
              }
          });
          return false;
      }

function add_to_favorite_click_handler(favoriteUser)
{
      var favoriteUserId = favoriteUser.parentNode.parentNode.getAttribute('datingUserId');

          $.ajax({
              url: "./favorite",
              type: "POST",
              data: {
                    'favoriteUserId' : favoriteUserId,
              },
              beforeSend: function () {

              },
              success: function (data) {
                 switch (data.status) {
                     case 1: //SUCCESS

                         break;
                     case 2: //SERVER_ERROR
                        $('#server-errorRegistr-alert').show();
                         break;
                     case 3: //CLIENT_ERROR
                         break;
                     case 4: //VALIDATION_ERROR
                 }
              }
          });
}

function show_favorite_users_click_handler()
{
              $.ajax({
                  url: "./favorite",
                  type: "GET",
                  data: {
                  },
                  beforeSend: function () {

                  },
                  success: function (data) {
                     switch (data.status) {
                         case 1: //SUCCESS

                              var strElemsAppend = "";
                            $.each( data.favoriteUserList, function( i, val ) {
                               strElemsAppend += '<div class="panel-group" id="accordion_'+val.id+'" role="tablist" aria-multiselectable="true">'
                                                  +' <div class="panel panel-default">'
                                                  +    '<div class="panel-heading" role="tab" id="heading_'+val.id+'">'
                                                  +      '<h4 class="panel-title">'
                                                  +        '<a role="button" data-toggle="collapse" data-parent="#accordion_'+val.id+'" href="#collapse_'+val.id+'" aria-expanded="false" aria-controls="collapse_'+val.id+'">'
                                                  +         val.name + '(' + val.age + ')'
                                                  +        '</a>'
                                                  +      '</h4>'
                                                  +   '</div>'
                                                  +    '<div id="collapse_'+val.id+'"" class="panel-collapse collapse" role="tabpanel" aria-labelledby="heading_'+val.id+'">'
                                                  +      '<div class="panel-body">'
                                                  +      'test test'
                                                  +      '</div>'
                                                  +    '</div>'
                                                  +  '</div>'
                                                  +'</div>';
                            });

                      $('#favorite-user').html(strElemsAppend)



                             break;
                         case 2: //SERVER_ERROR
                            $('#server-errorRegistr-alert').show();
                             break;
                         case 3: //CLIENT_ERROR
                             break;
                         case 4: //VALIDATION_ERROR
                     }
                  }
              });
}

function open_dialog_with_user(dialogWithUserId)
{
      var dialogUserId = dialogWithUserId.parentNode.parentNode.getAttribute('datingUserId');
        $('#message-page').attr('messageUserId', dialogUserId);
        $('.nav-pills').find('.active').removeClass('active');
        $('#messagePage').addClass('active');
}


      function send_message_click_handler() {
          $.ajax({
              url: "./message",
              type: "POST",
              data: {
                    'messageText' : $('#messageTest').val(),
                    'toUserId' : $('#message-page').attr("messageUserId")
              },
              beforeSend: function () {

              },
              success: function (data) {
                 switch (data.status) {
                     case 1: //SUCCESS
                         break;
                     case 2: //SERVER_ERROR
                        $('#server-errorRegistr-alert').show();
                         break;
                     case 3: //CLIENT_ERROR
                         break;
                     case 4: //VALIDATION_ERROR
                 }
              }
          });
          return false;
      }
