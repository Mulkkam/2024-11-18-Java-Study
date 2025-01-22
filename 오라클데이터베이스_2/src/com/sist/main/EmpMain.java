package com.sist.main;
import java.util.*;
import java.sql.*;
public class EmpMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("이름 입력:");
		String ename=scan.next();
		
		// 오라클 연결후 데이터 읽기 => 출력
		try
		{
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url="jdbc.oracle:thin@localhost:1521:XE";
			Connection conn=DriverManager.getConnection(url,"hr","happy");
			// SQL문장 전송
			String sql="SELECT ename,job,sal,hiredate "
					+"FROM emp"
					+"WHERE ename='"+ename+"'";
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}
