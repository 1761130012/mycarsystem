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
<form class="form-horizontal" id="system_menu_add_form">
    <div class="form-group">
        <label class="col-md-2 text-center">父菜单：</label>
        <div class="col-md-10">
            <input type="hidden" id="system_menu_add_parentIds" name="parentIds">
            <input type="text" id="system_menu_add_parentTitle" class="form-control" readonly>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-2 text-center">菜单名：</label>
        <div class="col-md-10">
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
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="system_menu_add_submit" class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        init();

        function init() {
            //获取 父id
            let parentId = "${param.parentIds}";
            let title;
            if (0 === parseInt(parentId)) {
                title="无父菜单";
            } else {
                $.ajax({
                    url: 'systemMenu/queryMenuTitleParentId',
                    data: {id: parentId},
                    async:false,
                    dataType:"json",
                    success: function (data) {
                        title=data;
                    }
                })
            }
            $("#system_menu_add_parentTitle").val(title);
            $("#system_menu_add_parentIds").val(parentId);
        }

        $("#system_menu_add_submit").click(function () {
            let array=myFromSubmit("#system_menu_add_form");
            $.ajax({
                url:'systemMenu/insertMenu',
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
