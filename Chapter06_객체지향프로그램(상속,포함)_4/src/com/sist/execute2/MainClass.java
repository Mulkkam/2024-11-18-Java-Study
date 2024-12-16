package com.sist.execute2;
class Sub
{
	// Object => 모든 메소드 사용이 가능
	// Sub sub=new Sub(), Object obj=new Sub()
	int a=10;
	@Override
	public String toString()
	{
		System.out.println("Sub...");
		return "";
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Object obj=new Sub();
		// 묶어서 한개로 관리
		obj.toString();
	}

}
