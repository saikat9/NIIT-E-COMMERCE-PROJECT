<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- Don't display category page without authorization -->
<c:if test="${sessionScope.role=='Admin'}">
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

<h3 align="center">Category menu</h3>
<!-- HTML form to add category-->
<form action="includecategory" method="post">
<table class="center" class="table table-bordered">
<tr>
<td style="text-align: center;">Category Name</td>
<td style="text-align: center;"><input type="text" name="categoryName"></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Category Description</td>
<td style="text-align: center;"><input type="text" name="categoryDesc"></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td/>
<td  style="text-align: center;"><input type="submit" value="Add Category"></td>
</tr>
</table>
</form>
<br>
<table class="center" border="1">
<!-- Category list header -->
<tr>
<td style="text-align: center;">Category ID</td>
<td style="text-align: center;">Category Name</td>
<td style="text-align: center;">Category Description</td>
<td style="text-align: center;">Edit</td>
<td style="text-align: center;">Delete</td>
</tr>
<!-- Category list -->
<c:forEach items="${categoryList}" var="category">
<tr>
<td style="text-align: center;">${category.categoryId}</td>
<td style="text-align: center;">${category.categoryName}</td>
<td style="text-align: center;">${category.categoryDesc}</td>
<td style="text-align: center;">
<a class="btn btn-success" href="<c:url value="/amendCategory/${category.categoryId}"/>">Edit</a>
</td>
<td style="text-align: center;">
<a class="btn btn-danger" href="<c:url value="/${category.categoryId}/removeCategory"/>">Delete</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>
</c:if>