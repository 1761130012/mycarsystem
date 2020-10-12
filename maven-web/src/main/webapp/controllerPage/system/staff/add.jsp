<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 10:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="system_staff_add_form">
    <div class="form-group">
        <label class="col-md-3 text-center">员工账户：</label>
        <div class="col-md-9">
            <input type="text" name="id" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">员工名称：</label>
        <div class="col-md-9">
            <input type="text" name="name" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">员工密码：</label>
        <div class="col-md-9">
            <input type="password" name="pwd" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">员工电话：</label>
        <div class="col-md-9">
            <input type="text" name="phone" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">员工身份证：</label>
        <div class="col-md-9">
            <input type="text" name="identityCard" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">入职时间：</label>
        <div class="col-md-9">
            <input type="date" name="time" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-8 col-md-offset-2 "><input type="button" id="system_staff_add_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $("#system_staff_add_submit").click(function () {
            //进行 获取 值
            let array = myFromSubmit("#system_staff_add_form");

            //进行添加
            $.ajax({
                url: 'systemStaff/insertStaff',
                data: array,
                dataType: 'json',
                success: function (data) {
                    myAlert("添加提示:", "添加" + data ? '成功' : '失败' + "!");
                    //关闭
                    myDialogModalHide();
                }
            })
        })
    })
</script>
</body>
</html>
