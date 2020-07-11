package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;


import com.bean.Hospital;

import com.util.HospitalDBUtil;

public class HospitalDao {
	
		
		Connection con=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		public boolean checkLoginDetail(Hospital hospital) throws SQLException,ClassNotFoundException {
				// TODO Auto-generated method stub
				System.out.println("Dao");
				boolean flag=false;
				con=HospitalDBUtil.getConnection();
				
				ps=con.prepareStatement("Select * from login where USERNAME=? and PASSWORD=?");
				
				ps.setString(1,hospital.getUserName());
				//System.out.println("ps1");
				ps.setString(2,hospital.getPassword());
				rs = ps.executeQuery(); 
				
				if(rs!=null && rs.next()) {
					flag=true;
				}
				else {
					flag=false;
	  			}
				HospitalDBUtil.closeConnection(con);
				HospitalDBUtil.closeStatement(ps);
		return flag;
	}
		public int patientRegistration(Hospital hospital) throws SQLException,ClassNotFoundException {
		Integer id=null;
		//Integer customerId = null;
		int rowstatus = 0;
		String query = null;
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs =  null;
		Statement stmt = null;		
		
		try {		
			con = HospitalDBUtil.getConnection();
			ps=con.prepareStatement("insert into PatientAccount_HMS(Patient_Id,SSN_Id,Patient_Name,Patient_Age,Date_of_Admission,Bed_Type,Patient_Address,State,City) values(patientIdSeq.nextval,?,?,?,?,?,?,?,?)");
			ps.setInt(1,hospital.getSsnid());
			ps.setString(2,hospital.getPatientName());
			ps.setInt(3,hospital.getPatientAge());
			ps.setString(4,hospital.getDateOfAdmission());
			ps.setString(5,hospital.getBedtype());
			ps.setString(6,hospital.getAddress());
			ps.setString(7,hospital.getState());
			ps.setString(8,hospital.getCity());
			
			rowstatus = ps.executeUpdate(); 
			System.out.println(rowstatus);
			query = "Select MAX(Patient_Id) from PatientAccount_HMS";
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);
			while(rs.next()) 
			{
				id = rs.getInt(1);
				hospital.setPatientId(id);
				System.out.println("Patient Id :" +id);
			}
			//banker.setCid(customerId.toString());
						
		} 
		catch (SQLException e) {
			e.printStackTrace();
		}
		return id;
		}
		public boolean updatePatientId(Hospital hospital) throws SQLException,ClassNotFoundException {
			
			boolean flag=false;
			
			int patientId=hospital.getPatientId();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			//Statement stmt = null;		
			
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
				ps.setInt(1,patientId);
				rs = ps.executeQuery();
				while(rs.next()) 
				{
					hospital.setPatientId(rs.getInt(1));
					hospital.setSsnid(rs.getInt(2));
					hospital.setPatientName(rs.getString(3));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setDateOfAdmission(rs.getString(5));
					hospital.setBedtype(rs.getString(6));
					hospital.setAddress(rs.getString(7));
					hospital.setState(rs.getString(8));
					hospital.setCity(rs.getString(9));
				}
				System.out.println(hospital.getAddress());
				flag=true;
				System.out.println(flag);
								
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);
			return flag;
		}
		public boolean updatePatient(Hospital hospital) throws SQLException,ClassNotFoundException {		
			boolean flag=false;
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("Update PatientAccount_HMS SET Patient_Name=?,Patient_Age=?,Date_of_Admission=?,Bed_Type=?,Patient_Address=?,State=?,City=? where Patient_Id=?");
				ps.setString(1,hospital.getPatientName());
				ps.setInt(2,hospital.getPatientAge());
				ps.setString(3,hospital.getDateOfAdmission());
				ps.setString(4,hospital.getBedtype());		
				ps.setString(5,hospital.getAddress());
				ps.setString(6,hospital.getState());
				ps.setString(7,hospital.getCity());
				ps.setInt(8,hospital.getPatientId());
				rs = ps.executeQuery();
				flag=true;
				System.out.println("hello");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);
			
			return flag;
}
public boolean deletePatientId(Hospital hospital) throws SQLException,ClassNotFoundException {
			
			boolean flag=false;
			
			int patientId=hospital.getPatientId();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			//Statement stmt = null;		
			
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
				ps.setInt(1,patientId);
				rs = ps.executeQuery();
				while(rs.next()) 
				{
					hospital.setPatientId(rs.getInt(1));
					hospital.setSsnid(rs.getInt(2));
					hospital.setPatientName(rs.getString(3));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setDateOfAdmission(rs.getString(5));
					hospital.setBedtype(rs.getString(6));
					hospital.setAddress(rs.getString(7));
					hospital.setState(rs.getString(8));
					hospital.setCity(rs.getString(9));
				}
				//System.out.println(hospital.getAddress());
				flag=true;
				//System.out.println(flag);
								
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);
			return flag;
		}
		public boolean deletePatient(Hospital hospital) throws SQLException,ClassNotFoundException {		
			boolean flag=false;
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("delete from PatientAccount_HMS where Patient_Id=?");
				ps.setInt(1,hospital.getPatientId());
				rs = ps.executeQuery();
				System.out.println("patient id"+hospital.getPatientId());
				flag=true;
				System.out.println("hello");
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);
			
			return flag;
}
		public ArrayList<Hospital> viewPatient() {
			ArrayList<Hospital> blist = new ArrayList<Hospital>();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("Select * from PatientAccount_HMS ");
				rs = ps.executeQuery();
				while(rs.next()) 
				{
					Hospital hospital=new Hospital();
					hospital.setPatientId(rs.getInt(1));
					hospital.setSsnid(rs.getInt(2));
					hospital.setPatientName(rs.getString(3));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setDateOfAdmission(rs.getString(5));
					hospital.setBedtype(rs.getString(6));
					hospital.setAddress(rs.getString(7));
					hospital.setState(rs.getString(8));
					hospital.setCity(rs.getString(9));
			
					blist.add(hospital);
				}					
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);		
			return blist;
		}
public boolean searchPatientId(Hospital hospital) throws SQLException,ClassNotFoundException {
			
			boolean flag=false;
			
			int patientId=hospital.getPatientId();
			Connection con = null;
			PreparedStatement ps = null;
			ResultSet rs =  null;
			//Statement stmt = null;		
			
			try {		
				con = HospitalDBUtil.getConnection();
				ps=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
				ps.setInt(1,patientId);
				rs = ps.executeQuery();
				while(rs.next()) 
				{
					hospital.setPatientId(rs.getInt(1));
					hospital.setSsnid(rs.getInt(2));
					hospital.setPatientName(rs.getString(3));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setPatientAge(rs.getInt(4));
					hospital.setDateOfAdmission(rs.getString(5));
					hospital.setBedtype(rs.getString(6));
					hospital.setAddress(rs.getString(7));
					hospital.setState(rs.getString(8));
					hospital.setCity(rs.getString(9));
				}
				//System.out.println(hospital.getAddress());
				flag=true;
				//System.out.println(flag);
								
			} 
			catch (SQLException e) {
				e.printStackTrace();
			}
			HospitalDBUtil.closeConnection(con);
			HospitalDBUtil.closeStatement(ps);
			
			return flag;
}
public ArrayList<Hospital> getPharmacyDetail(Hospital hospital) {
	
	int patientId=hospital.getPatientId();
	Connection con = null;
	PreparedStatement ps1 = null;
	ResultSet rs1 =  null;
	//Statement stmt = null;		
	ArrayList<Hospital> blist = new ArrayList<Hospital>();
	PreparedStatement ps = null;
	ResultSet rs =  null;
	try {		
		con = HospitalDBUtil.getConnection();
		ps1=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
		ps1.setInt(1,patientId);
		rs1 = ps1.executeQuery();
		while(rs1.next()) 
		{
			hospital.setPatientId(rs1.getInt(1));
			hospital.setSsnid(rs1.getInt(2));
			hospital.setPatientName(rs1.getString(3));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setDateOfAdmission(rs1.getString(5));
			hospital.setBedtype(rs1.getString(6));
			hospital.setAddress(rs1.getString(7));
			hospital.setState(rs1.getString(8));
			hospital.setCity(rs1.getString(9));
		}
		ps=con.prepareStatement("Select * from medicine where Patient_Id=?");
		ps.setInt(1,patientId);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			Hospital hs=new Hospital();
			hs.setMedicine(rs.getString(1));
			hs.setQuantity(rs.getInt(2));
			hs.setPatientId(rs.getInt(3));
			hs.setRate(rs.getInt(4));
			hs.setAmountPharmacy(rs.getInt(5));
			blist.add(hs);
			System.out.println(hs.getMedicine());
		}					
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	HospitalDBUtil.closeConnection(con);
	HospitalDBUtil.closeStatement(ps);		
	return blist;
}
public boolean pharmacy(Hospital hospital) throws SQLException,ClassNotFoundException {
	boolean flag=false;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		
	
	try {		
		con = HospitalDBUtil.getConnection();
		ps=con.prepareStatement("insert into medicine(Medicine_Name,Quantity,Patient_Id,Rate,Amount) values(?,?,?,?,?)");
		ps.setString(1,hospital.getMedicine());
		ps.setInt(2,hospital.getQuantity());
		ps.setInt(3,hospital.getPatientId());
		ps.setInt(4,hospital.getRate());
		ps.setInt(5,hospital.getAmountPharmacy());

		rs = ps.executeQuery();
		flag=true;
				
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}
public ArrayList<Hospital> getDiagnosticsDetail(Hospital hospital) {
	
	int patientId=hospital.getPatientId();
	Connection con = null;
	PreparedStatement ps1 = null;
	ResultSet rs1 =  null;
	//Statement stmt = null;		
	ArrayList<Hospital> blist = new ArrayList<Hospital>();
	PreparedStatement ps = null;
	ResultSet rs =  null;
	try {		
		con = HospitalDBUtil.getConnection();
		ps1=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
		ps1.setInt(1,patientId);
		rs1 = ps1.executeQuery();
		while(rs1.next()) 
		{
			hospital.setPatientId(rs1.getInt(1));
			hospital.setSsnid(rs1.getInt(2));
			hospital.setPatientName(rs1.getString(3));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setDateOfAdmission(rs1.getString(5));
			hospital.setBedtype(rs1.getString(6));
			hospital.setAddress(rs1.getString(7));
			hospital.setState(rs1.getString(8));
			hospital.setCity(rs1.getString(9));
		}
		ps=con.prepareStatement("Select * from diagnostics where Patient_Id=?");
		ps.setInt(1,patientId);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			Hospital hs=new Hospital();
			hs.setPatientId(rs.getInt(1));
			hs.setTestName(rs.getString(2));
			hs.setAmountDiagnosis(rs.getInt(3));
			
			blist.add(hs);
		
		}
		System.out.println("hurray");
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	HospitalDBUtil.closeConnection(con);
	HospitalDBUtil.closeStatement(ps);		
	return blist;
}
public boolean diagnostics(Hospital hospital) throws SQLException,ClassNotFoundException {
	boolean flag=false;

	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs =  null;
	Statement stmt = null;		

	try {		
		con = HospitalDBUtil.getConnection();
		ps=con.prepareStatement("insert into diagnostics(Patient_Id,Diagnosis,Amount) values(?,?,?)");
		ps.setInt(1,hospital.getPatientId());
		ps.setString(2,hospital.getTestName());
		ps.setInt(3,hospital.getAmountDiagnosis());

		rs = ps.executeQuery();
		flag=true;
				
	} 
	catch (SQLException e) {
		e.printStackTrace();
	}
	return flag;
	}
public ArrayList<Hospital>[] getBillingDetail(Hospital hospital) {
	hospital.chargePharmacy=0;
	hospital.chargeDiagnosis=0;
	hospital.chargeBed=0;
	int patientId=hospital.getPatientId();
	Connection con = null;
	PreparedStatement ps1 = null;
	PreparedStatement ps2 = null;
	ResultSet rs1 =  null;
	ResultSet rs2 =  null;
	//Statement stmt = null;		
	ArrayList<Hospital> blist = new ArrayList<Hospital>();
	ArrayList<Hospital> clist = new ArrayList<Hospital>();
	PreparedStatement ps = null;
	ResultSet rs =  null;
	ArrayList<Hospital> arr[]=new ArrayList[2];
	try {		
		con = HospitalDBUtil.getConnection();
		ps1=con.prepareStatement("Select * from PatientAccount_HMS where Patient_Id=?");
		ps1.setInt(1,patientId);
		rs1 = ps1.executeQuery();
		while(rs1.next()) 
		{
			hospital.setPatientId(rs1.getInt(1));
			hospital.setSsnid(rs1.getInt(2));
			hospital.setPatientName(rs1.getString(3));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setPatientAge(rs1.getInt(4));
			hospital.setDateOfAdmission(rs1.getString(5));
			hospital.setBedtype(rs1.getString(6));
			hospital.setAddress(rs1.getString(7));
			hospital.setState(rs1.getString(8));
			hospital.setCity(rs1.getString(9));
		}
		ps=con.prepareStatement("Select * from diagnostics where Patient_Id=?");
		ps.setInt(1,patientId);
		rs = ps.executeQuery();
		while(rs.next()) 
		{
			Hospital hs=new Hospital();
			hs.setPatientId(rs.getInt(1));
			hs.setTestName(rs.getString(2));
			hs.setAmountDiagnosis(rs.getInt(3));
			hospital.chargeDiagnosis=hospital.chargeDiagnosis+hs.getAmountDiagnosis();
			blist.add(hs);
	System.out.println(hs.getTestName());
		}
		ps2=con.prepareStatement("Select * from medicine where Patient_Id=?");
		ps2.setInt(1,patientId);
		rs2 = ps2.executeQuery();
		while(rs2.next()) 
		{
			Hospital hs=new Hospital();
			hs.setMedicine(rs2.getString(1));
			hs.setQuantity(rs2.getInt(2));
			hs.setPatientId(rs2.getInt(3));
			hs.setRate(rs2.getInt(4));
			hs.setAmountPharmacy(rs2.getInt(5));
			hospital.chargePharmacy=hospital.chargePharmacy+hs.getAmountPharmacy();
			clist.add(hs);
			System.out.println(hs.getMedicine());
		}		
		long m=System.currentTimeMillis();
		java.sql.Date date=new java.sql.Date(m);
		String dateBefore=hospital.getDateOfAdmission();
		String dateAfter=date.toString();
		LocalDate bd=LocalDate.parse(dateBefore);
		LocalDate ba=LocalDate.parse(dateAfter);
		System.out.println(dateAfter);
		long day=ChronoUnit.DAYS.between(bd, ba);
		System.out.println(day);
		if((hospital.getBedtype()).equals("General")) {
			hospital.chargeBed=(int)day*2000;
		}else if((hospital.getBedtype()).equals("Semi")) {
			hospital.chargeBed=(int)day*4000;
		}else {
			hospital.chargeBed=(int)day*8000;
		}
		hospital.days=(int)day;
		System.out.println("hurray");
		arr[0]=blist;
		arr[1]=clist;
		hospital.grandTotal=hospital.chargeBed+hospital.chargeDiagnosis+hospital.chargePharmacy;
	} 
	
	catch (SQLException e) {
		e.printStackTrace();
	}
	HospitalDBUtil.closeConnection(con);
	HospitalDBUtil.closeStatement(ps);		
	return arr;
}

}
