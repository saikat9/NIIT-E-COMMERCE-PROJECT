<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.role=='Admin'}">
<%@include file="CommonNavbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
 table.center 
 {
    margin-left:auto; 
    margin-right:auto;
 }
  body {
    background-color: silver;
}

input[type=file]
{
padding-left: 6.5em;
}

</style>
</head>
<body>
<h3 align="center">Product menu</h3>
<div class="container-fluid">
<form:form action="includeproduct" modelAttribute="product" method="post" enctype="multipart/form-data">
<table class="center" class="table table-bordered">
<tr>
<td style="text-align: center;">Product Name</td>
<td style="text-align: center;"><form:input path="productName"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Price</td>
<td style="text-align: center;"><form:input path="price"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Stock</td>
<td style="text-align: center;"><form:input path="stock"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Category</td>
<td style="text-align: center;">
<form:select path="categoryId">
<form:option value="0" label="-------Category List-------"/>
<form:options items="${categoryListMap}"/>
</form:select>
</td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">SupplierId</td>
<td style="text-align: center;"><form:input path="supplierId"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Product Description</td>
<td style="text-align: center;"><form:input path="productDesc"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Product Image</td>
<td >
<form:input type="file" path="pimage"  />
</td>
</tr>
<tr>
<td/>
<td  >
<br>
<input type="submit" value="Add Product"/>
</td>
</tr>
</table>
</form:form>
<br>
<table class="center" class="table table-bordered" border="1">
<tr>
<td style="text-align: center;">Product ID</td>
<td style="text-align: center;">Product Name</td>
<td style="text-align: center;">Product Description</td>
<td style="text-align: center;">Category</td>
<td style="text-align: center;">Price</td>
<td style="text-align: center;">Supplier</td>
<td style="text-align: center;">Stock</td>
<td style="text-align: center;">Edit</td>
<td style="text-align: center;">Delete</td>
</tr>
<c:forEach items="${productList }" var="product">
<tr>
<td style="text-align: center;">${product.productId}</td>
<td style="text-align: center;">${product.productName}</td>
<td style="text-align: center;">${product.productDesc}</td>
<td style="text-align: center;">${product.categoryId}</td>
<td style="text-align: center;">${product.price}</td>
<td style="text-align: center;">${product.supplierId}</td>
<td style="text-align: center;">${product.stock}</td>
<td style="text-align: center;">
<a class="btn btn-success" href="<c:url value="/amendProduct/${product.productId}"/>">Edit</a>
</td>
<td style="text-align: center;">
<a class="btn btn-danger" href="<c:url value="/${product.productId}/removeProduct"/>">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</div>
</body>
</html>
</c:if>