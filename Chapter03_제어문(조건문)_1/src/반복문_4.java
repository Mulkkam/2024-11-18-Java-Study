// 1~100까지의 합
public class 반복문_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 짝수합, 홀수합, 총합
		int sum=0;
		for(int i=1;i<=100;i++)
		{
			sum+=i;
			System.out.println("sum="+sum+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum);
		
		int sum1=0;
		for(int i=1;i<=100;i+=2)
		{
			sum1+=i;
			System.out.println("sum="+sum1+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum1);

		int sum2=0;
		for(int i=0;i<=100;i+=2)
		{
			sum2+=i;
			System.out.println("sum="+sum2+",i="+i);
		}
		System.out.println("1~100까지 사이의 총합:"+sum2);
		
	}

}
