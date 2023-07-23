package com.jsp.springjdbc.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class employedaoImp implements employeedao 
{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public employedaoImp(JdbcTemplate jdbcTemplate) 
    {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addemployee(employee e1) 
    {
        String query = "INSERT INTO employee (EID, ENAME, ESALARY, EDEPTNO, EMAIL, PASSWORD, EMOBILENO) VALUES (?, ?, ?, ?, ?, ?, ?)";
return jdbcTemplate.update(query, e1.getEID(), e1.getENAME(), e1.getESALARY(), e1.getEDEPTNO(), e1.getEMAIL(), e1.getPASSWORD(), e1.getEMOBILENO());
    }

    @Override
    public int delemployee(int employeeId) 
    { // Update the parameter type to int
        String query = "DELETE FROM employee WHERE EID = ?";
        return jdbcTemplate.update(query, employeeId);
    }
    @Override
    public employee getEmployeeById(int employeeId) {
        String query = "SELECT * FROM employee WHERE EID = ?";
        return jdbcTemplate.queryForObject(query, new BeanPropertyRowMapper<>(employee.class), employeeId);
    }
    @Override
    public int updateEmployee(employee e) {
        String query = "UPDATE employee SET ENAME = ?, ESALARY = ?, EDEPTNO = ?, EMAIL = ?, PASSWORD = ?, EMOBILENO = ? WHERE EID = ?";
        return jdbcTemplate.update(query, e.getENAME(), e.getESALARY(), e.getEDEPTNO(), e.getEMAIL(), e.getPASSWORD(), e.getEMOBILENO(), e.getEID());
    }

	
 
}
