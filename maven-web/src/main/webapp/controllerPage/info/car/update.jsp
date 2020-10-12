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
<form class="form-horizontal" id="info_user_update_form">
    <div class="form-group">
        <label class="col-md-3 text-center">用户账户：</label>
        <div class="col-md-9">
            <input type="text" readonly name="id" class="form-control"/>
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
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="info_user_update_submit"
                                                      class="btn btn-info form-control" value="修改"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        let from = "#info_user_update_form";
        init();
        $("#info_user_update_submit").click(function () {
            let array = myFromSubmit(from);
            $.ajax({
                url: "infoUser/updateInfoUser",
                data: array,
                success: function (data) {
                    myAlert("添加用户信息", "添加用户" + eval(data) ? '成功' : '失败' + "!");
                }
            })
        })

        function init() {
            //进行 填充
            $(from).form("load", "infoUser/queryInfoUserId?id=${param.id}");
        }
    })
</script>
</body>
</html>
