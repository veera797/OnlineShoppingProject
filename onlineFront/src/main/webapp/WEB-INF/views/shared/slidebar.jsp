<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<div class="list-group">
<c:forEach items="${categories}" var="category">
            <a href="${contextRoot}/show/category/${category.id}/products" class="list-group-item">${category.name}</a>
         </c:forEach>  
          </div>