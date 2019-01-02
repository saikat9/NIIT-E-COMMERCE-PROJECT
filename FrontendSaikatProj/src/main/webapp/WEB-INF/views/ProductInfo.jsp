<!-- Displaying individual product detailed information -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.role=='User'}">
<%@include file="CommonNavbar.jsp" %>
<!DOCTYPE html>
<html>
<head>

<style type="text/css">

   body {
    background-color: silver;
    margin-left: auto;
    margin-right: auto;
    justify-content: center;
    
}
</style>
</head>
<body>
<h1>Product information:-</h1>
<!-- Function to amend quantity using scrolling-->
<script>
function myFunction() {
    document.getElementById("quantity").stepUp(5);
}
</script>
<br/><br/><br/>
<form action="<c:url value="/addtocart/${product.productId}"/>" method="post">
<div class="container">
<div class="row"> 
<div class="col-xs-4 item-photo">
<!-- variable for image name -->
<c:set var="pid" value="${product.productName}${product.productId}"/>
<img src="/resources/images/${product.productName}${product.productId}.jpg" align="middle"/>
</div>
</div> 
<div class="row">
<div class="col-xs-5" style="border: 0px solid gray">
<h3>Product Name: ${product.productName}</h3>
<h6 class="title-price">
Stock : <c:if test="${product.stock > 0}">
                     ${product.stock}/-
        </c:if>
        <c:if test="${product.stock <= 0}">
                     <font color="red"><b>Not available</b></font>
        </c:if>
</h6>
<h3 style="margin-top: 0px;">Price : INR ${product.price}/-</h3>
<div class="section">
<h6 class="title-attr" style="margin-top: 15px;">
Description : ${product.productDesc}
</h6>
<div>
<div class="attr" style="width: 25px; background: #5a5a5a;"></div>
<div class="attr" style="width: 25px; background: white;"></div>
</div>
</div>
<div>
<!-- Variable stock is total quantity of respective product already added in cart -->
<c:set var="stock" value="0"></c:set>
<c:forEach items="${listCartItems}" var="cartItem">
 <c:if test="${cartItem.productId == product.productId}">
  <c:set var="stock" value="${stock + cartItem.quantity}"></c:set>
 </c:if>
</c:forEach>
<!-- Maximum quantity to be added in cart should not exceed product actual stock -->
<c:if test="${(product.stock - stock) > 0}">
 <h3>Quantity:-</h3>
 <input value="1" name="quantity" id="quantity" type="number" min="1" max="${product.stock- stock}"/>
</c:if>
</div>
<br>
<div class="section" style="padding-bottom: 20px;">
<c:if test="${(product.stock - stock) > 0}">
 <input type="submit" class="btn btn-success" value="Add To Cart">
</c:if>
</div>
</div>
</div>
</div>
</form> 
</body>
</html>
</c:if>