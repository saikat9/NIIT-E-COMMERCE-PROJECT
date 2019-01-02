<!-- Common navigation bar to be included in all pages -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width,initial-scale=1"/>
<title>NIIT ECOMMERCE</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" />
<style type="text/css">
.navbar.navbar-inverse
{
 margin-bottom: 0;
}
</style>
</head>
<body>
    <nav class="navbar navbar-inverse">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
        </div>
        <div class="collapse navbar-collapse" id="myNavbar">
          <ul class="nav navbar-nav">
          <!-- Making respective tab active on click -->
            <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Home.jsp' ? ' active' : ''}"><a href = "<c:url value="/home"/>">Home <span class="glyphicon glyphicon-home"></span></a>
            </li>              
            <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/AboutUs.jsp' ? ' active' : ''}"><a href="<c:url value="/aboutus"/>">About Us </a>
            </li>            
            <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/ContactUs.jsp' ? ' active' : ''}"><a href="<c:url value="/contactus"/>">Contact Us</a>
            </li>           
            <c:if test="${sessionScope.loggedIn }">
            <!-- Showing admin specific tabs -->
              <c:if test="${sessionScope.role=='Admin'}">
                 <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Category.jsp' ? ' active' : ''}">
                 <a href="<c:url value="/listcategories"/>">Manage Category</a>
                 </li>
                 <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Product.jsp' ? ' active' : ''}">
                 <a href="<c:url value="/listproducts"/>">Manage Product</a>
                 </li>
              </c:if>
              <!-- Showing user specific tabs -->
              <c:if test="${sessionScope.role=='User'}">
                 <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/ProductImage.jsp' ? ' active' : ''}">
                 <a href="<c:url value="/showproductimage"/>">ProductImage</a>
                 </li> 
                 <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Cart.jsp' ? ' active' : ''}">
                 <a href="<c:url value="/cartitems"/>">CartMenu</a>
                 </li> 
                 <li class="nav-item dropdown"> 
                 <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">Category Types</a>   
                 <div class="dropdown-menu">
                 <c:forEach items="${categoryList}" var="category">
                    <a class="dropdown-item" href="<c:url value="/showproductscategorywise/${category.categoryId}"/>">${category.categoryName }</a><br>
                 </c:forEach>
                 </div>
                 </li>	
              </c:if>
            </c:if>           
          </ul>
          <ul class="nav navbar-nav navbar-right">
           <c:if test="${!sessionScope.loggedIn}">
            <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Register.jsp' ? ' active' : ''}">
            <a href="<c:url value="/register"/>"><span class="glyphicon glyphicon-user"></span> Sign Up</a>
            </li>
            <li class="${pageContext.request.requestURI eq '/FrontendSaikatProj/WEB-INF/views/Login.jsp' ? ' active' : ''}">
            <a href="<c:url value="/login"/>"><span class="glyphicon glyphicon-log-in"></span>Login</a>
            </li>
           </c:if>
           <c:if test="${sessionScope.loggedIn }">
             <div id="userdetail">
             <font color="white">
             Welcome ${sessionScope.username }
             <a href="<c:url value="/perform_logout"/>" class="btn btn-danger">Logout</a>
             </font>
             </div>
           </c:if>
          </ul>
        </div>
      </div>
    </nav>
</body>
</html>