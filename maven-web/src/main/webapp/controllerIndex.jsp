<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-12
  Time: 8:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>后台页面</title>
    <link href="resources/css/bootstrap.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-treeview.min.css" rel="stylesheet"/>
    <link href="resources/css/bootstrap-table.css" rel="stylesheet">

    <script src="resources/js/jquery.min.js"></script>
    <script src="resources/js/bootstrap.min.js"></script>
    <script src="resources/js/bootstrap-closable-tab.js"></script>
    <script src="resources/js/bootstrap-table.js"></script>
    <script src="resources/js/bootstrap-table-zh-CN.min.js"></script>
    <script src="resources/js/bootbox.js"></script>
    <script src="resources/js/bootbox.locales.js"></script>
    <script src="resources/js/bootstrap-treeview.min.js"></script>
    <script src="resources/js/jquery.easyui.min.js"></script>

</head>
<style type="text/css">
    /* 隐藏机制 */
    *[data-discern-code='0'] {
        display: inline;
    }

    *[data-discern-code='1'] {
        display: none;
    }</style>
<body>
<!-- 顶部导航条 -->
<nav class="navbar-default">
    <div class="container-fluid">
        <!-- 头部 -->
        <div class="navbar-header">
            <a class="navbar-brand" href="#">我的后台</a>
        </div>

        <!-- 主要 -->
        <div class="collapse navbar-collapse" id="navbar-collapse-1">
            <ul class="nav navbar-right">
                <li><a href="#">安全退出</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="well container-fluid" style="padding: 30px">
    <div class="row">
        <div class="col-md-2" id="left_accordion"></div>
        <div class="col-md-9" id="right_tab"></div>
    </div>
</div>

<script type="text/javascript">
    init();

    function init() {
        bootbox.setLocale("zh_CN");
    }


    $(function () {
        $("#left_accordion").load("accordionIndex.html");
        $("#right_tab").load("tabIndex.html");
    })

    function myAlert(title, message, fn) {
        bootbox.alert({
            backdrop: true,//点击背景 进行关闭
            title: title,
            message: "<h4>" + message + "</h4>",
            callback: fn
        })
    }

    function myConfirm(title, message, fn) {
        bootbox.confirm({
            title: title,
            message: "<h4>" + message + "</h4>",
            callback: fn,
            backdrop: true,//点击背景 进行关闭
        })
    }

    function myPrompt(title, fn) {
        bootbox.prompt({
            title: title,
            callback: fn,
            centerVertical: true,
            backdrop: true,//点击背景 进行关闭
        });
    }

    /**
     * 返回 :
     * 0 错误 并弹框
     *  否则返回行
     * @param selectorTable table 选择器 仅支持 id
     */
    function myIsSelectRowTable(selectorTable) {
        let rows = $(selectorTable).bootstrapTable("getSelections");
        if (rows.length === 0) {
            myAlert("错误提示：", "<strong style='color: red'>未选中行</strong>");
            return 0;
        }
        return rows;
    }

    function myDialogModal(title, url) {
        let modal = $("<div></div>").load(url);
        bootbox.dialog({
            title: "<div class='text-center' style='font-size: 20px'>" + title + "</div>",
            message: modal,
        })
    }

    //隐藏
    function myDialogModalHide() {
        bootbox.dialog({
            show: false
        })
    }

    function myFromSubmit(formId) {
        let serializeArray = $(formId).serializeArray();
        let array = {};
        $.each(serializeArray, function () {
            array[this.name] = this.value;
        })
        return array;
    }

    function myDisabledButton(id) {
        return $(id).attr("class").indexOf("disabled") === -1;
    }

    /**
     * 增改删 按钮 进行 添加 识别码
     * @param tabId 选项卡 id 代表 菜单的 id
     * @param id集合
     */
    function removeClassDisabledButton(tabId, arrayId) {
        tabId = parseInt(tabId);
        $.ajax({
            url: 'systemRole/queryStaffMenuIdCode',
            data: {menuId: tabId},
            dataType: 'json',
            success: function (data) {
                //data 是 tabId 的 子菜单 中 有的 识别码
                $.each(arrayId, function () {
                    for (let i = 0; i < data.length; i++) {
                        if ($(this + "").attr("data-discern-code") === data[i]) {
                            $(this + "").removeClass("disabled");
                        }
                    }
                })
            }
        })
    }
</script>
</body>
</html>
