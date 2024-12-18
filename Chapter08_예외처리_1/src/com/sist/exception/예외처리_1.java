package com.sist.exception;
/*
 * 	변수 => 데이터형
 * 	연산자 / 제어문
 * 	배열 => 1차원
 * 	클래스 / 객체 생성 / 메소드
 * 	상속 => 오버라이딩
 * 	인터페이스
 * 	예외처리
 * 	라이브러리 => 조립
 * 		=> Collection / IO
 * 	---------------------- 웹
 * 	오라클
 * 
 * 	예외처리
 * 	
 * 	목적 : 사전에 에러를 방지하는 목적
 * 		  우선시 => if
 * 		  -------> 처리가 어려운 경우 : 예외처리 사용
 * 		  => 비정상 종료를 방지하고 정상상태 유지
 * 		  => 예외처리 => 에러발생시 에러를 건너뛴다
 * 			 ------- if
 * 
 * 	에러발생
 * 	 사용자 => 잘못된 입력 => 유효성 검사 => if(javascript)
 * 	 개발자 => 실수 => 배열인덱스, 정수 변환, 형변환
 * 	 -----------------------------------------------
 * 			  컴파일			   인터프리터
 * 	 A.java ========> A.class =========> 화면 출력
 * 			 javac				java
 * 			   |				  |
 * 			  에러				 에러
 * 							  ---------- 에러처리
 *   						   실시간 에러
 * 							   RuntimeException
 * 							   => 경우에 따라 예외처리
 * 			확인) 컴파일시에 반드시 예외처리가 필요
 * 
 * 	=> CheckException : 필수적으로 예외처리
 * 	   = IO (파일 입출력)
 * 		 IOException
 * 	   = 네트워크 (서버 => URL,IP)
 * 		 MalformedURLException
 * 	   = SQL (데이터베이스)
 * 		 SQLException
 * 	   = 쓰레드
 * 		 InterruptedException
 * 	=> UnCheckException : 필요시에만 예외처리 ==> 
 * 	   배열범위 초과 / 정수 변환 / 0으로 나누는 경우
 * 	   객체가 null / 클래스 형변환...
 * 
 * 	1) 사전에 차단 (우선시 => if) => 예외처리
 * 	2) 에러
 * 	   = 에러 => 소스상에서 수정이 불가능한 에러
 * 				메모리가 부족, 이클립스...
 * 				치명적인 에러 => 처리가 불가능
 * 	   = 예외처리 => 소스상에서 수정이 가능한 에러
 * 		 예) 파일읽기 => 경로명 / 파일명 다른 경우
 * 			데이터베이스 => SQL문장 틀린 경우
 * 			크롤링 => URL 주소가 다른 경우
 * 			배열 인덱스가 틀린 경우
 * 	3) 예외처리 방법
 * 	   = 예외복구 : try ~ catch
 * 				  ---   ----- 예외가 발생시 처리 복구
 * 				  정상수행
 * 				  => 직접처리 => 개발자가 직접처리
 * 	   = 예외회피 (떠맏기기) : throws
 * 				=> 시스템에 맡기는 경우 (간접처리)
 * 				=> 라이브러리에 많이 존재
 * 				=> 사용시에 예외처리후 사용
 * 	   = 임의 발생 => 견고한 프로그램 여부 확인
 * 	   = 지원하지 않는 예외 : 사용자 정의 예외처리
 * 		 -------------
 * 			public class MyException extends Exception
 * 			{
 * 	   
 * 			}
 * 		예외처리를 하는 경우
 * 		--------------- 예외가 많이 예상되는 경우
 * 		catch를 여러개 사용이 가능
 * 		--------------------- 순서가 문제
 * 
 * 		문자열 => 정수로 변경후에 배열에 저장 나눈값을 출력
 * 				--------	-------- ----------
 * 		=> 사전에 에러방지 => 에러 예상하면서 소스 코딩
 * 		   ----------------------------------
 * 
 * 
 * 		=> 				Object
 * 						  |
 * 					  Throwable
 * 						  |
 * 			  -------------------------------
 * 			  |								|
 * 			Error						Exception
 * 			----- 처리가 불가능
 * 				  메모리 부족
 * 				  => ElasticSearch
 * 				  => 루씬 => 구글 (검색 엔진)
 * 				  => 데이터베이스 (NoSQL)
 * 
 * 
 * 					Exception
 * 						|
 * 			Check						UnCheck
 * 			=> 반드시 예외처리				=> 필요시에만 예외처리
 * 			=> 컴파일러가 감시
 * 			-----------------------------------
 * 			|
 * 		IOException : 입출력
 * 			=> 파일 
 * 			=> 메모리
 * 			=> 네트워크
 * 		SQLException : 오라클
 * 			오라클 (데이터베이스)
 * 			=> SQL문장
 * 			=> INSERT/UPDATE/DELETE
 * 			   SELECT
 * 			   ------ JOIN / SUBQUERY
 * 			   ------ FUNCTION
 * 			   		  PROCEDURE
 * 					  TRIGGER
 * 				입고 => 재고
 * 				출고 => 재고
 * 			SQL
 * 			|
 * 			DQL	=> SELECT(검색)
 * 			DML	=> I/U/D
 * 			DCL	=> GRANT / REVOKE
 * 			TCL	=> COMMIt / ROLLBACK
 * 			DDL	=> CREATE / ALTER / DROP
 * 		ClassnotFoundException
 * 			Class.forName("패키지.클래스명")
 * 			=> 리플렉션 => 클래스 정보
 * 		InterruptedException : 충돌방지
 * 			=> 쓰레드
 * 		MalformedURLException
 * 			=> URL
 * 
 * 		=> java.io / java.sql / java.net
 * 		   CheckException ==> 반드시 예외처리를 하고 사용
 * 
 * 		IllegalArgumentException : 매개변수에 잘못된 데이터를 전송
 * 		------------------------
 * 			웹 => 400(Bad Request)
 * 				 200 => 정상 수행
 * 				 403 => 접근 거부
 * 				 404 => 파일 Not Found
 * 				 500 => 자바 소스 오류
 * 				 415 => 한글 변환 코드
 * 		
 * 		UnCheckException : 컴파일러가 제한하지 않는다
 * 				=> 예외처리가 없을 수 있다
 * 				=> 에러가 많이 발생부분에서는 예외처리를 하면 좋다
 * 				=> 웹 / 윈도우 => 정수입력...
 * 				=> "10" => 정수형 변경이 안된다 => trim()
 * 				=> 웹 => board_list.jsp?page = 10 => 오류
 * 											 ----
 * 		=> RuntimeException
 * 				|
 * 		   ArrayIndexOutOfBoundsException : 배열범위 초과
 * 			int[] arr=new int[2]; // 0,1
 * 			arr[2]=100; => 오류 발생
 * 		   NullPointerException : 0으로 나누는 경우
 * 			A a;
 *          a.display() => 객체 주소가 지정되지 않은 경우 
 *          ArithmeticException : 0으로 나누는 경우 
 *          10/0
 *         ClassCastException 
 *          class A
 *          class B extends A
 *              
 *          B b=(B)new A(); => 오류 
 *              
 *          A a=new B();
 *          B b=(B)a;
 *              
 *          NumberFormatException : 문자열을 정수형 변경시 에러
 *             
 *         => catch여러개인 경우 
 *            계층 순서로 적용 
 *            
 *         
 *         catch(NumberFormatException)
 *         catch(IOException e)
 *         catch(Exception e)=> 기타
 *         
 *         => 위로 올라갈수록 예외처리범위가 커진다 
 *            -----------------------------
 *            catch는 반드시 작은 순위 => 큰순위로 설정한다 
 *         => 예외처리의 가장 큰 클래스는 Exception
 *         
 *   ========> 예외처리의 기본 
 *             try ~ catch : 가장 많이 사용되는 예외처리 
 *             => 정상 수행 => 에러발생 하면
 *                           catch처리 => 스킵
 *                           ======== 에러처리후 복구
 *                           ======== 에러 위치 확인 
 *                                    어떤 에러가 났는지 
 *                                    
 *       try
 *       {
 *           정상으로 수행하는 문장 
 *       }catch(예상되는 예외클래스)
 *       {
 *           예외가 발생시 처리 
 *       }
 *       
 *       => 예)
 *       --------
 *       문장 1
 *       문장 2 ==> 에러 발생 => 종료 (비정상 종료)
 *       문장 3
 *       --------
 *       
 *       문장 1
 *       문장 2 
 *       try
 *       {
 *          문장 3
 *          문장 4 ==> 에러 => catch로 이동
 *          문장 5 스킵
 *          ---------- 수행을 하지 않는다 
 *       }catch(예상되는 클래스){
 *          문장 6 => 문장 5으로 이동 => 복구
 *       }
 *       문장 7
 *       문장 8
 *       
 *       => 1,2,3,4,5,7,8
 *       => 1,2,3,6,7,8
 *   
 */
public class 예외처리_1 {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
        //Thread.sleep(100);
		int a=10;
		int b=a/0;
		System.out.println(b);
	}

}