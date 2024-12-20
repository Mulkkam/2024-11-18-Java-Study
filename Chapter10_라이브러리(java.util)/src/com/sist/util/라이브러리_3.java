package com.sist.util;
import java.util.*;
public class 라이브러리_3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String color="red|yellow|green|pink|magenta|blue|black|cyan";
		StringTokenizer st=new StringTokenizer(color,"|");
//		String[] colors=color.split("\\|");
		System.out.println("컬러 갯수:"+st.countTokens());
		// 초과시에는 오류
		while(st.hasMoreElements())
		{
			System.out.println(st.nextToken());
		}
	}

}
