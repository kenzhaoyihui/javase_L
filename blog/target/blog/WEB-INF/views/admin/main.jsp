<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/12/18
  Time: 8:26 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Kenzhaoyihui's Blog</title>
    <%--<%--%>
        <%--pageContext.setAttribute("APP_PATH", request.getContextPath());--%>
    <%--%>--%>
    <meta charset="UTF-8">

    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/static/js/jquery.slim.min.js"></script>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
    <script src="/static/js/layer.js"></script>

</head>
<body>

<%--<nav class="navbar navbar-expand-lg navbar-light bg-light" >--%>
    <%--<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">--%>
        <%--<span class="navbar-toggler-icon"></span>--%>
        <%--<a class="navbar-brand text-success" href="/admin/main">Blog Manage</a>--%>
    <%--</button>--%>
    <%--&lt;%&ndash;<a class="navbar-brand text-success" href="/admin/main">Blog Manage</a>&ndash;%&gt;--%>

    <%--<div class="collapse navbar-collapse" id="navbarTogglerDemo03">--%>
        <%--<ul class="navbar-nav mr-auto mt-2 mt-lg-0">--%>
            <%--<li class="nav-item">--%>
                <%--<!-- Example single danger button -->--%>
                <%--<div class="btn-group">--%>
                    <%--<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                        <%--New--%>
                    <%--</button>--%>
                    <%--<div class="dropdown-menu">--%>
                        <%--<a class="dropdown-item" href="javascript:void(0);" onclick="fullScreen('Add Article','/admin/article/add')">Article</a>--%>
                        <%--<!-- <a class="dropdown-item" href="#">评论</a> -->--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</li>--%>
            <%--<li class="nav-item active">--%>
                <%--<a class="nav-link" href="/admin/main">Main Page </a>--%>
            <%--</li>--%>
            <%--<li class="nav-item">--%>
                <%--<a class="nav-link" href="/admin/article/list">Article Manage</a>--%>

            <%--</li>--%>

        <%--</ul>--%>
        <%--<form class="form-inline my-2 my-lg-0" action="/admin/article/search" method="GET">--%>
            <%--<input class="form-control mr-sm-2" type="search" placeholder="Article title or content..." aria-label="Search" name="word">--%>
            <%--<button class="btn btn-outline-success my-2 my-sm-0 btn-sm" type="submit">Search</button>--%>
        <%--</form>--%>

        <%--<a class="btn btn-outline-danger btn-sm" href="/admin/logout" role="button">Exit</a>--%>
    <%--</div>--%>

<%--</nav>--%>

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
            <a class="navbar-brand text-success" href="/admin/main">Blog Manage</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <%--<li class="active"><a href="#">Link <span class="sr-only">(current)</span></a></li>--%>
                <%--<div class="btn-group">--%>
                    <%--<button type="button" class="btn btn-danger dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">--%>
                        <%--New--%>
                    <%--</button>--%>
                    <%--<div class="dropdown-menu">--%>
                        <%--<a class="dropdown-item" href="javascript:void(0);" onclick="fullScreen('添加文章','/admin/article/add')">文章</a>--%>
                    <%--</div>--%>
                <%--</div>--%>
                <li>
                    <a href="/admin/article/add">New</a>
                </li>
                    <li>
                        <a href="/admin/main">Main Page</a>
                    </li>
                    <li>
                        <a href="/admin/article/list">Article Manage</a>
                    </li>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">One more separated link</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            </ul>
            <form class="navbar-form navbar-left" action="/admin/article/search" method="get">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="Content Or Title">
                </div>
                <button type="submit" class="btn btn-default">Search</button>
            </form>

            <%--<a class="btn btn-outline-danger btn-sm" href="/admin/logout" role="button">Exit</a>--%>
            <a class="btn-danger" href="/admin/logout" role="button">Logout</a>


            <%--<ul class="nav navbar-nav navbar-right">--%>
                <%--<li><a href="#">Link</a></li>--%>
                <%--<li class="dropdown">--%>
                    <%--<a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">Dropdown <span class="caret"></span></a>--%>
                    <%--<ul class="dropdown-menu">--%>
                        <%--<li><a href="#">Action</a></li>--%>
                        <%--<li><a href="#">Another action</a></li>--%>
                        <%--<li><a href="#">Something else here</a></li>--%>
                        <%--<li role="separator" class="divider"></li>--%>
                        <%--<li><a href="#">Separated link</a></li>--%>
                    <%--</ul>--%>
                <%--</li>--%>
            <%--</ul>--%>
        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>


<div class="card mb-3">
    <div style="height: 180px;overflow: hidden">
        <img class="card-img-top" src="/static/images/82839-106.jpg" alt="Card image cap" style="height: 100%;width:100%;">
    </div>

    <div class="card-body">
        <h4 class="card-title">${admin.username}</h4>
        <p class="card-text"><small class="text-muted">Last Login Time: ${loginLog.date}</small></p>
        <p class="card-text"><small class="text-muted">Last Login IP: ${loginLog.ip}</small></p>
        <p class="card-text"><small class="text-muted">Login IP: ${clientIp}</small></p>
    </div>
</div>
<div >
    <table class="table table-hover">
        <p class="text-success" style="text-align: center"> System Count</p>
        <thead>
        <tr >
            <th>#</th>
            <th>Articles</th>
            <th>Comments</th>
            <th>Logins</th>
        </tr>
        </thead>
        <tbody>
        <tr class="table-success">
            <th scope="row">ALL</th>
            <td>${articleCount}</td>
            <td>${commentCount}</td>
            <td>${loginNum}</td>
        </tr>
        </tbody>
    </table>
</div>

<div style="width: 50%;position: relative;left: 25%">
    <table class="table table-sm" >
        <p class="text-success" style="text-align: center"> System Info</p>

        <tr>
            <th scope="row">Server IP</th>
            <td>${hostIp}</td>
        </tr>
        <tr>
            <th scope="row">Server Port</th>
            <td>${hostPort}</td>
        </tr>
        <tr>
            <th scope="row">Server Time</th>
            <td>${date}</td>
        </tr>

    </table>
</div>
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
</script>

</body>
</html>
