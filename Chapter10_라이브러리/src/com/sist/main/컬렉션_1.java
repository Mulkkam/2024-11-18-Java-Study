package com.sist.main;
/*
 * 	자바 컬렉션
 * 	--------
 * 	1. 프로그램 => 데이터 관리 (효율적)
 * 				 ---------------
 * 				 1) 스프링/JSP(MVC) => 데이터관리
 * 					=> 데이터베이스 (오라클,MySql)
 * 				 2) VueJS/React/Next/Node
 * 					=> 상태관리 (데이터가 변경시마다)
 * 	2. 데이터베이스 : 데이터를 저장하는 공간
 * 	   ---------
 * 		변수/상수	=> 데이터 한개 저장후 관리 => 데이터 많으면 관리 힘듬
 * 	   ---------
 * 		  배열	=> 고정적 / 데이터가 증가되면 다른 배열을 생성
 * 	   ---------
 * 		=> 가변적 : 데이터가 증가되면 자동으로 메모리 공간 확장
 * 		   컬렉션 
 * 	   --------------------> 메모리 공간 (데이터가 사라진다)
 * 	   ---------
 * 		  파일	=> 종속적이다 다른 파일을 연결해서 사용이 어렵다
 * 	   ---------
 * 		 RDBMS	=> 오라클 (관계형 데이터베이스 => 연결성)
 * 	   ---------
 * 		=> 웹 가장 많이 사용되는 클래스 : ArrayList/String/Integer
 * 		=> ArrayList는 데이터를 메모리에 저장후에 브라우저로 전송
 * 		=> 웹은 대부분이 Map형식으로 만들어져 있다
 * 		   request / response / session / cookie
 * 		   -------	 --------	-------	  ------
 * 			 요청			응답		서버에 저장  브라우저 저장
 * 
 * 		1. Collection 개요
 * 		   => 배열의 단점을 보완한 클래스 (고정 => 가변)
 * 			  --------------------
 * 		   데이터를 효율적으로 저장하고 관리하기 위한 라이브러리
 * 		   => 표준화가 되어 있다 (모든 개발자가 같은 메소드를 사용)
 * 			  ---- 개발이 쉽다
 * 			  ---- 프레임위크 => 개발 형식을 동일할 때 사용
 * 				   ------- 스프링 / React / JQuery / Vue..
 * 				   ------- MyBatis / JPA
 * 				   ------- 장바구니 / 예약
 * 						   ----------- 오라클 / Session / Cookie
 * 		   컬렉션은 저장 => Object만 저장 (객체만 저장)
 * 						------------
 * 						최상위 데이터형 => 항상 형변환
 * 									   --------
 * 						
 * 		2. Collection 종류
 * 					Interable
 * 						|
 * 					Collection
 * 		   --------------------------
 * 			|			|			|
 * 		   List		   Set		   Map => Interface
 * 			|			|			|	
 * 		ArrayList	HashSet		 HashMap
 * 		Vector		TreeSet		 HashTable
 * 		LinkedList					|
 * 			|						|
 * 		  Queue					Properties
 * 								----------
 * 								| XML
 * 
 * 		ArrayList
 * 		1) 순서가 존재				=====> 인덱스번호는 자동으로 조절
 * 		2) 데이터 중복 허용				   0부터 순차적으로 유지
 * 		3) 가장 많이 사용되는 컬렉션
 * 		4) 비동기적인 방식
 * 			=> 데이터베이스 (오라클)
 * 			=> 접근 속도가 빠름
 * 		5) 단점 : 데이터가 많은 경우에 추가/삭제 => 속도가 늦다
 * 				 ==> 인덱스번호 조절
 * 				 ==> 추가시에 마지막에 추가하는 것을 권장
 * 		
 * 		Vector => 보완 (ArrayList)
 * 		=> 동기적 => 네트워크 사용자 정보를 저장
 * 		LinkedList
 * 		=> 데이터에 접근하는 속도가 늦다
 * 		=> 추가 / 삭제가 빠르다
 * 		=> 게시판
 * 		=============== List라는 인터페이스 구현 (메소드가 동일)
 * 		
 * 		List list=new ArrayList()
 * 		list=new LinkedList()
 * 		list=new Vector()
 * 				 
 * 		3. 제네릭스
 * 		4. 활용 => 크롤링 / 중복 제거 / ArrayList와 ArrayList
 * 								   --------------------
 * 									1. 교집합 2. 차집합 3. 합집합
 * 									=> 멜론 / 지니뮤직		=> 중복제거
 * 									=> Intersect, Minus 	Union
 * 									=> 자바 메소드로 되어있다
 * 	
 * 							ArrayList		LinkedList
 * 						----------------------------------
 * 		데이터접근 속도			   빠름 			   느림
 * 		데이터(추가/삭제)		   느림			   빠름
 * 		메모리 사용			   효율적			  비효율적
 * 		구조					  배열기반			연결리스트 기반
 * 
 *              			---------
 *              			 객체주소
 *              			---------       -----------
 *                                   		이전 객체 주소
 *                                     		-----------
 *                                       		데이터
 *                                     		-----------
 *                                    		다음 객체 주소 
 *                                     		-----------
 * 
 * 		ArrayList의 주요 메소드
 * 		1) 데이터 추가
 * 		   add(Object obj) => 마지막 추가
 * 		   add(int index,Object obj) => 원하는 인덱스에 추가
 * 		2) 저장된 갯수 : int size()
 * 		3) 데이터 추출 => Object get(int index)
 * 		4) 데이터를 삭제 => remove(int index)
 * 		5) 데이터를 수정 => set(int index,Object obj)
 * 		===> CURD : 자료구조 (효율적으로 사용)
 * 		===> import를 사용한다
 * 			 java.util.ArrayList
 * 		===> List => 구현한 클래스 변경이 쉽게 인터페이스를 이용하는 경우가 많다
 * 			------ MyBatis/JPA
 * 		===> 단점은 형변환
 * 			 Object => 최상위 클래스
 * 					=> 데이터형중에 가장 큰 데이터형
 * 
  *            예)
 *                Object obj=1;
 *                obj=0.1;
 *                obj="aaa";
 *                obj='A';
 *                obj=new A();
 *                ------------ => 원하는 데이터형으로 변경 
 *                                ===================
 *                                데이터형을 Object가 아닌 데이터형으로 통일 
 *                                ----------------------------------
 *                                제네릭스
 */
import java.util.*;
public class 컬렉션_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		// 경고 => 제네릭스 => 모든 return / 매개변수가 Object
		// 추가
		list.add("홍길동"); // 0
		list.add("심청이"); // 1
		list.add("강감찬"); // 2
		list.add("박문수"); // 3
		list.add("춘향이"); // 4
		
		System.out.println("현재 등록된 인원:"+list.size());
		// 출력 => size() => get()
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		System.out.println("==== 원하는 위치에 데이터 추가 ====");
		
		list.add(2,"이순신");
		System.out.println("현재 등록된 인원:"+list.size());
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		System.out.println("===== 삭제 =====");
		list.remove(3);
		// 추가 / 삭제시에 자동으로 인덱스 번호 변경
		
		System.out.println("현재 등록된 인원:"+list.size());
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		// 인덱스번호는 자동 처리
		// => 오라클은 자동 처리가 안된다 (출력)
		System.out.println("===== 수정 =====");
		list.set(2,"심청이 수정");
		
		System.out.println("현재 등록된 인원:"+list.size());
		for(int i=0;i<list.size();i++)
		{
			String name=(String)list.get(i);
			System.out.println(i+"."+name);
		}
		System.out.println("===== 전체 삭제 =====");
		list.clear();
		System.out.println("현재 등록된 인원:"+list.size());
		System.out.println("===== 데이터 존재 여부 =====");
		// isEmpty() => 장바구니
		if(list.isEmpty())
		{
			System.out.println("저장공간이 비워져있다");
		}
		else
		{
			System.out.println("저장공간에 데이터가 존재합니다");
		}
        /*
         *    메소드 
         *     1) 데이터 추가 => add()
         *     2) 데이터 갯수 => size() 
         *     3) 데이터 읽기 => get(int index)
         *     4) 데이터 존재 여부 => isEmpty()
         *     5) 데이터 수정 => set(int index,데이터)
         *     6) 데이터 삭제 => remove(int index)
         *     7) 데이터 전체 삭제 => clear()
         */
	}

}
