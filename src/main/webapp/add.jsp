<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false"%>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <!-- 使用Edge最新的浏览器的渲染方式 -->
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <!-- viewport视口：网页可以根据设置的宽度自动进行适配，在浏览器的内部虚拟一个容器，容器的宽度与设备的宽度相同。
    width: 默认宽度与设备的宽度相同
    initial-scale: 初始的缩放比，为1:1 -->
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>添加用户</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>

    <script>
        $(function () {
            $("#btn").click(function () {
                //点击返回按钮跳转到列表页面
                location.href="${pageContext.request.contextPath}/findAll";
            })
        })
    </script>
</head>
<body>
<div class="container" style="width: 400px; border: 1px solid black;margin: 100px auto">
    <h3 style="text-align: center;">添加用户</h3>
    <form action="${pageContext.request.contextPath}/addUser" method="post">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name" placeholder="请输入姓名">
        </div>

        <div class="form-group">
            <label>性别:</label>
            <input type="radio" name="gender" value="男"/>男
            <input type="radio" name="gender" value="女"/>女
        </div>

        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age" name="age" placeholder="请输入年龄">
        </div>

        <div class="form-group">
            <label for="address">籍贯:</label>
            <select name="address" class="form-control" id="address">
                <option value="泰安市">泰安市</option>
                <option value="烟台市">烟台市</option>
                <option value="济南市">济南市</option>
                <option value="烟台市">烟台市</option>
                <option value="菏泽市">菏泽市</option>
                <option value="滨州市">滨州市</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" name="qq" placeholder="请输入QQ号码" id="qq"/>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" placeholder="请输入邮箱地址" id="email"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="reset" value="重置" />
            <input class="btn btn-default" type="button" value="返回" id="btn" />
        </div>
    </form>
</div>
</body>
</html>
