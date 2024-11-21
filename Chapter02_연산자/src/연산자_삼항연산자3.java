
import java.util.Scanner;
public class 연산자_삼항연산자3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scan=new Scanner(System.in);
		System.out.println("점수입력(0~100):");
		int score=scan.nextInt(); // 정수값
		// || => 범위에 없는 경우 => 다시 입력을 요구
		// && => 범위안에 포함 => 정상 수행
		//System.out.println(c>='A' && c<='Z' ||  c>='a' && c<='z');
		// nextDouble():살수, nextBoolean(): true/false, next() : 문자열 
		System.out.println(score<0 || score>100? "비정상입력":"정상입력");
		System.out.println("===== 결과값 =====");
		System.out.println(score>=90 && score<=100? "A학점":"");
		System.out.println(score>=80 && score<90? "B학점":"");
		System.out.println(score>=70 && score<80? "C학점":"");
		System.out.println(score>=60 && score<70? "D학점":"");
		System.out.println(score<60? "F학점":"");
	}

}
