package com.sist.exception;
/*
 *   예외처리 
 *     => 전체 
 *     => 예상되는 부분에서만 처리 
 *     
 *     1. 예외처리시 흐름 
 *     ---------------
 */
public class 예외처리_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		try
//		{
//			for(int i=1;i<=10;i++)
//			{
//				int r=(int)(Math.random()*3);
//				// 0,1,2
//				int a=i/r;
//				System.out.println("i="+i+",a="+a);
//			}
//		}catch (Exception e) {
//			// TODO: handle exception
//			
//		}
		// 크롤링
		for(int i=1;i<=10;i++)
		{
			try
			{
				int r=(int)(Math.random()*3);
				// 0,1,2
				int a=i/r;
				System.out.println("i="+i+",a="+a);
			}catch (Exception ex) {	}
		}
	}	
}
