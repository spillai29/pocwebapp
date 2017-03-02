<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h3>
	<center>This will call UserManagement Micro service </center>
</h3>


<center><h3>User Registration</h3></center>

</br></br>
<form action="/webui/userregistration" >
<Center>Enter User Name  :<input id="username" name="username">   </input></Center>
<Center>Enter User Id    :<input id="userid" name="userid">   </input></Center>
<br/>
<Center>Enter Password  :<input id="pword" name=pword>   </input></Center>
<br/>
<Center><input type="submit" value="Register Me" /></Center>
</form>

</body>
</html>