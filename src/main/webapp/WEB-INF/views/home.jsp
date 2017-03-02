<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Welcome to WebUI of Telecom Service!  
</h1>


<P>   ${msgcreation}. </P>
<P>   You are logged in as ${logedinuser}. </P>
<h3>
	<center>This will call UserManagement Micro service </center>
</h3>


<center><h3>Login</h3></center>

</br></br>
<form action="/webui/login" >
<Center>Enter User Id  :<input id="userid" name="userid">   </input></Center>
<br/>
<Center>Enter Password  :<input id="pword" name=pword>   </input></Center>
<br/>
<Center><input type="submit" value="Login" /></Center>
</form>
  </br></bt>
<center><h4><a href="/webui/registration">Not Registerd User ?.Click For User Registration</a>

</h4></center>
</body>
</html>
