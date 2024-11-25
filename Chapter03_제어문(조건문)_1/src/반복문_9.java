//10개의 알파벳을 추출 => 대문자 몇개 , 소문자 몇개
public class 반복문_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int count1=0, count2=0;
		for(int i=1;i<=10;i++)
		{
			char c='A';
			int no=(int)(Math.random()*2);
			
			if(no==0)
				c=(char)((Math.random()*26)+65);
			else
				c=(char)((Math.random()*26)+97);
			System.out.println(c+" ");
			
			if(c>='A' && c<='Z')
				count1++;
			else
				count2++;
		}
		System.out.println();
		System.out.println("소문자 갯수: "+count1);
		System.out.println("대문자 갯수: "+count2);
	}

}
