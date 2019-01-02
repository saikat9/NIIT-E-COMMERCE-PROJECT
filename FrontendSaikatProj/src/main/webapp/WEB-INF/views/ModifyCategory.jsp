<!-- JSP for category amendment view -->
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
<h3 align="center">Category Amendment Page</h3>
<form action="<c:url value="/modifyCategory"/>" method="post">
<table class="center">
<tr>
<td style="text-align: center;">Category ID</td>
<td style="text-align: center;"><input type="text" id="categoryId" name="categoryId" value="${category.categoryId}" readonly="readonly"></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Category Name</td>
<td style="text-align: center;"><input type="text" id="categoryName" name="categoryName" value="${category.categoryName}"></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td style="text-align: center;">Category Description</td>
<td style="text-align: center;"><input type="text" id="categoryDesc" name="categoryDesc" value="${category.categoryDesc}"></td>
</tr>
<tr>
<td>
<br>
</td>
</tr>
<tr>
<td/>
<td style="text-align: center;" ><input type="submit" value="Modify Category"></td>
</tr>
</table>
</form>
</body>
</html>
</c:if>