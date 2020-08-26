<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
         <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Crux Bank</title>


</head>
<body>


   
   	<div style="display: none">
   
       <form id="accountInfo" action="/cruxbank.com/userHomePage" method="post">
       <input type="hidden" name="username"  value="${userDetails}">
       <input type = "submit" value="submit"  id="doGo">
       
    </form>
   
   
   </div>


	<div  align="center">   
	<p style="font-family:candara;font-size:20px" >Thank you for choosing Crux Bank</p> </br>
    <p style="font-family:candara;font-size:18px"> ${txnMessage} </p> </br>
    <p> You will be redirected to Home page in few sec</p>   
    

   </div>

 <script>


function preventBack(){
	window.history.forward();
}
setTimeout("work();",2000);

window.onunload = function(){null};
 
 
function work(){	 
	 document.getElementById("accountInfo").submit(); 
 }
</script>  
   
   
</body>
</html>