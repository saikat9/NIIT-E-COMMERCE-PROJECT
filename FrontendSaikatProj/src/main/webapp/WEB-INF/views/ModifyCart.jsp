<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.role=='User'}">
<%@include file="CommonNavbar.jsp" %>
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
<div class="container-fluid">
<h3 align="center">Cart Amendment Page</h3>
<form action="<c:url value="/modifyCart"/>" method="post">
<table class="center">
<tr>
<td style="text-align: center;">Cart ID</td>
<td style="text-align: center;"><input type="text" name="cartId" id="cartId" value="${cartItem.cartId}" readonly="readonly"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Product Name</td>
<td style="text-align: center;"><input type="text" name="cartId" id="cartId" value="${cartItem.productName}" readonly="readonly"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Quantity</td>
<td style="text-align: center;"><input type="text" name="quantity" id="quantity" value="${cartItem.quantity}"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Price</td>
<td style="text-align: center;"><input type="text" name="cartId" id="cartId" value="${cartItem.price}" readonly="readonly"/></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td/>
<td>
<!-- Display warning if amended quantity is more than product stock -->
<b><font color="red">${warning}</font></b>
</td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td/>
<td style="text-align: center;" ><input type="submit" value="Modify Cart"></td>
</tr>
</table>
</form>
</div>
</body>
</html>
</c:if>