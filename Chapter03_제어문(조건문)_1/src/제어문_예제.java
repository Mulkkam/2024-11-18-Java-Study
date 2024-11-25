import java.util.Scanner;
public class 제어문_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 예제
		Scanner scan=new Scanner(System.in);
		System.out.print("정수 입력: ");
		int score=scan.nextInt();
		int avg=score/10;
				
		switch(avg) 
		{
			case 10: case 9:
				System.out.println("A학점입니다.");
				break;
			case 8:
				System.out.println("B학점입니다.");
				break;
			case 7:
				System.out.println("C학점입니다.");
				break;
			case 6:
				System.out.println("D학점입니다.");
				break;
			default:
				System.out.println("F학점입니다.");
		}
		//2번 예제
		System.out.print("정수 입력: ");
		int num1=scan.nextInt();
		
		System.out.print("정수 입력: ");
		int num2=scan.nextInt();

		System.out.print("연산자 입력(+,-,*,/):");
		
		switch(scan.next())
		{
			case "+": 
				System.out.printf("%d + %d = %d\n",num1,num2,num1+2);
				break;
			case "-": 
				System.out.printf("%d - %d = %d\n",num1,num2,num1-2);
				break;
			case "*":
				System.out.printf("%d * %d = %d\n",num1,num2,num1*2);
				break;
			case "/":
				if(num2==0)
					System.out.println("0으로 나눌 수 없습니다.");
				else
					System.out.printf("%d / %d = %d\n",num1,num2,num1/2);
				break;
			default:
				System.out.println("잘못된 연산자 입력입니다!!");
		}
		//3번 예제
		int sum1=0;
		for(int i=0;i<=100;i+=2)
		{
			sum1+=i;
		}
		System.out.println("1~100까지 사이의 총합:"+sum1);
		//4번 예제
		for(int i=5;i<=50;i+=5)
		{
			System.out.print(i+" ");
		}
		//5번 예제
		for(char c='B';c<='Z';c+=2)
		{
			System.out.print(c+" ");
		}
		//6번 예제
		int sum2=0;
		System.out.print("정수 입력:");
		int num3=scan.nextInt();

		for(int i=1;i<=num3;i++)
		{
			sum2+=i;
		}
		System.out.println("1~"+num3+"까지 사이의 총합:"+sum2);
		//7번 예제
		for(int a3=2;a3<=30;a3+=2)
		{
			System.out.print(a3+" ");
			if(a3%3==0)
				System.out.println();
		}
		//8번 예제
		int sum3=0;
		for(int i=1;i<=10;i++)
		{
			if(i%2==1)
				sum3+=i;
			else if(i%2==0)
				sum3-=i;
		}
		System.out.println("1-2+3..-10까지의 합:"+sum3);
		//9번 예제
		for(int i=1;i<=10;i++)
		{
			if(i%3!=0)
			System.out.print(i+" ");
		}
	}

}
