package com.sist.io;
import java.io.*;
// 문자 단위 저장 => write(String s)
//문자 단위 저장 => write(String s)
import java.util.*;
public class IO_5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileWriter fw=new FileWriter("c:\\java_data\\student.txt",true);
//			String msg="Hello Java!! => IO => Hello\n";
//			fw.write(msg);
//			fw.close();
			String msg="Hello Oracle";
        	// 크롤링 / Open API 
			BufferedWriter bw=new BufferedWriter(fw);
			
			bw.write(msg);
			System.out.println("저장 완료!!");
			bw.close();
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
	}

}
