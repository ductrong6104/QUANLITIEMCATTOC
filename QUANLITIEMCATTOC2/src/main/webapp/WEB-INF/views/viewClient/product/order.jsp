
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jstl/fmt_rt" prefix="f" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Booking</title>
    <base href = "${pageContext.servletContext.contextPath }/">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
	<link href='https://fonts.googleapis.com/css?family=Yellowtail:400' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.min.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.css">
	<link rel="stylesheet" href="css/neon.css" />
    <link rel="stylesheet" href="css/service.css" />
    <link rel="stylesheet" href="css/style.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
    <script src="//cdnjs.cloudflare.com/ajax/libs/timepicker/1.3.5/jquery.timepicker.min.js"></script>
</head>
<style>
    i{
    	color: red;
    }
    </style>

<body>
    <div class="container-fluid">
        <header class="p-3 text-white">
          <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
              <img width="40" height="40" class="d-inline-block align-top" alt="Omnifood logo" src="image/2.jpg" />
              <h1 style="margin-left: 1rem; font-family: 'Yellowtail', 'sans-serif';" class="heading-primary neon-infinite">
                Barber Shop
              </h1>
            </a>
            <ul style="margin-left: 3rem;" class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
              <li><a id="home" role="button" class="nav-link px-2 text-white" href="#" onclick="changeClass(this)">HOME</a></li>
              <li><a id ="thongBao" role="button" class="nav-link px-2 text-white" href="client/notify.htm">THÔNG BÁO</a></li>
              <li><a id ="datLich" role="button" class="nav-link px-2 text-white" href="client/serviceClient/booking.htm" >ĐẶT LỊCH</a></li>
              <li><a id = "dichVu" role="button" class="nav-link px-2 text-white" href="client/serviceClient/index/${usernameKH}.htm" >DỊCH VỤ</a></li>
              <li><a id ="sanPham" role="button" class="nav-link px-2 text-white" href="client/productClient/index/${usernameKH}.htm" >SẢN PHẨM</a></li>
            </ul>
    
            <div class="text-end">
              <a role="button" class="btn btn-outline me-2 neon-blue">PROFILE</a>
              <a role="button" class="btn btn-outline me-2 neon-red" href="client/loginKH.htm">ĐĂNG XUẤT</a>
            </div>
          </div>    
        </header>

        <div class="row container product-details">
            <div class="row d-flex justify-content-center align-items-center">
                <div class="col-12">
                  <div class="card-registration card-registration-2 neon-red text-white" style="border-radius: 15px;">
                    <div class="card-body p-0">
                      <div class="row g-0">
                        <div class="col-lg-8">
                          <div class="p-5">
                            <div class="d-flex justify-content-between align-items-center mb-5">
                              <h1 class="fw-bold mb-0 neon-white-link">Giỏ hàng</h1>
                              <h6 class="mb-0 ">Số sản phẩm:${chiTietPhieuDatHangs.size()}</h6>
                            </div>
                            
                            <c:forEach var="ctpdh" items="${chiTietPhieuDatHangs }">
	                            <hr class="my-4">
	          					
	                            <div class="row mb-4 d-flex justify-content-between align-items-center">
	                            	<div class="col-md-2 col-lg-2 col-xl-1">
	                            	<input class = "chooseProduct" type="checkbox" style="transform: scale(1.5)" 
	                            	onclick="calTotal(calPrice${ ctpdh.idChiTietPhieuDatHang}, this)">
	                            	</div>
	                              <div class="col-md-2 col-lg-2 col-xl-2">
	                                <img
	                                  src="image/product/${ctpdh.sanPhamDuocDat.hinhAnh }"
	                                  class="img-fluid rounded-3" alt="Cotton T-shirt">
	                              </div>
	                              <div class="col-md-3 col-lg-3 col-xl-3">
	                                <h6 class="">${ctpdh.sanPhamDuocDat.tenSanPham }</h6>
	                                
	                              </div>
	                              <div class="col-md-3 col-lg-3 col-xl-2 d-flex">
	                                <button class="btn btn-link px-2" id="minus"
	                                  onclick="this.parentNode.querySelector('input[type=number]').stepDown();
		                                   document.getElementById('calPrice${ ctpdh.idChiTietPhieuDatHang}').innerHTML
		                                   = ${ctpdh.sanPhamDuocDat.gia}
		                                   * parseInt(document.getElementById('quantity${ ctpdh.idChiTietPhieuDatHang}').value)">
	                                  <i class="fa fa-minus" style="color:white;"></i>
	                                </button>
	                                
	                                
	                                <input id="quantity${ ctpdh.idChiTietPhieuDatHang}" min="1" name="quantity" value="${ctpdh.soLuong }" type="number"
	                                  class="form-control form-control-sm" style="width:70px; padding-left:20px;pointer-events: none;"/>
	          
	                                <button class="btn btn-link px-2"  id="plus"
	                                  onclick="this.parentNode.querySelector('input[type=number]').stepUp();
	                                   document.getElementById('calPrice${ ctpdh.idChiTietPhieuDatHang}').innerHTML
	                                   = ${ctpdh.sanPhamDuocDat.gia}
	                                   * parseInt(document.getElementById('quantity${ ctpdh.idChiTietPhieuDatHang}').value)">
	                                  <i class="fas fa-plus" style="color:white;"></i>
	                                </button>
	                              </div>
	                              
	                              <div class="col-md-3 col-lg-2 col-xl-2 offset-lg-1" style="display:flex;">
	                              	
	                                <h6 class="mb-0 perPriceProduct"  id="calPrice${ ctpdh.idChiTietPhieuDatHang}"  style="padding-top:3px;">${ctpdh.sanPhamDuocDat.gia*ctpdh.soLuong}</h6>
	                              	<span style="padding-left:5px"></span>
	                              </div>
	                              
	                              <div class="col-md-1 col-lg-1 col-xl-1 text-end">
	                                <a href="#!" class="text-muted" ><i  class="fas fa-times"></i></a>
	                              </div>
	                            </div>
                            </c:forEach>
                            
          
                           
          
                            <hr class="my-4">
          
                            <div class="pt-5">
                              <h6 class="mb-0 neon-blue-link">
                                <a style="color: white !important;" href="productClient/index/${usernameKH}.htm" class="text-body">
                                  Quay lại trang sản phẩm
                                </a>
                              </h6>
                            </div>
                          </div>
                        </div>
                        <div class="col-lg-4">
                          <div class="p-5">
                            <h3 class="fw-bold mb-5 mt-2 pt-1">Summary</h3>
                            <hr class="my-4">
          
                            <!-- <div class="d-flex justify-content-between mb-4">
                              <h5 class="text-uppercase">items 3</h5>
                              <h5>€ 132.00</h5>
                            </div> -->
          
                            <!-- <h5 class="text-uppercase mb-3">Phí giao hàng</h5> -->
          
                            <!-- <div class="mb-4 pb-2">
                              <select style="border-radius: 5px;" class="select neon-blue-box">
                                <option value="1">Thường - 5.000đ</option>
                                <option value="2">Nhanh - 10.000đ</option>
                                <option value="3">Hỏa tốc - 15.000đ</option>
                                <option value="4">Hỏa tốc pro max - 100.000đ</option>
                              </select>
                            </div> -->
          
                            <!-- <h5 class="text-uppercase mb-3">Mã giảm giá</h5>
          
                            <div class="mb-5">
                              <div class="form-outline">
                                <input type="text" id="form3Examplea2" class="form-control form-control-lg neon-blue" />
                                <label class="form-label" for="form3Examplea2">Nhập mã giảm giá</label>
                              </div>
                            </div> -->
          
                            <hr class="my-4">
							
								
	
                            <div class="d-flex justify-content-between mb-5">
                              <h5 class="text-uppercase" >Tổng tiền</h5>
                              <h5 id="total">0</h5>
                              <span>VND</span>
                            </div>
          
                            <button type="button" class="btn btn-lg neon-blue"
                              data-mdb-ripple-color="dark" disabled="true" id="xacNhan">Xác nhận</button>
                          </div>
                        </div>
                      </div>
                    </div>
                  </div>
                </div>
            </div>
        </div>
      </div>
      <script type="module" src="../common/js/logout.js"></script>
      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
</body>
<script>

	
	/* var perProduct = document.querySelectorAll(".perPriceProduct")
	var chooseP = document.querySelectorAll(".chooseProduct")
	console.log(perProduct)
	console.log(chooseP)
	
	for (i = 0; i<chooseP.length;i++){
		console.log(i)
		if (chooseP[i].checked){
			console.log(perProduct[i])
			total += parseInt(perProduct[i].innerHTML)
			console.log(total)
		}
		else{
			total -= parseInt(perProduct[i].innerHTML)
			console.log(total)
		}
	} */
	
	function calTotal(id, object){
		/* console.log(id.innerHTML)
		console.log(parseInt(id.innerHTML))
		console.log(this.checked) */
		total = document.getElementById('total').innerHTML
		if (object.checked){
			 total = parseInt(total) + parseInt(id.innerHTML)
			 document.getElementById('xacNhan').disabled = false
		}
		else{
			 total = parseInt(total) - parseInt(id.innerHTML)
		}
		if (total == 0){
			document.getElementById('xacNhan').disabled = true
		}
		document.getElementById('total').innerHTML = total
		
	}
	
	
   
 	
    
</script>
</html>