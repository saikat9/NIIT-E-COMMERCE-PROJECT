<!-- JSP for product amendment view -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.role=='Admin'}">
<%@include file="CommonNavbar.jsp" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
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
</style>
</head>
<body>
<h3 align="center">Product Amendment Page</h3>
<br>
<form:form action ="modifyProduct" modelAttribute="product" method="post">
<table class="center">
<tr>
<td style="text-align: center;">Product ID</td>
<td style="text-align: center;"><form:input path="productId" value="${product.productId}" readonly="true"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Product Name</td>
<td style="text-align: center;"><form:input path="productName" value="${product.productName}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Product Description</td>
<td style="text-align: center;"><form:input path="productDesc" value="${product.productDesc}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Price</td>
<td style="text-align: center;"><form:input path="price" value="${product.price}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Stock</td>
<td style="text-align: center;"><form:input path="stock" value="${product.stock}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">SupplierId</td>
<td style="text-align: center;"><form:input path="supplierId" value="${product.supplierId}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td/>
<td style="text-align: center;" ><input type="submit" value="Modify Product"></td>
</tr>
</table>
</form:form>
</body>
</html>
</c:if>