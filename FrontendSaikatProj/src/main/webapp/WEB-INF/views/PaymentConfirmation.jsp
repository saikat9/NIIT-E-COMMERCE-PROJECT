<!-- JSP view for customer order processing-->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3 align="center">Order Details</h3>
<div class="container"> 
<table class="table bordered">
<tr bgcolor="teal">
<td><b> SL # </b></td>
<td><b> Product Name</b></td>
<td><b> Quantity</b></td>
<td><b> Price</b></td>
<td colspan="4"><b>Total Price</b></td>
</tr>
<c:forEach items="${listCartItems}" var="cartItem" varStatus="loop">
<tr>
<td>${loop.index + 1}</td>
<td> ${cartItem.productName}</td>
<td> ${cartItem.quantity}</td>
<td> ${cartItem.price}</td>
<td colspan="5"> ${cartItem.quantity * cartItem.price}/-</td>
</tr>
</c:forEach>
<tr bgcolor="cyan">
<td/>
<td/>
<td/>
<td ><b>Total Cart Price</b></td>	
<td ><b>Rs.${cartTotalPrice}/-</b></td>
<td/>
<td/>
</tr>
</table>
<form action="orderprocessing" method="post">
<!-- cardDetailsIND on means page to populate card details -->
<input type="hidden" name="cardDetailsIND" value="" />
<!-- Below variable is used for payment method in case cardDetailsIND is on -->
<input type="hidden" name="paymentMode" value="" />
<table class="table bordered">
<tr bgcolor="cyan">
<td colspan="7">Payment Details</td>
</tr>
<!-- This page would be displayed initially with payment mode -->
<!-- radio button, in case cash payment is selected it would -->
<!-- be redirected to receipt page but if card payment is opted -->
<!-- it would be redirected to same page with additional card related -->
<!-- fields and once resubmitted would be taken to receipt page -->
<c:if test="${cardDetailsInd !='on'}">
 <tr bgcolor="orange">
   <td>Payment Type</td>
   <td><input type="radio" name="paymentMode" value="cashPayment">Cash On Delivery</td>
   <td><input type="radio" name="paymentMode" value="cardPayment">Card Payment</td>
 </tr>
</c:if>
<c:if test="${cardDetailsInd =='on'}">
 <tr bgcolor="orange">
   <td>Credit Card</td>
   <td colspan="3"><input type="text" name="creditCard"/></td>
 </tr>
 <tr bgcolor="orange">
   <td>CVV<input type="text" name="cvvNo"/></td>
   <td colspan="3">Valid Upto<input type="text" name="validupto"/></td>
 </tr>
 <input type="hidden" name="cardDetailsIND" value="ON" />
</c:if>
<tr bgcolor="cyan">
<td><a href="<c:url value="/cartitems"/>"><b>Back To Cart</b></a></td>
<td/>
<td><input type="submit" value="Pay"/></td>
</tr>
</table>
</form>
</div> 
</body>
</html>
</c:if>