package com.sist.main;
import java.io.*;
public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		FileInputStream fis=null;
		FileOutputStream fos=null;
        try
        {
        	// 파일 복사 => 파일 전송 
        	// 파일 자체 제어 => Reader / Writer
        	fis=new FileInputStream("c:\\JavaDev\\movie.txt");
        	fos=new FileOutputStream("c:\\java_data\\movie.txt");
        	//                      => 파일이 없는 경우에 자동으로 생성 
        	/*
        	 *    mode 
        	 *      r => read
        	 *      w => write => create 
        	 *      a => append
        	 *      FileOutputStream("c:\\java_data\\movie.txt",true)
        	 */
        	int i=0; // i=> 글자 한글자 
        	// 읽은 바이트수 
        	byte[] buffer=new byte[1024];//TCP(1024) / UDP(512)
        	// read(): 글자번호  / read(byte[],start,end): 읽은 바이트 수
        	// 789
        	while((i=fis.read(buffer,0,1024))!=-1)
        	{
        		fos.write(buffer, 0, i);
        	}
        	System.out.println("복사 완료");
        }catch(Exception ex) 
        {
        	ex.printStackTrace();
        }
        finally
        {
        	try
        	{
        		fis.close();
        		fos.close();
        	}catch(Exception ex) {}
        }
	}

}