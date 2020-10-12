<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-12
  Time: 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>车辆信息管理</title>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <div id="info_car_toolbar">
                <input type="button" id='info_car_add' data-discern-code="add" class='disabled btn btn-info'
                       value="添加"/>
                <input type='button' id='info_car_update' data-discern-code="update" class='disabled btn btn-info'
                       value='修改'/>
                <input type='button' id='info_car_delete' data-discern-code="delete" class='disabled btn btn-danger'
                       value='删除'/>
            </div>
            <table id="info_car_table"></table>
        </div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        let headUrl = "controllerPage/info/";
        let table = "#info_car_table";
        init()

        $("#info_car_add").click(function () {
            if (myDisabledButton(this)) {
                myDialogModal("添加信息", headUrl + "car/add.jsp")
            }
        })
        $("#info_car_update").click(function () {
            let row = myIsSelectRowTable(table);
            if (myDisabledButton(this) && row !== 0) {
                myDialogModal("修改信息", headUrl + "car/update.jsp?id=" + row[0].id)
            }
        })
        $("#info_car_delete").click(function () {
            let row = myIsSelectRowTable(table);
            if (myDisabledButton(this) && row !== 0) {
                myConfirm("删除提示：", "是否要删除用户：" + row[0].id, function (t) {
                    if (t) {
                        $.ajax({
                            url: 'infoCar/deleteId',
                            success: function (data) {
                                myAlert("删除提示", "删除" + data ? '成功' : '失败' + "!")
                            }
                        })
                    }
                })
            }
        })

        function init() {
            removeClassDisabledButton("${param.tabId}", ['#info_car_add',
                '#info_car_update',
                '#info_car_delete',]);

            //进行 加载 table
            $(table).bootstrapTable({
                url: 'infoCar/queryPageVo',
                method: 'get',
                clickToSelect: true,
                toolbar: "#info_car_toolbar",//自定义工具栏
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
                    {field: "id", title: "编号"},
                    {
                        field: "imageUrl", title: "图片", formatter: function (value) {
                            return "<img src='" + value + "' style='width: 200px;height: 100px'/>";
                        }
                    },
                    {field: "name", title: "车辆名称"},
                    {
                        field: "carType", title: "品牌", formatter: function (value) {
                            return value.name;
                        }
                    },
                    {field: "carCode", title: "车牌号"},
                    {field: "time", title: "生产时间"}
                ]
            })
        }
    })
</script>
</body>
</html>
