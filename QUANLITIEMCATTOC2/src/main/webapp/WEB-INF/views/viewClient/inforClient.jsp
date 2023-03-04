<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<base href="${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Thông tin cá nhân</title>
	<style>
	</style>
</head>
<body>
	<h1>${message }</h1>
	<form:form action="inforPersonal/client/${usernameKH }.htm" method="post" modelAttribute="khachHang">
		<div>
			<label>SDT</label>
			<form:input path="soDienThoai" disabled="true"/>
		</div>
		<div>
			<label>Họ</label>
			<form:input path="ho"/>
		</div>
		<div>
			<label>Tên</label>
			<form:input path="ten"/>
		</div>
		<div>
			<label>Ngày sinh</label>
			<form:input path="ngaySinh"/>
		</div>
		<div>
			<label>Địa chỉ</label>
			<form:input path="diaChi"/>
		</div>
		<div>
			<label>Email</label>
			<form:input path="email"/>
		</div>
		<div>
			<button>Cập Nhật</button>
		</div>
</form:form>
</body>
</html>