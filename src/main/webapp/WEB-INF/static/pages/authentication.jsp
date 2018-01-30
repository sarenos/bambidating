<jsp:include page="insert/header.jsp" />
<link href="${pageContext.request.contextPath}/resources/css/authentication.css" rel="stylesheet" >
<body>
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="login-register-form-section">

            <div class="panel panel-default">

                    <ul class="nav nav-tabs" role="tablist">
                        <li class="active"><a href="#login" data-toggle="tab">Login</a></li>
                        <li><a href="#register" data-toggle="tab">Register</a></li>
                    </ul>

                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="login">
                            <form data-toggle="validator" role="form" id="login-form">
                                <div class="form-group" id="email-form-group">
                                     <input type="email" maxlength="255" class="form-control" id="emailLogin" placeholder="Email" required>
                                     <label class="control-label" id="form-emailLogin-label" for="emailLogin" hidden>Input with error</label>
                                </div>
                                <div class="form-group" id="password-form-group">
                                  <input type="password" minlength="5" class="form-control" id="passwordLogin" placeholder="Password" required>
                                  <label class="control-label" id="form-password-label" for="passwordLogin" hidden>Input with error</label>
                                </div>
                                <div class="form-group">
                                    <button type="submit" id="login-button" class="btn btn-primary">Login</button>
                                </div>
                                <div class="form-group">
                                    <div class="alert alert-danger" id="server-errorLogin-alert" role="alert" hidden>
                                        <button type="button" id="close-alertLogin" class="close" aria-label="Close">
                                        <span aria-hidden="true">&times;</span></button>
                                        <span>Server Error!</span>
                                    </div>
                                </div>
                            </form>
                        </div>
                        <div role="tabpanel" class="tab-pane fade" id="register">
                            <form data-toggle="validator" role="form" id="register-form" >
                                <div class="form-group" id="email-form-group">
                                     <input type="email" maxlength="255" class="form-control" id="emailRegist" placeholder="Email" required>
                                     <label class="control-label" id="form-emailRegist-label" for="emailRegist" hidden>Input with error</label>
                                </div>
                                <div class="form-group" id="password-form-group">
                                  <input type="password" minlength="5" class="form-control" id="passwordRegist" placeholder="Password" required>
                                  <label class="control-label" id="form-password-label" for="passwordRegist" hidden>Input with error</label>
                                </div>
                                <div class="form-group" id="name-form-group">
                                     <input type="text" maxlength="30" class="form-control" id="nameRegist" placeholder="Name" required>
                                     <label class="control-label" id="form-name-label" for="nameRegist" hidden>Input with error</label>
                                </div>
                                <div class="form-group" id="name-form-group">
                                     <input type="number" min="14" max="99" class="form-control" id="ageRegist" placeholder="Age" required>
                                     <label class="control-label" id="form-name-label" for="ageRegist" hidden>Input with error</label>
                                </div>
                                <div class="form-group">
                                <label class="radio-inline">
                                  <input type="radio"  name="inlineRadioOptions" id="inlineRadio1" value="MALE" required> Male
                                </label>
                                <label class="radio-inline">
                                  <input type="radio" name="inlineRadioOptions" id="inlineRadio2" value="FEMALE" required> Fimale
                                </label>
                                </div>
                                <div class="form-group">
                                    <button type="submit" id="register-button" class="btn btn-primary">Register</button>
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
                    </div>
                  </div>
                </div>
            </div>
        </div>
    </div>
</body>
<jsp:include page="insert/footer.jsp"/>
