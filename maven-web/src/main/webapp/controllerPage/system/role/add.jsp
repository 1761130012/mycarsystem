<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 17:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="system_role_add_form">
    <div class="form-group">
        <label class="col-md-3 text-center">角色名：</label>
        <div class="col-md-9">
            <input type="text" name="name" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">备注：</label>
        <div class="col-md-9">
            <input type="text" name="remark" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-8 col-md-offset-2 "><input type="button" id="system_role_add_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $("#system_role_add_submit").click(function () {
           let array= myFromSubmit("#system_role_add_form")
            $.ajax({
                url:'systemRole/insertRole',
                data:array,
                success:function (data) {
                    myAlert("添加提示:", "添加" + data ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
