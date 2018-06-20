<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/16/18
  Time: 5:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Title</title>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<table class="table table-striped table-sm">
    <tr class="table-active">
        <th width="15%">ID</th>
        <td>${article.id}</td>
    </tr>

    <tr class="table-secondary">
        <th>Title</th>
        <td>${article.title}</td>
    </tr>

    <tr class="table-success">
        <th>Keywords</th>
        <td>${article.keywords}</td>
    </tr>

    <tr class="table-danger">
        <th>Intro</th>
        <td>${article.desci}</td>
    </tr>

    <tr class="table-warning">
        <th>Publish time</th>
        <td>${article.time}</td>
    </tr>

    <tr class="table-info">
        <th>Click</th>
        <td>${article.click}</td>
    </tr>

    <tr class="table-light">
        <th>Content</th>
        <td>${article.content}</td>
    </tr>
</table>

</body>
</html>
