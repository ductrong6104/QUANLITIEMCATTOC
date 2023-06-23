<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    <%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href = "${pageContext.servletContext.contextPath }/">
	<link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/home.css" />
    <link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
    <script src="https://code.jquery.com/jquery-3.7.0.min.js"></script>
</head>
<style type="text/css">
*[id$=errors]{
padding-top:20px;
color:red;
font-style: italic;
font-size:20px;
}
</style>

<body>
	<header class="header">
      <a href="#">
        
      </a>
      <nav class="main-nav">
        <ul class="main-nav-list">
          <li><a role="button" class="main-nav-link nav-cta neon-border" href="client/loginKH.htm">Đăng nhập</a></li>
        </ul>
      </nav>
    </header>

    <main>
      <section class="section-hero">
        <div class="hero">
          <div class="hero-text-box">
            <h1 class="heading-primary neon-infinite">
              Barber Shop
            </h1>
            <a onclick="$(document).scrollTop(2800);" class="btn btn--outline neon-border" id="datlich"
              >Đặt lịch ngay</a>
            <a onclick="$(document).scrollTop(800);" class="btn btn--outline neon-border">Khám phá &darr;</a>
            <div class="delivered-items">
              <div class="delivered-imgs">
              	<c:forEach var="img" items="${services }" begin="0" end="2">
               	 <img src="image/service/${img.hinhAnh }" alt="Customer photo" />
                </c:forEach>
              </div>
              <p class="delivered-text">
                <span>250,000+</span> khách hàng đã được phục vụ!
              </p>
            </div>
          </div>
          <div class="hero-img-box">
            <img
              src="image/service/${services.get(0).hinhAnh }"
              class="hero-img"
              alt="Woman enjoying food, items in storage container, and food bowls on a table"
            />
          </div>
        </div>
      </section>

      <section class="section-items" id="listService">
        <div class="container center-text">
          <h2 class="heading-secondary">
            Dịch vụ
          </h2>
        </div>

        <div class="container grid grid--3-cols margin-bottom-md">
        <c:forEach var="sv" items="${services }" begin="0" end="2">
        <div class="item">
            <img
              src="image/service/${sv.hinhAnh }"
              class="item-img"
              alt="hinh anh dich vu"
            />
            <div class="item-content">
              <p class="item-title">${sv.tenDichVu }</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong><f:formatNumber value="${sv.gia }" type="currency"></f:formatNumber></strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>Chứa mật ong giúp làm đẹp da</span>
                </li>
                <!-- <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.9</strong> rating (537)</span>
                </li> -->
              </ul>
            </div>
          </div>
        </c:forEach>
          

          
        </div>
      </section>

      <section class="section-items">
        <div class="container center-text">
          <h2 class="heading-secondary">
            Sản phẩm
          </h2>
        </div>

        <div class="container grid grid--3-cols margin-bottom-md">
          <c:forEach var="pd" items="${products }" begin="0" end="2">
        <div class="item">
            <img
              src="image/product/${pd.hinhAnh }"
              class="item-img"
              alt="hinh anh dich vu"
            />
            <div class="item-content">
              <p class="item-title">${pd.tenSanPham }</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong><f:formatNumber value="${pd.gia }" type="currency"></f:formatNumber></strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>Chứa mật ong giúp làm đẹp da</span>
                </li>
                <!-- <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.9</strong> rating (537)</span>
                </li> -->
              </ul>
            </div>
          </div>
        </c:forEach>
        </div>
      </section>

      <section class="section-cta" id="section-dangky">
        <div class="container">
          <div class="cta neon-border">
            <div class="cta-text-box">
              <h2 class="heading-secondary">Đăng kí thành viên để nhận thêm nhiều ưu đãi!</h2>
              <p class="cta-text">
                Có thể đặt lịch online, mua sắm tại cửa hàng, có thể nhận được voucher!
              </p>

              <form:form cssClass="cta-form" action="client/	home.htm" modelAttribute="logUp" method="POST">
                <div>
                  <label for="full-name">Họ Tên</label>
                  <form:input
                    id="full-name"
                    path="hoTen"
                    cssStyle="color:black;"
                    required="true"
                    type="text"
                    placeholder="Đào Huy Hiệu"
                  />
                  <form:errors path="hoTen"/>
                </div>

                <div>
                  <label for="phoneNumber">Số điện thoại (10 số)</label>
                  <form:input
                    id="phoneNumber"
                    path="sdt"
                    cssStyle="color:black;"
                    required="true"
                    type="tel"
                    pattern="[0-9]{10}"
                    placeholder="09xxxxxxxx"
                  />
                  <form:errors path="sdt"/>
                </div>
                <div>
                  <label for="pass">Mật khẩu</label>
                  <form:input
                    id="pass"
                    path="password"
                    cssStyle="color:black;"
                    required="true"
                    type="password"
                  />
                  <form:errors path="password"/>
                </div>
                <div>
                  <label for="passrepeat">Xác nhận lại mật khẩu</label>
                  <form:input
                    id="passrepeat"
                    path="passwordRepeat"
                    cssStyle="color:black;"
                    required="true"
                    type="password"
                  />
                  <form:errors path="passwordRepeat"/>
                </div>
				<div>
					<button class="btn btn--form neon-border" type="submit">Đăng kí ngay</button>
				</div>
                

                <!-- <input type="checkbox" />
                <input  /> -->
              </form:form>
            </div>
          </div>
        </div>
      </section>
    </main>

    <footer class="footer">
      <div class="container grid grid--footer">
       
        <div class="address-col">
          <p class="footer-heading neon-text">Contact us</p>
          <address class="contacts">
            <p class="address" style="color: #fff;">
              97 Man Thiện, Hiệp Phú, Quận 9, Thành phố Hồ Chí Minh
            </p>
            <p>
              <a class="footer-link" href="tel:415-201-6370">096-201-6370</a
              ><br />
              <a class="footer-link" href="mailto:hello@omnifood.com"
                >hello@omnifood.com</a
              >
            </p>
          </address>
        </div>
        <nav class="nav-col">
          <p class="footer-heading neon-text">Account</p>
          <ul class="footer-nav">
            <li><a class="footer-link" href="client/loginKH.htm">Sign in</a></li>
  
          </ul>
        </nav>

        
      </div>
    </footer>
  </body>
  <c:choose>
  	<c:when test="${success == true}">
  		<script type="text/javascript">
				alert("Đăng ký thành công!");
			</script>
  	</c:when>
  	<c:when test="${success == false}">
  		<script type="text/javascript">
				alert("Đăng ký thất bại!");
				document.getElementById('datlich').click()
			</script>
  	</c:when>
  	<c:otherwise></c:otherwise>
  </c:choose>

</body>
<!-- <script type="text/javascript">
	$('#datlich').click(function(){
	$(document).scrollTop(3500) // any value you need
	});
</script> -->
</html>