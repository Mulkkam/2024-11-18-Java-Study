/*
 * 	반복문 -> for
 * 	1. 형식
 * 	   for(초기식;조건식;증감식;)
 * 	   {
 * 			반복 수행 문장
 * 	   }
 * 	   => 향상된 for => for-each
 * 					  --------- 배열 / Collection
 * 					  --------- 웹에서 주로 사용
 * 	2. 동작 순서
 * 		  	 1	  2    4
 * 	   for(초기식;조건식;증가식)
 * 				  | true
 * 			3. 반복수행 문장 => 4로 이동
 * 	   1 => 초기식은 한번만 수행
 * 	   2 => 3 => 4
 * 	   2 => 3 => 4
 * 	   ...
 * 	   ...
 * 	   4번에 증가/감소 => 2조건식에 대입 => false가 나올때까지 동작
 * 	3. 프로그램 구현 방법
 * 	   순서
 * 	   1) 변수 설정
 * 	   2) 변수 초기화 => 난수 / 명시적 / 입력값
 * 	   3) 제어문을 이용해서 사용자 요청 값을 추출
 * 		  => 데이터베이스안에 있는 데이터 추출
 * 	   4) 결과값을 출력
 */
import java.io.*;
public class 반복문_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BufferedReader FileReader = null;
		FileReader fr=new FileReader("C:\\JavaDev\\movie.txt");
		String movie="";
		StringBuffer sb=new StringBuffer();
		int i=0;
		while((i=fr.read())!=-1)
		{
			sb.append((char)i);
		}
		fr.close();
		System.out.println(sb.toString());
		
	}

}
