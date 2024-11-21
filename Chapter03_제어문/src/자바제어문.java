/*
 * 	자바에서 지원하는 제어문
 * 		=> 프로그램의 흐름 변경 (흐름제어)
 * 			1) 필요시에는 건너뛰는 프로그램을 만들 수 있다
 * 			2) 반복수행 : 반복문
 * 			3) 중간에 정지 : 반복제어문 => ESC
 * 	= 조건문
 * 		=> 단일 조건문
 * 			=> 마우스 클릭 / 버튼 클릭 / 상세보기
 * 		=> 선택 조건문 : true / false 나눠서 처리
 * 		=> 다중 조건문
 * 	= 선택문
 * 		=> switch~case : 값을 1개만 선택해서 처리
 * 		=> 게임 : 키값에 따라 처리
 * 	= 반복문
 * 		=> while
 * 		=> do~while
 * 		=> for
 * 	= 반복제어문
 * 		=> break
 * 		=> 특정부분을 제외 : continue
 * 	====> 배열 /메소드
 * 		  ==> 변수 / 연산자 / 제어문
 * 	====> 객체지향 프로그램
 * 
 * 
 * 	1. 조건문
 * 		=> 형식
 * 		=> 코딩 순서
 * 		=> 활용
 * 		=> 응용
 * 
 * 	2. 단일 조건문
 * 	   ***** 자바의 모든 제어문은 바로 밑에 있는 문장의 1개만 수행
 * 	   여러개를 동시에 제어할때는 {}
 * 	   if(조건문)
 *		  문장 1 ==> if에서 제어
 *		======
 *		  문장 2
 *		  문장 3
 *		======= 별도의 문장
 *	   if(조건문)
 *		{
 *			문장1
 *			문장2
 *			문장3 ==> 3문장이 동시에 제어
 *		}
 * 		
 * 		 형식) 
 * 		   | => 연산자 : 부정연산자 / 비교연산자 / 논리연산자
 * 		 if(조건문)
 * 		 {
 * 			 실행문장 ==> 조건이  true일때만 수행
 * 		 }
 * 		 => 단점 : 여러개 사용시에 모든 if문의 조건을 확인 (속도가 늦다)
 * 
 * 
 */
public class 자바제어문 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=80;
		if(score>60) // true => false => 건너뛴다
			System.out.println("합격");
		System.out.println("프로그램 종료!!"); // if와 관련없는 문장
	}

}
