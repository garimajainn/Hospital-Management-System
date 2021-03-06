<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.*,java.util.*,java.time.*" %>
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
                
                <li class="dropdown"><a href="HospitalController?source=logout">Logout</a></li>
            </ul>
        </nav>
    </div>
  </div>
<div id="header2">

<div class="center">
<% Hospital hospital = (Hospital)request.getAttribute("hospital"); %>
	<center>
	
	<h2>Pharmacy</h2>
	<table border bgcolor="white" cellspacing="5">
	<tr>
	<th>Patient ID</th>
	<th>Name</th>
	<th>Age</th>
	<th>Address</th>
	<th>DOJ</th>
	
	<th>Type of Room</th>
	
	</tr>
	
	<tr>
	<td><%= hospital.getPatientId() %></td>
	<td><%= hospital.getPatientName() %></td>
	<td><%= hospital.getPatientAge() %></td>
	<td><%= hospital.getAddress() %></td>
	<td><%= hospital.getDateOfAdmission() %></td>
		
	<td><%= hospital.getBedtype() %></td>
	</tr>
	</table>
	<br>
	No. of days:  <%= hospital.days %>
	<br>
	Bill for Room:  <%= hospital.chargeBed %>
	<% ArrayList<Hospital> p = (ArrayList<Hospital>)request.getAttribute("phar"); %>
	<br>
	<br>
	
	<h2>Medicine Issued</h2>
	<table border bgcolor="white" cellspacing="5">
	<tr>
	<th>Medicine</th>
	<th>Quantity</th>
	<th>Rate</th>
	<th>Amount</th>
	</tr>
	<% for(Hospital hs1:p){ %>
	<tr>
	<td><%= hs1.getMedicine() %></td>
	<td><%= hs1.getQuantity() %></td>
	<td><%= hs1.getRate() %></td>
	<td><%= hs1.getAmountPharmacy() %></td>
	</tr>
	<% } %>	
	</table>
	<br>
	<br>
	Bill for Pharmacy: <%= hospital.chargePharmacy %>
	<br>
	
	<br>
	<br>
	<% ArrayList<Hospital> blist = (ArrayList<Hospital>)request.getAttribute("diag"); %>
	<br>
	<br>
	
	<h2>Diagnostics Conducted</h2>
	<table border bgcolor="white" cellspacing="5">
	<tr>
	<th>Name of the test</th>
	<th>Amount</th>
	</tr>
	<% for(Hospital hs:blist){ %>
	<tr>
	<td><%= hs.getTestName() %></td>
	<td><%= hs.getAmountDiagnosis() %></td>
	</tr>
	<% } %>	
	</table>
	<br>
	<br>
	Bill for Pharmacy:  <%= hospital.chargeDiagnosis %>
	<br>
	<br>
	Grand total:  <%= hospital.grandTotal %>
	<br>
	<input type="submit" value="Confirm" onclick="alert('Please Collect the amount.')">
	</center>
</div>
</div>
		
</body>
</html>