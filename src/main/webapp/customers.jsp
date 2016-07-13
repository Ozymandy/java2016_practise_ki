<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>
            CustomersList
        </title>
    </head>
 
    <body>
        <h1>
            Customers
        </h1>
<ul>
<c:forEach var='item' items='${requestScope.customers}' varStatus='counter'>
  <li> <c:out value='${item.toString()}'/> <a href="/edit?cardId=${item.getCardNumber()}">Edit</a></li>
</c:forEach>
</ul>
    </body>
</html>