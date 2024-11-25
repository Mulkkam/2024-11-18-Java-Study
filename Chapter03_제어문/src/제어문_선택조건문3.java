/*
 *    if(조건문)
 *    {
 *       조건 => true => 문장 
 *    }
 *    else
 *    {
 *       조건 => false => 문장
 *    }
 *    
 *    if(조건문)
 *    {
 *    }
 *    -----------------
 *    if(조건문)
 *    {
 *    }
 *    else ==> 바로 위에 있는 if와 관련 => 단독으로 사용이 불가능 
 *    {
 *    }
 *    
 *    ==> 다중 조건문 ==> 58page => 해당 조건에 맞는 내용 한개 실행
 *    if(조건문) => +
 *    {
 *       실행문장
 *       조건 true => 문장 실행 => 종료
 *       조건 false
 *    }        ↓
 *    else if(조건문) => -
 *    {
 *        실행문장
 *        조건 true => 문장 실행 => 종료
 *        조건 false
 *    }        ↓
 *    else if(조건문) => *
 *    {
 *        실행문장
 *        조건 true => 문장 실행 => 종료
 *        조건 false
 *    }        ↓
 *    else if(조건문) => /
 *    {
 *        실행문장
 *        조건 true => 문장 실행 => 종료
 *        조건 false
 *    }        ↓
 *    else ==> 생략이 가능
 *    {
 *        실행문장 
 *    }
 *    
 *    게임 => key선택 => UP/DOWN/LEFT/RIGHT / ENTER,Space
 *    메뉴 => 다중 조건문 
 */
public class 제어문_선택조건문3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=15;// 조건에 여러개 수행 
		if(a%3==0)
			System.out.println(a+"는(은) 3의 배수입니다");
		if(a%5==0)
			System.out.println(a+"는(은) 5의 배수입니다");
		if(a%7==0)
			System.out.println(a+"는(은) 7의 배수입니다");
		/*
		 * else System.out.println(a+"는(은) 3,5,7의 배수가 아닙니다");
		 */
	}

}