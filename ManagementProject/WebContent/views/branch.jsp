<%@page import="entities.Branch"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
	<%@include file="../style/bootstrap.min.css" %>
</style>
<meta charset="UTF-8">
<title>Quản lý loại hàng</title>
</head>
<body>
	<header>
		<jsp:include page="header.jsp"></jsp:include>
	</header>
	<main>
		<!-- Cart -->
        <section id="cart" class="py-3">
            <div class="container-fluid w-75">
                <a href="AddBranch" class="btn btn-danger">Thêm loại hàng</a>
                <div class="row">
                    <div class="col-sm-12">
                    	<% List<Branch> branchs = (List<Branch>) request.getAttribute("branchs"); %>
                       	<% for (Branch branch: branchs) { %>
                       		<div class="row border-top py-3 mt-3">
	                            <div class="col-sm-8">
	                                <h5 class="font-baloo font-size-20"><%=branch.getTitle()%></h5>
	                            </div>
	                            <div class="col-sm-2 text-right">
	                               <a href="EditBranch?id=<%=branch.getId()%>">Sửa</a>
	                               <br>
	                               <a href="DeleteBranch?id=<%=branch.getId()%>">Xóa</a> 
	                            </div>
                        	</div>
                       	<% } %>
                    </div>  
                </div>
            </div>
        </section>
	</main>
</body>
</html>