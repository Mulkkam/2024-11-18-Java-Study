// 1. 대소문자가 있는 문자열을 입력받아서
// 대문자는 소문자로 소문자는 대문자 변경
// 예) abdDeF ==> ABDdEf
// 2. 문자열을 입력받아서 역순으로 출력하는 프로그램 작성
// 예) abcde => edcba
import java.util.Scanner;
// toString() : 객체의 주소 => 오버라이딩
/*
 *   length() 
 *   substring()
 *   equals()
 *   contains()
 *   indexOf() / lastIndexOf() 
 *   valueOf() 
 *   trim() 
 *   --------------------------
 *   replace() 
 *   --------------------------
 *   split()
 *   -------------------------- 필요적으로 암기 
 *   AI ==> 데이터 수집 ==> 데이터 분석 ==> 교육  
 *          --------- 전처리기 
 */
public class 문자열_5 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//예제 1번
		System.out.print("문자열을 입력하시오:");
		String msg=scan.next();
//		System.out.println(new StringBuilder(msg).reverse());
//		for(int i=msg.length()-1;i>=0;i--)
//		{
//			System.out.print(msg.charAt(i));
//		}
		System.out.println("변경 전:"+msg);
		String change="";
		for(int i=0;i<msg.length();i++)
		{
			char c=msg.charAt(i);
			if(c>='A' && c<='Z')
			{
		    	//change+=(char)(c+32);
				change+=Character.toLowerCase(c);
			}
			else if(c>='a' && c<='z')
			{
				change+=Character.toUpperCase(c);
		    	//change+=Character.toUpperCase(c);
			}
		}
		System.out.println("변경 후:"+change);
		
	}

}
