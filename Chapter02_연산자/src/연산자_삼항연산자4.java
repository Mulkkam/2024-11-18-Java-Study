
import java.util.Scanner;
public class 연산자_삼항연산자4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int com=(int)(Math.random()*3);
		Scanner scan=new Scanner(System.in);
		System.out.print("가위(0),바위(1),보(2):");
		int user=scan.nextInt();
		
		System.out.println("===== 결과값 =====");
		System.out.print("컴퓨터:");
		System.out.print(com==0?"가위":"");
		System.out.print(com==1?"바위":"");
		System.out.print(com==2?"보":"");
		System.out.println(); // 다음줄에 출력
		System.out.print("사용자:");
		System.out.print(user==0?"가위":"");
		System.out.print(user==1?"바위":"");
		System.out.print(user==2?"보\n":"");
		
		System.out.println("결과...");
		int result=com-user;
		
		System.out.println(result==1 || result==-2?"컴퓨터 Win":"");
		System.out.println(result==-1 || result==2?"사용자 Win":"");
		System.out.println(result==0?"비겼다":"");

	}

}
