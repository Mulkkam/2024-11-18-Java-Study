package com.sist.dao;
import java.util.*;
import java.sql.*;
public class ShoesDAO {
	private Connection conn;
	private PreparedStatement ps;
	private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	private static ShoesDAO dao;
	// melon / genie
	public ShoesDAO()
	{
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		}catch (Exception ex) {
			// TODO: handle exception
		}
	}
	
	public static ShoesDAO newInstance()
	{
		if(dao==null)
			dao=new ShoesDAO();
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
	public void foodInsert(ShoesVO vo)
	{
		try
		{
			getConnection();
			String sql="INSERT INTO food_menupan "
					  +"VALUES(fm_no_seq.nextval,"
					  +"?,?,?,?,?,?,?,0)";
			//name,image,brand,size,sale_price,price;
			ps=conn.prepareStatement(sql);
			ps.setString(1, vo.getName());
			ps.setString(2, vo.getImage());
			ps.setString(3, vo.getBrand());
			ps.setString(4, vo.getSize());
			ps.setString(5, vo.getSale_price());
			ps.setString(6, vo.getPrice());
			ps.executeUpdate();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
			disConnection();
		}
	}
}
