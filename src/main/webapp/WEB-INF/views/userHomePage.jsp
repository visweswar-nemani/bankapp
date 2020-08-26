<!DOCTYPE>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
     <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
     <%@ page isELIgnored="false" %>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
	<head>
	<title>Crux Bank</title>
	<script type="text/javascript">
	function preventBack(){
		window.history.forward();
	}
	setTimeout("preventBack();", 0);
	 window.onunload = function(){null};
	 
	 function performTxn(){
		 	if(document.getElementById("txnType").value!="none"){
		 		document.getElementById("amount").style.display="block";
		 		document.getElementById("amountConfirm").style.display="block";	
		 	} else {
		 		document.getElementById("amount").style.display="none";
		 		document.getElementById("amountConfirm").style.display="none";
		 	}
	}
	 
	 const data = 'test';
	 const options= {
			 method:'POST',
			 headers:{
				 "content-type":"application/json"
			 },
			 body:JSON.Stringify(data)
	 };
	 const result = fetch('/cruxbank.com/doTest',options);
	 console.log(result.json());
	
	</script>
	 </head>

	<body>
	<P align ="center" style="font-family:candara;font-size:30px" >Crux Bank</p>
	
	<c:set var = "txnResponse" scope="session" value="${txnMessage}"/>
	<c:if test="${txnResponse != null}">
	<script> alert("${txnResponse}") </script>
	</c:if>
	
	
	
	
	<div align="right" style="font-size:20px">
	<form action="/cruxbank.com/logout"  method="post" >
		<input type="hidden"  name="username" value="${userDetails.username}"/>
		<input style="font-size:16px" type="submit" value="Sign out" >
	
	</form>
	</div>
	
	<div>
	<div align="left">
	<table align="left">
	<th align="left"  >Account Details</th>
	<tr> <td>Account Holder : </td><td>${userDetails.firstname}  ${userDetails.lastname} </td></tr>
	<tr> <td>Account Number : </td><td>${userDetails.acc_id}</td></tr>
	<tr> <td>Account Type : </td><td>${userDetails.acc_type}</td></tr>
	<tr> <td>Account Balance : </td><td>${userDetails.acc_bal}</td></tr>
	<tr> <td>Card Number : </td><td>${userDetails.card_id}</td></tr>
	<tr> <td>Card Status : </td><td>${userDetails.card_status}</td></tr>
	</table>
	</body>
	
	</div>
	
	<div>
		<table align="center">
			<form action="/cruxbank.com/doTransaction" method="post" >
			<th align="center">Perform Transaction</th>
			<input type="hidden" name="account_id" value="${userDetails.acc_id}">
			<input type="hidden" name="username" value="${userDetails.username}">
			<tr> <td><select  name="txn_type" id=txnType onchange="performTxn()">
			 <option value="deposit">Deposit</option>
			 <option value="withdraw">withdraw</option>
			 <option value="none" selected>None</option>
			 
			 </select></td>  <td><input id="amount" name="amountEntered" style="display: none" type="text"  placeholder="Enter  amount" ></td>  <td><input id="amountConfirm" type="submit"  style="display: none" value="confirm" ></td> </tr>
			</form>
		
		
		</table>
	
	
	
	</div>
	

</html>