<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Thông Báo</title>
	<style>
		table{
			border-collapse:collapse;
			width: 100%;
		}
		th, td{
			line-height:25px;
			border: 1px solid black;
			padding: 5px;
		}
		th{
			background-color:gray;
		}
	</style>
</head>
<body>
	<h1>${message }</h1>
	<table class="table table-hover">
		<tr>
			<th>Tiêu đề</th>
			<th>Nội dung rút gọn</th>
			<th>Ngày giờ đăng</th>
			<th>Xem chi tiết</th>
			<th>Quản lí tạo</th>
		</tr>
		<c:forEach var="u" items="${list }">
			<tr>
				<td>${u.tieuDe }</td>
				<td>${u.noiDungRutGon }</td>
				<td>${u.ngayGioDang }</td>
				<td>${u.xemChiTiet }</td>
				<td>${u.quanLiTB.ten }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>