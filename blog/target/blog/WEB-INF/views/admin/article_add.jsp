<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/16/18
  Time: 5:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>

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
    <script src="/static/js/ueditor/ueditor.all.js"></script>
    <script src="/static/js/ueditor/ueditor.config.js"></script>
    <script src="/static/js/wangEditor.min.js"></script>
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
    <form action="/admin/article/add/do" method="post">
        <div class="form-group">
            <label for="title">Article title</label>
            <input type="text" class="form-control" id="title" name="title" placeholder="article title">
        </div>

        <div class="form-group">
            <label for="catalogId">CataLogId</label>
            <select class="form-control" id="catalogId" name="catalogId">
                <option value="0">Learn</option>
                <option value="1">Life</option>
            </select>
        </div>

        <div class="form-group">
            <label for="keywords">Keywords</label>
            <input type="text" class="form-control" id="keywords" name="keywords" placeholder="keywords">
        </div>

        <div class="form-group">
            <label for="desci">Description</label>
            <textarea id="desci" name="desci" rows="3" placeholder="Description"></textarea>
        </div>

        <div class="form-group">
            <label for="div1">Content</label>
            <div id="div1">
            </div>
            <%--<textarea id="content" name="content" style="display: none"></textarea>--%>
            <textarea id="content" name="content"></textarea>
        </div>
        <input type="submit" value="Publish">
    </form>

    <script type="text/javascript">
        var E = window.wangEditor
        var editor = new E('#div1')
        var $text1 = $('content')
        editor.customConfig.onchange = function (html) {
            $text1.val(html)
        }
        editor.creat()
        $text1.val(editor.txt.html())
    </script>
</div>

</body>
</html>
