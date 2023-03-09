<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sản phẩm</title>
	<base href = "${pageContext.servletContext.contextPath }/">
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link rel="stylesheet" href="css/neon.css" />
    <link rel="stylesheet" href="css/cosmetics.css" />
    <link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
</head>
<body>
<div class="container-fluid">
    <header class="p-3 fixed-top text-white">
      <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
        <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
          <img width="40" height="40" class="d-inline-block align-top" alt="Omnifood logo" src="image/2.jpg" />
          <h1 style="margin-left: 1rem; font-family: 'Yellowtail', 'sans-serif';" class="heading-primary neon-infinite">
            Barber Shop
          </h1>
        </a>
        <ul style="margin-left: 3rem;" class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-around mb-md-0">
          <li><a class="nav-link px-2 text-white" href="">HOME</a></li>
          <li><a class="nav-link px-2 text-white" href="notification/index/${usernameKH}.htm">THÔNG BÁO</a></li>
          <li><a class="nav-link px-2 text-white" href="">ĐẶT LỊCH</a></li>
          <li><a class="nav-link px-2 text-white" href="serviceClient/index/${usernameKH}.htm">DỊCH VỤ</a></li>
          <li><a class="nav-link px-2 neon-blue-link" href="productClient/index/${usernameKH}.htm">SẢN PHẨM</a></li>
        </ul>

        <div class="text-end">
          <a role="button" class="btn btn-outline me-2 neon-blue" href="">PROFILE</a>
          <a role="button" class="btn btn-outline me-2 neon-red logout" href="loginKH.htm" >ĐĂNG XUẤT</a>
        </div>
      </div>    
    </header>
    <template>
      <div class="card">
        <div class="content">
          <h2 class="neon-text-blue">01</h2>
          <h3>Búa</h3>
          <img
            src="image/2.jpg"
            class="comestic-item-img"
            alt="IMAGE"
          />
          <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Est voluptate, minus dolores aut unde totam, libero odit laborum eum cupiditate similique, culpa deleniti. Earum itaque voluptates dolore perferendis, ullam quos?</p>
          <a href="#" class="neon-blue">Mua</a>
        </div>
      </div>
    </template>
    <div id="carouselExampleIndicators" class="carousel" data-bs-ride="carousel">
      <div class="carousel">
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="0" class="active" aria-current="true" aria-label="Slide 1"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="1" aria-label="Slide 2"></button>
        <button type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide-to="2" aria-label="Slide 3"></button>
      </div>
      <div class="carousel-inner">
      <c:forEach var="i" items="${collectionPage}"> 
        <div class="carousel-item active">
          <div class="container">
            <div class="row">
              <div class="col" style="display: flex; justify-content: center; align-items: center;">
                <c:choose>
                	<c:when test="${i == collectionPage.size()-1}">
                		<c:forEach var="j" items="${products }" begin="${i*4 }" end="${ i*4+lastPage-1 }">
		                <div class="card">
		                  <div class="content">
		                    <h2 class="neon-text-blue"></h2>
		                    <h3>${j.tenSanPham }</h3>
		                    <img
		                      src="image/1.jpg"
		                      class="comestic-item-img"
		                      alt="IMAGE"
		                    />
		                    <p>${j.moTa }</p>
		                    <a href="#" class="neon-blue">Mua</a>
		                  </div>
		                </div>
		               	</c:forEach>
                	</c:when>
                	<c:when test="${i < collectionPage.size()-1}">
                		<c:forEach var="j" items="${products }" begin="${i*4 }" end="${ i*4+3}">
	                		<div class="card">
			                  <div class="content">
			                    <h2 class="neon-text-blue"></h2>
			                    <h3>${j.tenSanPham }</h3>
			                    <img
			                      src="image/1.jpg"
			                      class="comestic-item-img"
			                      alt="IMAGE"
			                    />
			                    <p>${j.moTa }</p>
			                    <a href="#" class="neon-blue">Mua</a>
			                  </div>
			                </div>
			           	</c:forEach>
                	</c:when>
                </c:choose>
        		</div>
            </div>
          </div>
       </div>
      </c:forEach>
      </div>
<%--         <c:forEach var="i" items="${collectionPage}"> --%>
<!--     	<div class="carousel-item active"> -->
<!--           <div class="container"> -->
<!--             <div class="row"> -->
<!--               <div class="col" style="display: flex; justify-content: center; align-items: center;"> -->
<%--                 <c:choose> --%>
<%--                 	<c:when test="${i == collectionPage.size()-1}"> --%>
<%--                 		<c:forEach var="j" items="${products }" begin="${i*4 }" end="${ i*4+lastPage-1 }"> --%>
<!-- 			                <div class="card"> -->
<!-- 			                  <div class="content"> -->
<!-- 			                    <h2 class="neon-text-blue"></h2> -->
<%-- 			                    <h3>${j.tenSanPham }</h3> --%>
<!-- 			                    <img -->
<!-- 			                      src="image/2.jpg" -->
<!-- 			                      class="comestic-item-img" -->
<!-- 			                      alt="IMAGE" -->
<!-- 			                    /> -->
<%-- 			                    <p>${j.moTa }</p> --%>
<!-- 			                    <a href="#" class="neon-blue">Mua</a> -->
<!-- 			                  </div> -->
<!-- 			                </div> -->
<%--                 		</c:forEach> --%>
<%--                 	</c:when> --%>
<%--                 	<c:when test="${i < collectionPage.size()-1}"> --%>
<%--                 		<c:forEach var="j" items="${products }" begin="${i*4 }" end="${ i*4+3}"> --%>
<!-- 			                <div class="card"> -->
<!-- 			                  <div class="content"> -->
<!-- 			                    <h2 class="neon-text-blue"></h2> -->
<%-- 			                    <h3>${j.tenSanPham }</h3> --%>
<!-- 			                    <img -->
<!-- 			                      src="image/1.jpg" -->
<!-- 			                      class="comestic-item-img" -->
<!-- 			                      alt="IMAGE" -->
<!-- 			                    /> -->
<%-- 			                    <p>${j.moTa }</p> --%>
<!-- 			                    <a href="#" class="neon-blue">Mua</a> -->
<!-- 			                  </div> -->
<!-- 			                </div> -->
<%--                 		</c:forEach> --%>
<%--                 	</c:when> --%>
<%--                 </c:choose> --%>
<%--      	 </c:forEach> --%>
      </div>
      <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="prev">
        <span class="carousel-control-prev-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Previous</span>
      </button>
      <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleIndicators" data-bs-slide="next">
        <span class="carousel-control-next-icon" aria-hidden="true"></span>
        <span class="visually-hidden">Next</span>
      </button>
    </div>
  </div>
<!--   <script type="module" src="../common/js/logout.js"></script> -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>