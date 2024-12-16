package com.sist.execute;
import java.util.Scanner;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.println("A(1),B(2),C(3),D(4)");
		int select=scan.nextInt();
		I[] i= {null,new A(),new B(),new C(),new D()};
		// i=new A(), i=new B()
		i[select].execute();
	}

}
