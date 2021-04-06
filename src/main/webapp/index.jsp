<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理システム</title>
</head>
<body style="background-color: #fffeee;">
<h1>商品管理システム</h1>
<form action="/portfolio_1/LoginServlet" method="post">
<p>ユーザーID：<input style="margin-left: 8px;" type="text" name="id" autofocus></p>
<p>ユーザーPW：<input type="password" name="pass" required></p>
<c:if test ="${not empty msg}">
	<p style="color:red;">${msg}</p>
</c:if>
<input style="margin-left: 120px;" type="submit" value="ログイン">&nbsp;&nbsp;
<input type="reset" value="キャンセル">
</form>
</body>
</html>