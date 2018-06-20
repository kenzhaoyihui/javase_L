<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/16/18
  Time: 5:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <%--<script src="/static/js/jquery-3.3.1.min.js"></script>--%>
    <script src="/static/js/jquery.slim.min.js"></script>
    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <%--<link rel="short icon" type="image/x-icon" href="${APP_PATH}/static/imgages/web-icon.png" media="screen"/>--%>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
    <script src="/static/js/layer.js"></script>
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/admin/main">Blog Manage</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--<li class="nav-item">--%>
                    <%--<div class="btn-group">--%>
                        <%--<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                            <%--New--%>
                        <%--</button>--%>
                        <%--<div class="dropdown-menu">--%>
                            <%--<a class="dropdown-item" href="javascript:void(0);" onclick="fullScreen('Add Article', '/admin/article/add')">Articles</a>--%>
                            <%--&lt;%&ndash;<a class="dropdown-item" href="#">Comments</a>&ndash;%&gt;--%>
                        <%--</div>--%>
                    <%--</div>--%>
                <%--</li>--%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">New <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="/admin/article/add">New Article</a></li>
                            <%--<li><a href="#">Another action</a></li>--%>
                            <%--<li><a href="#">Something else here</a></li>--%>
                            <%--<li role="separator" class="divider"></li>--%>
                            <%--<li><a href="#">Separated link</a></li>--%>
                            <%--<li role="separator" class="divider"></li>--%>
                            <%--<li><a href="#">One more separated link</a></li>--%>
                        </ul>
                    </li>

                <%--<li><a class="btn-danger" href="/admin/article/add">New</a></li>--%>
                <li class="nav-item"><a href="/admin/main">Main Page <span class="sr-only">(current)</span></a></li>
                <li class="nav-item active"><a href="/admin/article/list">Articles Manage</a></li>
                <li class="nav-item btn-danger"><a href="/admin/logout">Exit</a></li>
            </ul>
            <form class="navbar-form navbar-right" action="/admin/article/search" method="get">
                <div class="form-group">
                    <input type="text" class="form-control mr-sm-2" placeholder="Article Content or Title..." aria-label="Search" name="word">
                </div>
                <button type="submit" class="btn btn-default btn-outline-success my-2 my-sm-0 btn-sm">Search</button>
            </form>

            <%--<a class="btn btn-outline-danger btn-sm" href="/admin/logout" role="button">Exit</a>--%>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>

<br/>

<table class="table table-hover">
    <tr class="table-info">
        <th>id</th>
        <th width="25%">Title</th>
        <th>Publish Time</th>
        <th>Click</th>
        <th>Details</th>
        <th>Comments</th>
        <th>Edit</th>
        <th>Delete</th>
    </tr>

    <c:forEach items="${articles}" var="article">
        <tr>
            <th scope="row">${article.id}</th>
            <td>${article.title}</td>
            <td>${article.time}</td>
            <td>${article.click}</td>
            <td><button type="button" class="btn btn-outline-info btn-sm" onclick="fullScreen('${article.title}', '/admin/article/detail?id=${article.id}')">detail</button> </td>
            <td><button type="button" class="btn btn-outline-success btn-sm" onclick="fullScreen('${article.title} | comment', '/admin/article/comment?id=${article.id}')">comment</button> </td>
            <td><button type="button" class="btn btn-outline-primary btn-sm" onclick="fullScreen('${article.title} | edit', '/admin/article/edit?id=${article.id}')">edit</button> </td>
            <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${article.id}', '${article.title}')">delete</button> </td>
        </tr>
    </c:forEach>
</table>

<nav aria-label="Page navigation" style="position: absolute;bottom: 10px;left: 42%">
    <ul class="pagination justify-content-center">
        <li><a href="/admin/article/list?page=1">First</a> </li>
        <c:if test="${pageInfo.hasPreviousPage}">
            <li>
                <a href="/admin/article/list?page=${pageInfo.pageNum-1}" aria-label="Previous">
                    <span aria-hidden="true">&laquo;</span>
                </a>
            </li>
        </c:if>

        <c:forEach items="${pageInfo.navigatepageNums}" var="page_Num">
            <c:if test="${page_Num == pageInfo.pageNum}">
                <li class="active"><a href="#">${page_Num}</a> </li>
            </c:if>

            <c:if test="${page_Num != pageInfo.pageNum}">
                <li><a href="/admin/article/list?page=${page_Num}">${page_Num}</a> </li>
            </c:if>
        </c:forEach>

        <c:if test="${pageInfo.hasNextPage}">
            <li>
                <a href="/admin/article/list?page=${pageInfo.pageNum+1}" aria-label="Next">
                    <span aria-hidden="true">&raquo;</span>
                </a>
            </li>
        </c:if>

        <li><a href="/admin/article/list?page=${pageInfo.pages}">Last</a> </li>

    </ul>
</nav>

<%--<nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">--%>
<%--<ul class="pagination justify-content-center">--%>
<%--<li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">--%>
<%--<a class="page-link" href="/admin/article/list?page=1" >&laquo;</a>--%>
<%--</li>--%>
<%--<c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">--%>
<%--<li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" href="/admin/article/list?page=${pageNo}">${pageNo}</a></li>--%>
<%--</c:forEach>--%>
<%--<li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">--%>
<%--<a class="page-link" href="/admin/article/list?page=${pageInfo.pages}">&raquo;</a>--%>
<%--</li>--%>
<%--</ul>--%>
<%--</nav>--%>

<%--<table class="table table-sm">--%>

    <%--<tbody>--%>
    <%--<c:forEach items="${articles}" var="article">--%>
        <%--<tr>--%>
            <%--<th scope="row">${article.id}</th>--%>
            <%--<td>${article.title}</td>--%>
            <%--<td>${article.time}</td>--%>
            <%--<td>${article.click}</td>--%>
            <%--<td><button type="button" class="btn btn-outline-info btn-sm" onclick="fullScreen('《${article.title}》','/admin/article/detail?id=${article.id}')">详情</button></td>--%>
            <%--<td><button type="button" class="btn btn-outline-success btn-sm" onclick="fullScreen('《${article.title}》|评论管理','/admin/article/comment?id=${article.id}')">评论</button></td>--%>
            <%--<td><button type="button" class="btn btn-outline-primary btn-sm" onclick="fullScreen('《${article.title}》|编辑','/admin/article/edit?id=${article.id}')">编辑</button>&nbsp;&nbsp;</td>--%>
            <%--<td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${article.id}','${article.title}') ">删除</button></td>--%>
        <%--</tr>--%>
    <%--</c:forEach>--%>
    <%--</tbody>--%>
<%--</table>--%>
<%--<nav aria-label="Page navigation example" style="position: absolute;bottom: 10px;left: 42%">--%>
    <%--<ul class="pagination justify-content-center">--%>
        <%--<li class="page-item  <c:if test="${pageInfo.pageNum==1}">disabled</c:if> ">--%>
            <%--<a class="page-link" href="/admin/article/list?page=1" >&laquo;</a>--%>
        <%--</li>--%>
        <%--<c:forEach begin="1" end="${pageInfo.pages}" step="1" var="pageNo">--%>
            <%--<li class="page-item <c:if test="${pageInfo.pageNum==pageNo}">active</c:if>"><a class="page-link" href="/admin/article/list?page=${pageNo}">${pageNo}</a></li>--%>
        <%--</c:forEach>--%>
        <%--<li class="page-item  <c:if test="${pageInfo.pageNum==pageInfo.pages}">disabled</c:if> ">--%>
            <%--<a class="page-link" href="/admin/article/list?page=${pageInfo.pages}">&raquo;</a>--%>
        <%--</li>--%>
    <%--</ul>--%>
<%--</nav>--%>

<script src="/static/js/jquery-3.3.1.min.js"></script>
<script>
    function fullScreen(title,url){
        var index = layer.open({
            type: 2,
            title: title,
            area: ['70%', '70%'],
            content: url,
            maxmin: true
        });
        layer.full(index);
    }
    function ifdelete(id,title) {
        layer.confirm('Confirm to delete the article?', {
            btn: ['Confirm','Cancel'] //按钮
        }, function(){
            $.ajax({
                type: 'POST',
                url: '/api/article/del',
                datatype:'json',
                data:{"id":id},
                success: function(data){
                    if(data['stateCode']==1){
                        layer.msg('Delete Successfully!',{icon:1,time:1000});
                        setTimeout("window.location.reload()",1000);
                    }
                    else {
                        layer.msg('Delete Failed!',{icon:5,time:1000});
                    }
                },
                error:function(data) {
                    console.log('Error...');
                },
            });
        }, function () {
            
        });
    }
</script>


</body>
</html>
