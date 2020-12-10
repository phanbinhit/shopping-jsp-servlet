<%@page import="entities.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm sản phẩm</title>
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
	<div class="alert alert-primary" id="alert" role="alert" disabled>
	  Vui lòng nhập đủ các trường
	</div>
	 <form action="AddProduct" name="myForm" method="POST" onsubmit="return validateForm()">
	 	  <% List<Branch> branchs = (List<Branch>) request.getAttribute("branchs"); %>
		  <div class="form-group">
		    <label for="title">Tên sản phẩm</label>
		    <input class="form-control" id="title" name="title">
		  </div>
		  <div class="form-group">
		    <label for="quantity">Số lượng</label>
		    <input type="number" class="form-control" id="quantity" name="quantity"  min=0>
		  </div>
		  <div class="form-group">
		    <label for="price">Giá bán</label>
		    <input type="number" class="form-control" id="price" name="price" min=0>
		  </div>
		  <div class="form-group">
		    <label for="branch">Loại hàng</label>
		    <select class="form-control" id="branch" name="branch">
		      <%for (Branch branch: branchs) { %>
		      	<option><%=branch.getTitle() %></option>
		      <%} %>
		    </select>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Thêm sản phẩm</button>
		</form>
</div>
</main>
</body>
<script type="text/javascript">
	document.getElementById('alert').style.display = "none";
	function validateForm() {
		let x = document.forms["myForm"];
		if (x["title"].value == "" || x["quantity"].value == "" || x["price"].value == "") {
			document.getElementById('alert').style.display = "block";
			return false;
		}
	}
</script>
</html>