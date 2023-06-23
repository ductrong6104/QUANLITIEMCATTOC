<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<base href = "${pageContext.servletContext.contextPath }/">
	<meta charset="UTF-8">
	<title>Sản phẩm</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
    <link rel="stylesheet" href="css/neon.css" />
    <link rel="stylesheet" href="css/detail.css" />
    
</head>
<body>
<div style="padding-top: 2rem;" class="container-fluid d-flex flex-column justify-content-center align-items-center">
    <div class="row">
      <header class="col fixed-top text-white">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
              <img width="40" height="40" class="d-inline-block align-top"  src="image/2.jpg" />
              <h1 style="margin-left: 1rem; font-family: 'Yellowtail', 'sans-serif';" class="heading-primary neon-infinite">
                Barber Shop
              </h1>
            </a>
            <ul style="margin-left: 3rem;" class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-around mb-md-0">
              <li><a class="nav-link px-2 text-white" href="../home/home.html">HOME</a></li>
              <li><a class="nav-link px-2 text-white" href="client/notify.htm">THÔNG BÁO</a></li>
              <li><a class="nav-link px-2 text-white" href="client/serviceClient/booking.htm">ĐẶT LỊCH</a></li>
              <li><a class="nav-link px-2 text-white" href="client/serviceClient/index/${usernameKH}.htm">DỊCH VỤ</a></li>
              <li><a class="nav-link px-2 neon-blue-link" href="client/productClient/index/${usernameKH}.htm">SẢN PHẨM</a></li>
            </ul>
    
            <div class="text-end">
                <div class="btn btn-outline btd-flex me-2">
                  <a class="btn neon-blue" onclick="gotoCart()">
                      <i class="bi-cart-fill me-2"></i>
                      Giỏ hàng
                      <span class="badge bg-dark text-white ms-1 rounded-pill"><div id="itemCount">0</div></span>
                  </a>
                </div>
              <a role="button" class="btn btn-outline me-2 neon-blue" href="">PROFILE</a>
          <a role="button" class="btn btn-outline me-2 neon-red logout" href="client/loginKH.htm" >ĐĂNG XUẤT</a>
            </div>
          </div>    
      </header>
    </div>
    <div class="row">
      <section class="py-5">
          <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-4 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                  <div class="col mb-5">
                    <div class="card-cosmetics">
                      
                        <div class="content" data-item="124">
                          <img class="card-img-top" src="image/product/${ sanPham.hinhAnh}" />
                        
                        <div class="card-body p-4">
                            <div class="text-center" style="color:white;">
                                
                                <h5>${ sanPham.tenSanPham}t</h5>
                                <span>200.000 VND</span>
                            </div>
                        </div>
                        <div style="margin-bottom: 2rem;" class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                            <div class="text-center" style="color:white;"><button class="btn btn-outline mt-auto neon-blue" onclick="addItem(this)">Thêm vào giỏ</button></div>
                        </div>
                        </div>
                    </div>
                  </div>
  
                </div>
            </div>
        </section>
        <script>
          // Nơi lưu id mặt hàng
          let memo = [];
          function addItem(e){
              let cartCount = document.querySelector('#itemCount');
              cartCount.innerHTML = `${Number.parseInt(cartCount.innerHTML)+1}`;
              memo.push(e.parentElement.parentElement.parentElement.getAttribute("data-item"));
              let med = {};
              for (a of memo){
                med[a] = med[a] === undefined ? 0 : ++med[a];
              }
              if (localStorage.getItem("cart")){
                localStorage.removeItem("cart");
              }
              localStorage.setItem("cart", JSON.stringify(med));
          }
          function gotoCart(){
            window.location.pathname = "customer/cosmetics/detail.html";
          }
        </script>
    </div>
  </div>
<!--   <script type="module" src="../common/js/logout.js"></script> -->
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
</html>