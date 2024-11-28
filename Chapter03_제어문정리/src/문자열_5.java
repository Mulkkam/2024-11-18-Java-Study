/*
 * 	문자의 위치 찾기
 * 	indexOf(문자)
 * 	lastIndexOf(문자)
 * 	=> 확장자
 * 
 *  https://www.daum.net/index.html
 *  Hello Java 
 *    
 *  a.b.c.txt
 */
public class 문자열_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String data="Hello Java";
		
		int a=data.indexOf("a");
		int b=data.lastIndexOf("a");
		int c=data.indexOf("c");
		// 웹에서 등장 : URL => 마지막 파일명을 찾아서 처리
		System.out.println("a="+a);
		System.out.println("b="+b);
		System.out.println("c="+c);

	}

}
