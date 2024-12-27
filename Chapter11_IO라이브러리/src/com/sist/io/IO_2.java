package com.sist.io;
import java.io.File;
import java.util.*;
//파일 제어
public class IO_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		File dir=new File("c:\\JavaDev");
		
		// => 어떤 파일 / 어떤 파일 있는 지 확인 
		// => listFiles
		File[] list=dir.listFiles();
		for(File f:list)
		{
			if(f.isFile())
			{
				System.out.println(f.getName()+" "
						+f.length()+"bytes");
			}
			else if(f.isDirectory())
			{
				System.out.println(f.getName()+" <DIR>");
				
			}
		}
	}

}
