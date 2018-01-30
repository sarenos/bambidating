<link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet" >
<jsp:include page="insert/footer.jsp"/>

<jsp:include page="insert/header.jsp" />
<body>
    <div class="container">
        <div class="row" style="border:2px solid #cecece;">
            <div class="col-md-4">
                <div class="row">
                    <a href="#profile" onclick="open_profile();" data-toggle="pill">
                        <img alt="Bootstrap Image Preview" src="./resources/img/no-photo_700x400.jpg" width="100px" style="border-radius:50%;">
                    </a>
                </div>
                <div class="row">
                    <label for="userBalance"> Balance: </label> <span id="userBalance"></span>
                    <label for="userRating"> Rating: </label> <span id="userRating"></span>
                </div>
            </div>
            <div class="col-md-8">
            </div>
        </div>
        <div class="row" style="border:2px solid #cecece;">
            <div class="col-md-4">
                <ul class="nav nav-pills nav-stacked">
                  <li role="presentation" class="active"><a href="#dating" data-toggle="pill">Photo Battle</a></li>
                  <li id="favoritesTab" role="presentation"><a href="#favorites" data-toggle="pill">Favorites</a></li>
                  <li id="dialogsTab" role="presentation"><a href="#dialogs" data-toggle="pill">Messages</a></li>
                </ul>
            </div>
            <div class="col-md-8" id="includePage">
                 <div class="tab-content">
                    <div role="tabpanel" class="tab-pane fade" id="profile">
                        <jsp:include page="insert/profile.jsp" />
                    </div>
                    <div role="tabpanel" class="tab-pane fade in active" id="dating">
                        <jsp:include page="insert/dating.jsp" />
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="favorites">
                        <jsp:include page="insert/favorites.jsp" />
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="dialogs">
                        <jsp:include page="insert/dialogs.jsp" />
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="messagePage">
                        <jsp:include page="insert/messagePage.jsp" />
                    </div>
                 </div>
            </div>
        </div>
    </div>
</body>
<script src="${pageContext.request.contextPath}/resources/js/main.js"></script>