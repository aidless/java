<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html lang="zh-CN">
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="X-UA-Compatible" content="IE=edge"/>
    <meta name="viewport" content="width=device-width, initial-scale=1"/>
    <title>首页</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <script type="text/javascript">
    </script>
</head>
<body>
<div align="center" style="margin: 50px auto">
    <%--<a
            href="${pageContext.request.contextPath}/findAll" style="text-decoration:none;font-size:33px">${admin.username},欢迎您点击查询所有用户信息
    </a>--%>
        <a
                href="${pageContext.request.contextPath}/findPage" style="text-decoration:none;font-size:33px">${admin.username},欢迎您点击查询所有用户信息
        </a>
</div>
</body>
</html>
