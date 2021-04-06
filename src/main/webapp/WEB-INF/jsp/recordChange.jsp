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
	<form action="/portfolio_1/SalesRecordChangeServlet" method="post">
		<h1>販売記録確認ページ</h1>
		<table border="1">
			<tr>
				<th>販売番号</th>
				<th>販売時間</th>
				<th>顧客</th>
				<th>商品番号</th>
				<th>商品名</th>
				<th>数量</th>
				<th>価格</th>
			</tr>
			<c:forEach var="salsesRecord" items="${salsesRecordList}">
				<tr>
					<td><input type="checkbox" name="checkbox" value="${salsesRecord.number}" /><c:out value="${salsesRecord.number}" /></td>
					<td><c:out value="${salsesRecord.date}" /></td>
					<td><c:out value="${salsesRecord.customer}" /></td>
					<td><c:out value="${salsesRecord.productId}" /></td>
					<td><c:out value="${salsesRecord.productName}" /></td>
					<td><c:out value="${salsesRecord.productAmount}" /></td>
					<td><c:out value="${salsesRecord.price}" /></td>
				</tr>
			</c:forEach>
		</table>
	</form>
	<p>
		<a href="/portfolio_1/MainServlet">トップページへ戻る</a>
	</p>
</body>
</html>