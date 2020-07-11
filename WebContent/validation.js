/**
 * 
 */
//validation for Login Pg
function alphanumeric()
{
	var un = document.loginForm.username.value;
	var letters = /^[0-9a-zA-Z]+$/;
	if (un.match(letters) && un.length >= 8) {
		return true;
	} else {
		alert("Please enter at least 8 alphanumeric characters");
		document.loginForm.username.focus();
		return false;
	}
}

function chkPassword()
{
	var pw = document.loginForm.password.value;
	var letters = /^(?=.*\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[^a-zA-Z0-9])(?!.*\s).{10,}$/;
	if (pw.match(letters)) {
		return true;
	} else {
		alert("Please enter at least 10 characters including one uppercase, one numeric digit, one special character...!");
		document.loginForm.password.focus();
		return false;
	}
}
//validation for Create Customer Pg
function chkCustName()
{
	var cname = document.createCustForm.custname.value;
	if(cname == null || cname.length<=0)
	{
		alert(" Please enter Customer Name ");
		document.customerForm.firstName.focus();
		return false;
	}
	return true;
}
