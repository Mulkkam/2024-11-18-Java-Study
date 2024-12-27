package com.sist.io;
import java.util.*;
import java.io.*;
// BufferedInputStream / BufferedOutputStream
// String StringBuffer
/*
 * 	파일 자체 제어 => FileReader / FileWriter
 * 				   BufferedReader / BufferedWriter
 * 				   => 한줄씩 읽기 , 한줄씩 저장
 * 				   => readLine() , writeLine()
 */
public class IO_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
        	// jar / zip / png / mp3 ....
			FileInputStream fis=new FileInputStream("c:\\JavaDev\\mydata.jar");
			BufferedInputStream bis=new BufferedInputStream(fis);
			FileOutputStream fos=new FileOutputStream("c:\\java_data\\mydata.jar");
			BufferedOutputStream bos=new BufferedOutputStream(fos);
			
			int i=0;
			byte[] buffer=new byte[1024];
			while((i=bis.read(buffer,0,1024))!=-1)
			{
				bos.write(buffer,0,i);
			}
			fis.close();
			fos.close();
//			bis.close();
//			bos.close();
			System.out.println("파일 복사 종료");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}
