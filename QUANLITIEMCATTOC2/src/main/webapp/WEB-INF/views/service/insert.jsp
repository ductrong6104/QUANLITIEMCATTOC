<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Insert Service</title>
</head>
<body>
	<form action="service/insert/${usernameManager}.htm"  method="POST">
		<div>
			<label>Mã dịch vụ</label>
			<input name="maDichVu"/>
		</div>
		<div>
			<label>Tên dịch vụ</label>
			<input name="tenDichVu"/>
		</div>
		<div>
			<label>Thời gian thực hiện</label>
			<input name="thoiGianThucHien"/>
		</div>
		<div>
			<label>Mô tả</label>
			<input name="moTa"/>
		</div>
		<div>
			<label>Hình ảnh</label>
			<input name="hinhAnh"/>
		</div>
		<div>
			<label>Loại dịch vụ</label>
			<select name="loaiDichVu" >
				<c:forEach var="type" items="${typeServices}">
					<option value="${type.maLoaiDichVu}">${type.tenLoaiDichVu}</option>
				</c:forEach>
			</select>
		</div>
<!-- 		<div> -->
<!-- 			<label>Gía</label> -->
<!-- 			<input name="gia"/> -->
<!-- 		</div> -->
		<div>
			<label>Quản lí tạo</label>
			<input name="quanLiTaoDichVu" value="${manager.ten }" disabled="disabled"/>
		</div>
		<div>
			<button>Insert</button>
		</div>
	</form>
</body>
</html>