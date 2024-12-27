package com.sist.io;
//=> FileInputStream ==> Reader형식으로 변경 
//seoul_nature
import java.io.*; // 웹에서 가장 많이 사용되는 방식 
public class IO_6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			FileInputStream fis=new FileInputStream("c:\\JavaDev\\seoul_nature.txt");
			BufferedReader br=new BufferedReader(new InputStreamReader(fis));
        	// 웹을 읽는 경우 
        	// 1byte => 2byte변환 => InputStreamReader()
//        	int i=0;
//        	while((i=br.read())!=-1)
//        	{
//        		System.out.print((char)i);
//        	}
        	while(true)
        	{
        		String msg=br.readLine();
        		// 한줄씩 읽기 
        		if(msg==null) break;
        		System.out.println(msg);
        	}
        	fis.close();
        }catch(Exception ex)
        {
        	ex.printStackTrace();
        }
	}

}