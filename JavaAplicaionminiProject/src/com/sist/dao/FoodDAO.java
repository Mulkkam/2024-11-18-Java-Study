package com.sist.dao;
import java.util.*;
import java.sql.*;
import com.sist.vo.*;
public class FoodDAO {
	   private Connection conn;
	   private PreparedStatement ps;
	   private static FoodDAO dao;
	   private final String URL="jdbc:oracle:thin:@localhost:1521:XE";
	   //                                          211.238.142.124
	   // 1. 드라이버 등록 
	   public FoodDAO()
	   {
		   try
		   {
			   Class.forName("oracle.jdbc.driver.OracleDriver");
		   }catch(Exception ex) {}
	   }
	   
	   // WEB => JDBC => DBCP
	   // JDBC => 연결 / 닫기 => 연결에 시간 소모가 많다 
	   // => 미리 연결한후에 사용 => 재사용 (반환) => WEB에서 일반화 
	   // 2. Connection을 한개만 생성 
	   public static FoodDAO newInstance()
	   {
		   if(dao==null)
			   dao=new FoodDAO();
		   return dao;
	   }
	   
	   // 3. 연결 
	   public void getConnection()
	   {
		   try
		   {
			   conn=DriverManager.getConnection(URL,"hr","happy");
		   }catch(Exception ex) {}
	   }
	   // 4. 닫기 
	   public void disConnection()
	   {
		   try
		   {
			   if(ps!=null) ps.close();
			   if(conn!=null) conn.close();
		   }catch(Exception ex) {}
	   }
	   // 기능 
	   // 1. 전체 목록 => 인라인뷰 이용 
	   public List<FoodVO> foodListData(int page)
	   {
		   List<FoodVO> list=
				  new ArrayList<FoodVO>();
		   try
		   {
			   // 1. 연결 
			   getConnection();
			   // 2. SQL문장 제작 
			   String sql="SELECT fno,name,poster,num "
					     +"FROM (SELECT fno,name,poster,rownum as num "
					     +"FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk)*/fno,name,poster "
					     +"FROM food_menupan)) "
					     +"WHERE num BETWEEN ? AND ?";
			   // 3. SQL문장 오라클로 전송 
			   ps=conn.prepareStatement(sql);
			   // 4. ?에 데이터값을 채운다 
			   /*
			    *   1page => 1~12
			    *   2page => 13~24
			    */
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   
			   ps.setInt(1, start);
			   ps.setInt(2, end);
			   
			   // 실행=> 결과값 
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   FoodVO vo=new FoodVO();
				   vo.setFno(rs.getInt(1));
				   vo.setName(rs.getString(2));
				   vo.setPoster("https://www.menupan.com"+rs.getString(3));
				   list.add(vo);
			   }
			   rs.close();
			   
		   }catch(Exception ex)
		   {
			   // 오류 확인 
			   ex.printStackTrace();
		   }
		   finally
		   {
			   // 닫기 
			   disConnection();
		   }
		   return list;
	   }
	   // 1-1 총페이지 
	   public int foodTotalPage()
	   {
		   int total=0;
		   try
		   {
			   getConnection();
			   String sql="SELECT CEIL(COUNT(*)/12.0) FROM food_menupan";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   rs.next();
			   total=rs.getInt(1);
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return total;
	   }
	   // 1-2 인기순위 10개 
	   public List<FoodVO> foodTop10()
	   {
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   try
		   {
			   getConnection();
			   String sql="SELECT name,poster,score,rownum "
					  +"FROM (SELECT name,poster,score  "
					  +"FROM food_menupan ORDER BY score DESC) "
					  +"WHERE rownum<=10";
			   ps=conn.prepareStatement(sql);
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   FoodVO vo=new FoodVO();
				   vo.setName(rs.getString(1));
				   vo.setPoster(rs.getString(2));
				   vo.setScore(rs.getDouble(3));
				   list.add(vo);
			   }
			   rs.close();
		   }catch(Exception ex)
		   {
			   ex.printStackTrace();
		   }
		   finally
		   {
			   disConnection();
		   }
		   return list;
	   }
	   // 2. 상세보기 => 조회수 증가 / WHERE
	   public List<FoodVO> foodGenreData(int page,String genre)
	   {
		   List<FoodVO> list=new ArrayList<FoodVO>();
		   
		   try
		   {
			   getConnection();
			   String sql="SELECT fno,name,poster,num "
					   	+"FROM (SELECT fno,name,poster, rownum as num "
					    +"FROM (SELECT /*+ INDEX_ASC(food_menupan fm_fno_pk)*/ fno,name,poster"
					   	+"FROM food_menupan WHERE type LIKE '%'||?||'%')) "
					    +"WHERE num BETWEEN ? AND ?";
			   ps=conn.prepareStatement(sql);
			   ps.setString(1, genre);
			   int rowSize=12;
			   int start=(rowSize*page)-(rowSize-1);
			   int end=rowSize*page;
			   
			   ps.setInt(2, start);
			   ps.setInt(3, end);
			   
			   ResultSet rs=ps.executeQuery();
			   while(rs.next())
			   {
				   FoodVO vo=new FoodVO();
				   vo.setFno(rs.getInt(1));
				   vo.setName(rs.getString(2));
				   vo.setPoster("https://www.menupan.com"+rs.getString(3));
				   list.add(vo);
			   }
			   rs.close();
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
	public int foodGenreTotalPage(String genre)
	{
		int total=0;
		try
		{
			getConnection();
			String sql="SELECT CEIL(COUNT(*)/12.0 "
					+"FROM food_menupan "
					+"WHERE type LIKE '%'||?||'%'";
			ps=conn.prepareStatement(sql);
			ps.setString(1, genre);
			ResultSet rs=ps.executeQuery();
			rs.next();
			total=rs.getInt(1);
			rs.close();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return total;
	}
	public List<FoodVO> foodFindData(String address)
	{
		List<FoodVO> list=new ArrayList<FoodVO>();
		try
		{
			getConnection();
			String sql="SELECT fno,poster,name,address,type,score,rownum "
				   +"FROM food_menupan "
				   +"WHERE address LIKE '%'||?||'%' AND rownum<=10 "
				   +"ORDER BY fno ASC";
			ps=conn.prepareStatement(sql);
			ps.setString(1, address);
			ResultSet rs=ps.executeQuery();
			while(rs.next())
			{
				FoodVO vo=new FoodVO();
				vo.setFno(rs.getInt(1));
				vo.setPoster("https://www.menupan.com"+rs.getString(2));
				vo.setName(rs.getString(3));
				vo.setAddress(rs.getString(4));
				vo.setType(rs.getString(5));
				vo.setScore(rs.getDouble(6));
				list.add(vo);
			}
			rs.close();
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
	public FoodVO foodDetailData(int fno)
	{
		FoodVO vo=new FoodVO();
		try
		{
			getConnection();
			String sql="SELECT name,type,phone,"
					+"address,score,theme,poster,"
					+"images,time,parking,content,"
					+"price "
					+"FROM food_menupan"
					+"WHERE fno="+fno;
			ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setName(rs.getString(1));
			vo.setType(rs.getString(2));
			vo.setPhone(rs.getString(3));
			vo.setAddress(rs.getString(4));
			vo.setScore(rs.getDouble(5));
			vo.setTheme(rs.getString(6));
			vo.setPoster("https://www.menupan.com"+rs.getString(7));
			vo.setImages(rs.getString(8));
			vo.setTime(rs.getString(9));
			vo.setParking(rs.getString(10));
			vo.setContent(rs.getString(11));
			vo.setPrice(rs.getString(12));
			rs.close();
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