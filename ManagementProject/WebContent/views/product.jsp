<%@page import="java.util.ArrayList"%>
<%@page import="entities.Product"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm</title>
<style type="text/css">
	<%@include file="../style/bootstrap.min.css" %>
</style>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<main id="main-site">
        <!-- Cart -->
        <section id="cart" class="py-3">
            <div class="container-fluid w-75">
                <a href="AddProduct" class="btn btn-danger">Thêm sản phẩm</a>
                <div class="row">
                    <div class="col-sm-12">
                    	<% ArrayList<Product> products = (ArrayList<Product>) request.getAttribute("products");%>
                       	<% for (Product product: products) { %>
                       		 <div class="row border-top py-3 mt-3">
                            <div class="col-sm-8">
                                <h5 class="font-baloo font-size-20"><%=product.getTitle()%></h5>
                                <small>by <%=product.getBranch()%></small>
                                <br>
                                <span>Quantity: <%=product.getNumber()%></span>
                                <div class=" text-danger font-baloo font-size-20">$<span class="product-price"><%=product.getPrice()%></span></div>  
                            </div>
                            <div class="col-sm-2 text-right">
                               <a href="EditController?id=<%=product.getId()%>">Sửa</a>
                               <br>
                               <a href="DeleteProduct?id=<%=product.getId()%>">Xóa</a> 
                            </div>
                        </div>
                       	<% } %> 
                    </div>  
                </div>
            </div>
        </section>
</body>
</html>