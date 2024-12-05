import java.util.*;
public class 메소드_예제 {

	//1번 예제
	static void arr()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.print(i+" ");
		}
		System.out.println();
	}
	
	//2번 예제
	static void sum()
	{
		int sum=0;
		for(int i=1;i<=10;i++)
		{
			sum+=i;
		}
		System.out.println("1~10까지의 합: "+sum);
		System.out.println();
	}

	//3번 예제
	static int sum2(int a)
	{
		int total=0;
		for(int i=1;i<=a;i++)
		{
			total+=i;
		}
		return total;
	}
	//4번 예제
	static String div(int a, int b)
	{
		String result="";
		if(b==0)
			result="0으로 나눌수가 없습니다";
		else
			result=String.valueOf(a/(double)b);
		return result;
	}
	
	//5번 예제
	static String change(String s)
	{
		return s.toUpperCase();
	}

	//6번 예제
	static String comp(String s)
	{
		if(s.length()%2!=0)
			return "문자열 갯수가 짝수이어야 합니다";
		String res="";
		boolean bCheck=true;
		for(int i=0;i<s.length()/2;i++)
		{
			char start=s.charAt(i);
			char end=s.charAt(s.length()-1-i);
			if(start!=end)
			{
				bCheck=false;
				break;
			}
		}
		
		if(bCheck==true)	
			res= "좌우 대칭 입니다";
		else
			res="좌우 대칭이 아닙니다";
		
		return res;
	}
	//7번 예제
	static void reverse(String s)
	{
		System.out.println(new StringBuilder(s).reverse());
	}
	//8번 예제
	static void grade(int a)
	{
		String grade="";
		if(a<=100 && a>90)
			grade="A";
		else if(a<=90 && a>80)
			grade="B";
		else if(a<=80 && a>70)
			grade="C";
		else if(a<=70 && a>60)
			grade="D";
		else
			grade="F";
		
		System.out.println("학점은 "+grade+"등급 입니다");
	}
	static String leap(int a)
	{
		String year ="";
		if(a%4==0 && a%100!=0 || a%400==0)
			year="해당 년도는 윤년입니다";
		else
			year="해당 년도는 윤년이 아닙니다";
		return year;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		
		//1번
		arr();
		//2번
		sum();
		//3번 예제
		System.out.print("정수를 입력하시오:");
		int a=scan.nextInt();
		System.out.print("1부터~"+a+"까지의 합: "+sum2(a));
		System.out.println();
		
		//4번 예제
		System.out.print("정수를 입력하시오:");
		int num=scan.nextInt();
		System.out.print("정수를 입력하시오:");
		int num2=scan.nextInt();
		System.out.print(num+"/"+num2+"="+div(num,num2));
		
		//5번 예제
		System.out.println("문자열을 입력하시오:");
		String s=scan.next();
		System.out.println(change(s));
		
		//6번 예제
		System.out.println("문자열을 입력하시오:");
		String s1=scan.next();
		comp(s1);

		//7번 예제
		System.out.println("문자열을 입력하시오:");
		String s2=scan.next();
		reverse(s2);
	
		//8번 예제
		System.out.print("학점를 입력하시오:");
		int score=scan.nextInt();
		grade(score);
		
		//9번 예제
		System.out.println("년도를 입력하시오:");
		int year=scan.nextInt();
		leap(year);
		
		//10번 예제
		
	}

}
