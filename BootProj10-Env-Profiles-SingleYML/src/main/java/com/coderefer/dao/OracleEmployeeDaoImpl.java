package com.coderefer.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import com.coderefer.bo.EmployeeBO;

@Repository("empDAO")
@Profile({"uat", "prod"})
public class OracleEmployeeDaoImpl implements IEmployeeDAO {
	private static final String GET_EMPS_BY_DESG = 
			"SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, MGRNO FROM EMP WHERE JOB IN ";
	@Autowired
	private DataSource ds;
	
	public OracleEmployeeDaoImpl() {
		System.out.println("OracleEmployeeDaoImpl.OracleEmployeeDaoImpl()");
	}
	
	
	@Override
	public List<EmployeeBO> getEmpsByDesg(String cond) throws Exception {
		List<EmployeeBO> listBO = null;
		System.out.println(ds.getClass());
		try (
//				get pooled jdbc conn
				Connection con = ds.getConnection();
//				create statement obj
				Statement st = con.createStatement(); // prepared statement cannot be used because no of designations is dynamic value;
			) {
			
//			send and execute SQL Query in DB s/w
//			SELECT EMPNO, ENAME, JOB, SAL, DEPTNO, MGRNO FROM EMP WHERE JOB IN ('Technical Lead') ORDER BY JOB
			ResultSet rs = st.executeQuery(GET_EMPS_BY_DESG + cond + " ORDER BY JOB");
			
//			convert RS Object records to List of BO Class objects
			
			listBO = new ArrayList<>();
			EmployeeBO bo = null;
			while(rs.next()) {
				bo = new EmployeeBO();
				bo.setEmpNo(rs.getInt(1));
				bo.setEname(rs.getString(2));
				bo.setJob(rs.getString(3));
				bo.setMgrNo(rs.getInt(4));
				bo.setSal(rs.getDouble(5));
				
				listBO.add(bo);
			} //while
			
		} // try
		catch(SQLException se) {
			se.printStackTrace();
			throw se; // for exception propagation
		}
		catch (Exception e) {
//			for catching unknown exceptions
			e.printStackTrace();
			throw e;
		}
		
		return listBO;
	} // getEmpsByDesg
	
	
}
