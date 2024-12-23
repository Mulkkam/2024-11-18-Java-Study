package com.sist.main;
import java.util.*;
public class 컬렉션_7_Set_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HashSet<String> set=new HashSet<String>(); // => 일반 클래스
		// Set set=new HashSet() => 인스페이스
		// 1. 저장 => add()
		// => 콤보박스 => 부서명 / 장르 / 검색 ...
		// 근무지
		set.add("red");
		set.add("yellow");
		set.add("pink");
		set.add("blue");
		set.add("green");
		set.add("red");
		set.add("yellow");
		set.add("pink");
		set.add("blue");
		set.add("green");
		set.add("red");
		set.add("yellow");
		set.add("pink");
		set.add("blue");
		set.add("green");
		// 실제 저장은 5개만 됨
		System.out.println("저장 갯수:"+set.size());
//		Iterator<String> iter=set.iterator();
//		while(iter.hasNext())
//		{
//			System.out.println(iter.next());
//		}
		set.forEach(name->System.out.println(name));
//		for(String color:set)
//		{
//			System.out.println(color);
//		}
		System.out.println("===== 삭제 =====");
		set.remove("yellow");
		System.out.println("저장 갯수:"+set.size());

		for(String color:set)
		{
			System.out.println(color);
		}
		
		if(set.isEmpty())
		{
			System.out.println("장바구니가 비어있습니다");
		}
		else
		{
			System.out.println("장바구니에 담겨있는 데이터가 있습니다");
		}
	}

}
