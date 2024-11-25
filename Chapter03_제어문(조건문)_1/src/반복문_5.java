// 1~100 사이의 3의배수의 합, 5의 배수의 합, 7의 배수의 합
public class 반복문_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum=0;
		for(int i=0;i<=100;i+=3)
		{
			sum+=i;
			System.out.println("sum="+sum+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum);

		int sum1=0;
		for(int i=0;i<=100;i+=5)
		{
			sum1+=i;
			System.out.println("sum="+sum1+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum1);

		int sum2=0;
		for(int i=0;i<=100;i+=7)
		{
			sum2+=i;
			System.out.println("sum="+sum2+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum2);

	}

}
