package com.sist.dao;
import java.sql.*;
import java.util.Date;

import com.sist.vo.*;
public class MemberDAO {
	private Connection conn;
	private PreparedStatement ps;
	private static MemberDAO dao;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	
	public MemberDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public static MemberDAO newInstance()
	{
		if(dao==null)
			dao=new MemberDAO();
		return dao;
	}
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(URL,"hr","happy");
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
	public MemberVO isLogin(String id,String pwd)
	{
		MemberVO vo=new MemberVO();
		try
		{
			getConnection();
			String sql="SELECT COUNT(*) FROM member "
						+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, sql);
			
			ResultSet rs=ps.executeQuery();
			rs.next();
			int count=rs.getInt(1);
			rs.close();
			
			if(count==0)
			{
				vo.setMsg("NOID");
			}
			else
			{
				sql="SELECT id,pwd,name,sex "
					+"FROM member "
					+"WHERE id=?";
				ps=conn.prepareStatement(sql);
				ps.setString(1, id);
				rs=ps.executeQuery();
				rs.next();
				
				vo.setId(rs.getString(1));
				vo.setName(rs.getString(3));
				vo.setSex(rs.getString(4));
				String db_pwd=rs.getString(2);
				
				if(db_pwd.equals(pwd))
				{
					vo.setMsg("OK");
				}
				else
				{
					vo.setMsg("NOPWD");
				}
			}
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
		return vo;
	}
	/*
	 * 	private String id,pwd,name,sex,email,address,msg;
	private Date regdate,birthday;

	 */
	public MemberVO memberInfo(String id)
	{
		MemberVO vo=new MemberVO();
		try
		{
			getConnection();
			String sql="SELECT name,sex,email,address,"
					+"regdate,birthday "
					+"FROM member "
					+"WHERE id=?";
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setName(rs.getString(1));
			vo.setSex(rs.getString(2));
			vo.setEmail(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setRegdate(rs.getDate(5));
			vo.setBirthday(rs.getDate(6));			
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
}
