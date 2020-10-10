<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-10
  Time: 23:44
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
        <div class="well">
            <input type="button" id="system_menu_add" value="添加同级" data-discern-code="add"
                   class="disabled btn btn-info"/>
            <input type="button" id="system_menu_addChild" value="添加子级" data-discern-code="standbyOne"
                   class="disabled btn btn-info"/>
            <input type="button" id="system_menu_update" value="修改" data-discern-code="update"
                   class="disabled btn btn-info"/>
            <input type="button" id="system_menu_delete" value="删除" data-discern-code="delete"
                   class="disabled btn btn-danger"/>
        </div>
    </div>

    <div class="row" style="margin-top: -20px">
        <div id="system_menu_treeView"></div>
    </div>
</div>
<script type="text/javascript">
    $(function () {
        let treeViewId = "#system_menu_treeView";
        let headUrl = "controllerPage/system/";

        init();
        function init() {
            let tabId = "${param.tabId}";
            removeClassDisabledButton(tabId, ["#system_menu_add",
                "#system_menu_addChild",
                "#system_menu_update",
                "#system_menu_delete"]);

            let treeData;
            $.ajax({
                url: "systemMenu/queryAll",
                async: false,
                success: function (data) {
                    treeData = data;
                }
            })
            $(treeViewId).treeview({
                data: treeData,
                showTags: true,
                onNodeSelected: function (event, node) {

                    if (/(添加|修改|删除|-)+/.test(node.text)) {
                        $("#system_menu_addChild").addClass("disabled").css("cursor", "not-allowed");
                    } else {
                        $("#system_menu_addChild").removeClass("disabled").css("cursor", "pointer");
                    }
                }
            })
        }

        let node;
        $("#system_menu_add").click(function () {
            if (isSelectedTreeView()) {
                node = $(treeViewId).treeview("getSelected")[0];
                myDialogModal("添加菜单", headUrl + "menuJsp/add.jsp?parentIds=" + node.parentIds);
            }
        })

        $("#system_menu_addChild").click(function () {
            if (myDisabledButton(this)) return
            if (isSelectedTreeView()) {
                node = $(treeViewId).treeview("getSelected")[0];
                //获取子的节点的 parentIds
                myDialogModal("添加菜单", headUrl + "menuJsp/add.jsp?parentIds=" + node.id);
            }
        })
        $("#system_menu_update").click(function () {
            if (isSelectedTreeView()) {
                node = $(treeViewId).treeview("getSelected")[0];
                myDialogModal("修改菜单", headUrl + "menuJsp/upate.jsp?id=" + node.id);
            }
        })
        $("#system_menu_delete").click(function () {
            if (isSelectedTreeView()) {
                node = $(treeViewId).treeview("getSelected")[0];
                myConfirm("删除提示", "是否要删除菜单: " + node.text, function (t) {
                    $.ajax({
                        url: 'systemMenu/deleteMenuId',
                        data: {id: node.id},
                        dataType: 'json',
                        success: function (data) {
                            myAlert("删除提示", "删除" + data ? '成功' : '失败' + "!")
                        }
                    })
                });
            }
        })

        function isSelectedTreeView() {
            node = $(treeViewId).treeview("getSelected");
            if (node.length === 0) {
                myAlert("提示信息:", "请选择菜单！！！")
                return false;
            }
            return true;
        }
    })

</script>
</body>
</html>
