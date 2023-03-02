<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href = "${pageContext.servletContext.contextPath }/">
</head>
<body>
	<table class="table table-hover">
		<tr>
			<th>Tài khoản</th>
			<th>password</th>
			<th>trang thai</th>
			<th>quyen</th>
		</tr>
		<c:forEach var="r" items="${tknv }">
			<tr>
				<td>${r.userNameNhanVien }</td>
				<td>${r.passWord}</td>
				<td>${r.trangThaiTaiKhoanNhanVien.tenTrangThai }</td>
				<td>${r.quyen.tenQuyen }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>