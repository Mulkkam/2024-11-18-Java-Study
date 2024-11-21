/*
 * 	대입연산자
 * 	--------
 * 
 * 	복합대입연산자
 * 	==========
 * 		+=	==> 여러개증가
 * 		-=	==> 여러개감소
 * 		*=
 * 		/=
 * 		%=
 * 
 */
public class 연산자_이항연산자_대입연산자 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=10;
		a++;
		a++;
		a++;
		a++;
		a++;
		System.out.println("a="+a);
		
		int b=10;
		b+=5;
		
		System.out.println("b="+b);
		
		int c=10;
		c=c+5;
		System.out.println("c="+c);

	}

}
