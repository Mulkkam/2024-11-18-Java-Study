import java.util.*;
public class 문자열_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 1번 예제
		int[] score={100, 90, 85};
		int total=0;
		
		for(int i=0;i<score.length;i++)
		{
			System.out.println((i+1)+"번 학생 : "+score[i]);
			total+=score[i];
		}
		System.out.println("학생 총점: "+ total);
		System.out.println();
		
		// 2번 예제
		int[] per= {50, 45, 35, 12, 70};
		int jtotal=0;
		double javg=0.0;
		int max=per[0];
		int min=per[0];
		int maxi=0;
		int mini=0;
		
		for(int i=0;i<per.length;i++)
		{
			System.out.printf("사원(%d) : %d, ",i+1,per[i]);
			jtotal+=per[i];
			
			if(max<per[i])
			{
				max=per[i];
				maxi=i+1;
			}
			else if(min>per[i])
			{
				min=per[i];
				mini=i+1;
			}
		}
		javg=jtotal/3.0;	
		System.out.println("1월 실적 총점:"+jtotal);
		System.out.printf("1월 실적 평균: %.2f\n",javg);
		System.out.println("1월 우수 사원 : "+maxi+"번, 실적 : "+max);
		System.out.println("1월 꼴등 사원 : "+mini+"번, 실적 : "+min);
		System.out.println();
		
		// 3번 예제
		int[] arr=new int[10];
		
		for(int i=0;i<arr.length;i++)
		{
			arr[i]=i;
		}
		System.out.print(Arrays.toString(arr));
		System.out.println();
		
		//4번 예제
		int[] arr2 = {10, 20, 30, 40, 50};
		int sum = 0;

		for(int i=0;i<arr2.length;i++)
		{
			sum+=arr2[i];
		}
		System.out.println("sum="+sum); // 결과 : sum=150
		System.out.println();
		
		//5번 예제
		int[] arr3 = new int[10];
		int evenTotal=0;
		int oddTotal=0;
		
		for(int i=0;i<arr3.length;i++)
		{
			arr3[i]=(int)(Math.random()*100)+1;
			
			if(arr3[i]%2==0)
			{
				evenTotal+=arr3[i];
			}
			else
			{
				oddTotal+=arr3[i];
			}
		}
		System.out.println(Arrays.toString(arr3));
		System.out.println("배열 내 홀수 합: "+ oddTotal+", 배열 내 짝수 합: "+evenTotal);
		System.out.println();
		
		//6번 예제
		int[] arr4= new int[100];
		int[] freq= new int[10];
		int[] countfreq=new int[100];
		
		for(int i=0;i<arr4.length;i++)
		{
			arr4[i]=(int)(Math.random()*10);
//			for(int j=0;j<10;j++)
//			{
//				if(arr4[i]==j)
//				{
//					countfreq[j]++;
//					freq[j]=countfreq[j];
//				}
//			}
		}
		
		for(int i=0;i<arr4.length;i++)
		{
			freq[arr4[i]]++;
		}
		System.out.println(Arrays.toString(arr4));
				
		for(int i=0;i<freq.length;i++)
		{
			System.out.println(i+"의 개수: "+freq[i]);
		}
//		{'A','C','D','H','J'}

		//7번 예제	
		char[] arr5=new char[5];
		// 초기값
		// ASC정렬 ==> 선택 정렬
		// DESC정렬 ==> 버블 정렬
		
		for(int i=0;i<arr5.length;i++)
		{
			arr5[i]=(char)((Math.random()*26)+65);
		}
		System.out.println(Arrays.toString(arr5));
		for(int i=0;i<arr5.length-1;i++)
		{
			for(int j=i+1;j<arr5.length;j++)
			{
				if(arr5[i]>arr5[j])
				{
					char temp=arr5[i];
					arr5[i]=arr5[j];
					arr5[j]=temp;
				}
			}
		}
		System.out.println("오름차순 정렬 후:");
		System.out.println(Arrays.toString(arr5));
		for(int i=0;i<arr5.length-1;i++)
		{
			for(int j=i+1;j<arr5.length;j++)
			{
				if(arr5[i]<arr5[j])
				{
					char temp=arr5[i];
					arr5[i]=arr5[j];
					arr5[j]=temp;
				}
			}
		}
		System.out.println("내림차순 정렬 후:");
		System.out.println(Arrays.toString(arr5));
	}

}
