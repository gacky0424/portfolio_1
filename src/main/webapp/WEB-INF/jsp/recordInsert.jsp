<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>商品管理システム</title>
</head>
<body style="background-color: #fffeee;">
	<form action="/portfolio_1/RecordInsertServlet" method="post">
		<h1>記録追加ページ</h1>
		<table border="1">
			<tr>
				<th></th>
				<th>商品番号</th>
				<th>商品名</th>
				<th>商品数量</th>
				<th>商品価格</th>
			</tr>
			<c:forEach var="products" items="${productsList}">
				<tr>
					<td></td>
					<td><c:out value="${products.productId}" /></td>
					<td><c:out value="${products.productName}" /></td>
					<td><c:out value="${products.productStock}" /></td>
					<td><c:out value="${products.productPrice}" /></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<select name="productId" size=4>
				<option value="A101">デジタルカメラ</option>
				<option value="A102">ヘッドホン</option>
				<option value="A103">30インチ4kテレビ</option>
				<option value="A104">タブレット</option>
			</select>
		<p>
			数量：<input type="text" name="amount">
		</p>
		<p>
			顧客：<input type="text" name="customer">
		</p>
		<p>
			<input style="margin-left: 300px;" type="submit" value="追加">
		</p>
	</form>
	<p>
		<a href="/portfolio_1/SalesRecordServlet">販売記録確認ページへ戻る</a><br> <a
			href="/portfolio_1/MainServlet">トップページへ戻る</a>
	</p>
</body>
</html>