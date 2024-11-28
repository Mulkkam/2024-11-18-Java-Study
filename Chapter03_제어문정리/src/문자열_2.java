// contains : 포함된 문자열
// Jsoup => 크롤링 라이브러리
// => 데이터가 필요 => 데이터를 읽어온다 => 자바 기능..
// => 다음 => 데이터를 모아서 처리 => 배열
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
public class 문자열_2 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("검색어 입력:");
		String fd=scan.next();
		int k=1;
		for(int i=1;i<=4;i++)
		{
			Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20241127&hh=10&rtm=Y&pg="+i).get();
			// 곡명 읽기
			Elements title =doc.select("table.list-wrap a.title");
			for(int j=0;j<title.size();j++)
			{
//				if(title.get(j).text().contains(fd)) %검색어%
//				if(title.get(j).text().startsWith(fd)) 검색어%
				if(title.get(j).text().endsWith(fd)) // %검색어
				{
					System.out.println((k)+"."+title.get(j).text());
//					Thread.sleep(2000);
					k++;
				}
			}
		}
	}

}
