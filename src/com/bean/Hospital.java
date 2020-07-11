package com.bean;

public class Hospital {
	private boolean check;
	
	public boolean isCheck() {
		return check;
	}
	public void setCheck(boolean check) {
		this.check = check;
	}
	private int PatientId;
public int getPatientId() {
		return PatientId;
	}
	public void setPatientId(int patientId) {
		PatientId = patientId;
	}
private String userName;
private String password;
private int ssnid;
private String patientName;
private int patientAge;
private String dateOfAdmission;
public int getSsnid() {
	return ssnid;
}
public void setSsnid(int ssnid) {
	this.ssnid = ssnid;
}
public String getPatientName() {
	return patientName;
}
public void setPatientName(String patientName) {
	this.patientName = patientName;
}
public int getPatientAge() {
	return patientAge;
}
public void setPatientAge(int patientAge) {
	this.patientAge = patientAge;
}
public String getDateOfAdmission() {
	return dateOfAdmission;
}
public void setDateOfAdmission(String dateOfAdmission) {
	this.dateOfAdmission = dateOfAdmission;
}
public String getBedtype() {
	return bedtype;
}
public void setBedtype(String bedtype) {
	this.bedtype = bedtype;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getState() {
	return state;
}
public void setState(String state) {
	this.state = state;
}
public String getCity() {
	return city;
}
public void setCity(String city) {
	this.city = city;
}
private String bedtype;
private String address;
private String state;
private String city;
private String status;
private String message;

public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
private String medicine;
private int quantity;
private int amountPharmacy;
private int rate;
public String getMedicine() {
	return medicine;
}
public void setMedicine(String medicine) {
	this.medicine = medicine;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public int getAmountPharmacy() {
	return amountPharmacy;
}
public void setAmountPharmacy(int amountPharmacy) {
	this.amountPharmacy = amountPharmacy;
}
public int getRate() {
	return rate;
}
public void setRate(int rate) {
	this.rate = rate;
}
public String getTestName() {
	return testName;
}
public void setTestName(String testName) {
	this.testName = testName;
}
public int getAmountDiagnosis() {
	return amountDiagnosis;
}
public void setAmountDiagnosis(int amountDiagnosis) {
	this.amountDiagnosis = amountDiagnosis;
}
private String testName;
public int amountDiagnosis;
public int chargePharmacy;
public int chargeDiagnosis;
public int chargeBed;
public int grandTotal;
public int days;


}
