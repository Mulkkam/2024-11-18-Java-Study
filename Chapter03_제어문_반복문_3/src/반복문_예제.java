import java.util.Scanner;
public class 반복문_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//5번 예제
		for(int i=1;i<=6;i++)
		{
			for(int j=1;j<=6;j++)
			{
				if(i+j==6)
					System.out.printf("[%d , %d]\n",i,j,i+j);
			}
		}
		
		//6번 예제
		System.out.print("정수의 시작을 입력하시오:");
		int start=scan.nextInt();
	
		int end=0;
		int sum=1;

		while(true)
		{
			System.out.print("정수의 끝을 입력하시오:");
			end=scan.nextInt();
			if(start<end)
				break;
			else
				System.out.println("잘못입력하였습니다!!");
		}
		
		for(int i=start;i<=end;i++)
		{
			sum*=i;
		}
		System.out.printf("%d와 %d까지의 곱: %d\n",start,end,sum);
		
		//7번 예제
		int sum1=0;
		for(int i=5;i<=16;i++) 
		{
			sum1+=i;
		}
		System.out.println("5와 16까지의 합:"+sum1);			
		
		//8번 예제
		int sum2=0;
		for(int i=3;i<=4462;i++)
		{
			if(i%2==0)
				sum2+=i;
		}
		System.out.println("3이상 4462이하에서 짝수인 정수의 합:"+sum2);
		
		//9번 예제
		int a2=0, a3=0;
		for(int i=0;i<=12;i++)
		{
			if(i%2==0)
				a2+=i;
			if(i%3==0)
				a3+=i;
		}
		System.out.println("0부터 12까지 2의 배수의 합:"+a2);
		System.out.println("0부터 12까지 3의 배수의 합:"+a3);
		
		//10번 예제
		int a4=0;
		for(int i=1;i<=100;i++)
		{
			if(i%4==0)
				a4+=i;
		}
		System.out.println("0부터 100까지 4의 배수의 합:"+a4);
		
		//11번 예제
		int even=0;
		for(int i=1;i<=10;i++)
		{
//			System.out.print("정수를 입력하시오:");
//			int num=scan.nextInt();
			int num=(int)(Math.random()*100)+1;
			System.out.print(num+" ");
			if(num%2==0)
				even++;
		}
		System.out.println();
		System.out.println("입력한 정수중 짝수의 개수는"+even+"개 입니다");
		
		//12번 예제
		int b3=0,a5=0;
		for(int i=1;i<=10;i++)
		{
//			System.out.print("정수를 입력하시오:");
//			int num=scan.nextInt();
			int num=(int)(Math.random()*100)+1;
			System.out.print(num+" ");
			if(num%2==0)
				b3++;
			if(num%5==0)
				a5++;
		}
		System.out.println();
		System.out.println("입력한 정수중 3의 배수의 개수는"+b3+"개 입니다");
		System.out.println("입력한 정수중 5의 배수의 개수는"+a5+"개 입니다");
		
		//13번 예제
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=10;j++)
			{
				System.out.print("*");
			}
			System.out.println(" ");
		}
		
		//14번 예제
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(i);
			}
			System.out.println(" ");
		}
		//15번 예제
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(i==j)
					System.out.print(i);
				else
					System.out.print("#");
			}
			System.out.println(" ");
		}
		//16번 예제
		char c='A';
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(c++);
			}
			c='A';
			System.out.println(" ");
		}
		//17번 예제
		char cb='A';
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				System.out.print(cb);
			}
			cb++;
			System.out.println(" ");
		}
		//
		for(int i=1;i<=5;i++)
		{
			for(int j=1;j<=5;j++)
			{
				if(6-i==j)
					System.out.print("★");
				else
					System.out.print("☆");
			}
			System.out.println();
		}
	}

}
