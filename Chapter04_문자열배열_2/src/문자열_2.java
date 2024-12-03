import java.util.*;
public class 문자열_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		// 새로운 메모리 저장공간을 생성해라 => new
		String[] ids={"admin","hong","park","kim","shim"};
		String[] pwds={"1234","1234","1234","1234","1234"};
		String[] names={"이순신","홍길동","박문수","김두한","심청이"};
		
		// 로그인 처리
		System.out.print("ID를 입력:");
		String id=scan.next();
		
		System.out.print("Password를 입력:");
		String pwd=scan.next(); // pwd 암호화 /복호화
		// encoder => decoder
		int count=0; // 반복문은 무조건 처음부터 ~~ 디폴트를 설정한다
		// hong
		int index=0;
		for(int i=0;i<ids.length;i++)
		{
			if(ids[index].equals(id))
			{
				count++;
				index=i;
				break;
			}
			index++;
		}
		
		
		if(count==0)
		{
			System.out.println("ID가 존재하지 않습니다");
		}
		else
		{
			if(pwds[index].equals(pwd))
			{
				System.out.println(names[index]+"님 로그인 되었습니다");
			}
			else
			{
				System.out.println("비밀번호가 틀립니다");
			}
		}
	}

}
