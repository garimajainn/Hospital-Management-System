<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.bean.Hospital" %>
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

th, td {
  text-align: left;
  padding: 8px;
}
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
                
                <li class="dropdown"><a href="HospitalController?source=logout">Logout</a></li>
            </ul>
        </nav>
    </div>
  </div>
<div id="header2">
<h2 align="center">Update Patient</h2>
<!--div class="center"-->


<form action="HospitalController" method="post" name="patientUpdateGetForm"
			autocomplete="off">
			<input type="hidden" name="source" value="getUpdatePatient">
			<table cellpadding=2 align="center">
			<tr>
			<th>Patient ID*</th>
			 <td><input type="text" name="patientId" placeholder="PatientID" required></td>
			 <td></td>
			 <td><input type="submit" value="Get"></td>
			 </tr>
			 </table>
			 </form>
		<form action="HospitalController" method="post" name="patientUpdateForm"
			autocomplete="off">
			<input type="hidden" name="source" value="updatePatients">
			<table cellpadding=2 align="center">
			 <tr>
			 <th>Patient Name</th>
			 <td><input type="text" name="name" placeholder="Name" required></td>
			 </tr>
			 <tr>
			 <th>Patient Age</th>
			 <td><input type="text" name="age" placeholder="Age" required></td>
			 </tr>
			 <tr>
			 <th>Date of Admission</th>
			 <td><input type="text" name="date" placeholder="DD/MM/YYYY" required></td>
			 </tr>
			 <tr>
			 <th>Type of Bed</th>
			 <td><select name="bed" >
					<option value="Single" selected >Single</option>
					<option value="Double" >Double</option>
				</select>	
			 </td>
			 </tr>
			 <tr>
			 <th>Address</th>
			 <td><textarea name="address" id="address" required></textarea></td>
			 </tr>
			 <tr>
			 <th>State</th>
			 <td><select name="state" >
					<option value="UttarPradesh" selected >UttarPradesh</option>
					<option value="MadhyaPradesh" >MadhyaPradesh</option>
					<option value="AndraPradesh" >AndraPradesh</option>
					<option value="Delhi" >Delhi</option>
					<option value="Rajasthan" >Rajasthan</option>
					<option value="HimachalPradesh" >HimachalPradesh</option>
					<option value="Punjab" >Punjab</option>
					<option value="Haryana" >Haryana</option>
					<option value="Uttarakhand" >Uttarakhand</option>
			</select></td>
			 </tr>
			 <tr>
			 <th>City</th>
			 <td><select name="city" >
					<option value="Delhi" selected >Delhi</option>
					<option value="Gurgaon" >Gurgaon</option>
					<option value="Dehradun" >Dehradun</option>
					<option value="Nanital" >Nanital</option>
					<option value="Shimla" >Shimla</option>
					<option value="Jaipur" >Jaipur</option>
					<option value="Amritsar" >Amritsar</option>
					<option value="Indore" >Indore</option>
					<option value="Etawah" >Etawah</option>
			</select></td>
			 </tr>
			 </table>
			 <centre>
			 <br><br>
			 *Mandatory<br>
			 <input type="submit" value="Update">
			 </centre>
		</form>
		
<!--/div-->
</div>
		
</body>
</html>