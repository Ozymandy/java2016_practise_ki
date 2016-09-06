<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<html>
    <head>
        <title>
            Edit
        </title>
<link href = "../css/bootstrap.min.css" rel = "stylesheet">   
    </head>
 
    <body>
        <h1>
            Edit Customer 
        </h1>
<form action="edit" method="POST">
<input type="hidden" name="id" value="${param.id}"/>
First Name: <input type="text" name="firstName" value="${item.getFirstName()}"/>
<br />
Last Name: <input type="text" name="lastName" value="${item.getName()}"/>
<br />
Adress: <input type="text" name="address" value="${item.getAddress()}"/>
<input type="submit" value="Save" />
</form>
    </body>
</html>