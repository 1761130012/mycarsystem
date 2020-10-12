<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 17:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div id="system_role_toolbar">
                <input type="button" id='system_role_add' data-discern-code="add" class='disabled btn btn-info'
                       value="添加"/>
                <input type='button' id='system_role_update' data-discern-code="update" class='disabled btn btn-info'
                       value='修改'/>
                <input type='button' id='system_role_delete' data-discern-code="delete" class='disabled btn btn-danger'
                       value='删除'/>
            </div>
            <table id="system_role_table"></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        let headUrl = "controllerPage/system/";
        let roleTable = "#system_role_table";

        init();

        function init() {
            removeClassDisabledButton("${param.tabId}", ["#system_role_add",
                "#system_role_update",
                "#system_role_delete"]);

            $(roleTable).bootstrapTable({
                url: "systemRole/queryAll",
                clickToSelect: true,
                toolbar: "#system_role_toolbar",//自定义工具栏
                showRefresh: true,//刷新
                singleSelect: true,
                columns: [
                    {checkbox: true},
                    {field: "id", title: "编号"},
                    {field: "name", title: "角色名"},
                    {field: "remark", title: "备注"}
                ]
            })
        }

        $("#system_role_add").click(function () {
            if (myDisabledButton(this)) {
                myDialogModal("添加角色信息", headUrl + "role/add.jsp")
            }

        })

        $("#system_role_update").click(function () {
            let row = myIsSelectRowTable(roleTable);
            if (myDisabledButton(this) && row !== 0) {
                myDialogModal("修改角色信息", headUrl + "role/update.jsp?id=" + row[0].id)
            }
        })
        $("#system_role_delete").click(function () {
            let row = myIsSelectRowTable(roleTable);
            if (myDisabledButton(this) && row !== 0) {
                myConfirm("删除提示：", "是否删除角色：" + row[0].name, function (t) {
                    if (t) {
                        $.ajax({
                            url: 'systemRole/deleteId',
                            data: {id: row[0].id},
                            success: function (data) {
                                myAlert("删除提示", "删除" + data ? '成功' : '失败' + "!")
                            }
                        })
                    }
                })
            }
        })
    })
</script>
</body>
</html>
