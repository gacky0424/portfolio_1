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
<h1>在庫確認ページ</h1>
<table border="1">
	<tr>
		<th>商品番号</th>
		<th>商品名</th>
		<th>商品在庫</th>
		<th>商品原価</th>
		<th>商品総原価</th>
		<th>商品価格</th>
		<th>商品総価格</th>
	</tr>
	<c:forEach var="products" items="${productsList}">
	<tr>
		<td><c:out value="${products.productId}"/></td>
		<td><c:out value="${products.productName}"/></td>
		<td><c:out value="${products.productStock}"/></td>
		<td><c:out value="${products.productCost}"/></td>
		<td><c:out value="${products.productCost * products.productStock}"/></td>
		<td><c:out value="${products.productPrice}"/></td>
		<td><c:out value="${products.productPrice * products.productStock}"/></td>
	</tr>
	</c:forEach>
</table>
<p><a href="/portfolio_1/MainServlet">トップページへ戻る</a></p>
</body>
</html>