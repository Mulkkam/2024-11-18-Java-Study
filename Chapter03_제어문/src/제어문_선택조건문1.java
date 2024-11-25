/*
 *   선택조건문 
 *     = 조건 true일때 처리
 *     = 조건 false일때 처리 
 *     ------------------ 나눠서 작업
 *     예) 로그인 (O) , 로그인 (X)
 *     
 *     형식) ==> 56page 
 *     ==> 무조건 수행 (두줄에 한개의 문장만 수행 
 *     if(조건문)
 *     {
 *        조건문 true일때 처리하는 문장  ==> 종료
 *     }
 *     else
 *     {
 *        조건문 false일때 처리하는 문장 ==> 종료
 *     }
 *     
 *     점수 입력 ==> 
 *     60이상 합격 ==> 불합격
 *     if(score>=60)
 *     if(score<60) ==> else
 */
public class 제어문_선택조건문1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        char c='A';
        int type=(int)(Math.random()*2); //0,1
        if(type==0)
        {
        	c=(char)((Math.random()*26)+65);// 대문자
        }
        if(type==1)
        {
        	c=(char)((Math.random()*26)+97);// 소문자
        }
        System.out.println("c="+c);
        
        System.out.println("===== 결과값 =====");
        if(c>='A' && c<='Z') // true => 대문자면
        	System.out.println(c+"는(은) 대문자입니다!!");
        //if(c>='a' && c<='z')
        else // false => 소문자면 
        	System.out.println(c+"는(은) 소문자입니다!!");
        
	}

}
