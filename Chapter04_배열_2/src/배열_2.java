// char 배열 사용법 / double / Stirng
// => 응용 => 정렬 /달력... / 중복없는 난수
// => 지니뮤직, 서울 여행, 맛집...
public class 배열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//선언
		char[] alpha=new char[26];
		//초기화
		char c='A';
		for(int i=0;i<alpha.length;i++)
		{
			alpha[i]=c++; // A~Z까지 입력
		}
		// 처리 => (X)
		// 출력
		for(char cc:alpha)
		{
			System.out.print(cc+" ");
		}
		System.out.println();
		// => 'K'가 있는 인덱스번호를 출력
		int index=0;
		for(int i=0;i<alpha.length;i++)
		{
			if(alpha[i]=='K')
			{
				index=i;
				break;
			}
		}
		System.out.println("K의 위치는 "+index);
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
	}

}
