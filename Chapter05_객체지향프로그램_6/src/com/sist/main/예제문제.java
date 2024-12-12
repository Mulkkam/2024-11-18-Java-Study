package com.sist.main;
/*
 *   1. 객체 / 클래스 
 *   건축 
 *   ---
 *    설계 ===> 시공 ===> 완성 
 *    ---      ---      ---
 *    class    구현      | 객체 / 인스턴스 
 */
import java.util.*;
class Member
{	
	String name;
	String id;
	String password;
	int age;
	
	Member(String n,String p){
		this.name=n;
		this.password=p;
	}
}
public class 예제문제 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
//		Member m=new Member();

//		System.out.println("이름 입력: ");
//		String name=scan.next();
//		m.name=name;
//		System.out.println("아이디 입력: ");
//		String id=scan.next();
//		m.id=id;

		System.out.println("이름 입력: ");
		String name=scan.next();
		name=name;
		System.out.println("아이디 입력: ");
		String id=scan.next();
		id=id;
		
		new Member(name, id);

	}

}
