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
<h1>トップページ</h1>
<p><c:out value="${loginUser.id}"/>がログイン中です。</p>
<ul>
<li><a href="/portfolio_1/StockCheckServlet">在庫確認</a></li>
<li><a href="/portfolio_1/SalesRecordServlet">販売記録</a></li>
<li><a href="/portfolio_1/LogoutServlet">ログアウト</a></li>
</ul>
</body>
</html>