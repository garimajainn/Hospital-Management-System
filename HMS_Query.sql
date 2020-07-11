//Login Query
create Table login (
USERNAME varchar2(30) not null,
PASSWORD varchar2(30) not null
);

insert into login(USERNAME, PASSWORD) values ('admin123','Admin@1234');

Select * from login;

//Patient Table
create Table PatientAccount_HMS(
patient_Id NUMBER(11) PRIMARY KEY,
SSN_ID NUMBER(11) NOT NULL,
Patient_Name varchar2(30),
Patient_Age varchar2(30),
Date_of_Admission varchar2(30),
Bed_Type varchar2(30),
Patient_Address varchar2(30),
State varchar2(30),
City varchar2(30)
);

create sequence patientIdSeq
MINVALUE 100000000
MAXVALUE 10000000000
START WITH 100000000
INCREMENT BY 1;


CREATE TABLE medicine (
    Medicine_Name varchar2(30),
    Quantity NUMBER(11),
    Patient_Id NUMBER(11),
    Rate Number(10),
    Amount Number(10),
    FOREIGN KEY (Patient_Id) REFERENCES PatientAccount_HMS(Patient_Id)
);

CREATE TABLE diagnostics (
    Patient_Id NUMBER(11),
    Diagnosis varchar2(30),
    Amount Number(10),
    FOREIGN KEY (Patient_Id) REFERENCES PatientAccount_HMS(Patient_Id)
);

Select * from PatientAccount_HMS;

Select * from medicine;

Select * from diagnostics;

delete from PatientAccount_HMS where Patient_Id=100000003;

drop table PatientAccount_HMS;

drop table medicine;

drop table diagnostics;

drop sequence patientIdSeq;