<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-12
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="info_user_add_form">
    <div class="form-group">
        <label class="col-md-3 text-center">用户账户：</label>
        <div class="col-md-9">
            <input type="text" name="id" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">用户密码：</label>
        <div class="col-md-9">
            <input type="password" name="pwd" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-3 text-center">用户名称：</label>
        <div class="col-md-9">
            <input type="text" name="name" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">用户身份证号：</label>
        <div class="col-md-9">
            <input type="text" name="code" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">用户驾驶证号：</label>
        <div class="col-md-9">
            <input type="text" name="carCode" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">用户创建时间：</label>
        <div class="col-md-9">
            <input type="date" name="time" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="info_user_add_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $("#info_user_add_submit").click(function () {
            let array = myFromSubmit("#info_user_add_form");
            $.ajax({
                url: "infoUser/insertInfo",
                data: array,
                success: function (data) {
                    myAlert("添加用户信息", "添加用户" + eval(data) ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
