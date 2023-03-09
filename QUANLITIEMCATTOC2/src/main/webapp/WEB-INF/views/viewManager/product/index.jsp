<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
    <script defer="defer" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<link rel="stylesheet" href="css/ketXuatTable.css">
	<link rel="stylesheet" href="css/dashboard.css">
	<style>
		table {
		    border-collapse: collapse;
		    margin: 25px 0;
		    font-size: 0.9em;
		    font-family: sans-serif;
		    min-width: 400px;
		    box-shadow: 0 0 20px rgba(0, 0, 0, 0.15);
		}

		table thead tr {
		    background-color: #5a7be0;
		    color: #ffffff;
		    text-align: left;
		}
		
		table th,
		table td {
		    padding: 12px 15px;
		}
		
		table tbody tr {
		    border-bottom: 1px solid #dddddd;
		}
		
		table tbody tr:nth-of-type(even) {
		    background-color: #f3f3f3;
		}
		
		table tbody tr:last-of-type {
		    border-bottom: 2px solid #5a7be0;
		}
		
		table tbody tr.active-row {
		    font-weight: bold;
		    color: #5a7be0;
		}
	</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/viewManager/dashboard.jsp" />
	${message }
	<table class="styled-table ct-navbar">
	<thead>
		<tr>
			<th>Mã sản phẩm</th>
			<th>Tên sản phẩm</th>
			<th>Mô tả</th>
			<th>Loại sản phẩm</th>
			<th>Giá</th>
			<th>Cập nhật</th>
			<th>Xóa</th>
		</tr>
	</thead>
		<tbody>
			<c:forEach var="p" items="${products }">
				<tr>
					<td>${p.maSanPham }</td>
					<td>${p.tenSanPham }</td>
					<td>${p.moTa }</td>
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
		</tbody>
		
	</table>

</body>
</html>