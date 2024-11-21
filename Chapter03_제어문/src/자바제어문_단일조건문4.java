/*
 * 	윤년
 *  ---
 *  윤년 조건
 *  1. 4년마다
 *  2. 100년마다 제외
 *  3. 400년마다
 * 	
 */
// 년도를 입력을 받아서 윤년여부 확인
import java.util.Scanner;
public class 자바제어문_단일조건문4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("년도 입력");
		int year = scan.nextInt();
		
		if((year%4==0 && year%100!=0) || (year%400==0))
		{
			System.out.println(year+"는(은) 윤년입니다!!");
		}
		if(!((year%4==0 && year%100!=0) || (year%400==0)))
		{
			System.out.println(year+"는(은) 윤년이 아닙니다!!");
		}
	}

}
