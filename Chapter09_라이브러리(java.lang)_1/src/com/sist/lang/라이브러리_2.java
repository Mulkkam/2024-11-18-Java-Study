package com.sist.lang;
/*
 * 	java.lang
 * 		1. Object
 * 	   		: 최상위 클래스 => 모든 클래스의 상위 클래스
 * 		 	----------
 * 		 	관리하는 기능 : 객체와 관련
 * 		 	객체 소멸 / 객체 복제 / 객체 비교 / 객체 생성
 * 			-------	 --------  -------	 -------
 * 			finalize() clone() equals()  getClass()
 * 		2. String : 문자열 관리 클래스
 * 			=> 웹에서 3대 클래스
 * 			   String / ArrayList / Integer
 * 			=> 오라클 연동 3대 클래스
 * 			   Connection / ResultSet / Statement
 * 
 * 			기능
 * 			1) trim() : 공백 제거(좌우)
 * 			2) length() : 문자 갯수
 * 			3) substring() : 문자를 자르는 경우
 * 			4) indexOf/lastIndexOf => 문자 위치 찾기
 * 			5) equals() : 문자 비교
 * 			   ------------------ 로그인
 * 			6) contains() : 포함 문자열
 * 			7) startsWith() : 시작문자열 => 방문한 맛집
 * 				food_1 food_2
 * 			8) valueOf() => 다른 데이터형 문자열 반환
 * 			9) replace() / replaceAll()
 * 			10) split()
 * 		3. StringBuffer
 * 		4. Math : random() / ceil()
 * 			=> 모든 메소드가  static으로 만들어짐
 * 			=> Math.random() Math.ceil()
 * 		5. System : println() print() / printf()
 * 					gc() , exit()
 * 		6. Wrapper
 * 		   : 기본형(데이터형)을 클래스화 시켜서 사용이 편리하게 만든 클래스
 * 			 byte ===> Byte
 * 			 short ===> Short
 * 			 int ===> Integer
 * 			 long ===> Long
 * 			 float ===> Float
 * 			 double ===> Double
 * 			 char ===> Character
 * 			 boolean ===> Boolean
 * 			---------------------- 기능(메소드)
 *
 *    10장 
 *      날짜 / 문자열 자르기 / 문자열 변환 
 *      ----------------------------
 *      
 */
import java.io.*;
public class 라이브러리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			// log 파일 만들때
			long start=System.currentTimeMillis();
			FileReader fr=new FileReader("c:\\JavaDev\\movie.txt");
			int i=0; // 문자를 받는 경우
//			String data=""; // 문자열 결합
			StringBuffer sb=new StringBuffer();
			// 문자열 결합의 최적화
			// 파일읽기 => 웹사이트 => HTML
			while((i=fr.read())!=-1)
			{
//				data+=(char)i;
				sb.append((char)i);
			}
			fr.close();
			String data=sb.toString(); 
//			System.out.println(sb.toString());
			System.out.println(data);
			// 문자열 제어는 String
			// 문자열 결합 => StringBuffer (비동기적) 데이터 크롤링 => 쓰레드
			//			   StringBuffer (동기적)
			long end=System.currentTimeMillis();
			System.out.println("걸린 시간: "+(end-start));
		}catch (Exception ex) {
			// TODO: handle exception
			
		}

	}

}
