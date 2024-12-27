package com.sist.movie;
import java.io.*;
import java.util.*;
public class MovieSystem {
	// 영화정보를 가지고 있다 => 요청 가능
	private static List<Movie> movielist= new ArrayList<Movie>();
	
	static
	{
		ObjectInputStream ois=null;
		try
		{
			FileInputStream fis=new FileInputStream("c:\\java_data\\movie_data.txt");
			ois=new ObjectInputStream(fis);
			movielist=(List<Movie>)ois.readObject();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
			try
			{
				ois.close();
			}catch (Exception ex) {
				// TODO: handle exception
			}
		}
		
	}
	public List<Movie> movieListDat()
	{
		return movielist;
	}
	public Movie movieDetailData(int mno)
	{
		Movie movie=new Movie();
		for(Movie m:movielist)
		{
			if(m.getMno()==mno)
			{
				movie=m;
				break;
			}
		}
		return movie;
	}
	public List<Movie> movieFindData(String title)
	{
		List<Movie> list=new ArrayList<Movie>();
		
		for(Movie m:movielist)
		{
			if(m.getTitle().contains(title))
			{
				list.add(m);
			}
		}
		return list;
	}
}
