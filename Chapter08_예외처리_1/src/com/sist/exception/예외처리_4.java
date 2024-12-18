package com.sist.exception;
import java.util.Scanner;
/*
 *   UnCheck 
 *   ---------
 *       Throwable
 *          |
 *       Exception : 예외처리의 모든 것을 잡을 수 있다 
 *          |
 *      RuntimeException =>배열범위 초과,.0으로 나누는 경우,정수변환,형변환  
 *          | 
 *   ------------------------------
 *   |
 *  ArrayIndexOutOfBoundsException => 배열범위 초과 
 *  ArithmeticException => 0으로 나누는 경우 
 *  NumberFormatException => 정수변환 
 *  ClassCastExeption => 형변환 
 *  ...
 *  ...
 *  int a=0,b=0;
 *  try
 *  {
 *     a=10;
 *     
 *  }catch(Exception e)
 *  {
 *     b=20;
 *  }
 *  
 *  a,b => 사라진다 
 *  
 */
public class 예외처리_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Scanner scan=new Scanner(System.in);
        int[] arr=new int[2];// 배열범위 , 0
        try
        {
        	System.out.print("첫번째 정수 입력:");
        	String s1=scan.next();
        	System.out.print("두번째 정수 입력:");
        	String s2=scan.next();// 오류발생
        	
        	arr[0]=Integer.parseInt(s1);// 정수 변환
        	arr[1]=Integer.parseInt(s2);
        	
        	int result=arr[0]/arr[1];
        	System.out.println("result="+result);
        }
        catch(ArrayIndexOutOfBoundsException ex)
        {
        	//System.out.println(ex.getMessage());
        	// 에러 메세지만 출력 
        	ex.printStackTrace(); // 권장 
        	// 에러시 => 에러 위치 확인 
        }catch(ArithmeticException e)
        {
        	//System.out.println(e.getMessage());
        	e.printStackTrace();
        }
//        catch(Throwable e)
//        {
//        	
//        }
//        catch(Exception e)
//        {
//        	System.out.println("에러발생");
//        }
        // 기타적인 에러 
        catch(NumberFormatException e)
        {
        	//System.out.println(e.getMessage());
        	e.printStackTrace();
        }
       
        System.out.println("정상 수행");
        // 정상 수행 => catch는 수행하지 않는다
        // try안에서 오류발생시 catch수행 
	}
}
