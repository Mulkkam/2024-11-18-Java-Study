package com.sist.main;
import java.util.*;
class Sawon
{
	String name;
	String dept;
	String loc;
	
	public void display() {
		System.out.println("이름:"+name);
		System.out.println("부서:"+dept);
		System.out.println("근무지:"+loc);
	}
}
public class 재사용 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList list=new ArrayList();
		Sawon s1=new Sawon();
		s1.name="홍길동";
		s1.dept="개발부";
		s1.loc="서울";
		list.add(s1);
//		list.add(10);
		Sawon s=(Sawon)list.get(0);
	}

}
