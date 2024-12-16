package com.sist.main;
/*
 * 	상속
 * 	=> 기존의 클래스를 재사용 (메소드 변경, 메소드 추가)
 * 	=> extends
 * 	=> 단일 상속
 * 	=> 객체지향
 * 	   재사용 / 데이터 손실 방지 / 변경이 쉽게, 추가 기능
 * 				| 캡슐화			|다형성(오버라이딩,오버로딩)
 *     -----------------------------------------------
 *     	| 상속
 *     	=> 제약조건이 많다
 *     	=> 소스를 볼 수 없다 => 분석(가독성)
 *     	=> 상위 클래스 => 하위 클래스 메모리 할당 => 실행 속도가 늦다
 *     	=> 상속 => 보완 : 인터페이스(구현)
 *     
 *     1)장점
 *     => 중복을 제거
 *     => 코드가 간결하다
 *     => 메소드 기능을 필요시마다 변경 가능
 *     
 *     => 상위 클래스
 *     	  : 공통적인 기능
 *     	  영화관 : 포스터 출력 / 예약 / 극장 / 회원가입 / 로그인...
 *     			  영화관
 *     				|
 *     			--------------------------------
 *     				|		|		|		|
 *     			자유게시판 댓글게시판 갤러리게시판 묻고답하기
 *     						|		|		| 
 *     						|		|		관리자/사용자
 *     					댓글 추가	 변경(이미지 업로드)
 *     => 하위 클래스
 *     => 상속을 받으면 데이터형이 두개가 생긴다
 *     => 동률
 *     개 a=new 개()
 *     동률 b=new 개()
 *     -------------- 상속을 내리는 클래스 => 상속을 받는 클래스
 *     int, long, double ==> 데이터형
 *     클래스 => 사용자 정의 데이터형이다
 *     		   ------------------
 *     메소드 : 사용자 정의 메소드
 *     		  --------------
 *     
 *     ==> 변경 (오버라이딩)
 *     오버라이딩 (메소드 재정의) => 덮어쓴다
 *     						   ------ 구조가 동일
 *     1) 상속이 존재 => 클래스에서 상속없이 재정의(오버라이딩)
 *     					=> 익명의 클래스
 *     2) 메소드가 동일
 *     3) 리턴형이 동일
 *     4) 접근지정어 확장이 가능 / 축소하면 오류 발생
 *     private < default < protected / public
 *     => 메소드는 다른 클래스와 연결
 *     	  -------------------- 가급적이면 public으로 사용
 *     	  클래스 / 생성자 / 메소드 => public
 *     	  멤버변수 => private (데이터 보호)
 *     	  => 필요시에 사용이 가능 => getter / setter
 *        윈도우 => 보안(X) => Button, TextField => default
 *        
 *        상위 클래스 : 상속을 내리는 클래스
 *        			 => 하위 클래스를 제어할 권한이 없다
 *        하위 클래스 : 자신 + 상위클래스를 제어 할 수 있다
 *        			 ---   ---------------------
 *        			 this  		super
 *        			   |	 	  |
 *        			자신의 객체 상위 클래스의 객체
 *        					 => super()
 *        			=> 생성자 : this()
 *        
 *        A a=new B(); => double d=10
 *       --		  ---
 *       상위 클래스 하위 클래스
 *       -------- --------
 *       A의 변수	   B의 메소드
 *       
 *       변수 : 클래스형
 *       메소드 : 생성자
 *       
 *       ---------------------
 *       상위 클래스를 이용한다
 *       	| 관련된 클래슬 여러개 묶어서 사용
 *       	| 한개의 객체명으로 처리가 가능
 *       	| 변수 많거나 / 객체가 많으면
 *       	  ------------------------- 제어가 어렵다
 *       	  | 한개의 이름으로 제어하는 방법
 *       		-------- 상위 클래스 / 인터페이스
 *       								| 클래스의 일종
 *       => 상속시 예외 조건 / 접근 지정어
 *       	------------	| private : 접근이 불가능
 *       	| static		  => getter / setter 이용
 *       	| 생성자 
 *       	| 초기화블럭
 *       
 *       => 상속이 있는 경우
 *       	생성자 => 매개변수가 있다면
 *       
 */			
class A
{
	public A() {
		
	}
	public A(String s) {
		System.out.println(s);
	}
}
class B extends A
{
	public B(String s)
	{
		super(s); // 상위 클래스 메모리 할당
	}
}
public class 상속_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
