<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-10
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="system_menu_update_form">
    <div class="form-group">
        <label class="col-md-2 text-center">菜单名：</label>
        <div class="col-md-10">
            <input type="hidden" name="id">
            <input type="text" name="text" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">URL：</label>
        <div class="col-md-10">
            <input type="text" name="url" class="form-control">
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="system_menu_update_submit" class="btn btn-info form-control" value="修改"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        let form="#system_menu_update_form";
        init();
        function init() {
            //获取 父id
            let id = "${param.id}";
                $.ajax({
                    url: 'systemMenu/queryMenuId',
                    data: {id: id},
                    async:false,
                    dataType:"json",
                    success: function (data) {
                        console.log(data)
                        $(form).form("load",data);
                    }
                })
        }

        $("#system_menu_update_submit").click(function () {
            let array=myFromSubmit(form);
            $.ajax({
                url:'systemMenu/updateMenu',
                data:array,
                success:function (data) {
                    myAlert("添加菜单信息","添加菜单"+eval(data)?'成功':'失败'+"!");
                }
            })
        })
    })
</script>
</body>
</html>
