<div class="row" id="dating-users">

</div>
<div class="row">
 <div class="col-md-12">
            <jsp:include page="photoBattleUser.jsp">
                <jsp:param name="id" value="0" />
            </jsp:include>
             <div class="col-md-2">
                <button type="button" id="filter" class="btn btn-primary" data-toggle="modal" data-target="#filterModal" data-whatever="@mdo">Filter</button>
                <button type="button" id="showNextDatingUsers" class="btn btn-success" style="display: none;">Show next</button>

                <div class="modal fade" id="filterModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel">
                    <div class="modal-dialog" role="document">
                        <div class="modal-content">
                            <div class="modal-header">
                                <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span
                                            aria-hidden="true">&times;</span></button>
                                <h4 class="modal-title" id="exampleModalLabel">Фильтр</h4>
                            </div>
                            <div class="modal-body">
                                <form role="form" id="filter_form">
                                    <div id="alert_placeholder_r">
                                    </div>
                                    <div class="form-group">
                                        <div class="col-md-6">
                                            <label for="age_min_filter">
                                                Возраст от
                                            </label>
                                            <input id="age_min_filter" min="18" max="100" type="number" class="form-control"/>
                                        </div>
                                        <div class="col-md-6">
                                            <label for="age_max_filter">
                                                до
                                            </label>
                                            <input id="age_max_filter" min="18" max="100" type="number" class="form-control" />
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <label for="sex_filter">Пол</label>
                                        <select id="sex_filter" class="filter form-control">
                                            <option value="ALL">Не указан</option>
                                            <option value="MALE">Мужской</option>
                                            <option value="FEMALE">Женский</option>
                                        </select>
                                    </div>
                                    <div class="form-group checkbox">
                                        <label>
                                            <input id="with_photo_filter" type="checkbox" class="filter" />
                                            Только с фото
                                        </label>
                                    </div>
                                    <div class="modal-footer">
                                        <button type="submit" class="btn btn-primary">Применить</button>
                                        <button type="button" class="btn btn-default" data-dismiss="modal">Закрыть</button>
                                    </div>
                                </form>
                            </div>
                        </div>
                    </div>
                </div>
             </div>
            <jsp:include page="photoBattleUser.jsp">
                <jsp:param name="id" value="1" />
            </jsp:include>

        </div>
</div>