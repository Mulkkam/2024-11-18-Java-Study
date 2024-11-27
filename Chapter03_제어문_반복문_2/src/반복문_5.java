import java.io.*;
public class 반복문_5 {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		FileReader fr=new FileReader("C:\\JavaDev\\JavaStudy\\Chapter03_제어문_반복문_2\\src\\반복문_4.java");
		int i=0;
		while((i=fr.read())!=-1)
		{
			System.out.print((char)i);
		}
	}

}
