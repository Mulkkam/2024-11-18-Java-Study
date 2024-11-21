import java.util.Scanner;
public class 자바제어문_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner Scan=new Scanner(System.in);

		System.out.print("정수 입력:");
		int num = Scan.nextInt();
		
		// 예제 9번
		if(num>0)
			System.out.println(num+"는(은) 양의 정수입니다");
		if(num==0)
			System.out.println(num+"는(은) 0입니다");
		if(num<0)
			System.out.println(num+"는(은) 음의 정수입니다");
		
		//예제 10번
		System.out.print("정수 입력:");
		int num2 = Scan.nextInt();
		
		System.out.println(num2%3==0?"는(은) 3의 배수입니다":"는(은) 3의 배수가 아닙니다");
		
		//예제 11번
		System.out.print("두자리 정수 입력:");
		int num3 = Scan.nextInt();
		
		int units, tens;
		
		units = num3 / 10;
		tens = num3 % 10;
		
		if(units <= 9 && units >= 1)
		{
			if(units == tens)
				System.out.println(num3+"는(은) 10의 자리와 1의 자리가 같습니다");
			if(units != tens)
				System.out.println(num3+"는(은) 10의 자리와 1의 자리가 같지 않습니다");
		}
		else	
		{
			System.out.println("값을 잘못 입력했습니다");
		}
		
		//예제 11번
		System.out.print("달을 입력하세요(1~12):");
		int month = Scan.nextInt();
		
		
		if(month>=3 && month <6)
			System.out.println("봄");
		if(month>=6 && month <9)
			System.out.println("여름");
		if(month>=9 && month <12)
			System.out.println("가을");
		if((month==12 || month <3) && (month==12 || month >0))
			System.out.println("겨울");
		else
			System.out.println("값을 잘못 입력하셨습니다");

	}

}
