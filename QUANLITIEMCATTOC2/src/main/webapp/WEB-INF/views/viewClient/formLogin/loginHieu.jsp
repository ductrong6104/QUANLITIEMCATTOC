<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri= "http://www.springframework.org/tags/form" prefix="form" %>
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
<style>
	*[id$=.errors]{
		color:red; font-style: italic;
	}
</style>
<body>
	<div class="container">
	    <div class="watermark">
	      <h1 class="neon-text-header">Barber shop</h1>
	    </div>
	     <form:form action="client/loginKH.htm" id="noti-form" method ="POST" modelAttribute="account">
	     <!-- <form id="form-login"> -->
	      <div class="input-group">
	        <label for="phoneNumber" class="neon-text">Số điện thoại:</label>
	        <form:input path="username" id="phoneNumber" required="true" type="text" pattern="[0-9]{10}"/>
	        <form:errors path="username"/>
	      </div>
	      <div class="input-group">
	        <label for="password" class="neon-text">Mật khẩu:</label>
	        <form:input path="password" id="password" required="true" type="password"/>
	        <form:errors path="password"/>
	      </div>
	      <div class="input-group">
	        <button type="submit" class="btn-neon neon-text">Đăng nhập</button>
	      </div>
	      
	      
	    </form:form>
	    <div class="input-group">
	      	<a style="border-radius: 5px;border: 1px solid white; padding: 5px;margin-left:370px; color:white" class="btn-neon neon-text">Đăng ký</a>
	      </div>
	    <script src="../constants/common.js" type="module"></script>
	    <script src="./login.js" type="module"/>
	  </div>
</body>
</html>