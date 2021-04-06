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
	<form action="/portfolio_1/RecordDeleteServlet" method="post">
		<h1>記録削除ページ</h1>
		<table border="1">
			<tr>
				<th></th>
				<th>販売番号</th>
				<th>販売時間</th>
				<th>顧客</th>
				<th>商品番号</th>
				<th>商品名</th>
				<th>数量</th>
				<th>価格</th>
			</tr>
			<c:forEach var="salesRecord" items="${salesRecordList}">
				<tr>
					<td><input type="checkbox" name="checkbox"
						value="${salesRecord.number}" /></td>
					<td><c:out value="${salesRecord.number}" /></td>
					<td><c:out value="${salesRecord.date}" /></td>
					<td><c:out value="${salesRecord.customer}" /></td>
					<td><c:out value="${salesRecord.productId}" /></td>
					<td><c:out value="${salesRecord.productName}" /></td>
					<td><c:out value="${salesRecord.productAmount}" /></td>
					<td><c:out value="${salesRecord.price}" /></td>
				</tr>
			</c:forEach>
		</table>
		<p>
			<input style="margin-left: 300px;" type="submit" value="削除">
		</p>
	</form>
	<p>
		<a href="/portfolio_1/SalesRecordServlet">販売記録確認ページへ戻る</a><br> <a
			href="/portfolio_1/MainServlet">トップページへ戻る</a>
	</p>
</body>
</html>