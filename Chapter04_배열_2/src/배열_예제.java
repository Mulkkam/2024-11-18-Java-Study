/*
 * 	git
 */
import java.util.*;
public class 배열_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		//3번 예제
		char[] alpha = {'a', 'b', 'c', 'd'};

		for(int i=0;i<alpha.length; i++)
		{
			System.out.print(alpha[i]);
		}
		System.out.println();
		// 4번 예제
		int[] arr=new int[10];
		
		for(int i=0;i<arr.length;i++)
		{
			System.out.print("정수 입력:");
			arr[i]=scan.nextInt();
//			arr[i]=(int)(Math.random()*100)+1;
		}
		System.out.print(Arrays.toString(arr));
		System.out.println();
		System.out.print("위 배열 중 3의 배수는:");
		for(int i:arr)
		{
			if(i%3==0)
				System.out.print(" "+i+" ");
		}
		System.out.println();

		// 5번 예제
		int[] arr2=new int[10];
		int sum=0;
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i]=(int)(Math.random()*10)+1;
			sum+=arr2[i];
		}
		System.out.print(Arrays.toString(arr2));
		System.out.println();
		System.out.println("배열값의 합:"+sum);

		double avg=sum/10.0;
		System.out.print("배열값의 평균:"+avg);
		System.out.println();
		
		//6번 예제
		int[] num = { 94, 85, 95, 88, 90 };
		int max=num[0]; 
		int	min=num[0];
		
		for(int i=0;i<num.length;i++)
		{
			if(max<num[i])
				max=num[i];
			if(min>num[i])
				min=num[i];
		}
		System.out.println("배열의 최소값:"+min+" ,배열의 최대값:"+max);
		
		//7번 예제
		int[] arr3=new int[10];
		int sum2=0;
		for(int i=0;i<arr3.length;i++)
		{
			arr3[i]=(int)(Math.random()*10)+1;
			sum2+=arr3[i];
		}
		System.out.print(Arrays.toString(arr3));
		System.out.println();
		System.out.println("배열값의 합:"+sum2);

		double avg2=sum2/10.0;
		System.out.println("배열값의 평균:"+avg2);
		//8번 예제
		int[] arr4 = {10,20,30,50,3,60,-3};
		
		for(int i=0;i<arr4.length;i++)
		{
			if(i==1)
				System.out.println("index가 1인 곳의 값:"+arr4[i]);
		}
		//9번 예제
		int index=0;
		
		for(int i=0;i<arr4.length;i++)
		{
			if(arr4[i]==60)
			{
				System.out.println("배열의 값이 60인 곳의 index:"+index);
			}
			index++;
		}
	}

}
