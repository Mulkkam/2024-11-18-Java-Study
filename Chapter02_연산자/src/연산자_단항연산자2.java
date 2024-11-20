/*
 * 	부정연산자 : !
 * 	  => 조건문 
 *		 => 로그인이 안된 경우
 *		 => 예약날짜가 아닌 경우...
 *		 => 게임 : 턴 
 *	  => 무조건 boolean만 사용이 가능
 *		 true => !true
 *
 * 	  예) 
 * 		 boolean bCheck=false;
 * 		 !bCheck => true
 */
public class 연산자_단항연산자2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		boolean bCheck=false;
		// boolean : 논리형 => true/false만 저장이 가능
		System.out.println(bCheck); // false
		bCheck=!bCheck; // true 변경
		System.out.println(bCheck); // true
		
	}

}
