<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<base href = "${pageContext.servletContext.contextPath }/">
	<title>Dashboard</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-icons/1.10.3/font/bootstrap-icons.min.css"/>
    <script defer="defer" src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
	<link rel="stylesheet" href="css/dashboard.css">
	
	
</head>
<body>
	
                 <div
                 class="offcanvas offcanvas-start sidebar-nav bg-dark shadow-lg" data-bs-scroll="true" style="background-color: #4e73df !important" tabindex="-1" id="sidebar-dashboard">
                 <div class="offcanvas-body">
                   <nav class="navbar-dark">
                   
                   <!-- Nội dung sidebar-dashboad  -->
               <ul class="navbar-nav">
           
                   <li class="d-flex px-3">
                       <a href="product/index/${usernameManager }.htm" class="nav-link active py-0">
                           <span class="me-2"><i class="bi bi-person-fill-gear fw-bolder fs-4"></i></span>
                           <span class="fs-4 fw-bolder">Quản lí</span>
                       </a>
                   </li>
           
                   <li>
                       <hr />
                   </li>
           
                   <li>
                       <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts"> <span class="me-2"><i
                                   class="bi bi-box2-fill"></i></span> <span>Sản phẩm</span> <span class="ms-auto"> <span
                                   class="right-icon"> <i class="bi bi-chevron-down"></i>
                               </span>
                           </span>
                       </a>
                       <div class="collapse" id="layouts">
                           <ul class="navbar-nav ps-3">
                               <li><a role="button" href="product/index/${usernameManager }.htm" class="nav-link px-3"> <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                       <span>Danh sách sản phẩm</span>
                                   </a> 
                                   <a role="button" href="product/insert/${usernameManager }.htm" class="nav-link px-3"> <span class="me-2"><i
                                               class="bi bi-folder-plus"></i></span> <span>Thêm sản phẩm</span>
                                   </a></li>
                           </ul>
                       </div>
                   </li>
           
                   <li>
                       <hr />
                   </li>

                   <li>
                    <a class="nav-link px-3 sidebar-link" data-bs-toggle="collapse" href="#layouts1"> <span class="me-2"><i
                                class="bi bi-box2-fill"></i></span> <span>Dịch vụ</span> <span class="ms-auto"> <span
                                class="right-icon"> <i class="bi bi-chevron-down"></i>
                            </span>
                        </span>
                    </a>
                    <div class="collapse" id="layouts1">
                        <ul class="navbar-nav ps-3">
                            <li><a role="button" href="service/index/${usernameManager }.htm" class="nav-link px-3"> <span class="me-2"><i class="bi bi-speedometer2"></i></span>
                                    <span>Danh sách dịch vụ</span>
                                </a> <a role="button" href="service/insert/${usernameManager }.htm" class="nav-link px-3"> <span class="me-2"><i
                                            class="bi bi-folder-plus"></i></span> <span>Thêm dịch vụ</span>
                                </a></li>
                        </ul>
                    </div>
                </li>
        
                <li>
                    <hr />
                </li>
           
                   <li>
                        <a href="#" class="nav-link px-3"> 
                            <span class="me-2"><i class="bi bi-cart"></i></span> 
                            <span>Đơn hàng</span>
                        </a>
                    </li>
               </ul>
                    <!-- Nội dung sidebar-dashboad  -->
                   </nav>
                 </div>
               </div>
               
               
         
	
</body>
</html>