package com.jsp.springjdbc.dao;

public class employee 
{
  private int EID;
  private String ENAME;
  private int ESALARY;
  private int EDEPTNO;
  private String EMAIL;
  private String PASSWORD;
  private String EMOBILENO;
public int getEID() {
	return EID;
}
public void setEID(int eID) {
	EID = eID;
}
public String getENAME() {
	return ENAME;
}
public void setENAME(String eNAME) {
	ENAME = eNAME;
}
public int getESALARY() {
	return ESALARY;
}
public void setESALARY(int eSALARY) {
	ESALARY = eSALARY;
}
public int getEDEPTNO() {
	return EDEPTNO;
}
public void setEDEPTNO(int eDEPTNO) {
	EDEPTNO = eDEPTNO;
}
public String getEMAIL() {
	return EMAIL;
}
public void setEMAIL(String eMAIL) {
	EMAIL = eMAIL;
}
public String getPASSWORD() {
	return PASSWORD;
}
public void setPASSWORD(String pASSWORD) {
	PASSWORD = pASSWORD;
}
public String getEMOBILENO() {
	return EMOBILENO;
}
public void setEMOBILENO(String eMOBILENO) {
	EMOBILENO = eMOBILENO;
}
@Override
public String toString() {
	return "employee [EID=" + EID + ", ENAME=" + ENAME + ", ESALARY=" + ESALARY + ", EDEPTNO=" + EDEPTNO + ", EMAIL="
			+ EMAIL + ", PASSWORD=" + PASSWORD + ", EMOBILENO=" + EMOBILENO + "]";
}
  
  
}
