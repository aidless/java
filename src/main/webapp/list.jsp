<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
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
    <title>用户信息管理系统</title>

    <!-- 1. 导入CSS的全局样式 -->
    <link href="css/bootstrap.min.css" rel="stylesheet">
    <!-- 2. jQuery导入，建议使用1.9以上的版本 -->
    <script src="js/jquery-2.1.0.min.js"></script>
    <!-- 3. 导入bootstrap的js文件 -->
    <script src="js/bootstrap.min.js"></script>
    <style type="text/css">
        td, th {
            text-align: center;
        }
    </style>

    <script>
        /*删除单个数据*/
        function confirmDelete(id) {
            if(confirm("你确定要删除该用户吗?")){
                location.href="${pageContext.request.contextPath}/deleteUser?id="+id;
            }
        }
        /*批量删除*/
        $(function () {
            //全选
            $("#selectAll").click(function () {
                $(".choice").prop("checked",true);
            });
            //全不选
            $("#selectNone").click(function () {
                $(".choice").prop("checked",false);
            });
            //反选
            $("#reverse").click(function () {
                //遍历所有的复选框(如果是选中,那么设置为false;反之设置为true)
                $.each($(".choice"),function () {
                    this.checked=!this.checked;
                })
            });

            //删除选中
            $("#batch").click(function () {
                //获取选中的数量
                var checkedNum=$(".choice:checked").length;
                if (checkedNum==0){
                    alert("请至少选择一项!");
                    //不需要执行下面的操作
                    return false;
                }
                //创建数组容器,用于存储选中的用户id
                var checkArray=new Array();
                $(".choice:checked").each(function () {
                    checkArray.push($(this).val());
                });

                if (confirm("你确定要删除这"+checkedNum+"条选中项吗?")){
                    location.href="${pageContext.request.contextPath}/batchDelete?ids="+checkArray;
                }
            })
        })
    </script>
</head>
<body>
<div class="container" style="width:80%">
    <h3 style="text-align: center">用户信息列表</h3>

    <div style="float: right;">
        <form class="form-inline" action="" method="post">
            <div class="form-group">
                <label for="exampleInputName">姓名</label>
                <input type="text" name="name" value="" class="form-control" id="exampleInputName">
            </div>
            <div class="form-group">
                <label for="exampleInputName">性别</label>
                <input type="text" name="gender" value="" class="form-control"
                       id="exampleInputGender">
            </div>
            <div class="form-group">
                <label for="exampleInputAddress">籍贯</label>
                <input type="text" name="address" value="" class="form-control" id="exampleInputAddress">
            </div>
            <div class="form-group">
                <label for="exampleInputEmail">邮箱</label>
                <input type="text" name="email" value="" class="form-control" id="exampleInputEmail">
            </div>
            <button type="submit" class="btn btn-default">查询</button>
        </form>
    </div>

    <div style="float: left;margin: 5px;">
        <a class="btn btn-primary" href="add.jsp">添加用户</a>
        <a class="btn btn-primary" id="batch">删除选中</a>
    </div>

    <table border="1" class="table table-bordered table-hover">
        <tr class="success">
            <th width="20%">
                <input type="button" id="selectAll" value="全选">
                <input type="button" id="selectNone" value="全不选">
                <input type="button" id="reverse" value="反选">
            </th>
            <th>编号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>年龄</th>
            <th>籍贯</th>
            <th>QQ</th>
            <th>邮箱</th>
            <th>操作</th>
        </tr>
        <%--解析域中的数据(使用jstl标签库(core核心标签库)中的遍历:foreach)--%>
        <c:forEach items="${pb.list}" var="user" varStatus="vs">
            <tr>
                <td><input type="checkbox" name="id" class="choice" value="${user.id}"></td>
                <td>${vs.count}</td>
                <td>${user.name}</td>
                <td>${user.gender}</td>
                <td>${user.age}</td>
                <td>${user.address}</td>
                <td>${user.qq}</td>
                <td>${user.email}</td>
                <td>
                    <a class="btn btn-default btn-sm" href="${pageContext.request.contextPath}/findUser?id=${user.id}">修改</a>&nbsp;
                    <a class="btn btn-default btn-sm" href="javascript:confirmDelete(${user.id})">删除</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <div>

        <nav aria-label="Page navigation">
            <ul class="pagination">
                <li>
                    <a href="${pageContext.request.contextPath}/findPage?pageNum=1">首页</a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/findPage?pageNum=${pb.pageNum-1}" aria-label="Previous">
                        <span aria-hidden="true">&laquo;</span>
                    </a>
                </li>
                <c:forEach begin="1" end="${pb.totalPage}" var="i">
                    <li><a href="${pageContext.request.contextPath}/findPage?pageNum=${i}">${i}</a></li>
                </c:forEach>

                <li>
                    <a href="${pageContext.request.contextPath}/findPage?pageNum=${pb.pageNum+1}" aria-label="Next">
                        <span aria-hidden="true">&raquo;</span>
                    </a>
                </li>
                <li>
                    <a href="${pageContext.request.contextPath}/findPage?pageNum=${pb.totalPage}">尾页</a>
                </li>
            </ul>
            <span style="font-size: 24px;float: right;margin-top: 20px">
                共${pb.totalCount}条数据,共${pb.totalPage}页
            </span>
        </nav>
    </div>
</div>
</body>
</html>

