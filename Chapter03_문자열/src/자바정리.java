import java.util.Scanner;

public class 자바정리 {
	static int userInput(String s)
	{
		Scanner scan=new Scanner(System.in);
		System.out.print(s+" 입력:");
		return scan.nextInt();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int kor=자바1_3_정리.userInput("국어");
        int eng=자바1_3_정리.userInput("영어");
        int math=자바1_3_정리.userInput("수학");
        
		System.out.println("점수는 국어:"+kor+"영어:"+eng+"수학:"+math+" 입니다.");

	}

}