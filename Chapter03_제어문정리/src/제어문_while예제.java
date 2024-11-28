
import java.util.Scanner;
public class 제어문_while예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 1번 예제
		System.out.print("정수를 입력하세요:");
		int i=1;
		int num = scan.nextInt();
		while(i<=9)
		{
			int mul = i * num;
			System.out.print(num+"*"+i+"="+mul+"\t");
			i++;
		}		
		System.out.println(" ");
		
		//2번 예제
		int num1 = 1;
		while(num1<=100)
		{
			if(num1%8==0)
			System.out.print(num1+" ");
			num1++;
		}
		System.out.println(" ");
		
		//3번 예제
		int num2 = 1;
		while(num2<=100)
		{
			if(num2%4==0 || num2%7==0)
			System.out.print(num2+" ");
			num2++;
		}
		System.out.println(" ");
		//4번 예제
		int num3 = 1;
		while(num3<=100)
		{
			if(num3%10==3 || num3%10==6 || num3%10==9)
			System.out.print(num3+" ");
			num3++;
		}
		System.out.println(" ");

		//5번 예제
		int j=0;
		int a=0,e=0,k=0,o=0,u=0;
		
		System.out.print("문자열을 입력하세요:");
		String str = scan.next();
		while(j<str.length())
		{
			char c=str.charAt(j);
			if(c=='a')
				a++;
			else if(c=='e')
				e++;
			else if(c=='i')
				k++;
			else if(c=='o')
				o++;
			else if(c=='u')
				u++;
			
			j++;
		}		
		System.out.println("모음 갯수:"+(a+e+k+o+u));
		//6번 예제
		int num5 = 10;
		int num6 = 0;

		while(true) 
		{
			System.out.print("정수를 입력하세요:");
			num6 = scan.nextInt();

			if(num6<10)
			{
				while(num5<100)
				{
					if(num6==(num5/10 + num5%10))
					System.out.print(num5+"\t");
					num5++;
				}
				break;
			}	
			else
			{
				System.out.println("잘못입력하였습니다!!");
				continue;
			}
		}
		System.out.println(" ");

		//7번 예제
		int num7 = 10;
		while(num7<=20)
		{
			System.out.print(num7+"\t");
			num7++;
		}
		System.out.println(" ");

		//8번 예제
		int num8 = 20;
		while(num8>=10)
		{
			System.out.print(num8+"\t");
			num8--;
		}
		System.out.println(" ");
		// 문자열을 입력 받아서 => 꺼꾸로 출력
		// 이미지를 꺼꾸로 출력하는 프로그램을 작성 => byte[]
		System.out.print("문자열 입력:");
		String strex=scan.next(); // ENTER
		i=strex.length()-1;
		while(i>=0)
		{
			System.out.print(strex.charAt(i));
			i--;
		}
		System.out.println(" ");

		//9번 예제
		i=1;
		int max=0;
		while(i<=5)
		{
			int num9=(int)(Math.random()*100)+1;
			System.out.print(num9+" ");
			if(max<num9)
				max=num9;
			i++;
		}
		System.out.println("가장 큰 수:"+max);
		System.out.println(" ");

		i=1;
		int usermax=0;
		
		while(i<=5)
		{
			System.out.print("정수를 입력하세요:");
			int a1 = scan.nextInt();
			if(usermax<a1)
				usermax=a1;
			i++;
		}	
		System.out.println("가장 큰 수:"+usermax);
		System.out.println(" ");

		//10번 예제
		i=1;
		int sum=0;
		String strMax="";
		int max1=0;
		while(i<=3)
		{
			System.out.print("문자열 입력:");
			String str1=scan.next(); // ENTER
			sum+=str1.length();

			if(max1<str1.length())
			{
				strMax=str1;
			}
			i++;
		}
		System.out.println("===== 결과값 =====");
		System.out.println("총 문자열 길이:"+sum);
		System.out.println("가장 긴 문자열:"+strMax);

	}

}
