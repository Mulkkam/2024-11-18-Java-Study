package com.sist.movie;
import java.util.*;
//데이터를 여러개 가지고 온다 => ArrayList
//목록 / 검색 
//데이터 상세보기 => Movie 
//=> Movie : 영화 한개에 대한 정보 => 사용자 정의 데이터형 클래스 
//=> 데이터 출력 : 웹,모바일 , 애플리케이션 => for-each 
//Collection => 반드시 제네릭응 리용해서 저장을 한다 
//<Movie> : <반드시 클래스형만 사용이 가능> 
//일반 기본형(int,double...) => Wrapper클래스를 이용한다
//기본형 데이터형을 클래스화 => 사용이 쉽게 ,제네릭에 주로 사용
public class MovieUser {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		MovieSystem ms=new MovieSystem();
		while(true)
		{
			System.out.println("======= Menu =======");
			System.out.println("1. 전체 영화 목록");
			System.out.println("2. 상세보기");
			System.out.println("3. 검색(영화명)");
			System.out.println("4. 검색(출연진)");
			System.out.println("5. 검색(장르)");
			System.out.println("6. 프로그램 종료");
			System.out.println("====================");
			System.out.println("메뉴 선택:");
			int menu=scan.nextInt();
			if(menu==6)
			{
				System.out.println("프로그램을 종료합니다");
				System.exit(0);
			}
			else if(menu==1)
			{
				ArrayList<Movie> list=ms.movieListData();
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."
							+m.getTitle());
				}
			}
			else if(menu==2)
			{
				System.out.println("1~1938까지 영화 번호 입력:");
				int mno=scan.nextInt();
				Movie m=ms.movieDetailData(mno);
				System.out.println("==="+m.getTitle()+"상세보기 ===");
				System.out.println("영화명:"+m.getTitle());
				System.out.println("출연:"+m.getActor());
				System.out.println("감독:"+m.getDirector());
				System.out.println("장르:"+m.getGenre());
				System.out.println("개봉일:"+m.getRegdate());
				System.out.println("등급:"+m.getGrade());
				
			}
			else if(menu==3)
			{
				System.out.println("검색어 입력:");
				String title=scan.next();
				ArrayList<Movie> list=ms.moviefindTitle(title);
				System.out.println("검색 결과: "+list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle());
				}
			}
			else if(menu==4)
			{
				System.out.println("검색어 입력:");
				String actor=scan.next();
				ArrayList<Movie> list=ms.moviefindTitle(actor);
				System.out.println("검색 결과: "+list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle()+" "+m.getActor());
				}
			}
			else if(menu==5)
			{
				System.out.println("검색어 입력:");
				String genre=scan.next();
				ArrayList<Movie> list=ms.moviefindTitle(genre);
				System.out.println("검색 결과: "+list.size()+"건");
				for(Movie m:list)
				{
					System.out.println(m.getMno()+"."+m.getTitle()+" "+m.getGenre());
				}
			}
		}
	}

}
