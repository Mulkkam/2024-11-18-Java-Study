//무한루프
/*
 * 
 * 
 * 
 * 
 */
import java.util.Scanner;
public class 반복문_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*100)+1;
		
		Scanner scan=new Scanner(System.in);
		
		for(;;)
		{
			System.out.println("1~100사이의 정수 입력:");
			int user=scan.nextInt();
			
			if(com>user)
			{
				System.out.println("높은 정수 이력!!");
			}
			else if(com<user)
			{
				System.out.println("작은 정수 입력!!");
			}
			else
			{
				System.out.println("정답입니다!!");
				System.exit(0);  // 프로그램 종료\
			}
			
		}
	}

}
