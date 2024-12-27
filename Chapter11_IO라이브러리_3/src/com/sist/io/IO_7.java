package com.sist.io;
import java.io.*;
import java.net.*;
import java.util.Scanner;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
public class IO_7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] strUrl= {
				"",
				"searchMainDailyBoxoffice.do",
				"searchMainRealticket.do",
				"searchMainDailySeatTicket.do"
		};
		try
		{
			Scanner scan=new Scanner(System.in);
			System.out.println("===== Menu =====");
			System.out.println("1. 일일박스오피스");
			System.out.println("2. 실시간 예매율");
			System.out.println("3. 좌석 점유율");
			System.out.println("================");
			System.out.println("메뉴 선택: ");
			int menu=scan.nextInt();
			String path="https://www.kobis.or.kr/kobis/business/main/";
        	// .do => MVC구조 => URL주소는 마음대로 변경이 가능 
        	path=path+strUrl[menu];
        	Document doc=Jsoup.connect(path).get();
        	System.out.println(doc.toString());
        	// Document doc=Jsoup.connect().get();
//        	URL url=new URL(path);
//        	HttpURLConnection conn=
//        			(HttpURLConnection)url.openConnection();
//        	
//        	if(conn!=null) // 접속이 된 경우
//        	{
//        		BufferedReader br=
//        			new BufferedReader(
//        					new InputStreamReader(conn.getInputStream()));
//        		// 전송 => 1byte , 받은 경우 => 2byte로 변환후 출력 
//        		// 한글이 깨진다 => UTF-8 
//        		// 네트워크의 단점 : 전송시 byte (1byte) 
//        		// => 2byte
//        		// 네트워크 : Oracle , 웹 
//        		// => 주소 / PORT
//        		//    URL => 8080 => 0~65535 
//        		while(true)
//        		{
//        			String msg=br.readLine();
//        			if(msg==null) break;
//        			
//        			System.out.println(msg);
//        		}
//        	}
//        	conn.disconnect();
//        	
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
	}

}