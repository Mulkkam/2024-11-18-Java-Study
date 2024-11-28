/*
 * 	문자열 분리 / 자르기 / 변경 / 찾기
 * 	= charAt(int index)
 * 	Hello Java
 * 	0123456789
 * 	charAt(6)
 * 
 */
import java.util.Scanner;
//사용자의 문자열 입력을 받아서 좌우 대칭 여부 확인
public class 문자열_4 {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*		String data="Hello Java";
		System.out.println("첫번째 문자:"+data.charAt(0));
		System.out.println("마지막 문자:"+data.charAt(data.length()-1));*/
		Scanner scan=new Scanner(System.in);
		System.out.print("문자열 입력:");
		String data=scan.nextLine();
		int count=0;
		Boolean bCheck=true;
		for(int i=0;i<data.length()/2;i++)
		{
			char start=data.charAt(i);
			char end=data.charAt(data.length()-1);	
			System.out.println("start="+start+",end="+end);
//			System.out.println(ch);
			if(start != end)
			{
				bCheck=false;
				break;
			}
			start--;
		}
		System.out.println("===== 결과값 =====");
		if(bCheck==true)
		{
			System.out.println("입력된 문자열은 좌우대칭입니다.");
		}
		else
		{
			System.out.println("입력된 문자열은 좌우대칭이 아닙니다.");
		}
//		int count=0; 
//		int i=0;
//		for(i=0;i<data.length();i++)
//		{
//			char ch=data.charAt(i);
//			//System.out.println(ch);
//			if(ch=='a' || ch=='A')
//				count++;
//			
//		}
//		// 지역변수 => {}변수 => {}이 종료하면 사라지는 변수 
//		System.out.println("a나 A의 갯수:"+count);
	}

}
