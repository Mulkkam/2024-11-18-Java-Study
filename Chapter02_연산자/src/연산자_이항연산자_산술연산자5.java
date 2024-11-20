
import java.util.Scanner;
public class 연산자_이항연산자_산술연산자5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// %
        Scanner scan=new Scanner(System.in);

//		int a=369;
//		int f=a/100;
//		int s=(a%100)/10;
//		int t=a%10;
//		
//		System.out.println(f);
//		System.out.println(s);
//		System.out.println(t);

        int value = 759;
        System.out.println(value-(value%100));

        System.out.print("A:");
        int a=scan.nextInt();

        System.out.print("B:");
        int b=scan.nextInt();      

        System.out.print("C:");
        int c=scan.nextInt();      

        System.out.println("나머지값:"+ ((int)a*b+c));
        
        System.out.print("A:");
        int value1=scan.nextInt();

        System.out.print("B:");
        int value2=scan.nextInt();      

        System.out.println("나머지값:"+value1%value2);

	}

}
