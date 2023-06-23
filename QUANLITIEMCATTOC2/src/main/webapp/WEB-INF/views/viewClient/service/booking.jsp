<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
</head>
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
              <li><a role="button" class="nav-link px-2 text-white" href="#">HOME</a></li>
              <li><a role="button" class="nav-link px-2 text-white" href="client/notify.htm">THÔNG BÁO</a></li>
              <li><a role="button" class="nav-link px-2 neon-blue-link" href="client/serviceClient/booking.htm">ĐẶT LỊCH</a></li>
              <li><a role="button" class="nav-link px-2 text-white" href="client/serviceClient/index/${usernameKH}.htm">DỊCH VỤ</a></li>
              <li><a role="button" class="nav-link px-2 text-white" href="client/productClient/index/${usernameKH}.htm">SẢN PHẨM</a></li>
            </ul>
    
            <div class="text-end">
              <a role="button" class="btn btn-outline me-2 neon-blue">PROFILE</a>
              <a role="button" class="btn btn-outline me-2 neon-red" href="client/loginKH.htm">ĐĂNG XUẤT</a>
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
        <div class="content_booking">
            <div class="content_booking__inner">
              <div class="container overflow-hidden">
                <div class="multisteps-form">
                  <div class="row">
                    <div class="col-12 col-lg-12 ml-auto mr-auto mb-4 p-3">
                      <div class="multisteps-form__progress">
                        
                        <button class="multisteps-form__progress-btn js-active" type="button" title="Address">Dịch vụ</button>
                        <button class="multisteps-form__progress-btn" type="button" title="Order Info">Thời gian</button>
                      </div>
                    </div>
                  </div>
                  <div class="row">
                    <div class="col-12 col-lg-8 m-auto">
                      <form class="multisteps-form__form">
                        
          
                        <div class="multisteps-form__panel shadow p-4 rounded js-active" data-animation="scaleIn">
                          <h3 class="multisteps-form__title">Chọn dịch vụ</h3>
                          <div class="multisteps-form__content">
                            <div class="row d-flex justify-content-center">
                              <div class="col-12 d-flex col-md-6 mt-4 justify-content-center">
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
                                      <a href="#" class="neon-blue">Chọn</a>
                                    </div>
                                  </div>
                              </div>
                              <div class="col-12 d-flex col-md-6 mt-4 justify-content-center">
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
                                            <a href="#" class="neon-blue">Chọn</a>
                                        </div>
                                    </div>
                              </div>
                            </div>
                            <div class="row d-flex align-items-center">
                              <div class="button-row d-flex mt-4 col-12">
                                <button style="margin-right: 1rem;" class="btn js-btn-prev neon-blue" type="button" title="Prev">Quay lại</button>
                                <button class="btn ml-auto js-btn-next neon-red" type="button" title="Next">Tiếp tục</button>
                              </div>
                            </div>
                          </div>
                        </div>
          
                        <div class="multisteps-form__panel shadow p-4 rounded" data-animation="scaleIn">
                          <h3 class="multisteps-form__title">Chọn ngày giờ</h3>
                          <div class="multisteps-form__content">
                            <div class="form-row mt-4">
                                <form>
                                    <div class="row form-group">
                                        <label for="date" class="col-sm-1 col-form-label">Ngày</label>
                                        <div class="col-sm-4">
                                            <div class="input-group date" id="datepicker">
                                                <input type="text" class="form-control">
                                                <span class="input-group-append">
                                                    <span class="input-group-text" style="height: 100%;">
                                                        <i class="fa fa-calendar"></i>
                                                    </span>
                                                </span>
                                            </div>
                                        </div>
                                    </div>
                                </form>
                                    <div class="row form-group">
                                        <label for="date" class="col-sm-1 col-form-label">Giờ</label>
                                        <div class="col-sm-4">
                                            <div class="input-group time" id="timepicker">
                                                <input type="text" class="form-control timepicker timepicker-with-dropdown text-center">
                                            </div>
                                        </div>
                                    </div>
                                </form>
                            </div>
                            <div class="button-row d-flex mt-4">
                              <button style="margin-right: 1rem;" class="btn js-btn-prev neon-blue" type="button" title="Prev">Quay lại</button>
                              <button class="btn ml-auto neon-green" type="button" title="Send">Xác nhận</button>
                            </div>
                          </div>
                        </div>
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
        </div>
    </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js" integrity="sha384-w76AqPfDkMBDXo30jS1Sgez6pr3x5MlQ1ZAGC+nuZB+EYdgRZgiwxhTBTkF7CXvN" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/yourcode.js" crossorigin="anonymous"></script>
    <script  src="js/function.js"></script>
    <script type="text/javascript">
        $(function() {
            $('#datepicker').datepicker({
                format: 'dd/mm/yyyy',
                        });
        });
        $(document).ready(function(){
            $('input.timepicker').timepicker({});
        });
    </script>

</body>
</html>