package com.service;

import java.sql.SQLException;
import java.util.ArrayList;


import com.bean.Hospital;

import com.dao.HospitalDao;

public class HospitalService {
HospitalDao hDao=new HospitalDao();

public boolean checkLoginDetail(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.checkLoginDetail(hospital);
}
public int patientRegistration(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.patientRegistration(hospital);
}
public boolean updatePatientId(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.updatePatientId(hospital);
}
public boolean updatePatient(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.updatePatient(hospital);
}
public boolean deletePatientId(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.deletePatientId(hospital);
}
public boolean deletePatient(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.deletePatient(hospital);
}
public ArrayList<Hospital> viewPatient() throws ClassNotFoundException, SQLException {
	return hDao.viewPatient();
}
public boolean searchPatientId(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.searchPatientId(hospital);
}
public ArrayList<Hospital> getPharmacyDetail(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.getPharmacyDetail(hospital);
}
public boolean pharmacy(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.pharmacy(hospital);
}
public ArrayList<Hospital> getDiagnosticsDetail(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.getDiagnosticsDetail(hospital);
}
public boolean diagnostics(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.diagnostics(hospital);
}
public ArrayList<Hospital>[] getBillingDetail(Hospital hospital) throws ClassNotFoundException, SQLException {
	return hDao.getBillingDetail(hospital);
}
}
