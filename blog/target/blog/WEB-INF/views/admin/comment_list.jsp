<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 6/16/18
  Time: 5:49 PM
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
    <c:if test="${!empty comments}">
        <table class="table">
            <%--<thead class="thead-default">--%>
            <tr>
                <th>Running Number</th>
                <th>Article ID</th>
                <th>Comment Content</th>
                <th>Date</th>
                <th>NickName</th>
                <th>Email</th>
                <th>Delete</th>

            </tr>
            <%--</thead>--%>

            <c:forEach items="${comments}" var="comment">
                <tr>
                    <th scope="row">${comment.id}</th>
                    <td>${comment.articleId}</td>
                    <td>${comment.content}</td>
                    <td>${comment.date}</td>
                    <td>${comment.name}</td>
                    <td>${comment.email}</td>
                    <td><button type="button" class="btn btn-outline-danger btn-sm" onclick="ifdelete('${comment.id}')">Delete</button> </td>
                </tr>
            </c:forEach>
        </table>

        <script src="/static/js/jquery-3.3.1.min.js"></script>
        <script>
            function ifdelete(id) {
                layer.confirm('Confirm to delete the comment?', {
                    btn: ['Confirm', 'Cancel']
                }, function () {
                    $.ajax({
                        type: 'POST',
                        url: '/api/comment/del',
                        dataType: 'json',
                        data: {"id": id},
                        success: function (data) {
                            if(data['stateCode']==1){
                                layer.msg('Delete Successfully', {icon:1, time:1000});
                                setTimeout("window.location.reload()", 1000);
                            }else {
                                layer.msg('Delete Failed', {icon:5, time: 1000});
                            }
                        },
                        error: function (data) {
                            console.log('Error...');
                        },
                    });
                }, function () {

                });
            }
        </script>
    </c:if>

    <c:if test="${empty comments}">
        <div class="card">
            <div class="card-body">
                The article has no comments!
            </div>
        </div>
    </c:if>
</div>

</body>
</html>
