<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href = "${pageContext.servletContext.contextPath }/">
	<title>Sản phẩm</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
    <script defer="defer" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="css/dashboard.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/viewManager/dashboard.jsp" />
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
    

<main>
        <div class="p-4 container-fluid" style="margin-top: 69.6px;background-color: #f7f8fb">
    
    <div class="container-fluid py-3 bg-white shadow-lg">
        <form class="mt-4 row gy-4" action="product/insert/${usernameManager}.htm" enctype="multipart/form-data" method="POST">
        
            <div class="col-12 col-md-6">
	            	<div>
				<label for="exampleFormControlInput1" class="form-label">Mã sản phẩm</label>
				<input class="form-control" name="maSanPham" id="exampleFormControlInput1"/>
				</div>
                <div>
                  <label for="exampleFormControlInput1" class="form-label">Tên sản phẩm</label>
                  <input name="tenSanPham" class="form-control" id="exampleFormControlInput1">
                </div>
            
                <div class="mt-4">
                    <label for="exampleFormControlTextarea1" class="form-label">Mô tả</label>
                      <textarea name="moTa" class="form-control" id="exampleFormControlTextarea1" rows="3"></textarea>
                </div>
                
                <div class="row"> 
                
                
                    <div class="mt-4 col-12 col-md-6">
                        <label for="exampleFormControlTextarea1" class="form-label">Loại sản phẩm</label>
                        <select class="form-select" name="loaiSanPham" aria-label="Default select example">
                        	<option selected>Open this select menu</option>
							<c:forEach var="type" items="${typeProducts}">
								<option value="${type.maLoaiSanPham}">${type.tenLoaiSanPham}</option>
							</c:forEach>
						</select>	
                    </div>
                    
<!--                     <div class="mt-4 col-12 col-md-6"> -->
<!--                         <label for="exampleFormControlTextarea1" class="form-label">Màu</label> -->
<!--                         <select class="form-select" aria-label="Default select example"> -->
<!--                           <option selected>Open this select menu</option> -->
<!--                           <option value="1">Xanh</option> -->
<!--                           <option value="2">Đỏ</option> -->
<!--                           <option value="3">Vàng</option> -->
<!--                         </select> -->
<!--                     </div> -->
                
                </div>
                
                <div class="mt-4"> 
                    <label for="exampleFormControlInput1" class="form-label">Giá tiền</label>
                   <input name="gia" type="number" class="form-control" id="exampleFormControlInput1">
                </div>
                
                <div class="row mt-4">
                    <div class="col-6">
                        <label for="exampleFormControlInput1" class="form-label">Hình ảnh</label>
                        <input name="hinhAnh" type="file" id="exampleFormControlInput1">
                    </div>
                 	<div>
						<label for="exampleFormControlInput1" class="form-label" >Quản lí tạo</label>
						<input name="quanLiTaoSanPham" id="exampleFormControlInput1" value="${manager.ten }" disabled="disabled" class="form-control"/>
					</div>
                </div>
                
                
                 
            </div>
            
<!--             <div class="col-12 col-md-6"> -->
                
<!--                 <div class="row gx-3 gy-5"> -->
                
<!--                  <label for="exampleFormControlInput1" class="form-label">Số lượng</label> -->
                 
    
                     
<%--                      <c:forEach var = "i" begin = "35" end = "46"> --%>
                         
                         
<!--                          <div class="col-3 col-md-4 col-xl-3"> -->
<!--                              <div class="form-floating"> -->
<%--                               <input type="number" class="form-control" min="0" id="floatingInput" placeholder="size-${i}"> --%>
<%--                               <label for="floatingInput"><c:out value = "size ${i}"/></label> --%>
<!--                             </div> -->
<!--                          </div> -->
<%--                       </c:forEach> --%>
<!--                  </div> -->
                 
<!--                  <div class="mt-4"> -->
                     
<!--                  </div> -->
                    
<!--             </div> -->
            <div class="col-12 mt-4">
                <button style="background-color:#4e73df !important" type="submit" class="btn btn-success btn-block w-100 fw-bolder">Thêm</button>
            </div>
            
        
        </form>
        
        
        
    </div>
        </div>

</main>

    <div class="py-3 ct-navbar text-sm text-center bg-white shaldow-lg">end</div>
</body>
</html>