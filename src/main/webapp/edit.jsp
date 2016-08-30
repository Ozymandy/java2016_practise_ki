<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>
            CustomersList
        </title>
<link href = "css/bootstrap.min.css" rel = "stylesheet">   
    </head>
 
    <body>
        <h1>
            Edit Customer 
        </h1>
<form action="edit" method="POST">
First Name: <input type="text" name="firstName" value="${customer.getFirstName()}"/>
<br />
Last Name: <input type="text" name="lastName" value="${customer.getName()}"/>
<br />
Adress: <input type="text" name="address" value="${customer.getAddress()}"/>
<input type="submit" value="Save" />
</form>
    </body>
</html>