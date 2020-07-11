package com.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bean.Hospital;
import com.service.HospitalService;

@SuppressWarnings("serial")
@WebServlet("/HospitalController")
public class HospitalController extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HospitalService service = new HospitalService();
		
		String source = request.getParameter("source");
		if(source.equals("vPatient"))
		{
//View Patient
			try {
				ArrayList<Hospital> blist = service.viewPatient();
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/viewPatient.jsp");
				request.setAttribute("list", blist);
				rd.forward(request, response);	
			}							
			 catch (Exception e) {
				e.printStackTrace();
				}	
		}else if(source.equals("logout")) 
		{
			HttpSession session = request.getSession();
			session.getAttribute("uname");
			session.invalidate();
			response.sendRedirect("login.jsp");
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid;
		HospitalService service = new HospitalService();
		String source = request.getParameter("source");
		
//Login Page		
		if(source.equals("login")) 
		{	
			Hospital hospital=new Hospital();
			 String uname=request.getParameter("username");
			hospital.setUserName(request.getParameter("username"));
			hospital.setPassword(request.getParameter("password"));
			
			boolean flag;
			try {
				flag = service.checkLoginDetail(hospital);
				if(flag==true) 
				{
					HttpSession session = request.getSession();
					session.setAttribute("uname", uname);
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/home.jsp");
					request.setAttribute("uname", uname);
					PrintWriter out = response.getWriter();
					out.println("<font color=green>Success</font>");
					rd.forward(request, response);
				}
				else 
				{
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/login.jsp");
					PrintWriter out = response.getWriter();
					
					out.println("<font color=red>Invalid Credentials...Please check your Username or Password</font>");
					rd.include(request, response);
					
				}
			} catch (ClassNotFoundException | SQLException e) {
				
				e.printStackTrace();
			}						
		}else if(source.equals("patientRegistration")){
//Patient Registration
			Hospital hospital=new Hospital();
			HttpSession session = request.getSession();
			session.getAttribute("uname");
			hospital.setSsnid(Integer.parseInt(request.getParameter("ssnId")));
			hospital.setPatientName(request.getParameter("name"));
			hospital.setPatientAge(Integer.parseInt(request.getParameter("age")));
			hospital.setDateOfAdmission(request.getParameter("date"));
			hospital.setBedtype(request.getParameter("bed"));
			hospital.setAddress(request.getParameter("address"));
			hospital.setState(request.getParameter("state"));
			hospital.setCity(request.getParameter("city"));
			
			
			try {
				Integer patientId = service.patientRegistration(hospital);
				if (patientId != null) {
					request.setAttribute("patientId", patientId);
					System.out.println("Patient Created :"+patientId);
				}
				RequestDispatcher rd = getServletContext().getRequestDispatcher("/patientRegistration.jsp");
				rd.forward(request, response);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}else if(source.equals("getUpdatePatient")) {
//Get Patient id for Patient Update
			Hospital hospital=new Hospital();
			hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
			//int id=Integer.parseInt(request.getParameter("patientId"));
			try {
				boolean flag = service.updatePatientId(hospital);
				
				if(flag) {
					
					RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatePatient.jsp");
					request.setAttribute("hospital", hospital);
					rd.forward(request, response);
				}
		}catch (Exception e) {
			e.printStackTrace();
		}
			
		}else if(source.equals("updatePatient")) {
//Update patient
			Hospital hospital=new Hospital();
			
			System.out.println(request.getParameter("patientId"));
			hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
			hospital.setPatientName(request.getParameter("name"));
			hospital.setPatientAge(Integer.parseInt(request.getParameter("age")));
			hospital.setDateOfAdmission(request.getParameter("date"));
			hospital.setBedtype(request.getParameter("bed"));
			hospital.setAddress(request.getParameter("address"));
			hospital.setState(request.getParameter("state"));
			hospital.setCity(request.getParameter("city"));
			try {
				boolean flag = service.updatePatient(hospital);
				int patientId=hospital.getPatientId();
				if(flag) {
					

					RequestDispatcher rd = getServletContext().getRequestDispatcher("/updatedSuccessfully.jsp");
					rd.forward(request, response);
				}
				}catch (Exception e) {
					e.printStackTrace();
				}

		}
		else if(source.equals("getDeletePatient")) {
//Get Patient id for Patient Delete
						Hospital hospital=new Hospital();
						hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
						//int id=Integer.parseInt(request.getParameter("patientId"));
						try {
							boolean flag = service.deletePatientId(hospital);
							
							if(flag) {
								
								RequestDispatcher rd = getServletContext().getRequestDispatcher("/deletePatient.jsp");
								request.setAttribute("hospital", hospital);
								rd.forward(request, response);
							}
					}catch (Exception e) {
						e.printStackTrace();
					}
						
					}
		else if(source.equals("deletePatient")) {
			//Update patient
						Hospital hospital=new Hospital();
						hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
						//System.out.println(request.getParameter("patientId"));
						/*hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
						hospital.setPatientName(request.getParameter("name"));
						hospital.setPatientAge(Integer.parseInt(request.getParameter("age")));
						hospital.setDateOfAdmission(request.getParameter("date"));
						hospital.setBedtype(request.getParameter("bed"));
						hospital.setAddress(request.getParameter("address"));
						hospital.setState(request.getParameter("state"));
						hospital.setCity(request.getParameter("city"));*/
						try {
							boolean flag = service.updatePatient(hospital);
							int patientId=hospital.getPatientId();
							if(flag) {
								//System.out.println("Deleted");
								
									//System.out.println("check");

								RequestDispatcher rd = getServletContext().getRequestDispatcher("/deletedSuccessfully.jsp");
								rd.forward(request, response);
							}
							}catch (Exception e) {
								e.printStackTrace();
							}

					}
		else if(source.equals("getSearchPatient")) {
			//Get Patient id for Patient Delete
									Hospital hospital=new Hospital();
									hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
									//int id=Integer.parseInt(request.getParameter("patientId"));
									try {
										boolean flag = service.searchPatientId(hospital);
										
										if(flag) {
											
											RequestDispatcher rd = getServletContext().getRequestDispatcher("/searchPatient.jsp");
											request.setAttribute("hospital", hospital);
											rd.forward(request, response);
										}
								}catch (Exception e) {
									e.printStackTrace();
								}
									
								}
		else if(source.equals("getPharmacyDetail")) {
			//Get Patient id for Pharmacy Patient
									Hospital hospital=new Hospital();
									hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
									pid=Integer.parseInt(request.getParameter("patientId"));
									System.out.println(pid);
									try {
										ArrayList<Hospital> blist = service.getPharmacyDetail(hospital);
										for(Hospital hs:blist){
											System.out.println(hs.getMedicine());
										}
											RequestDispatcher rd = getServletContext().getRequestDispatcher("/pharmacy.jsp");
											request.setAttribute("hospital", hospital);
											request.setAttribute("list", blist);
											rd.forward(request, response);	
										
								}catch (Exception e) {
									e.printStackTrace();
								}
									
								}
		else if(source.equals("pharmacy")) {
			//Update patient
						Hospital hospital=new Hospital();
						
						
						//hospital.setPatientId(pid);
						System.out.println(Integer.parseInt(request.getParameter("patientId")));
						hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
						hospital.setAmountPharmacy(Integer.parseInt(request.getParameter("amount")));
						hospital.setMedicine(request.getParameter("medicine"));
						hospital.setRate(Integer.parseInt(request.getParameter("rate")));
						hospital.setQuantity(Integer.parseInt(request.getParameter("quantity")));
						
						try {
							boolean flag = service.pharmacy(hospital);
							if(flag) {
								System.out.println("done");
								
								RequestDispatcher rd = getServletContext().getRequestDispatcher("/getPharmacy.jsp");	
								rd.forward(request, response);
							}
							}catch (Exception e) {
								e.printStackTrace();
							}

					}
		else if(source.equals("getDiagnosticsDetail")) {
			//Get Patient id for Pharmacy Patient
									Hospital hospital=new Hospital();
									hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
									pid=Integer.parseInt(request.getParameter("patientId"));
									//System.out.println(pid);
									try {
										ArrayList<Hospital> blist = service.getDiagnosticsDetail(hospital);
										System.out.println("diag");
										RequestDispatcher rd = getServletContext().getRequestDispatcher("/dg.jsp");
										request.setAttribute("hospital", hospital);
										request.setAttribute("list", blist);
										rd.forward(request, response);	
										
								}catch (Exception e) {
									e.printStackTrace();
								}
									
								}
		else if(source.equals("diagnostics")) {
			//Update patient
						Hospital hospital=new Hospital();
						
						
						//hospital.setPatientId(pid);
						System.out.println(Integer.parseInt(request.getParameter("patientId")));
						hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
						hospital.setAmountDiagnosis(Integer.parseInt(request.getParameter("amount")));
						hospital.setTestName(request.getParameter("testname"));
						
						
						try {
							boolean flag = service.diagnostics(hospital);
							if(flag) {
								System.out.println("done");
								
								RequestDispatcher rd = getServletContext().getRequestDispatcher("/getDiagnostics.jsp");	
								rd.forward(request, response);
							}
							}catch (Exception e) {
								e.printStackTrace();
							}

					}
		else if(source.equals("getBillingDetail")) {
			//Get Patient id for Pharmacy Patient
									Hospital hospital=new Hospital();
									hospital.setPatientId(Integer.parseInt(request.getParameter("patientId")));
									System.out.println(hospital.getPatientId());
									try {
										ArrayList<Hospital>[] arr = service.getBillingDetail(hospital);
										System.out.println("diag");
										for(Hospital hs:arr[1]){
											System.out.println(hs.getMedicine());
										}
										RequestDispatcher rd = getServletContext().getRequestDispatcher("/billing.jsp");
										request.setAttribute("hospital", hospital);
										request.setAttribute("phar", arr[1]);
										request.setAttribute("diag", arr[0]);
										
										rd.forward(request, response);	
										
								}catch (Exception e) {
									e.printStackTrace();
								}
									
								}
		
	}
}
