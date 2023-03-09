<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Insert title here</title>
	<link rel="stylesheet" href="css/ketXuatTable.css">
</head>
<body>
	<h1>${message }</h1>
	<a role="button" href="service/insert/${usernameManager }.htm">Thêm</a>
	<table class="table table-hover">
		<tr>
			<th>Mã dịch vụ</th>
			<th>Tên dịch vụ</th>
			<th>Thời gian thực hiện</th>
			<th>Mô tả</th>
			<th>Hình ảnh</th>
			<th>Loại dịch vụ</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach var="s" items="${services }">
			<tr>
				<td>${s.maDichVu }</td>
				<td>${s.tenDichVu }</td>
				<td>${s.thoiGianThucHien }</td>
				<td>${s.moTa }</td>
				<td>${s.hinhAnh }</td>
				<td>${s.loaiDichVu.tenLoaiDichVu }</td>
				<td><a role="button" href="service/update/${s.maDichVu }.htm">Sửa</a></td>
				<td><a role="button" href="service/delete/${s.maDichVu }.htm">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>