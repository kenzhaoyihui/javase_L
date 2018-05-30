<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 5/30/18
  Time: 6:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Spring Landing Page</title>
</head>
<body>
<h2>Spring Landing Page</h2>
<p>Click to return a simple html</p>

<form:form method="get" action="/finalpage">
    <table>
        <tr>
            <td>
                <input type="submit" value="get the HTML page" />
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
