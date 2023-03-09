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
	<a role="button" href="product/insert/${usernameManager }.htm">Thêm</a>
	<table class="table table-hover">
		<tr>
			<th>Mã sản phẩm</th>
			<th>Tên sản phẩm</th>
			<th>Mô tả</th>
			<th>Hình ảnh</th>
			<th>Loại sản phẩm</th>
			<th>Giá</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
		<c:forEach var="p" items="${products }">
			<tr>
				<td>${p.maSanPham }</td>
				<td>${p.tenSanPham }</td>
				<td>${p.moTa }</td>
				<td></td>
				<td>${p.loaiSanPham.tenLoaiSanPham }</td>
				<td>
					<c:choose>
						<c:when test="${ p.giaSanPhams.size() != 0}"><f:formatNumber value="${p.giaSanPhams.get(0).gia }" type="currency"></f:formatNumber></c:when>
						<c:when test="${ p.giaSanPhams.size() == 0}">Chưa tạo giá</c:when>
					</c:choose>
				</td>
				<td><a role="button" href="product/update/${p.maSanPham }.htm">Sửa</a></td>
				<td><a role="button" href="product/delete/${p.maSanPham }.htm">Xóa</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>