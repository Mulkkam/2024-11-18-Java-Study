package com.sist.movie;

import java.io.*;
import java.util.*;

// 데이터 크롤링
// 객체단위로 저장한 파일을 만든다
public class MovieInputData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		try
		{
			List<Movie> list=new ArrayList<Movie>();
			FileReader fis=new FileReader("c:\\JavaDev\\movie.txt");
			
			int i=0;
			StringBuffer sb=new StringBuffer();
			while((i=fis.read())!=-1)
			{
				sb.append((char)i);
			}
			String data=sb.toString();
			String[] mdata=data.split("\n");
			for(String m:mdata)
			{
				String[] mm=m.split("\\|");
				Movie movie=new Movie();
				movie.setMno(Integer.parseInt(mm[0]));
				movie.setTitle(mm[1]);
				movie.setGenre(mm[2]);
				movie.setPoster(mm[3]);
				movie.setActor(mm[4]);
				movie.setRegdate(mm[5]);
				movie.setGrade(mm[6]);
				movie.setDirector(mm[7]);
				list.add(movie);
			}
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\movie_data.txt");
			oos=new ObjectOutputStream(fos);
        	oos.writeObject(list);
        	System.out.println("영화 객체 단위 저장 완료!");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally 
		{
			try
        	{
        		oos.close();
        	}catch(Exception ex) {
        		
        	}
     
		}
	}

}
