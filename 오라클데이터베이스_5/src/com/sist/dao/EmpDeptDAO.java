package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDeptDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static EmpDeptDAO dao;
	
	public EmpDeptDAO()
	{
		try
		{
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public static EmpDeptDAO newInstance()
	{
		if(dao==null)
			dao=new EmpDeptDAO();
		return dao;
	}
	
	public void getConnection()
	{
	   try
	   {
		   conn=DriverManager.getConnection(URL,"hr","happy");
	   }catch(Exception ex) {
		   
	   }
	}
	
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex) {
			   
		}
	}
	
	public void sqlExecute()
	{
		try
		{
			getConnection();
			  String sql="SELECT empno,ename,job,hiredate,sal,rank,dname,loc,grade "
			  		   + "FROM (SELECT empno,ename,job,hiredate,sal, "
			  		   + "RANK() OVER (ORDER BY DESC) rank"
			  		   + "dname,loc,grade"
			  		   + "WHERE emp.deptno=dept.deptno"
			  		   + "AND sal BETWEEN losal AND hisal)";
			  ps=conn.prepareStatement(sql);
			  ResultSet rs=ps.executeQuery();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}
}
