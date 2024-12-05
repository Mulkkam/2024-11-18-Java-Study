/*
 * 8) 학점을 구하는 메소드를 구현하시오
   9) 년도를 입력받아서 윤년인지 여부를 확인하는 메소드를 구현하시오
   10. 두수를 입력받아 큰 수를 출력하는 메소드를 구현하시오.
   11. 입력 받은 값이 짝수인지 홀숨인지 판별하는 메소드를 구현하시오
   12. 3의 배수를 판별하는 메소드를 구현하시오
   13. 년,월,일을 입력받아서 요일을 구하는 메소드를 구현하시오
   14. 메소드를 정의하여 입력받은 숫자를 거꾸로 뒤집은 쉬를 출력하는 프로그램을 작성하세요
 */
import java.util.Scanner;
public class 메소드_2 {
	static int[] display()
	{
		int[] arr= {10,20,30};
		return arr;
	}
	// => Call By Reference => 메모리 주소 전송 => 주소에 값을 받는 것 
	static void display2(int[] arr)
	{
		arr[0]=10;
		arr[1]=20;
		arr[2]=30;
	}
    // 학점을 구하는 메소드 
	// 평균을 구하는 메소드 
	// 총점을 구하는 메소드 
	// 순위를 구하는 메소드 
	// => 입력을 하는 메소드 
	/*
	 *  주소값이 전송되면 => 해당주소에 값을 채운다 
	 *  얕은 복사 
	 *  
	 *  int[] arr=new int[3];
	 *  int[] arr2=arr;
	 *  => 메모리 주소가 같은 경우에는 같은 메모리를 제어 
	 */
	// 매개변수 전송 => 값만 전송 (복사본) => Call By Value
	//              -------- 기본형 , String(일반 기본형 취급)
	// 매개변수 전송 => 메모리 주소값 전송 (원본) => Call By Reference 
	//               ---------- 배열 / 클래스
	// => 매개변수명 => 별칭 => 얕은 복사 
	static void input(int[] kor,int[] eng,int[] math)
	{
		Scanner scan=new Scanner(System.in);
		// 국어 / 영어 / 수학 입력 
		for(int i=0;i<kor.length;i++)
		{
			System.out.print((i+1)+"' 학생 국어 점수:");
			kor[i]=scan.nextInt();
			
			System.out.print((i+1)+"' 학생 영어 점수:");
			eng[i]=scan.nextInt();
			
			System.out.print((i+1)+"' 학생 수학 점수:");
			math[i]=scan.nextInt();
			
		}
	}
	static int sum(int kor,int eng,int math)
	{
		return kor+eng+math;
	}
	static double avgs(int total)
	{
		return total/3.0;
	}
	// => 결과출력 
	// => 조립 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 3명의 국어,영어,수학 점수를 받아서 학점,평균,총점,순위를 출력 
		int[] kor=new int[3];
		int[] eng=new int[3];
		int[] math=new int[3];
		int[] total=new int[3];
		char[] score=new char[3];
		double[] avg=new double[3];
		int[] rank=new int[3];
		
		/*
		 *    값 입력 
		 */
		input(kor, eng, math);// 같은 메모리 주소를 이용 
		// 총점 
		for(int i=0;i<total.length;i++)
		{
			total[i]=sum(kor[i],eng[i],math[i]);// 다른 주소를 이용
		}
		for(int i=0;i<avg.length;i++)
		{
			avg[i]=avgs(total[i]);
		}
		// 출력 
		for(int i=0;i<kor.length;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7.2f%-5d\n",
					kor[i],eng[i],math[i],avg[i],total[i]);
		}
		
		// 테스트 
		//int[] arr=display();
		/*
		 * int[] arr=new int[3]; display2(arr); // 배열 / 클래스 => 주소를 참조 for(int
		 * i=0;i<arr.length;i++) { System.out.println(arr[i]); }
		 */
		int[] arr={10,20,30};
		int[] a=arr;// 별칭  ==> arr대신 => a라는 이름으로 사용하겠다 
		a[0]=1000;
		a[1]=2000;
		a[2]=3000;
		System.out.println(arr[0]);
		System.out.println(arr[1]);
		System.out.println(arr[2]);
		System.out.println("arr="+arr);
		System.out.println("a="+a);
	}

}