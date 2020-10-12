<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="container">
    <div class="row" style="margin-top: 10px">
        <div id="system_staff_toolbar">
            <input type="button" id='system_staff_add' data-discern-code="add" class='disabled btn btn-info'
                   value="添加"/>
            <input type='button' id='system_staff_update' data-discern-code="update" class='disabled btn btn-info'
                   value='修改'/>
            <input type='button' id='system_staff_delete' data-discern-code="delete" class='disabled btn btn-danger'
                   value='删除'/>
        </div>
        <table id="system_staff_table"></table>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        let headUrl = "controllerPage/system/";

        let staffTable = "#system_staff_table";
        init();

        function init() {
            //进行 识别
            removeClassDisabledButton("${param.tabId}", ["#system_staff_add",
                "#system_staff_update",
                "#system_staff_delete"]);

            //加载table
            $(staffTable).bootstrapTable({
                url: "systemStaff/queryPageVo",
                method: 'get',
                clickToSelect: true,
                toolbar: "#system_staff_toolbar",//自定义工具栏
                pagination: true,
                showRefresh: true,//刷新
                pageNumber: 1,
                singleSelect: true,
                pageSize: 3,
                pageList: [3, 6, 9],
                paginationHAlign: "left",
                paginationPreText: "<",
                paginationNextText: ">",
                sidePagination: "server",
                queryParams: function (params) {//上传服务器的参数
                    return {//如果是在服务器端实现分页，limit、offset这两个参数是必须的
                        size: params.limit, // 每页显示数量
                        current: (params.offset / params.limit) + 1, // SQL语句起始索引
                    };
                },
                columns: [
                    {checkbox: true},
                    {field: "id", title: "员工账户"},
                    {field: "name", title: "员工名称"},
                    {field: "pwd", title: "员工密码"},
                    {field: "phone", title: "员工电话"},
                    {field: "identityCard", title: "员工身份证"},
                    {field: "time", title: "入职时间"}
                ]
            })
        }

        $("#system_staff_add").click(function () {
            if (myDisabledButton(this) && myDisabledButton(this)) {
                myDialogModal("添加角色", headUrl + "staff/add.jsp");
            }
        })

        $("#system_staff_update").click(function () {
            let rows = myIsSelectRowTable(staffTable);
            if (myDisabledButton(this) && myDisabledButton(this) && rows !== 0) {
                myDialogModal("修改角色", headUrl + "staff/update.jsp?id=" + rows[0].id);
            }
        })

        $("#system_staff_delete").click(function () {
            let row = myIsSelectRowTable(staffTable);
            if (myDisabledButton(this) && row !== 0) {
                myConfirm("删除提示：", "是否删除：" + row[0].name, function (t) {
                    if (!t) return
                    //进行删除
                    $.ajax({
                        url: 'systemStaff/deleteStaffId',
                        data: {id: row[0].id},
                        dataType: 'json',
                        success: function (data) {
                            myAlert("删除提示:", "删除" + data ? '成功' : '失败' + "!");
                        }
                    })
                })
            }
        })
    })
</script>
</body>
</html>
