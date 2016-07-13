<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>
            CustomersList
        </title>
    </head>
 
    <body>
        <h1>
            Search
        </h1>
<form action="search" method="POST">
<input type="text" name="keyword" value=""/>
<input type="submit" value="Search" />
</form>
<ul>
<c:forEach var='item' items='${requestScope.results}' varStatus='counter'>
  <li> <c:out value='${item.toString()}'/></li>
</c:forEach>
</ul>
    </body>
</html>