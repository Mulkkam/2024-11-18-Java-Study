import java.util.Scanner;

public class 메소드응용_변경_2 {

    // 입력 
	static int input(String msg)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(msg+" 입력:");
		int year=scan.nextInt();
		return year;
	}
	static int getWeek(int year,int month)
	{
		// 1. ~전년도까지 총 날수 
		int total=(year-1)*365
				 +(year-1)/4
				 -(year-1)/100
				 +(year-1)/400;
		// 2. 전달까지 총 날수
		int[] lastday={31,28,31,30,31,30,31,31,30,31,30,31};
		// 윤년 조건 
		if((year%4==0 && year%100!=0)||(year%400==0))
			 lastday[1]=29;
		else
			lastday[1]=28;
		
		for(int i=0;i<month-1;i++)
		{
			total+=lastday[i];
		}
		// 3. +1
		total++;
		
		// 요일 구하기 
		int week=total%7; // 0(일)~6(토)
		
		return week;
	}
	
	static void print(int year,int month,int week)
	{
		// 요일 출력 
		String[] strWeek={"일","월","화","수","목","금","토"};
		// 요일 구하기 
		
		int[] lastday={31,28,31,30,31,30,31,31,30,31,30,31};
		// 3.출력 
		System.out.println(year+"년도 "+month+"월");
		for(int i=0;i<strWeek.length;i++)
		{
			if(i==0)
			  System.err.print(strWeek[i]+"\t");
			else
			  System.out.print(strWeek[i]+"\t");
			
		}
		System.out.println();
		for(int i=1;i<=lastday[month-1];i++)
		{
			if(i==1)
			{
				// 해당 요일까지 공백 
				for(int j=0;j<week;j++)
				{
					System.out.print("\t");
				}
			}
			
			//if(week==0)
			 System.out.printf("%2d\t",i);
			//else
			 //System.out.printf("%2d\t",i);
			
			week++;
			if(week>6)
			{
				week=0;
				System.out.println();
			}
		}
	}
	
	static void process()
	{
		// TODO Auto-generated method stub
        //1. 입력 
		int year=input("년도");
		int month=input("월");
		
		
		int week=getWeek(year, month);
		
		print(year, month, week);
	}
	public static void main(String[] args) {
		process();
	}

}