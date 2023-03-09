<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Insert Product</title>
</head>
<body>
	<form action="product/insert/${usernameManager}.htm"  method="POST">
		<div>
			<label>Mã sản phẩm</label>
			<input name="maSanPham"/>
		</div>
		<div>
			<label>Tên sản phẩm</label>
			<input name="tenSanPham"/>
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
			<label>Loại sản phẩm</label>
			<select name="loaiSanPham" >
				<c:forEach var="type" items="${typeProducts}">
					<option value="${type.maLoaiSanPham}">${type.tenLoaiSanPham}</option>
				</c:forEach>
			</select>
		</div>
<!-- 		<div> -->
<!-- 			<label>Gía</label> -->
<!-- 			<input name="gia"/> -->
<!-- 		</div> -->
		<div>
			<label>Quản lí tạo</label>
			<input name="quanLiTaoSanPham" value="${manager.ten }" disabled="disabled"/>
		</div>
		<div>
			<button>Insert</button>
		</div>
	</form>
<%-- <form:form action="product/insert/${usernameManager}.htm"  method="POST" modelAttribute="product"> --%>
<!-- 		<div> -->
<!-- 			<label>Mã sản phẩm</label> -->
<%-- 			<form:input path="maSanPham"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<label>Tên sản phẩm</label> -->
<%-- 			<form:input path="tenSanPham"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<label>Mô tả</label> -->
<%-- 			<form:input path="moTa"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<label>Hình ảnh</label> -->
<%-- 			<form:input path="hinhAnh"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<label>Loại sản phẩm</label> -->
<%-- 			<form:select path="loaiSanPham" items="${ typeProducts}"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<label>Quản lí tạo</label> -->
<%-- 			<form:input path="quanLiTaoSanPham.ten" value="${manager.ten }" disabled="true"/> --%>
<!-- 		</div> -->
<!-- 		<div> -->
<!-- 			<button>Insert</button> -->
<!-- 		</div> -->
<%-- 	</form:form> --%>
</body>
</html>