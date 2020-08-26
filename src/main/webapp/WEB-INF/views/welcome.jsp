<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">

<script type="text/javascript">

function preventBack(){
	window.history.forward();
}
setTimeout("preventBack();", 0);
 window.onunload = function(){null};



	function check(){
		var lettersPattern = /[a-z]/ig;
		var specialCharectersPattern = /[@#$-+/`~_.,;:<>%^&*(){}!]/g;
		//document.getElementById("signup").preventDefault();
		var res = false;
		if(document.getElementById("fn").value.trim().length <= 2){
			alert("Minimum length required is two for first name");
			return false;
		}
		if(document.getElementById("ln").value.trim().length <= 2){
			alert("Minimum length required is two for last name");
			return false;
		}
		if(document.getElementById("un").value.trim().length <= 2){
			alert("Minimum length required is two for username");
			return false;
		}
		if(document.getElementById("password_signup").value.trim().length < 8 || !document.getElementById("password_signup").value.trim().match(lettersPattern) ){
			alert("Minimum length required is 8 and should have capital  and small letter");
			return false;
		}
		if(document.getElementById("ph_no").value.trim().length != 10 ){
			alert("please enter phone number having 10 digits");
			return false;
		}
		if(document.getElementById("ph_no").value.trim().match(lettersPattern) || document.getElementById("ph_no").value.trim().match(specialCharectersPattern)){
			alert("please enter valid  phone number ");
			return false;
		}	
		if(document.getElementById("email").value.trim().length <= 2){
			alert("Minimum length required is two for email");
			return false;
		}
		if(document.getElementById("address").value.trim().length <= 2){
			alert("Minimum length required is two for address");
			return false;
		}
		if(document.getElementById("city").value.trim().length <= 2){
			alert("Minimum length required is two for city");
			return false;
		}
		if(document.getElementById("state").value.trim().length <= 2){
			alert("Minimum length required is two for state");
			return false;
		}
		if(document.getElementById("country").value.trim().length <= 2){
			alert("Minimum length required is two for country");
			return false;
		}
		if(document.getElementById("zip").value.trim().length <= 2){
			alert("Minimum length required is two for country");
			return false;
		}
		if(document.getElementById("id_name").value.trim().length <= 2){
			alert("Minimum length required is two for country");
			return false;
		}
		if(document.getElementById("id_number").value.trim().length <= 2){
			alert("Minimum length required is two for country");
			return false;
		}
		
		//alert("function called ");
		return true;
	}
	
	
	function res(){
		//alert("function res");
		if(check()===true){
			//document.getElementById("toty").submit(); 
			alert("function res 4");
			document.getElementById("signup").submit(); 
			
		}
	}

</script>
<style>
    .error 
    {
        color:red;
        font-weight: bold;
    }
    </style>
    <title>CruxBank</title>


</head>
<body>




 <p align ="center" style="font-family:candara;font-size:30px" >Welcome to Crux Bank</p>

<br/>
<br/>
	<c:set var = "response" scope ="session" value="${result}"/>
<c:if test="${response != null}" >
	<p> <c:out value="${response}"></c:out> </p>

</c:if> 


<div id="forms" align="center">

<div id="signupForm" align="center" >
<form:form id="signup" action="/cruxbank.com/signup" modelAttribute="userInfo" method="post" >
	<table id="signupTable" align="center" style="margin:15px">	
	  <th> Sign up Here For New Account</th>
	  
	  <tr > <td>First Name</td>  <td><form:input id="fn"  path="first_name"  /></td> <td><form:errors  path="first_name" cssClass="error" /></td> </tr>  
	  <tr > <td>Last Name</td>  <td><form:input id="ln"  path="last_name"  /></td>  <td><form:errors  path="last_name"  cssClass="error"/></tr>  
	  <tr > <td>User Name</td>  <td><form:input id="un"  path="username"   /></td> <td><form:errors  path="username" cssClass="error" /> </tr>  
	  <tr > <td>password</td>  <td><form:password  id="password_signup" path="password"   /></td> <td><form:errors  path="password" cssClass="error" /></tr>  
	  <tr > <td>Phone</td>  <td><form:input   id="ph_no"  path="phone"   /></td><td><form:errors  path="phone" cssClass="error" /></tr>  
	  <tr > <td>Email Id</td>  <td><form:input id="email"  path="email"   /></td><td><form:errors  path="email" cssClass="error" /> </tr>  
	  <tr > <td>Address</td>  <td><form:input id="address"  path="address"   /></td> <td><form:errors  path="address" cssClass="error" /> </tr>  
	  <tr > <td>City</td>  <td><form:input  id="city" path="city"   /></td> <td><form:errors  path="city" cssClass="error" /></tr> 
	  <tr > <td>State</td>  <td><form:input  id="state" path="state"   /> <td><form:errors  path="state" cssClass="error" /></tr>   
	  <tr > <td>Country</td>  <td><form:input id="country"  path="country"   /></td> <td><form:errors  path="country" cssClass="error" /></tr>
	   <tr > <td>Zip</td>  <td><form:input id="zip"  path="zip"   /></td> <td><form:errors  path="zip" cssClass="error" /></tr>
	   <tr > <td>Id Name</td>  <td><form:input id="id_name"  path="id_name"   /></td> <td><form:errors  path="id_name" cssClass="error" /></tr>
	   <tr > <td>Id Number</td>  <td><form:input id="id_number"  path="id_number"   /></td> <td><form:errors  path="id_number" cssClass="error" /></tr>
	  
	   <tfoot > <td> <input type="button" value="create Account"  onclick="res();"/> </td> <td> ${result}</td>   </tfoot>
	    
	  	
	
	</table>
</form:form>


<br/>
<br/>
<br/>
<br/>
</div>
 <h3>Already have an account.Please login in <a href="http://localhost:8080/cruxbank.com/login">here</a></h3>

</div>


</body>
</html>