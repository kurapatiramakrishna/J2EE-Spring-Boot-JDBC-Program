package com.jsp.springjdbc.dao;

public interface employeedao 
{
	
     int addemployee(employee e1);
     
     int delemployee(int employeeId);
     
     employee getEmployeeById(int employeeId);

     int updateEmployee(employee e);

	

}
