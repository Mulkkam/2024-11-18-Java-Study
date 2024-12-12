import java.util.*;
public class MovieUserMain {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        MovieSystem ms=new MovieSystem();
        Scanner scan=new Scanner(System.in);
        while(true)
        {
        	System.out.println("========== 메뉴 =========");
        	System.out.println("1. 영화 목록");
        	System.out.println("2. 영화 상세보기");
        	System.out.println("3. 영화 검색(영화명)");
        	System.out.println("4. 영화 검색(출연진)");
        	System.out.println("5. 종료");
        	System.out.println("========================");
        	System.out.print("메뉴 선택:");
        	int menu=scan.nextInt();
        	if(menu==5)
        	{
        		System.out.println("프로그램 종료");
        		break;
        	}
        	else if(menu==1)
        	{
        		System.out.print("페이지 선택:");
        		int page=scan.nextInt();
        		Movie[] movies=ms.movieListData(page);
        		// 목록 출력 
        		for(Movie m:movies)
        		{
        			System.out.println(m.no+"."+m.title);
        		}
        	}
        	else if(menu==2)
        	{
        		System.out.print("영화번호 선택(1~1938):");
        		int no=scan.nextInt();
        		Movie movie=ms.movieDetail(no);
        		// 상세보기 
        		System.out.println("영화번호:"+movie.no);
        		System.out.println("영화명:"+movie.title);
        		System.out.println("출연진:"+movie.actor);
        		System.out.println("감독:"+movie.director);
        		System.out.println("장르:"+movie.genre);
        		System.out.println("등급:"+movie.grade);
        		System.out.println("개봉일:"+movie.regdate);
        		
        	}
        }
	}

}
