package com.sist.main;
import java.util.*;
import java.io.*;
import java.sql.*;
public class EmpDAO {
	private Connection conn;
	private PreparedStatement ps;
	private String driver,url,username,password;
	
	public EmpDAO()
	{
		try
		{
			Properties prop=new Properties();
			prop.load(new FileInputStream("C:\\JavaDev\\JavaStudy\\Chapter11_IO라이브러리_5\\src\\com\\sist\\main\\db.properties"));
			driver=prop.getProperty("driver");
			url=prop.getProperty("url");
			username=prop.getProperty("username");
			password=prop.getProperty("password");
			// 보안용 => 데이터베이스, 네트워크 서버
			// 드라이버 설치
			Class.forName(driver);
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		// 연결
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(url,username,password);
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	public List<Emp> empListData()
	{
		List<Emp> list=new ArrayList<Emp>();
		try
		{
			getConnection();
			String sql="SELECT empno,ename,job FROM emp";
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				Emp emp=new Emp();
				emp.setEmpno(rs.getInt(1));
				emp.setEname(rs.getString(2));
				emp.setJob(rs.getString(3));
				list.add(emp);
			}
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
}
