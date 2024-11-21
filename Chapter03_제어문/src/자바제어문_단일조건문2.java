// 국어 / 영어 / 수학 입력 ==> 1. 총점 2. 평균 3. 학점
import java.util.Scanner;

import javax.swing.JOptionPane;
public class 자바제어문_단일조건문2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);

		System.out.print("첫번째 정수 입력:");
		int num1=scan.nextInt();
		
		System.out.print("두번째 정수 입력:");
		int num2=scan.nextInt();
		
		System.out.print("연산자 입력(+(43),-(45),*(42),/(47):");
		char op=(char)scan.nextInt();
		
//		System.out.println(num1);
//		System.out.println(num2);
//		System.out.println(op);

		if(op=='+')
		{
			System.out.printf("%d + %d = %d\n",num1,num2,num1+num2);
		}
		if(op=='-')
		{
			System.out.printf("%d - %d = %d\n",num1,num2,num1-num2);
		}
		if(op=='*')
		{
			System.out.printf("%d * %d = %d\n",num1,num2,num1*num2);
		}
		if(op=='/')
		{
			// 중첩 조건문 => 이중 조건
			if(num2==0)
				System.out.println("0으로 나눌 수 없다");
			if(num2!=0)
				System.out.printf("%d / %d = %d\n",num1,num2,num1/num2);
		}
	}

}
