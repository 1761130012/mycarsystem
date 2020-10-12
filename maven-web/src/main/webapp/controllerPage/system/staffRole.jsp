<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-11
  Time: 23:17
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
        <div class="col-md-7">
            <table id="system_staffRole_staff"></table>
        </div>
        <div class="col-md-5">
            <div id="system_staffRole_roleToolbar">
                <input type="button" id="system_staffRole_standbyOne" data-discern-code="standbyOne"
                       class="disabled btn btn-info" value="授予职位"/>
            </div>
            <table id="system_staffRole_role"></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        let headUrl = "controllerPage/system/";
        init()

        function init() {
            removeClassDisabledButton("${param.tabId}", ["#system_staffRole_standbyOne"]);
        }

        let staffTable = "#system_staffRole_staff";
        $(staffTable).bootstrapTable({
            url: "systemStaff/queryAllPageVo",
            pagination: true,
            pageNumber: 1,
            pageSize: 3,
            showRefresh: true,//刷新
            clickToSelect: true,
            pageList: [3, 6, 9],
            singleSelect: true,
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
                {field: "id", title: "编号"},
                {field: "name", title: "员工名"},
                {field: "time", title: "入职日期"}
            ],
            onClickRow: function (item) {
                $(roleTable).bootstrapTable("refresh", {query: {staffId: item.id}});
            }
        })

        let roleTable = "#system_staffRole_role";
        $(roleTable).bootstrapTable({
            url: "systemRole/queryAllRoleA",
            toolbar: "#system_staffRole_roleToolbar",//自定义工具栏
            clickToSelect: true,
            columns: [
                {checkbox: true, field: 'checkbox'},
                {field: "id", hidden: true, title: "编号"},
                {field: "name", title: "角色名"},
                {field: "remark", title: "备注"},
            ]
        })

        //点击 进行 授予职位
        $("#system_staffRole_standbyOne").click(function () {
            let staffRow = myIsSelectRowTable(staffTable);
            if (myDisabledButton(this) && staffRow !== 0) {
                let array = $(roleTable).bootstrapTable("getSelections")
                let roleIds = [];
                $.each(array, function (index) {
                    roleIds[index] = this.id;
                })
                $.ajax({
                    url: 'systemRole/updateStaffRoleArrayStaffId',
                    type: 'post',
                    data: JSON.stringify({staffId: staffRow[0].id, roleIds: roleIds}),
                    contentType: 'application/json',
                    success: function (data) {
                        myAlert("修改提示", "修改" + data ? '成功' : '失败' + "!")
                    }
                })
            }
        })
    })
</script>
</body>
</html>
