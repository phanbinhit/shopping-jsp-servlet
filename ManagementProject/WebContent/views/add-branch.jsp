<%@page import="entities.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Thêm loại hàng</title>
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
	 <form action="AddBranch" name="myForm" method="POST" onsubmit="return validateForm()" class="w-50 mx-auto">
		  <div class="form-group">
		    <label for="title">Tên loại hàng</label>
		    <input class="form-control" id="title" name="title">
		  </div>
		  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Thêm loại hàng</button>
		</form>
</div>
</main>
</body>
<script type="text/javascript">
	document.getElementById('alert').style.display = "none";
	function validateForm() {
		let x = document.forms["myForm"];
		if (x["title"].value == "") {
			document.getElementById('alert').style.display = "block";
			return false;
		}
	}
</script>
</html>