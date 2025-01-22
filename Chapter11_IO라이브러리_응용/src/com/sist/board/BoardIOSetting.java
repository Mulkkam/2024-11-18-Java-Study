package com.sist.board;
import java.util.*;
import java.io.*;

public class BoardIOSetting {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ObjectOutputStream oos=null;
		try
		{
			List<BoardVO> list=new ArrayList<BoardVO>();
			FileOutputStream fos=new FileOutputStream("C:\\java_data\\board.txt");
			oos=new ObjectOutputStream(fos);
			oos.writeObject(list);
			System.out.println("파일에 저장공간 생성 완료!");
		}catch (Exception ex) {
			// TODO: handle exception
			ex.printStackTrace();
		}
		finally {
        	// 오라클 / 서버 / 파일 
			try
			{
				oos.close();
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
	}

}
