<div class="col-md-5 dating_users" id="datingUserNumber_${param.id}" datingUserId="">
    <div class="row" style="text-align:center;">
            <span id="datingUserName_${param.id}"></span>
            <span id="datingUserAge_${param.id}"></span>
    </div>
    <div class="row">
        <img  class="img-responsive" alt="Bootstrap Image Preview" src="./resources/img/no-photo_700x400.jpg">
    </div>
    <div class="row" style="text-align:center;">
        <button type="button" id="selectDatingUser_${param.id}" onclick="select_dating_user_click_handler(this);" class="btn btn-danger  btn_first">SelectUser</button>
        <button type="button" id="addToFavorite_${param.id}" onclick="add_to_favorite_click_handler(this);" class="btn btn-primary  btn_second" style="display: none;"> addToFavorite</button>
        <button type="button" id="sendMessage_${param.id}" href="#messagePage" data-toggle="pill" onclick="open_dialog_with_user(this);" class="btn btn-primary btn_second" style="display: none;" > sendMessage</button>
        <button type="button" id="showProfile_${param.id}" class="btn btn-primary  btn_second" style="display: none;" > showProfile</button>
    </div>
</div>