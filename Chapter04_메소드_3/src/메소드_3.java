/*
 * 9) 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
 *                  --------------- boolean (리턴형)
 *    ------------- 매개변수
   10. 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
   11. 입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
   12. 3의 배수를 판별하는 메소드를 구현하시오
   13. 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
   14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요
 */
import java.util.Calendar;
import java.util.Scanner;
public class 메소드_3 {
	// 사용빈도가 많을 수 있다 => 예약 / 개인 일정 ....
	// => 재사용 
    static boolean isYear(int year)
    {
    	boolean bCheck=false;
    	/*
    	 *   4년마다 
    	 *   100년마다 제외 
    	 *   400년마다 
    	 *   
    	 *   윤년 => 공식적으로 사용 
    	 *   
    	 */
    	if((year%4==0 && year%100!=0)||(year%400==0))
    		bCheck=true;
    	
    	return bCheck;
    }
    static void maxPrint(int a,int b)
    {
    	System.out.println("큰 값:"+Math.max(a, b));
    	//System.out.println(a>b?a:b);// 삼항연산자 
    	/*
    	 *   if(a>b)
    	 *     System.out.println(a)
    	 *   else
    	 *     System.out.println(b)
    	 */
    }
    static void print(int a)
    {
    	if(a%2==0)
    		System.out.println(a+"는(은) 짝수입니다");
    	else
    		System.out.println(a+"는(은) 홀수입니다");
    }
    // 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
    static char weekData(int year,int month,int day)
    {
    	char[] strWeek={' ','일','월','화','수','목','금','토'};
//    	//1. 1년도 1월 1일 ~~ 전년도까지의 총 날수 
//    	int total=(year-1)*365
//    			 +(year-1)/4
//    			 -(year-1)/100
//    			 +(year-1)/400;
//    	//2. 전달까지의 총날 수 
//    	int[] lastday={31,28,31,30,31,30,
//    			       31,31,30,31,30,31};
//    	if(isYear(year))
//    	{
//    		lastday[1]=29;
//    	}
//    	else
//    	{
//    		lastday[1]=28;
//    	}
//    	for(int i=0;i<month-1;i++)
//    	{
//    		total+=lastday[i];
//    	}
//    	//3. 입력된 일
//    	total+=day;
//    	//---------------------------- 총합 % 7 
//    	int week=total%7;//0~6
//    	// Calendar => java.util
    	Calendar cal=Calendar.getInstance();
    	cal.set(Calendar.YEAR, year);
    	cal.set(Calendar.MONTH, month-1);// month=0~
    	cal.set(Calendar.DATE, day);
    	int week=cal.get(Calendar.DAY_OF_WEEK);
    	// week => 1~7 
    	// substring(1,5) => 1,2,3,4
    	return strWeek[week];
    	
    }
    // 메소드 = 연산자+제어문 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
//        System.out.print("년도 입력:");
//        int year=scan.nextInt();
//        
//        boolean bCheck=isYear(year);
//        
//        if(bCheck==true)
//        	System.out.println(year+"년도는 윤년입니다");
//        else
//        	System.out.println(year+"년도는 윤년이 아닙니다");
        //System.out.print("정수 입력(10 20):");
        //int a=scan.nextInt();
        //int b=scan.nextInt();
        //print(a);
        //maxPrint(a, b);
        System.out.print("년 월 일을 입력(2024 11 20):");
        int year=scan.nextInt();
        int month=scan.nextInt();
        int day=scan.nextInt();
        
        char c=weekData(year, month, day);
        System.out.println("===== 결과값 =====");
        System.out.println(year+"년도 "
        		+month+"월 "
        		+day+"일은 "
        		+c+"요일입니다");
	}

}