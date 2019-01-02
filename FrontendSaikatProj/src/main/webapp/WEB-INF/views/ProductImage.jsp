<!-- Displaying product images with information -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:if test="${sessionScope.role=='User'}">
<%@include file="CommonNavbar.jsp" %>
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
</style>
</head>
<body>
<h3 align="center">Product Image Page</h3>
<div class="row text-center text-lg-left">
<c:forEach items="${productList }" var="product">
 <div class="col-lg-3 col-md-4 col-6">
 <a href="<c:url value="/productinfo/${product.productId}"/>" class="d-block mb-4 h-100">
 <img class="img-fluid img-thumbnail" src="/resources/images/${product.productName}${product.productId}.jpg" alt="" width="100" height="100"/>
 </a>
 <a href="<c:url value="/productinfo/${product.productId}"/>" class="d-block mb-4 h-100">
 <br><b>Price : ${product.price}/-</b>
 </a>
 <a href="<c:url value="/productinfo/${product.productId}"/>" class="d-block mb-4 h-100">
 <br><b>Stock : <c:if test="${product.stock > 0}">
                     ${product.stock}/-
               </c:if>
               <c:if test="${product.stock <= 0}">
                     <font color="red">Not available</font>
               </c:if>
 </b>
 </a>
 </div>
</c:forEach>
</div>
</body>
</html>
</c:if>