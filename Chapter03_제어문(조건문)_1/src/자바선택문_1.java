/*
 * 	선택문 : 다중조건문을 단순화 시킨 제어문
 * 		   => 한대만 수행이 가능
 * 		   => 게임 / 네트워크
 * 		   => ------------ 값을 한개만 선택(선택문), 범위(다중조건문)
 * 						   -------
 * 	1. 형식)
 * 			switch(정수|문자|문자열)
 * 						   ----
 * 			1) 정수 => 메뉴
 * 			switch(no) => 0,1,2..
 * 			{
 * 				case0:
 * 					처리문장 1
 * 					break; => 종료
 * 				case1:
 * 					처리문장 2
 *					break; => 종료
 * 				case2:
 * 					처리문장 3
 * 					break; => 종료
 * 				default: ==> else ==> 해당번호가 없는 경우에 처리
 * 					처리문장 4
 * 					break; => 종료
 * 			}
 */
// 다중조건문 동일 => 한개의 case에 있는 문장만 수행
public class 자바선택문_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score=(int)(Math.random()*101);
		int avg=score/10;
		switch(avg)
		{
			case 10: case 9:
				// avg == 10 || avg == 9
				// 다중조건문보다 가독성이 좋다
				// ======= 범위를 지정하기 때문에 => 페이징
				// 선택문은 범위 지정이 불가능
				// => 데이터베이스는 10000단위 저장
				System.out.println(score+"점은 A등급입니다");
				break;
			case 8:
				System.out.println(score+"점은 B등급입니다");
				break;
			case 7:
				System.out.println(score+"점은 C등급입니다");
				break;
			case 6:
				System.out.println(score+"점은 D등급입니다");
				break;
			default:
				System.out.println(score+"점은 F등급입니다");
		}

	}

}
