<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crux Bank</title>
<script>
function preventBack(){
	window.history.forward();
}
setTimeout("preventBack();", 0);
 window.onunload = function(){null};
</script></head>


<body>


 <p align ="center" style="font-family:candara;font-size:30px" >Welcome to Crux Bank</p>
 </br>
 </br>
 </br>
 </br>
 </br>
 </br>


<c:set var = "loginResponse" scope="session" value="${loginMessage}"/>
	<c:if test="${loginResponse != null}">
	<script> alert("Entered wrong username / password !!") </script>
	</c:if>


<div id="loginForm" align="center" >
	<form action="/cruxbank.com/auth" method="post">
	<table id="loginTable" align="center" >	
	  <th align="center"> Login Here</th>	 
	  <tr > <td>User name</td>  <td><input type="text" name="username" /></td> </tr>  
	  <tr > <td>password</td>  <td><input type="password" name="password" /></td> </tr>  
	  <tfoot align="center"> <td> <input type="submit"  value="login"/> </td> </tfoot>
	</table>

	</form>



</br>
</br>
</br>
</br>
</br>

<h3>Dont have an account.Please signup <a href="http://localhost:8080/cruxbank.com/">here</a></h3>
</div>




</body>
</html>