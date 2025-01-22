package com.sist.dao;
import java.util.*;
import com.sist.vo.*;
import java.sql.*;
// 로그인 처리 => COUNT 
// 회원가입 
// JDBC => DBCP => ORM (MyBatis,Hibernate,JPA)
public class MemberDAO {
   private Connection conn;
   private PreparedStatement ps;
   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
   private static MemberDAO dao;
   // 12장
   public MemberDAO()
   {
	   try
	   {
		   // ojdbc8.jar
		   Class.forName("oracle.jdbc.driver.OracleDriver");
	   }catch(Exception ex) {}
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
	   }catch(Exception ex) {}
   }
   public void disConnection()
   {
	   try
	   {
		   if(ps!=null) ps.close();
		   if(conn!=null) conn.close();
	   }catch(Exception ex) {}
   }
   /////////////////////////// 오라클 연결에 필수 사항 
   //// 기능 처리 
   // COUNT(*) => 로그인 
   // 화면 => DAO/VO는 상관없다 
   public MemberVO isLogin(String id,String pwd)
   {
	      MemberVO vo=new MemberVO();
	      try
	      {
	    	  // 1. 연결 
	    	  getConnection(); // conn hr/happy
	    	  // 2. SQL문장 전송 
	    	  String sql="SELECT COUNT(*) "
	    			    +"FROM member "
	    			    +"WHERE id=?";
	    	  // 0(아이디가 없는 경우) / 1(아이디가 있는 경우)
	    	  ps=conn.prepareStatement(sql);
	    	  // ?에 값을 채운다 
	    	  ps.setString(1, id); // 'hong'
	    	  // 실행후 결과값 받기 
	    	  ResultSet rs=ps.executeQuery();
	    	  rs.next();
	    	  int count=rs.getInt(1);
	    	  rs.close();
	    	  
	    	  if(count==0)//ID가 없는 상태 
	    	  {
	    		  vo.setMsg("NOID");
	    	  }
	    	  else //ID가 있는 상태 
	    	  {
	    		  sql="SELECT pwd,name,sex,address "
	    		     +"FROM member "
	    			 +"WHERE id=?";
	    		  ps=conn.prepareStatement(sql);
	    		  ps.setString(1, id);
	    		  rs=ps.executeQuery();
	    		  rs.next();
	    		  /*
	    		   *    1234
						심청이
						여자
						경기
	    		   */
	    		  String db_pwd=rs.getString(1);
	    		  String name=rs.getString(2);
	    		  String sex=rs.getString(3);
	    		  String address=rs.getString(4);
	    		  rs.close();
	    		  
	    		  if(db_pwd.equals(pwd))//로그인 
	    		  {
	    			  vo.setMsg("OK");
	    			  vo.setName(name);
	    			  vo.setSex(sex);
	    			  vo.setAddress(address);
	    			  // HttpSession에 저장 => 서버에서 관리 
	    		  }
	    		  else//비밀번호가 틀린 상태 
	    		  {
	    			  vo.setMsg("NOPWD");
	    		  }
	    	  }
	    	  
	      }catch(Exception ex)
	      {
	    	  // 오류 처리
	    	  ex.printStackTrace();
	    	  
	      }
	      finally
	      {
	    	  // 오라클 닫기 
	    	  disConnection();
	      }
	      return vo;
   }
   
   
}