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
            <select id="system_menu_add_parentIds" name="parentIds" class="form-control">
            </select>
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
        <label class="col-md-2 text-center">识别码：</label>
        <div class="col-md-10">
            <select id="system_menu_add_discernCode" name="discernCode" class="form-control">
                <option value="0">无识别码</option>
            </select>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="system_menu_add_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        let from = "#system_menu_add_form";
        init();

        function init() {
            //获取 父id 设置 参数
            let parentId = "#system_menu_add_parentIds";
            if (0 === parseInt("${param.parentIds}")) {
                $(parentId).append($("<option value='0'>无父菜单</option>"));
            } else {
                let id = parseInt("${param.parentIds}");
                $.ajax({
                    url: 'systemMenu/queryMenuParentId',
                    data: {id: id},
                    async: false,
                    dataType: 'json',
                    success: function (data) {
                        $.each(data, function () {
                            let option = $("<option value='" + this.id + "'>" + this.text + "</option>")
                            if (id === this.id) {
                                option.attr("selected", true);
                            }
                            $(parentId).append(option);
                        })
                    }
                })
            }

            //加载 识别码
            $.ajax({
                url: 'systemMenu/queryAllCode',
                dataType: 'json',
                success: function (data) {
                    let discernCode = $("#system_menu_add_discernCode");
                    $.each(data, function () {
                        discernCode.append("<option value='" + this.code + "'>" + this.name + "</option>");
                    });
                }
            })
        }

        $("#system_menu_add_submit").click(function () {
            let array = myFromSubmit(from);
            $.ajax({
                url: 'systemMenu/insertMenu',
                data: array,
                success: function (data) {
                    myAlert("添加菜单信息", "添加菜单" + eval(data) ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
