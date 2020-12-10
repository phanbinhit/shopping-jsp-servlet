<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<style type="text/css">
</style>
</head>
<body>
	<nav class="navbar navbar-expand-lg navbar-light bg-light w-100">
		<div class="collapse navbar-collapse" id="navbarNavAltMarkup">
		   <div class="navbar-nav ml-5">
		     <a class="nav-item nav-link" href="ProductController">Quản lý sản phẩm <span class="sr-only">(current)</span></a>
		     <a class="nav-item nav-link" href="BranchController">Quản lý loại hàng</a> 
		     <button type="button" id="btn-guide" class="btn btn-light">Hướng dẫn</button>
		     <a class="nav-item nav-link" href="SomethingController">Thông tin thêm (Đa server)</a>
		 </div>
		 <a class="nav-item nav-link float-right" href="LogoutController">Đăng xuất</a>
	</nav>
	<div class="alert alert-success w-50 mx-auto my-3" role="alert" id="guide-div">
	  <h4 class="alert-heading">Xin chào!</h4>
	  <p>Trên thank narbar sẽ hiển thị "Quản lý sản phẩm" và "Quản lý loại hàng". Kích vào mỗi link sẽ chuyển sang trang quản lý cụ thể</p>
	  <hr>
	  <p class="mb-0">Kích vào "Thông tin thêm (Đa server)" trên narbar sẽ lấy thông tin từ 1 server khác"</p>	  
	  <p class="mb-0">Sau khi vào mỗi trang sẽ hiển thị sản phẩm hoặc loại hàng</p>
	  <p class="mb-0">Kích vào "Thêm sản phẩm" hoặc "Thêm loại hàng" để thêm thứ bạn muốn thêm vào database</p>
	  <p class="mb-0">Kích vào "sửa" để sửa từng "Sản phẩm" hoặc "Loại hàng"</p>
	  <p class="mb-0">Kích vào "xóa" để xóa từng "Sản phẩm" hoặc "Loại hàng"</p>
	  <p class="mb-0">Kích vào "Đăng xuất" để đăng xuất</p>
	</div>
</body>
<script type="text/javascript">
	var btnGuide = document.getElementById('btn-guide');
	var guideDiv = document.getElementById('guide-div');
	guideDiv.style.display = "none";
	btnGuide.addEventListener("click", function() {
		if (window.getComputedStyle(guideDiv).display == "none") {
			guideDiv.style.display = "block";	
		} else {
			guideDiv.style.display = "none";
		}
	});
</script>
</html>
