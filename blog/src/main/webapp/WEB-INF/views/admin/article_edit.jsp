<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/16/18
  Time: 5:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <title>Ueditor</title>
    <script src="/static/js/jquery-3.3.1.min.js"></script>
    <script src="/static/js/jquery.slim.min.js"></script>
    <link rel="stylesheet" href="/static/bootstrap-3.3.7-dist/css/bootstrap.min.css">

    <%--<link rel="short icon" type="image/x-icon" href="${APP_PATH}/static/imgages/web-icon.png" media="screen"/>--%>
    <script src="/static/js/popper.min.js"></script>
    <script src="/static/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="/static/js/bootstrap4.0.min.js"></script>
    <script src="/static/js/layer.js"></script>

    <%--<script src="/static/js/ueditor/lang/en/en.js"></script>--%>
    <%--<script src="/static/js/ueditor/lang/zh-cn/zh-cn.js"></script>--%>
    <script src="/static/js/ueditor/ueditor.config.js"></script>
    <script src="/static/js/ueditor/ueditor.all.js"></script>
</head>
<body>

<div style="position: relative; top: 10%">
    <c:if test="${!empty succ}">
        <div class="alert alert-success" role="alert">
            ${succ}
        </div>
    </c:if>

    <c:if test="${!empty error}">
        <div class="alert alert-danger" role="alert">
            ${error}
        </div>
    </c:if>
</div>

<div class="container">
    <form action="/admin/article/edit/do" method="post">
        <input type="hidden" value="${article.id}" name="id">
        <div class="form-group">
            <label for="title">Article Title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="article title" value="${article.title}">
        </div>

        <div class="form-group">
            <label for="catalogId">CataLog</label>
            <select class="form-control" id="catalogId" name="catalogId">
                <option value="0" <c:if test="${article.catalogId==0}">selected="selected"</c:if>>Learn</option>
                <option value="1" <c:if test="${article.catalogId==1}">selected="selected"</c:if>>Life</option>
            </select>
        </div>

        <div class="form-group">
            <label for="keywords">Keywords</label>
            <input type="text" class="form-control" id="keywords" name="keywords" placeholder="Keywords" value="${article.keywords}">
        </div>

        <div class="form-group">
            <label for="desci">Description</label>
            <textarea class="form-control" id="desci" rows="3" name="desci" placeholder="Description">${article.desci}</textarea>
        </div>

        <div id="cont" style="display: none">
            ${article.content}
        </div>

        <div class="form-group">
            <%--<label for="editor">Content</label>--%>
            <%--<script id="editor" type="text/plain" name="content" style="width: 1024px; height: 500px;">--%>
                <%----%>
            <%--</script>--%>
        </div>
        <input type="submit" />
    </form>

    <script>
        $(function () {
            var ue = UE.getEditor('editor');
            ue.ready(function () {
                ue.setContent($("#cont").html());
            });
        });
    </script>
</div>


</body>
</html>
