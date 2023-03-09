<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	<title>Insert title here</title>
	<title>Tài khoản khách hàng</title>
	<base href="${pageContext.servletContext.contextPath }/">
     <link href="https://fonts.googleapis.com/css2?family=Roboto:wght@400;500&display=swap" rel="stylesheet">
     <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
     <style>
	     body{
	    margin: 0;
	    padding: 0;
	    font-family: 'Roboto', sans-serif;
		}
		section.section1{
		    width: 100%;
		    height: 100vh;
		    box-sizing: border-box;
		    background: url("image\\barbershop_background.jpg");
		    background-size: cover;
		}
		nav{
		    position: fixed;
		    top: 0;
		    left: 0;
		    width: 100%;
		    height: 80px;
		    background: rgba(0,0,0,0.4);
		    padding: 0 100px ;
		    box-sizing: border-box;
		    box-shadow: 0 1px 1px rgba(0,0,0,0.12),
		    0 2px 2px rgba(0,0,0,0.12),
		    0 4px 4px rgba(0,0,0,0.12),
		    0 8px 8px rgba(0,0,0,0.12),
		    0 16px 16px rgba(0,0,0,0.12);
		}
		
		nav .brand{
		    float: left;
		    height: 100%;
		    line-height: 80px;
		}
		nav .brand h2{
		    margin: 0;
		    padding: 0;
		    color: #fff;
		}
		nav ul{
		    float: right;
		    display: flex;
		    margin:0;
		    padding: 0;
		}
		nav ul li{
		    list-style: none;
		}
		nav ul li a{
		    position: relative;
		    display: block;
		    height: 80px;
		    line-height: 80px;
		    padding: 0 20px;
		    box-sizing: border-box;
		    color: #fff;
		    text-decoration: none;
		    text-transform: uppercase;
		    transition: 0.5s
		}
		
		nav ul li a:before{
		    content: '';
		    position: absolute;
		    top: 0;
		    left: 0;
		    width: 100%;
		    height: 100%;
		    background: #fff;
		    transform-origin: right;
		    z-index: -1;
		    transform: scaleX(0);
		    transition:  transform 0.5s;
		}
		nav ul li a:hover:before{
		    transform-origin: left;
		    transform: scaleX(1);
		}
		nav ul li a:hover{
		    color: #262626;
		}
		section.section2{
		    padding: 150px;
		}
     </style>
</head>
<body>
	<nav>
	    <div class="brand">
	        <h2>BARBER SHOP</h2>
	    </div>
	    <ul>
	        <li><a href=""><i class="fa fa-home" aria-hidden="true"></i> Trang Chủ</a></li>
	        <li><a role ="button" href="inforPersonal/client/${usernameKH }.htm"><i class="fa fa-info" aria-hidden="true"></i> Thông Tin Cá Nhân</a></li>
	        <li><a href=""><i class="fa fa-scissors" aria-hidden="true"></i> Dịch Vụ</a></li>
	        <li><a role ="button" href=""><i class="fa fa-product-hunt" aria-hidden="true"></i> Sản phẩm</a></li>
	        <li><a href=""><i class="fa fa-location-arrow" aria-hidden="true"></i> Địa Chỉ</a></li>
	        <li><a role="button" href="notification/index.htm"><i class="fa fa-bell" aria-hidden="true"></i> Thông Báo</a></li>
	    </ul>
	</nav>
	<!--Kết Thúc Navigation -->
	
	<!-- Dùng Để Chèn Hình Ảnh-->
	<section class="section1"></section>
</body>
</html>