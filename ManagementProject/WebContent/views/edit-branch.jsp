<%@page import="entities.Branch"%>
<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Chỉnh sửa loại hàng</title>
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
	<% Branch br = (Branch) request.getAttribute("branch"); %>
	<% boolean validId = (boolean) request.getAttribute("validId"); %>
	<% if (br == null || validId == false) {%>
	<h1 class="text-center">Không tìm thấy loại hàng</h1>
	<% } else { %>
	<div class="alert alert-primary" id="alert" role="alert" disabled>
	  Vui lòng nhập đủ các trường
	</div>
	 <form action="EditBranch" method="POST" name="myForm" onsubmit="return validateForm()">
	 	  <% ArrayList<Branch> branchs = (ArrayList<Branch>) request.getAttribute("branchs"); %>
		  <div class="form-group">
		    <label for="branch">Loại hàng</label>
		    <input class="form-control" id="branch" name="branch" value=<%=br.getTitle() %>>
		  </div>
		  <button class="btn btn-lg btn-primary btn-block text-uppercase" type="submit">Cập nhật</button>
		</form>
		<% } %>
</div>
</main>
</body>
<script type="text/javascript">
	document.getElementById('alert').style.display = "none";
	function validateForm() {
		let x = document.forms["myForm"];
		if (x["branch"].value == "") {
			document.getElementById('alert').style.display = "block";
			return false;
		}
	}
</script>
</html>