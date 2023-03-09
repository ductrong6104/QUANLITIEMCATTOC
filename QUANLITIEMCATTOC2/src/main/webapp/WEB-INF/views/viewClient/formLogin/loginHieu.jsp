<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href = "${pageContext.servletContext.contextPath }/">
<link rel="stylesheet" href="css/loginHieu.css">
 <link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
    <title>Document</title>
</head>
<body>
	<div class="container">
	    <div class="watermark">
	      <h1 class="neon-text-header">Barber shop</h1>
	    </div>
	     <form action="loginKH.htm" id="form-login" method ="POST">
	     <form id="noti-form">
	      <div class="input-group">
	        <label for="phoneNumber" class="neon-text">Số điện thoại:</label>
	        <input type="text" id="username" name="username" required>
	      </div>
	      <div class="input-group">
	        <label for="password" class="neon-text">Mật khẩu:</label>
	        <input type="password" id="password" name="password" required>
	      </div>
	      <div class="input-group">
	        <button type="submit" class="btn-neon neon-text">Đăng nhập</button>
	      </div>
	    </form>
<!-- 	    <script src="../constants/common.js" type="module"></script> -->
<!-- 	    <script src="./login.js" type="module"/> -->
	  </div>
</body>
</html>