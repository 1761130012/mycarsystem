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
<form class="form-horizontal" id="system_role_update_form">
    <div class="form-group">
        <label class="col-md-3 text-center">角色名：</label>
        <div class="col-md-9">
            <input type="hidden" name="id">
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
        <div class="col-md-8 col-md-offset-2 "><input type="button" id="system_role_update_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        let form="#system_role_update_form";
        init()
        function init(){
            $(form).form("load","systemRole/queryRoleId?id=${param.id}");
        }

        $("#system_role_update_submit").click(function () {
            let array= myFromSubmit(form)
            $.ajax({
                url:'systemRole/updateRoleId',
                data:array,
                success:function (data) {
                    myAlert("修改提示:", "修改" + data ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
