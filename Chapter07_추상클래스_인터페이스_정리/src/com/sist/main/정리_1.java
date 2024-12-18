package com.sist.main;
/*
 *    7장 => 클래스 종류 (추상클래스/인터페이스)
 *          => 형식 , 사용처 
 *    추상클래스 
 *      => 구현이 안된 메소드를 가지고 있다 
 *      => 객체를 직접 생성이 불가능 
 *      => 사용시에는 상속을 받은 하위 클래스에서 확장해서 사용 
 *      => 역할 / 필요성 
 *         
 *         상속을 통해서 코드를 재사용 => 강제로 메소드 구현을 하는 역할
 *                                  ------------------------
 *                                  확장성 / 유지보수가 용이 
 *         확장성 => 상속을 받아서 오버라이딩 기법을 사용한다 
 *                            --------
 *                            기능 변경 => 메소드 변경 
 *      => 형식)
 *         public abstact class ClassName
 *         {
 *            -------------------------
 *            변수 
 *              멤버변수 (인스턴스 변수)
 *              정적변수 (static 변수)
 *            -------------------------
 *            생성자 : 변수 초기화
 *            -------------------------
 *            구현된 메소드 : 필요시에만 오버라이딩 
 *                         => 있는 그대로 사용이 가능 
 *            -------------------------
 *            미구현 메소드 : 상속시에 강제로 구현 
 *            -------------------------
 *         } 
 *         ==> 관련이 있는 클래스 여러개를 모아서 관리 
 *             --------------------
 *             기능이 비슷한 클래스 
 *             ----------------  웹 (Model)
 *              ** Model => 사용자 요청처리 => 결과값을 브라우저로 전송
 *             => 소스가 간결하다 (조건문없이 사용이 가능)
 *             => Map클래스를 이용해서 클래스를 싱글턴으로 처리 
 *                -------- 메모리 절약 
 *   인터페이스 : 추상클래스의 단점을 보완한 클래스의 일종 
 *   -------- 자바에서 객체가 어떻게 행동해야 (동작) 정의한 타입 
 *            => 주로 메소드만 사용한다 
 *            => 이런 기능을 가지고 있다 (기능 설계)
 *            => 사전적 의미 : 결합성 , 접속기 
 *                          ------  ----- 리모콘 
 *                          서로 다른 클래스 연결해서 사용
 *               => 컴퓨터와 사용자간의 통신 (API)
 *            => 장점 
 *               1) 코드의 표준화 : 같은 메소드를 사용 
 *                               => 내용 구현은 다를 수 있다
 *               2) 설계만 되어 있다 => 프로그래머가 구현해서 사용 
 *                  ------------- 프로그램에 맞춰서 구현 
 *               3) ***다른 클래스와 연결시에 편리 
 *               4) 결합성을 낮게 만든다 
 *               5) 다중 상속이 가능 
 *               6) ************* 소스의 통일화 => 분석이 쉽다 
 *                               ------------
 *                               FrameWork (형식이 동일) 
 *                               | 스프링 / Jquery / VueJS / React
 *               7) 독립적으로 사용이 가능 (원격) : ServerSocket / Socket
 *               8) 유지보스가 쉽다 
 *               9) 여러개 클래스를 모아서 관리 (한개의 객체명으로 제어)
 *         형식) => 모든 구성요소가 only public
 *              => 수정없이 고정해야 된다 
 *                 (보완)
 *                 기능이 추가 / 기능 수정이 가능 
 *              public interface interface명 
 *              {
 *                  -----------------------
 *                  변수 => 상수형 변수만 사용이 가능 
 *                  (public static final) 데이터형 변수명=값;
 *                    사용할 수도 있고 생략도 가능 
 *                  -----------------------
 *                  구현이 안된 메소드 
 *                  (public abstract) 리턴형 메소드명(매개변수);
 *                  -----------------
 *                  -----------------------
 *                  JDK 1.5 추가 => 개발자가 요청
 *                  구현이 된 메소드 추가 
 *                  default 리턴형 메소드(매개변수)
 *                  {
 *                  }
 *                  -----------------------
 *                  static 리턴형 메소드(매개변수)
 *                  {
 *                  }
 *                  -----------------------
 *              }
 *               
 *      ***
 *       컴파일러가 자동 추가하는 소스 
 *       
 *       1) import java.lang.*; => 생략 
 *                 ----------- String , System...
 *       2) 모든 클래스는 Object 상속이다 
 *          ---------
 *          => 사용자 정의 
 *          => 라이브러리 
 *          public class ClassName extends Object
 *                                 ---------------
 *       3) 메소드 => void => return을 생략시에 
 *          public void display()
 *          {
 *             return; => 생략 
 *             ------- 메소드의 종료
 *          }
 *       4) 인터페이스 
 *          변수 => (public static final) 
 *          메소드 => (public abstract) 
 *          default => (public)
 *          static => (public)
 *          
 *    추상클래스 
 *      상속 => 단일 상속만 가능  => 확장 (extends)
 *    인터페이스 
 *      상속 => 다중 상속이 가능  => 메소드 구현 (implements)
 *      
 *              extends
 *    => 인터페이스 ====> 인터페이스 
 *              implements 
 *       인터페이스 ====> 클래스 
 *       (클래스 ====> 인터페이스)=> 사용이 불가능 
 *    => 다중상속 => 윈도우 / 네트워크 
 *       => 웹에서는 주로 단일 상속 
 *       interface A
 *       interface B
 *       
 *       class C implements A,B
 *                          ---- 다중상속 , 
 *                          
 *       *** 관련된 클래스 여러개를 묶어서 인터페이스 1개 제어 
 *           => 소스 간결하게 만든다
 *           
 *       자바 / 오라클 / JSP 
 *       ----------------- 스프링
 *       스프링부트 , JPA  => 5월 중순 => 80%
 */
interface I
{
	public void aaa(); // 강제성
	// 기능 추가
	public void bbb(); // 강제성
	default void ccc()
	{
		
	}
	// public 
	static void ddd()
	{
		
	}
}
class A implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class B implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
class C implements I
{

	@Override
	public void aaa() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void bbb() {
		// TODO Auto-generated method stub
		
	}
	
}
public class 정리_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
