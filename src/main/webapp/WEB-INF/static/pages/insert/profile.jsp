<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/uploader/css/style.css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/uploader/css/jquery.fileupload.css">


<div class="row">
    <div class="col-md-6">

                        <div id="carousel-example-generic" class="carousel slide" data-ride="carousel"
                             data-interval="false">
                            <ol id="car_ol" class="carousel-indicators">
                                <li data-target="#carousel-example-generic" data-slide-to="0" class="active"></li>
                            </ol>
                            <div class="carousel-inner" role="listbox" id="car_inner">
                                <div class="item active no_photo">
                                    <div class="carousel-caption">

                                    </div>
                                </div>
                            </div>

                            <a class="left carousel-control arrow hide" href="#carousel-example-generic" role="button"
                               data-slide="prev">
                                <span class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
                                <span class="sr-only">Previous</span>
                            </a>
                            <a class="right carousel-control arrow hide" href="#carousel-example-generic" role="button"
                               data-slide="next">
                                <span class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
                                <span class="sr-only">Next</span>
                            </a>
                        </div>
                        <button type="button" id="upload_button" class="btn btn-primary center-block"
                                data-toggle="modal" data-target="#photoModal" data-whatever="@mdo">Загрузить фото
                        </button>
    </div>
    <div class="col-md-6">
        <form data-toggle="validator" role="form" id="profile-form" >
            <div class="form-group" id="name-form-group">
                 <label for="nameRegist">Имя</label>
                 <input type="text" maxlength="30" class="form-control" id="nameRegist" placeholder="Name" required>
                 <label class="control-label" id="form-name-label" for="nameRegist" hidden>Input with error</label>
            </div>
            <div class="form-group" id="age-form-group">
                 <label for="ageRegist">Возраст</label>
                 <input type="number" min="14" max="99" class="form-control" id="ageRegist" placeholder="Age" required>
                 <label class="control-label" id="form-name-label" for="ageRegist" hidden>Input with error</label>
            </div>

            <div class="form-group">
                <label for="gender">Пол</label>
                <select id="profile-gender" class="form-control" required>
                    <option value="MALE">Мужской</option>
                    <option value="FEMALE">Женский</option>
                </select>
            </div>
            <div class="form-group hide" id="city_other_div">
                <label for="city_other">Другой город</label>
                <input type="text" id="city_other" class="form-control">
            </div>

            <div class="form-group">
                <button type="submit" id="login-button" class="btn btn-primary">Save</button>
            </div>
            <div class="form-group">
                <div class="alert alert-danger" id="server-errorRegistr-alert" role="alert" hidden>
                    <button type="button" id="close-alertRegistr" class="close" aria-label="Close">
                    <span aria-hidden="true">&times;</span></button>
                    <span>Server Error!</span>
                </div>
            </div>
        </form>
    </div>


                    <div class="modal fade" id="photoModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                        <div class="modal-dialog" role="document">
                            <div class="modal-content">
                                <div class="modal-header">
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                                aria-hidden="true">&times;</span></button>
                                    <h4 class="modal-title" id="exampleModalLabel">Загрузить фото</h4>
                                </div>
                                <div class="modal-body">
                            <span class="btn btn-success fileinput-button">
                                <i class="glyphicon glyphicon-plus"></i>
                                <span>Добавить изображения...</span>
                                <input id="fileupload" type="file" name="files[]" multiple>
                            </span>
                                    <button type="submit" class="btn btn-primary" id="start">
                                        <i class="glyphicon glyphicon-upload"></i>
                                        <span>Начать загрузку</span>
                                    </button>
                                    <br>
                                    <br>
                                    <p id="pr_status"></p>
                                    <div class="progress">
                                        <div id="progress" class="progress-bar progress-bar-striped active" role="progressbar"
                                             aria-valuenow="0" aria-valuemin="0" aria-valuemax="100" style="width:0%">
                                            <span class="sr-only">0%</span>
                                        </div>
                                    </div>
                                    <div class="container">
                                        <div id="alert_placeholder_image" class="custom_alert">
                                        </div>
                                        <table role="presentation" class="table table-striped table_photo_upload">
                                            <tbody class="files" id="files"></tbody>
                                        </table>

                                        <br>
                                    </div>
                                </div>

                            </div>
                        </div>
                    </div>
</div>


<script src="//i.onthe.io/u.js?wjfkb8_24135782"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/vendor/jquery.ui.widget.js"></script>
<script src="//blueimp.github.io/JavaScript-Load-Image/js/load-image.all.min.js"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/jquery.iframe-transport.js"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/jquery.fileupload.js"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/jquery.fileupload-process.js"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/jquery.fileupload-image.js"></script>
<script src="${pageContext.request.contextPath}/resources/uploader/js/jquery.fileupload-validate.js"></script>
<script src="${pageContext.request.contextPath}/resources/js/profile.js"></script>
