<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*,java.util.*,java.time.*" %>
<!DOCTYPE html>
<html>
<head>
<title>Hospital Management</title>
<script src="Javascript/validation.js" type="text/javascript">
</script>
</head>
<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <link href="https://fonts.googleapis.com/css2?family=Barlow&family=Open+Sans:wght@600&family=Roboto&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<style>
table, th, td {
  
  
  background-color: white;
  color: black;
}
th, td {
  text-align: left;
  padding: 8px;
}
table{
border-radius:6px;}
.dropdown{
margin-left:120px;
background-color:#3232bc;

font-size:20px;
border:1px solid black;
border-radius:4px;
}
#header{
padding:0.5px;
background-color:black;
}
#header1{
padding:15px;
background-color:#00bfff;
box-sizing:border-box;
}
#header2{

background-image:url("https://cdn.shopify.com/s/files/1/1124/9318/products/31FXBsiHr-L.jpg?v=1514138282.jpg");
background-repeat:no-repeat;
background-size:cover;
}
.Patient{
margin-left:60px;
background-color:#3232bc;
color:black;
font-size:20px;
border:1px solid black;
border-radius:4px;
}
.Diagonastic{
margin-left:100px;
background-color:#3232bc;
color:black;
font-size:20px;
border:1px solid black;
border-radius:4px;
}
.Pharmacy{
margin-left:120px;
background-color:#3232bc;
color:black;
font-size:20px;
border:1px solid black;
border-radius:4px;
}
.center{
margin:auto;
padding:25%;

padding:20px;
}
</style>
<body>
<div id="header">
<h3 style="text-align:center;color:white;">ABC Hospital Management System</h3>

</div>
<div class="container-fluid header-container" id="header1">
    <div class="container nav-container"><h1 style="text-align:center;color:#4000ff;padding:20px;">ABC Hospital Management System</h1>
        
    </div>
  </div>

<div id="header2">
<div class="center">
<h3 align="center">Login Page</h3>

		<form action="HospitalController" method="post" name="loginForm"
			autocomplete="off">
			<input type="hidden" name="source" value="login">
			<table align="center">
			<tr>
			<th>UserName:</th>
			 <td><input type="text" name="username" placeholder="Username" onchange="alphanumeric()" required></td>
			 </tr>
			 <tr>
			 <td></td>
			 </tr>
			 <tr>
			 <th>Password:</th>
			 <td><input type="password" name="password"	placeholder="Password" onchange="chkPassword()" required></td>
			 </tr>
			 </table>
			 <br><br>
			   <centre><input type="submit" value="Login" ></centre>
		</form>
		
</div>
</div>

</body>
</html>