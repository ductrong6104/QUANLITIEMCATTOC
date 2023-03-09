<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thông báo</title>
<base href = "${pageContext.servletContext.contextPath }/">
<link rel="stylesheet" href="css/notify.css" />
<link rel="stylesheet" href="css/common2.css" />
<script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
</head>
<body>

	<header class="header">
        <a href="#">
          <img class="logo" alt="Barber logo" src="image/2.jpg" />
        </a>
        <nav class="main-nav">
          <ul class="main-nav-list">
          	<li><a role="button" class="main-nav-link neon-text" href="#">HOME</a></li>
            <li><a class="neon-infinite" href="#">THÔNG BÁO</a></li>
            <li><a class="main-nav-link neon-text" href="#">ĐẶT LỊCH</a></li>
            <li><a role="button" class="main-nav-link neon-text" href="serviceClient/index/${usernameKH}.htm">DỊCH VỤ</a></li>
            <li><a role="button" class="main-nav-link neon-text" href="productClient/index/${usernameKH}.htm">SẢN PHẨM</a></li>
            <li><a class="main-nav-link nav-cta neon-border" href="loginKH.htm">Đăng xuất</a></li>
          </ul>
        </nav>
    </header>
    <main>
      <section class="section-noti">
        <div id="noti">
          <table id="noti-table" class="neon-border">
            <thead>
              <tr>
                <th>Tiêu đề</th>
			<th>Nội dung</th>
			<th>Ngày giờ đăng</th>
			
              </tr>
            </thead>
            <tfoot></tfoot>
            <tbody>
              <c:forEach var="u" items="${notifys }">
				<tr>
					<td>${u.tieuDe }</td>
					<td>${u.noiDung }</td>
					<td>${u.ngayGioDang }</td>
				</tr>
			</c:forEach>
            </tbody>
          </table>
        </div>
      </section> 
    </main>
   
</body>
</body>
</html>