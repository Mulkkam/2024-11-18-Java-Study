import java.util.Arrays;
import java.util.Scanner;

public class 배열_예제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 예제
		int[] std=new int[5];
		int[] rank=new int[5];
		for(int i=0;i<std.length;i++)
		{
			std[i]=(int)(Math.random()*101);
		}
		System.out.println(Arrays.toString(std));
	
		for(int i=0;i<std.length;i++)
		{
			rank[i]=1;
			for(int j=0;j<std.length;j++)
			{
				if(std[i]<std[j])
				{
					rank[i]++;
				}
			}
		}
		System.out.println(Arrays.toString(rank));
		//2번 예제
		int[] num=new int[10];
		int max=0;
		int min=100;
		
		for(int i=0;i<num.length;i++)
		{
			num[i]=(int)(Math.random()*100)+1;
		}
		
		// 최대값, 최소값
		for(int i:num)
		{
			if(max<i)
				max=i;
			if(min>i)
				min=i;
		}
		System.out.println(Arrays.toString(num));
		System.out.println("최대값:"+max+", 최소값:"+min);
		//3번 예제
		int[] arr=new int[10];
		
		for(int i=0;i<10;i++)
		{
			int num1=(int)(Math.random()*10);
			System.out.print(num1+" ");
			arr[num1]++;
		}
		System.out.println();
		for(int i=0;i<arr.length;i++)
		{
			System.out.print("arr["+i+"]="+arr[i]+" ");
		}
		System.out.println();

		//4번 예제
		int[] arr1=new int[10];
		int max1=0;
		for(int i=0;i<arr1.length;i++)
		{
			arr1[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr1));
		System.out.println(arr1[1]);
		System.out.println(arr1.length-1);
		//5번 예제
		for(int i:arr1)
		{
			if(max1<i)
				max1=i;
		}
		System.out.println("위 배열의 최대값:"+max1);
		//6번 예제
		int sum=0;
		double avg=0.0;
		int[] arr2=new int[10];
		//초기화 =>난수
		for(int i=0;i<arr2.length;i++)
		{
			arr2[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr2));
		for(int i:arr2)
		{
			sum+=i;
		}
		avg=sum/10.0;
		System.out.print("총합:"+sum+", 평점:"+avg);
		System.out.println();
		//7번 예제
		int[] arr3=new int[10];
		
		for(int i=0;i<arr3.length;i++)
		{
			arr3[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr3));

		for(int i=0;i<arr.length;i++)
		{
			if(i!=3)
			System.out.print(arr3[i]+" ");
		}
		System.out.println();

		//8번 예제
		int[] arr4=new int[5];
		
		for(int i=0;i<arr4.length;i++)
		{
			arr4[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr4));

		for(int i=0;i<2;i++)
		{
			int random=(int)(Math.random()*4);
			arr4[random] = arr4[random];
		}
		System.out.println();

		//9번 예제
		char[] alpha=new char[26];
		char c='A';
		
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=c++; // A~Z까지 입력
		}
		for(char cc:alpha)
		{
			System.out.print(cc+" ");
		}
		//10번 예제
		char[] alphar=new char[26];
		//초기화
		char cr='Z';
		for(int i=0;i<alphar.length;i++)
		{
			alphar[i]=cr--; // A~Z까지 입력
		}

		for(char cc:alphar)
		{
			System.out.print(cc+" ");
		}
		System.out.println();

		//11번 예제
		int[] arr6=new int[10];
		
		for(int i=0;i<arr6.length;i++)
		{
			arr6[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr6));
		for(int i=0;i<arr6.length;i++)
		{
			if(arr6[i]%3==0)
			System.out.print(arr6[i]+" ");
		}
		System.out.println();
		//12번 예제
		int[] arr7=new int[10];
		int evenmax=0;
		int oddmax=0;
		
		for(int i=0;i<arr7.length;i++)
		{
			arr7[i]=(int)(Math.random()*100)+1;
		}
		System.out.println(Arrays.toString(arr7));
		for(int i=0;i<arr7.length;i++)
		{
			if(arr7[i]%2==0 && arr7[i]>evenmax)
				evenmax=arr7[i];
			if(arr7[i]%2==1 && arr7[i]>oddmax)
				oddmax=arr7[i];
		}	
		System.out.print("짝수의 최댓값:"+evenmax+", 홀수의 최댓값:"+oddmax);
		System.out.println();
		//13번 예제
		int[] kor=new int[3];
		int[] eng=new int[3]; // 1번 / 2번 / 3번 => 인덱스번호 일치
		int[] math=new int[3];
		
		int[] total=new int[3];
		double[] avg1=new double[3]; // 0.0,0.0,0.0
		char[] score=new char[3]; // '\0'
		int[] rank1=new int[3];
		
		// 점수입력을 받아서 => 초기화 ==> avg
		Scanner scan=new Scanner(System.in);
		for(int i=0;i<kor.length;i++)
		{
			System.out.print((i+1)+" 국어 입력:");
			kor[i]=scan.nextInt();

			System.out.print((i+1)+" 영어 입력:");
			eng[i]=scan.nextInt();
			
			System.out.print((i+1)+" 수학 입력:");
			math[i]=scan.nextInt();

			total[i]=kor[i]+eng[i]+math[i];
			
			avg1[i]=total[i]/3.0;
		}
		// 학점 계산
		for(int i=0;i<kor.length;i++)
		{
			switch((int)(avg1[i]/10))
			{
				case 10: case 9:
					score[i]='A';
					break;
				case 8:
					score[i]='B';
					break;
				case 7:
					score[i]='C';
					break;
				case 6:
					score[i]='D';
					break;
				default:
					score[i]='F';
			}
		}
		//등수 계산
		for(int i=0;i<kor.length;i++)
		{
			rank1[i]=1;
			for(int j=0;j<kor.length;j++)
			{
				if(total[i]<total[j])
				{
					rank1[i]++;
				}
			}
		}
		for(int i=0;i<kor.length;i++)
		{
			System.out.printf("%-5d%-5d%-5d%-7d%-7.2f%-3c%-5d\n",
					kor[i],eng[i],math[i],total[i],avg1[i],score[i],rank1[i]);
		}
	}
}


