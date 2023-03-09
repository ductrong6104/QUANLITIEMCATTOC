<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<base href = "${pageContext.servletContext.contextPath }/">
	<link rel="stylesheet" href="css/common.css" />
    <link rel="stylesheet" href="css/home.css" />
    <link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
</head>
<body>
	<header class="header">
      <a href="#">
        <img class="logo" alt="Omnifood logo" src="image/2.jpg" />
      </a>
      <nav class="main-nav">
        <ul class="main-nav-list">
          <li><a role="button" class="main-nav-link nav-cta neon-border" href="loginKH.htm">Đăng nhập</a></li>
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
<!--             <a href="#" class="btn btn--full margin-right-sm neon-text" -->
<!--               >Đặt lịch ngay</a> -->
            <a href="#" class="btn btn--outline neon-border">Khám phá &darr;</a>
            <div class="delivered-items">
              <div class="delivered-imgs">
                <img src="image/1.jpg" alt="Customer photo" />
                <img src="image/2.jpg" alt="Customer photo" />
                <img src="image/1.jpg" alt="Customer photo" />
                <img src="image/2.jpg" alt="Customer photo" />
                <img src="image/1.jpg" alt="Customer photo" />
                <img src="image/2.jpg" alt="Customer photo" />
              </div>
              <p class="delivered-text">
                <span>250,000+</span> khách hàng đã được phục vụ!
              </p>
            </div>
          </div>
          <div class="hero-img-box">
            <img
              src="image/1.jpg"
              class="hero-img"
              alt="Woman enjoying food, items in storage container, and food bowls on a table"
            />
          </div>
        </div>
      </section>

      <section class="section-items">
        <div class="container center-text">
          <h2 class="heading-secondary">
            Dịch vụ
          </h2>
        </div>

        <div class="container grid grid--3-cols margin-bottom-md">
          <div class="item">
            <img
              src="image/1.jpg"
              class="item-img"
              alt="Japanese Gyozas"
            />
            <div class="item-content">
              <p class="item-title">Cắt tóc</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong>50.000 đ</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>Chứa mật ong giúp làm đẹp da</span>
                </li>
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.9</strong> rating (537)</span>
                </li>
              </ul>
            </div>
          </div>

          <div class="item">
            <img
              src="image/2.jpg"
              class="item-img"
              alt="Avocado Salad"
            />
            <div class="item-content">
              <div class="item-tags">
                <span class="tag tag--vegan">DA</span>
                <span class="tag tag--paleo">ĐỘ ẨM</span>
              </div>
              <p class="item-title">Mặt nạ vàng</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong>400.000 đ</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>NutriScore &reg; <strong>92</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.8</strong> rating (441)</span>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      <section class="section-items">
        <div class="container center-text">
          <h2 class="heading-secondary">
            Sản phẩm
          </h2>
        </div>

        <div class="container grid grid--3-cols margin-bottom-md">
          <div class="item">
            <img
              src="image/1.jpg"
              class="item-img"
              alt="Japanese Gyozas"
            />
            <div class="item-content">
              <div class="item-tags">
                <span class="tag tag--vegetarian">TÓC</span>
              </div>
              <p class="item-title">Dầu gội khô</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong>650.000 đ</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>Chứa mật ong giúp làm đẹp da</span>
                </li>
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.9</strong> rating (537)</span>
                </li>
              </ul>
            </div>
          </div>

          <div class="item">
            <img
              src="image/2.jpg"
              class="item-img"
              alt="Avocado Salad"
            />
            <div class="item-content">
              <div class="item-tags">
                <span class="tag tag--vegan">DA</span>
                <span class="tag tag--paleo">ĐỘ ẨM</span>
              </div>
              <p class="item-title">Mặt nạ vàng</p>
              <ul class="item-attributes">
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="flame-outline"></ion-icon>
                  <span><strong>400.000 đ</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon
                    class="item-icon"
                    name="restaurant-outline"
                  ></ion-icon>
                  <span>NutriScore &reg; <strong>92</strong></span>
                </li>
                <li class="item-attribute">
                  <ion-icon class="item-icon" name="star-outline"></ion-icon>
                  <span><strong>4.8</strong> rating (441)</span>
                </li>
              </ul>
            </div>
          </div>
        </div>
      </section>

      <section class="section-cta">
        <div class="container">
          <div class="cta neon-border">
            <div class="cta-text-box">
              <h2 class="heading-secondary">Đăng kí thành viên để nhận thêm nhiều ưu đãi!</h2>
              <p class="cta-text">
                Có thể đặt lịch online, mua sắm tại cửa hàng, có thể nhận được voucher!
              </p>

              <form class="cta-form" action="#">
                <div>
                  <label for="full-name">Họ Tên</label>
                  <input
                    id="full-name"
                    type="text"
                    placeholder="Đào Huy Hiệu"
                    required
                  />
                </div>

                <div>
                  <label for="email">Số điện thoại</label>
                  <input
                    id="phoneNumber"
                    type="tel"
                    placeholder="0344xxxxxx"
                    required
                  />
                </div>

                <button class="btn btn--form neon-border">Đăng kí ngay</button>

                <!-- <input type="checkbox" />
                <input  /> -->
              </form>
            </div>
          </div>
        </div>
      </section>
    </main>

    <footer class="footer">
      <div class="container grid grid--footer">
        <div class="logo-col">
          <a href="#" class="footer-logo">
            <img class="logo" alt="Omnifood logo" src="image/2.jpg" />
          </a>

          <ul class="social-links">
            <li>
              <a class="footer-link" href="#"
                ><ion-icon class="social-icon" name="logo-instagram"></ion-icon
              ></a>
            </li>
            <li>
              <a class="footer-link" href="#"
                ><ion-icon class="social-icon" name="logo-facebook"></ion-icon
              ></a>
            </li>
            <li>
              <a class="footer-link" href="#"
                ><ion-icon class="social-icon" name="logo-twitter"></ion-icon
              ></a>
            </li>
          </ul>

          <p class="copyright">
            Copyright &copy; 2027 by Omnifood, Inc. All rights reserved.
          </p>
        </div>
        <div class="address-col">
          <p class="footer-heading neon-text">Contact us</p>
          <address class="contacts">
            <p class="address" style="color: #fff;">
              623 Harrison St., 2nd Floor, San Francisco, CA 94107
            </p>
            <p>
              <a class="footer-link" href="tel:415-201-6370">415-201-6370</a
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
            <li><a class="footer-link" href="#">Create account</a></li>
            <li><a class="footer-link" href="#">Sign in</a></li>
            <li><a class="footer-link" href="#">iOS app</a></li>
            <li><a class="footer-link" href="#">Android app</a></li>
          </ul>
        </nav>

        <nav class="nav-col">
          <p class="footer-heading neon-text">Company</p>
          <ul class="footer-nav">
            <li><a class="footer-link" href="#">About Omnifood</a></li>
            <li><a class="footer-link" href="#">For Business</a></li>
            <li><a class="footer-link" href="#">Cooking partners</a></li>
            <li><a class="footer-link" href="#">Careers</a></li>
          </ul>
        </nav>

        <nav class="nav-col">
          <p class="footer-heading neon-text">Resources</p>
          <ul class="footer-nav">
            <li><a class="footer-link" href="#">Recipe directory </a></li>
            <li><a class="footer-link" href="#">Help center</a></li>
            <li><a class="footer-link" href="#">Privacy & terms</a></li>
          </ul>
        </nav>
      </div>
    </footer>
  </body>
</body>
</html>