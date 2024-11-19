/*
 * 		데이터저장 ===> 데이터활용 ===> 결과값추출
 * 		====================	  =======
 * 		 모든 프로그램이 동일				Application : 윈도우, 명령프롬프트
 * 									Web Application : 브라우저 (HTML)
 * 									Mobile Application : 안드로이드
 * 		데이터 저장 : 한개 / 여러개 한번에 저장 
 * 					|    =============
 * 				   변수	 	배열/클래스 ===> 메모리에 저장 (휘발성)
 * 				   ===
 * 			int a1~a200;
 * 		변수 : 데이터를 저장하는 메모리 공간의 이름
 * 						   ======== 숫자 (주소) => c언어 &
 * 						   자바의 장점 : C/C++ 파생
 * 									  ===== 어려운 부분을 제거
 * 									   주소 / 포인터 / 구조체
 * 						   ==> 주소/포인터 => HW
 * 						   ==> SW => 고급언어
 * 		0==========
 * 		  사용중
 * 		4==========  ==> a
 * 		  10
 * 		8==========
 * 		  사용중
 * 		12========== 
 * 		  사용중
 * 		16==========  ==> b b=100
 * 		  100
 * 		============
 * 		
 * 		1. 메모리 공간 크기 => 자료형, 데이터형, 데이터타입 ...
 * 						   =============
 * 						   1) 자바에서 지원 => 기본형
 * 						   2) 사용자정의 => 데이터형을 직접 제작
 * 							  => class
 * 							  class A
 * 							  {
 * 								  int a,b,c,d;
 * 							  }
 * 
 * 		2. 자바에서 지원하는 데이터형
 * 		   정수
 * 			byte => 1byte (-128 ~ 127) : 전송 / 읽기
 * 										 파일 / 네트워크 관련
 * 			int => 컴퓨터는 모든 숫자를 int로 인식
 * 				   -21억 4천 ~ 21억 4천
 * 				   => defualt
 * 				   => 가장 많이 사용되는 데이터형
 * 			long => 빅데이터 => int => long
 * 					금융/국세청
 * 			============기억 : int / long 구분은 숫자뒤에(L,l)
 * 		   실수
 * 			double : 실수의 디폴트 => 컴퓨터는 실수는 무조건 double을 인식
 * 					 8byte => 소수점 15자리
 * 		   문자
 * 			char : 문자 1개 저장 => ''
 * 				   2byte => 0 ~ 65535 => 멀티바이드 (유니코드)
 * 							각국의 언어를 사용할 수 있다.
 * 		   논리
 * 			boolean : 1byte => true/false만 저장이 가능
 * 					  => 조건문 / 반복문
 * 	
 * 		3. 변수 선언
 * 		   1) 선언과 동시에 값을 저장
 * 			  데이터형 변수명 = 값;
 * 		   2) 선언후에 값을 저장
 * 			  데이터형 변수명;
 * 			  변수명 = 값;
 * 		   3) 값을 데이터형을 가지고 있는 경우
 * 			  int a;
 * 			  int b;
 * 			  int c;
 * 
 * 			  int a,b,c;
 * 
 * 		4. 변수는 반드시 초기화 => 처음에 저장하는 값을 지정
 * 		   ===============
 * 		   int a = 10 => 명시적 초기화
 * 		   int a = Math.random() => 컴퓨터 임의의 추출
 * 		   int a = scan.nextInt() => 사용자로부터 입력값을 받아서 초기화
 * 		   ==> 웹 / 윈도우 프로그램은 입력값 처리 
 * 		
 * 		5. 변수명 제작 (식별자) => 클래스 / 메소드....
 * 		   => 같은 변수명을 사용할 수 없다
 * 
 * 		   1) 알파벳, 한글로 시작
 * 			  (알파벳은 대소문자 구분)
 * 		   2) 숫자는 앞에 사용 금지 => 뒤에 사용이 가능
 * 			  a1, a1b ....
 * 		   3) 특수문자 사용 : _ , $
 * 		   4) 키워드, 예약어 => 자바에서 이미 사용중에 있는 단어
 * 			  => 빨간색 단어
 * 		   5) 공백은 사용할 수 없다
 * 			  int a b (X)
 * 		   6) 문법은 아니다
 * 			  => 변수 : 소문자로 시작한다 mainClass
 * 			  => 상수 : 모든 문자를 대문자로 한다 MAINCLASS
 * 			  => 클래스 : 첫자 대문자로 한다 MainClass
 * 			  => 메소드 : 소문자로 시작한다 mainCalss()
 * 
 * 		   class Main
 * 		   {
 * 				Main main=new main();
 * 		   }
 * 
 * 		   => 26page => 변수선언 형식 / 식별지
 * 		   => 28page => 변수의 초기화
 * 		   => 30page => 자바에서 지원하는 데이터형
 * 		   => 35page => 예약어
 * 
 * 		   => 변수
 * 		   => 멤버변수
 * 		   => 공유변수
 * 		   => 지역변수 ==============> 관리 => 메모리가 한다
 * 									 {}을 벗어나면 사라진다
 * 									 => 반드시 초기화
 * 				= 루프변수
 * 				= 누적 변수
 * 				= 플로그 변수
 * 
 * 		  => 문법 => 책
 * 			=========
 * 			사용처 => 객체 지향
 * 
 */
public class 변수정리 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
