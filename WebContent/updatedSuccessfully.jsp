<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*,java.util.*" %>

<!DOCTYPE html>
<html>
<head>
<title>Hospital Management</title>
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
  border: 1px solid black;
  
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
padding:250px;
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
border:2px solid black;
padding:20px;
}
</style>
<body >
<div id="header">
<h3 style="text-align:center;color:white;">ABC Hospital Management System</h3>

</div>
<div class="container-fluid header-container" id="header1">
    <div class="container nav-container"><h1 style="text-align:center;color:#4000ff;padding:20px;">ABC Hospital Management System</h1>
        <nav class="navbar">
            <ul class="nav navbar-nav">
                
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Patient <span class="caret"></span></a>
                  <ul class="dropdown-menu">
                    <li><a href="patientRegistration.jsp">Patient Registration</a></li>
                    <li><a href="getPatientUpdate.jsp">Update Patient</a></li>
                    <li><a href="getPatientDelete.jsp">Delete Patient</a></li>
		    <li><a href="HospitalController?source=vPatient">View Patient</a></li>
		    <li><a href="getSearchPatient.jsp">Search Patient</a></li>
                  </ul>
                </li>
                <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Pharmacy <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                     <li><a href="getPharmacy.jsp">Pharmacy Detail</a></li>
                    </ul>
                  </li>
                  <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Diagnostics <span class="caret"></span></a>
                    <ul class="dropdown-menu">
<li><a href="getDiagnostics.jsp">Diagnostics Detail</a></li>
			<li><a href="getBilling.jsp">Patient Billing</a></li>
                      
                    </ul>
                  </li>
                
                <li class="dropdown"><a href="BankingController?source=logout">Logout</a></li>
            </ul>
        </nav>
    </div>
  </div>
<div id="header2">
<h2 align="center">Patient Updated Successfully...</h2>
<!--div class="center"-->
		
<!--/div-->
</div>
		
</body>
</html>