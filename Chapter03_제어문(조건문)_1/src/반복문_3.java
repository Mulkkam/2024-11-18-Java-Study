// 사용자로부터 값을 받아서 => 해당 구구단을 출력 
/*
 *    >>5
 *    5*1=5
 *    5*2=10
 *    ..
 *    ..
 *    5*9=45
 *    
 *    1 2 3 4 5...
 *    ==== 1씩 증가 
 *    1 1 2 3 5 7 8 10 12 15 20 => for문을 사용할 수 없다 
 *    
 *    맛집이미지 레시피이미지 상품이미지 
 *    맛집이미지 맛집이미지 상품이미지 
 *    맛집이미지 맛집이미지 상품이미지 
 *    맛집이미지 레시피이미지 맛집이미지
 *    맛집이미지 맛집이미지 상품이미지 
 *    
 *    => for은 일정 패턴을 가지고 있어야 출력이 가능 
 *    
 *    => 
 *    
 */
import java.util.Scanner;
public class 반복문_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("단 입력(2~9):");
		int dan=scan.nextInt();
		
		System.out.println("===== 결과값 =====");
		for(int i=1;i<=9;i++)
		{
			System.out.println(dan+"*"+i+"="+dan*i);
		}
	}

}
