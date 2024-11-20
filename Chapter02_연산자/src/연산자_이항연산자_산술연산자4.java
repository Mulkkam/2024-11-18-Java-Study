/*
 * 	키보드 입력 
 * 	1) BufferedReader => java.io
 * 	   => 예외처리
 * 	2) Scanner => java.util
 * 	
 * 	// 다른 폴더에 있는 경우에 클래스를 읽어온다
 * 	   import를 이용한다
 *	   include / using / from ... 
 * 
 */
import java.util.Scanner;
public class 연산자_이항연산자_산술연산자4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 클래스를 메모리에 저장 => new
		Scanner scan=new Scanner(System.in);
		// System.in => keyboard 입력값을 받는다
		// 연산자_이항연산자_산술연산자4 a=new 연산자_이항연산자_산술연산자4 
		System.out.print("국어 점수:");
		int kor=scan.nextInt();
		
		System.out.print("영어 점수:");
		int eng=scan.nextInt();
		
		System.out.print("수학 점수:");
		int math=scan.nextInt();
		
		System.out.println("국어 점수:"+kor);
		System.out.println("영어 점수:"+eng);
		System.out.println("수학 점수:"+math);
		
	}

}
