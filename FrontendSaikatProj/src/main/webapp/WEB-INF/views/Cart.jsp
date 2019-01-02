<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Don't display cart page without authorization -->
<c:if test="${sessionScope.role=='User'}">
<%@include file="CommonNavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">

body {
    background-color: silver;
}
</style>
</head>
<body>
<div class="container-fluid">
<h3 align="center">Cart</h3>
<table class="table bordered">
<tr bgcolor="green">
<!-- Cart header -->
<td><b> SL # </b></td>
<td><b> Product Name</b></td>
<td><b> Quantity</b></td>
<td><b> Price</b></td>
<td><b>Total Price</b></td>
<td><b> Amend</b></td>
<td><b> Delete</b></td>
</tr>

<!-- Display list of cart items -->
<c:forEach items="${listCartItems}" var="cartItem" varStatus="loop">
<tr>

<td>${loop.index + 1}</td>
<td> ${cartItem.productName}</td>
<td> ${cartItem.quantity}</td>
<td> ${cartItem.price}</td>
<td> ${cartItem.quantity * cartItem.price}/-</td>
<td>
<!-- Update cart -->
<a class="btn btn-success" href="<c:url value="/amendcartitem/${cartItem.cartId}"/>">Update</a>
</td>
<td>
<!-- Delete cart -->
<a class="btn btn-danger" href="<c:url value="/removecartitem/${cartItem.cartId}"/>">Delete</a>
</td>
</tr>
</c:forEach>

<tr bgcolor="cyan">
<td/>
<td/>
<td/>
<td><b>Total Cart Price</b></td>	
<td ><b>Rs.${cartTotalPrice}/-</b></td>
<td/>
<td/>
</tr>
<tr bgcolor="teal">
<!-- Redirect to product page from cart page -->
<td colspan="3"><a href="<c:url value="/showproductimage"/>"><b><font color="white">Continue Shopping</font></b></a></td>
<td/>
<td/>
<td/>
<!-- Redirect to order page from cart page -->
<td colspan="4"><a href="<c:url value="/checkout"/>" class="btn btn-success"><b>Checkout</b></a></td>
</tr>
</table>
</div>
</body>
</html>
</c:if>