<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đa server</title>
<style type="text/css">
	<%@include file="../style/bootstrap.min.css" %>
</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
<main>
<div class="w-50 mx-auto mt-5 px-3 py-3">
	 <form action="SomethingController" method="POST">
		  <div class="form-group">
		    <label for="option">Sản phẩm đắt nhất</label>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block text-uppercase mb-3" type="submit">Kiểm tra</button>
		  <% String output = (String )request.getAttribute("output"); %>
		  <% if (output != null) { %>
		  	<h3><%=output %></h3>
		  <% } %>
	</form>
</div>
</main>
</body>
</html>