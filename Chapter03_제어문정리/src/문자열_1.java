/*
 * 	문자열 => 기능 (메소드) => 반드시 결과값 (리턴형 / 반환형)
 * 	=> scan.nextInt()
 * 
 * 	=> String : 문자열을 저장하는 데이터형
 * 				------------------- 제한이 없다
 * 				일반 데이터형으로도 사용 / 클래스형으로 사용이 가능
 * 		문자열 변수 선언
 * 		= String name="홍길동";
 * 		= String name=new String("홍길동")
 * 	=> 기능 (메소드)
 * 	   => 문자열은 비교연산자를 사용하지 않는다
 * 	   문자열 기능
 * 	   --------
 * 	   1) 비교 기능
 * 		  equals() => ==
 * 		  => 로그인 처리 => ID/PWD
 * 		  contains() => 포함문제 => 검색
 * 		  -------------
 * 		  startsWith()
 * 		  endsWith()
 * 		  ------------- 자동완성기 / 서제스트
 * 		2) 변경
 * 		3) 문자열 분해
 * 		4) 제어
 * 	
 */
// 사용자의 입력값을 받아서 => ID/PWD => 로그인
import java.util.Scanner;
public class 문자열_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final String ID="admin";
		final String PWD="1234";	// 고정 => 상수
		
		Scanner scan=new Scanner(System.in);
		
		while(true)
		{
			System.out.print("ID를 입력하세요:");
			String id=scan.next();
			System.out.print("Password를 입력하세요:");
			String pwd=scan.next();
			// Scanner => 정수:nextInt()
			// 문자열 : next()
			// 실수 : nextDouble()
			// 논리 : nextBoolean()
			// String => 변경이 불가능 => 확장할 수 없다 => 제공한 내용만 사용
			// => 표준화
			/*
			 * 	equalsIgnoreCase => 대소문자 구분없이 비교 : 검색
			 * 	equals : 대소문 구분
			 * 	-------------------------------------------
			 * 	문자열 비교 ( == )
			 * 	
			 * 	반대효과 => !
			 * 
			 */
			if(ID.equals(id) && PWD.equals(pwd))
			{
				System.out.println("로그인되었습니다");
				System.out.println("메인 페이지로 이동합니다");
				break;
			}
			else
			{
				System.out.println("ID나 Password가 틀립니다");
				System.out.println("다시 입력하세요...");
			}
		}
	}

}
