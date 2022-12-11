<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<!-- 网页使用的语言 -->
<html lang="zh-CN">
<head>
    <!-- 指定字符集 -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>修改用户</title>

    <link href="css/bootstrap.min.css" rel="stylesheet">
    <script src="js/jquery-2.1.0.min.js"></script>
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
    <h3 style="text-align: center;">修改用户信息</h3>
    <form action="${pageContext.request.contextPath}/updateUser" method="post">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name" value="${user.name}"  readonly="readonly" placeholder="请输入姓名" />
        </div>

        <div class="form-group">
            <label>性别:</label>
            <input type="radio" name="gender" value="男" ${user.gender=="男"?"checked":""} />男
            <input type="radio" name="gender" value="女" ${user.gender=="女"?"checked":""} />女
        </div>

        <div class="form-group">
            <label for="age">年龄:</label>
            <input type="text" class="form-control" id="age"  name="age" value="${user.age}" placeholder="请输入年龄" />
        </div>

        <div class="form-group">
            <label for="address">籍贯:</label>
            <select name="address" class="form-control" id="address">
                <option value="北京市" ${user.address=="北京市"?"selected":""}>北京市</option>
                <option value="上海市" ${user.address=="上海市"?"selected":""}>上海市</option>
                <option value="武汉市" ${user.address=="武汉市"?"selected":""}>武汉市</option>
                <option value="南京市" ${user.address=="南京市"?"selected":""}>南京市</option>
                <option value="贵阳市" ${user.address=="贵阳市"?"selected":""}>贵阳市</option>
            </select>
        </div>

        <div class="form-group">
            <label for="qq">QQ:</label>
            <input type="text" class="form-control" name="qq" value="${user.qq}" placeholder="请输入QQ号码" id="qq"/>
        </div>

        <div class="form-group">
            <label for="email">Email:</label>
            <input type="text" class="form-control" name="email" value="${user.email}" placeholder="请输入邮箱地址" id="email"/>
        </div>

        <div class="form-group" style="text-align: center">
            <input class="btn btn-primary" type="submit" value="提交" />
            <input class="btn btn-default" type="button" value="返回" id="btn"/>
        </div>
    </form>
</div>
</body>
</html>
