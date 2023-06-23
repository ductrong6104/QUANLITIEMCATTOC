<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
     <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href = "${pageContext.servletContext.contextPath }/">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <script defer="defer" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
<!-- <link rel="stylesheet" href="css/ketXuatTable.css"> -->
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
	<jsp:include page="/WEB-INF/views/viewEmployee/dashboard.jsp" />
	<nav class="navbar navbar-expand bg-light py-0 fixed-top ct-navbar shadow">
        <div class="container-fluid px-4"> 
          
               <!-- button sidebar-dashboard -->
            <button class="navbar-toggler d-block d-lg-none me-3" type="button" data-bs-toggle="offcanvas" data-bs-target="#sidebar-dashboard" aria-controls="offcanvasExample">
                  <i class="bi bi-three-dots" data-bs-target="#sidebar-dashboard"></i>
            </button>
            <!-- button sidebar-dashboard -->
            
            
           
           
            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <form class="d-flex my-3">
                    <div class="input-group">
                        <input class="form-control" type="search" placeholder="Search for..." aria-label="Search"/>
                        <button class="btn" style="background-color:#4e73df !important" type="submit">
                            <i class="bi bi-search fw-bolder text-white"></i>
                        </button>
                        </div>
                      </form>
                 
                <ul class="navbar-nav ms-auto mb-2 mb-lg-0">
                       <li class="nav-item"><a role="button" href="loginNV.htm">Đăng xuất</a><li>
                </ul> 
            </div>
            
            
        </div>
    </nav>

        <div class="p-4 container-fluid" style="margin-top: 69.6px;background-color: #f7f8fb">
    
    <div class="container-fluid py-3 bg-white shadow-lg">
	${message }
	<table class="styled-table ct-navbar">
	<thead>
		<tr>
			<th>Mã sản phẩm</th>
			<th>Tên sản phẩm</th>
			<th>Mô tả</th>
			<th>Loại sản phẩm</th>
			<th>Giá</th>
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
						<f:formatNumber value="${p.gia }" type="currency"></f:formatNumber>
	
					</td>
				</tr>
			</c:forEach>
		</tbody>
		
	</table>
</div>
</div>

</body>
</html>