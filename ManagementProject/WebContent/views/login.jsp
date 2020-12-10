<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
<style type="text/css">
	<%@include file="../style/bootstrap.min.css" %>
</style>
</head>
<body>
<div class="container">
            <div class="row">
              <div class="mx-auto w-50">
                <div class="mx-5">
                  <div class="card card-signin my-5 card-login">
                    <div class="card-body">
                      <h5 class="card-title text-center">Đăng nhập</h5>
                      <form class="form-signin" action="LoginController" method="post">
                        <div class="form-label-group font-size-20 my-3">
                          <input type="email" idcircle="inputEmail" class="form-control" name="email" placeholder="Email address" required autofocus value="binh@gmail.com">
                        </div>
                        <div class="form-label-group my-3">
                          <input type="password" id="inputPassword" class="form-control" name="password" placeholder="Password" required value="Phanbinh123">
                        </div>
                        <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Đăng nhập</button>
                        <hr class="my-4">
                      </form>
                    </div>
                  </div>
                </div>
              </div>
            </div>
          </div>
</body>
</html>