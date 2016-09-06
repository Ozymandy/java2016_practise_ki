<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>
            CustomersList
        </title>
    </head>
 
    <body>
        <h1>
            Edit Customer 
        </h1>
<form action="new" method="POST">
First Name: <input type="text" name="firstName" value=""/>
<br />
Last Name: <input type="text" name="lastName" value=""/>
<br />
Adress: <input type="text" name="address" value=""/>
<input type="submit" value="New" />
</form>
    </body>
</html>