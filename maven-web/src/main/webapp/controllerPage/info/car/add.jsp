<%--
  Created by IntelliJ IDEA.
  User: LLY
  Date: 2020-10-12
  Time: 8:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form class="form-horizontal" id="info_car_add_form">
    <div class="form-group">
        <label class="col-md-3 text-center">编号：</label>
        <div class="col-md-9">
            <input type="text" name="id" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">图片：</label>
        <div class="col-md-9">
            <input type="file" name="imageFile" class="form-control"/>
        </div>
    </div>

    <div class="form-group">
        <label class="col-md-3 text-center">车辆名称：</label>
        <div class="col-md-9">
            <input type="text" name="name" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">品牌：</label>
        <div class="col-md-9">
            <select type="text" name="carTypeId" class="form-control"></select>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">车牌号：</label>
        <div class="col-md-9">
            <input type="text" name="carCode" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <label class="col-md-3 text-center">生产时间：</label>
        <div class="col-md-9">
            <input type="date" name="time" class="form-control"/>
        </div>
    </div>
    <div class="form-group">
        <div class="col-md-4 col-md-offset-4 "><input type="button" id="info_car_add_submit"
                                                      class="btn btn-info form-control" value="添加"/></div>
    </div>
</form>
<script type="text/javascript">
    $(function () {
        $("#info_car_add_submit").click(function () {
            let array = myFromSubmit("#info_carr_add_form");
            $.ajax({
                url: "infoCar/insertInfo",
                data: array,
                contentType:'multipart/form-data',
                success: function (data) {
                    myAlert("添加信息", "添加" + eval(data) ? '成功' : '失败' + "!");
                }
            })
        })
    })
</script>
</body>
</html>
