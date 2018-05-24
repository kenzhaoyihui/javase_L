<%--
  Created by IntelliJ IDEA.
  User: yzhao_sherry
  Date: 5/22/18
  Time: 1:36 PM
  To change this template use File | Settings | File Templates.
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>用户订单列表</title>
</head>
<body>
<c:forEach items="${orders}" var="order">
    订单号：${order.orderNo }，订单总额：${order.money }<br />
</c:forEach>
</body>
</html>
