<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 10:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="system_staff_update_form">
    <div class="form-group">
        <label class="col-md-2 text-center">员工账户：</label>
        <div class="col-md-10">
            <input type="text" name="id" readonly class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">员工名称：</label>
        <div class="col-md-10">
            <input type="text" name="name" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">员工密码：</label>
        <div class="col-md-10">
            <input type="password" name="pwd" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">员工电话：</label>
        <div class="col-md-10">
            <input type="text" name="phone" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">员工身份证：</label>
        <div class="col-md-10">
            <input type="text" name="identityCard" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">入职时间：</label>
        <div class="col-md-10">
            <input type="date" name="time" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-8 col-md-offset-2 "><input type="button" id="system_staff_update_submit"
                                                      class="btn btn-info form-control" value="修改"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        init();
        function init(){
            //进行 获取数据
            $("#system_staff_update_form").form("load","systemStaff/queryStaffId?id=${param.id}");
        }

        $("#system_staff_update_submit").click(function () {
            //进行 获取 值
            let array = myFromSubmit("#system_staff_update_form");

            //进行添加
            $.ajax({
                url: 'systemStaff/updateStaffId',
                data: array,
                dataType: 'json',
                success: function (data) {
                    myAlert("修改提示:", "修改" + data ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
