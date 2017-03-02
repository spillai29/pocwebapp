<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>
	Donate Or Request a Telecom package   - This will call  Telecom Micro Service
</h1>

<form action="/webui/telecomsell" >
<Center>
<h2>
	Donate  Telecom package  
</h2>

<Center>/
<Center>Provider name  :<input id="provider" name="provider">   </input></Center>
<br/>
<Center>Enter pack type  :<input id="type" name=type>   </input></Center>
<br/>
<Center>Enter pack name  :<input id="packname" name=packname>   </input></Center>
<br/>
<Center><input type="submit" value="Donate a pack" /> </Center>
</form>
</br></br></br></br>
<Center>
<h2>
	Request  Telecom package  
</h2>
</Center>
</br>
<form action="/webui/telecombuy" >
<Center>Provider name  :<input id="provider" name="provider">   </input></Center>
<br/>
<Center>Enter pack type  :<input id="type" name=type>   </input></Center>
<br/>
<Center>Enter pack name  :<input id="packname" name=packname>   </input></Center>
<br/>
<Center> <input type="submit" value="Request a pack" /></Center>
</form>

</body>
</html>